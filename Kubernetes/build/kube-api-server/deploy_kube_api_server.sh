#!/bin/sh

if [ $# -lt 1 ];then
  echo "Input 1 parameter"
  exit 1
fi

HOST_LIST="/root/Kubernetes/template/server.list"
IP12=$(cat $HOST_LIST|sed -n '2p')
IP21=$(cat $HOST_LIST|sed -n '3p')
IP22=$(cat $HOST_LIST|sed -n '4p')

AUDIT_YAML="audit.yaml"
KUBE_API_SERVER="/opt/kubernetes/server/bin/kube-apiserver.sh"
KUBE_API_SERVER_INI="/etc/supervisord.d/kube-apiserver.ini"
HOST_ID=$1

echo "*****************************download kube-server*****************************"
cd /opt/src/
wget https://dl.k8s.io/v1.15.2/kubernetes-server-linux-amd64.tar.gz
mv kubernetes-server-linux-amd64.tar.gz kubernetes-server-linux-amd64-v1.15.2.tar.gz

tar xf kubernetes-server-linux-amd64-v1.15.2.tar.gz -C /opt/
cd /opt
mv kubernetes/ kubernetes-v1.15.2
ln -s /opt/kubernetes-v1.15.2/ /opt/kubernetes
cd kubernetes

echo "*****************************download certs*****************************"
cd /opt/kubernetes/server/bin
mkdir cert
cd cert/
scp hdss7-200:/opt/certs/ca.pem .
scp hdss7-200:/opt/certs/ca-key.pem .
scp hdss7-200:/opt/certs/client-key.pem .
scp hdss7-200:/opt/certs/client.pem .
scp hdss7-200:/opt/certs/apiserver.pem .
scp hdss7-200:/opt/certs/apiserver-key.pem .

echo "*****************************download audit*****************************"
cd /opt/kubernetes/server/bin
mkdir conf
cd conf/
cp /root/Kubernetes/template/kube-apiserver/audit.yaml $AUDIT_YAML

cd ..
cp /root/Kubernetes/template/kube-apiserver/kube-apiserver.sh $KUBE_API_SERVER
sed -i "s/host12/$IP12/g" $KUBE_API_SERVER
sed -i "s/host21/$IP21/g" $KUBE_API_SERVER
sed -i "s/host22/$IP22/g" $KUBE_API_SERVER

chmod +x kube-apiserver.sh
cp /root/Kubernetes/template/kube-apiserver/kube-apiserver.ini $KUBE_API_SERVER_INI
sed -i "s/hostId/$HOST_ID/g" $KUBE_API_SERVER_INI

mkdir -p /data/logs/kubernetes/kube-apiserver


supervisorctl update
echo "*****************************sleep*****************************"
sleep 20s

supervisorctl status