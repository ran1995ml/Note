#!/bin/sh

if [ $# -lt 1 ];then
  echo "Input 1 parameter"
  exit 1
fi

HOST_LIST="/root/Kubernetes/template/server.list"
IP12=$(cat $HOST_LIST|sed -n '2p')
IP21=$(cat $HOST_LIST|sed -n '3p')
IP22=$(cat $HOST_LIST|sed -n '4p')
IP10=$(cat $HOST_LIST|sed -n '7p')
HOST_ID=$1

IP_VS="ipvs.sh"
KUBE_PROXY_SH="/opt/kubernetes/server/bin/kube-proxy.sh"
KUBE_PROXY_INI="/etc/supervisord.d/kube-proxy.ini"

echo "*****************************download certs*****************************"
cd /opt/kubernetes/server/bin/cert
scp hdss7-200:/opt/certs/kube-proxy-client.pem .
scp hdss7-200:/opt/certs/kube-proxy-client-key.pem .

echo "*****************************config proxy*****************************"
cd ../conf/
kubectl config set-cluster myk8s \
  --certificate-authority=/opt/kubernetes/server/bin/cert/ca.pem \
  --embed-certs=true \
  --server=https://$IP10:7443 \
  --kubeconfig=kube-proxy.kubeconfig

kubectl config set-credentials kube-proxy \
  --client-certificate=/opt/kubernetes/server/bin/cert/kube-proxy-client.pem \
  --client-key=/opt/kubernetes/server/bin/cert/kube-proxy-client-key.pem \
  --embed-certs=true \
  --kubeconfig=kube-proxy.kubeconfig

kubectl config set-context myk8s-context \
  --cluster=myk8s \
  --user=kube-proxy \
  --kubeconfig=kube-proxy.kubeconfig

kubectl config use-context myk8s-context --kubeconfig=kube-proxy.kubeconfig

cd

echo "*****************************ip vs*****************************"
lsmod |grep ip_vs
cp /root/Kubernetes/template/kube-proxy/ipvs.sh $IP_VS
chmod +x ipvs.sh
./ipvs.sh
lsmod |grep ip_vs

echo "*****************************config proxy supervisor*****************************"
cd /opt/kubernetes/server/bin/
cp /root/Kubernetes/template/kube-proxy/kube-proxy.sh $KUBE_PROXY_SH
sed -i "s/hostId/$HOST_ID/g" $KUBE_PROXY_SH
chmod +x kube-proxy.sh

mkdir -p /data/logs/kubernetes/kube-proxy
cp /root/Kubernetes/template/kube-proxy/kube-proxy.ini $KUBE_PROXY_INI
sed -i "s/hostId/$HOST_ID/g" $KUBE_PROXY_INI

supervisorctl update

sleep 30s

echo "*****************************sleep*****************************"
yum install ipvsadm -y
ipvsadm -Ln
kubectl get svc