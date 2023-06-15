#!/bin/sh

if [ $# -lt 1 ];then
  echo "Input 1 parameter"
  exit 1
fi

HOST_LIST="/root/Kubernetes/template/server.list"
IP12=$(cat $HOST_LIST|sed -n '2p')
IP21=$(cat $HOST_LIST|sed -n '3p')
IP22=$(cat $HOST_LIST|sed -n '4p')
SERVER_ID=$1
HOST_ID="127.0.0.1"
if (( $SERVER_ID == 21 )); then
    HOST_ID=$IP21
elif (( $SERVER_ID == 22 )); then
    HOST_ID=$IP22
else
    echo "Error Input"
    exit 1
fi

SUBNET_ENV="subnet.env"
FLANNEL_SH="flanneld.sh"
FLANNEL_INI="/etc/supervisord.d/flannel.ini"


echo "*****************************download flannel*****************************"
cd /opt/src/
wget https://github.com/coreos/flannel/releases/download/v0.11.0/flannel-v0.11.0-linux-amd64.tar.gz

mkdir /opt/flannel-v0.11.0
tar xf flannel-v0.11.0-linux-amd64.tar.gz -C /opt/flannel-v0.11.0/
ln -s /opt/flannel-v0.11.0/ /opt/flannel

echo "*****************************download cert*****************************"
cd /opt/flannel
mkdir cert

cd cert/

scp hdss7-200:/opt/certs/ca.pem .
scp hdss7-200:/opt/certs/client.pem .
scp hdss7-200:/opt/certs/client-key.pem .

cd ..
echo "*****************************config subnet*****************************"
cp /root/Kubernetes/template/flannel/subnet.env $SUBNET_ENV
sed -i "s/hostId/$SERVER_ID/g" $SUBNET_ENV

cp /root/Kubernetes/template/flannel/flanneld.sh $FLANNEL_SH
sed -i "s/hostId/$HOST_ID/g" $FLANNEL_SH
sed -i "s/host12/$IP12/g" $FLANNEL_SH
sed -i "s/host21/$IP21/g" $FLANNEL_SH
sed -i "s/host22/$IP22/g" $FLANNEL_SH

chmod +x flanneld.sh
mkdir -p /data/logs/flanneld
cp /root/Kubernetes/template/flannel/flannel.ini $FLANNEL_INI
sed -i "s/hostId/$SERVER_ID/g" $FLANNEL_INI

echo "*****************************config etcd*****************************"
if (( $SERVER_ID == 21 )); then
  cd /opt/etcd
  ./etcdctl set /coreos.com/network/config '{"Network": "172.7.0.0/16", "Backend": {"Type": "vxlan"}}'
  ./etcdctl get /coreos.com/network/config
fi

supervisorctl update

echo "*****************************sleep*****************************"
sleep 30s
supervisorctl status