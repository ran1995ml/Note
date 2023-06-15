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

K8S_NODE_YAML="k8s-node.yaml"
KUBELET_SH="/opt/kubernetes/server/bin/kubelet.sh"
KUBELET_INI="/etc/supervisord.d/kube-kubelet.ini"

echo "*****************************download certs*****************************"
cd /opt/kubernetes/server/bin/cert/
scp hdss7-200:/opt/certs/kubelet.pem .
scp hdss7-200:/opt/certs/kubelet-key.pem .

echo "*****************************config kubelet*****************************"
cd ../conf/

kubectl config set-cluster myk8s \
  --certificate-authority=/opt/kubernetes/server/bin/cert/ca.pem \
  --embed-certs=true \
  --server=https://$IP10:7443 \
  --kubeconfig=kubelet.kubeconfig

kubectl config set-credentials k8s-node \
  --client-certificate=/opt/kubernetes/server/bin/cert/client.pem \
  --client-key=/opt/kubernetes/server/bin/cert/client-key.pem \
  --embed-certs=true \
  --kubeconfig=kubelet.kubeconfig

kubectl config set-context myk8s-context \
  --cluster=myk8s \
  --user=k8s-node \
  --kubeconfig=kubelet.kubeconfig

kubectl config use-context myk8s-context --kubeconfig=kubelet.kubeconfig
cp /root/Kubernetes/template/kubelet/k8s-node.yaml $K8S_NODE_YAML

kubectl create -f k8s-node.yaml
kubectl get clusterrolebinding k8s-node -o yaml

echo "*****************************config pause*****************************"
docker pull kubernetes/pause
if (( $HOST_ID == 21 )); then
  docker images|grep pause
  docker tag f9d5de079539 harbor.od.com/public/pause:latest
  docker push harbor.od.com/public/pause:latest
fi

echo "*****************************config kubelet*****************************"
cp /root/Kubernetes/template/kubelet/kubelet.sh $KUBELET_SH
sed -i "s/hostId/$HOST_ID/g" $KUBELET_SH
cd /opt/kubernetes/server/bin
mkdir -p /data/logs/kubernetes/kube-kubelet /data/kubelet
chmod +x kubelet.sh

cp /root/Kubernetes/template/kubelet/kube-kubelet.ini $KUBELET_INI
sed -i "s/hostId/$HOST_ID/g" $KUBELET_INI

supervisorctl update

echo "*****************************sleep*****************************"
sleep 30s
supervisorctl status

kubectl get nodes

echo "*****************************label*****************************"
if (( $HOST_ID == 22 )); then
  kubectl label node hdss7-21.host.com node-role.kubernetes.io/master=
  kubectl label node hdss7-21.host.com node-role.kubernetes.io/node=
  kubectl label node hdss7-22.host.com node-role.kubernetes.io/master=
  kubectl label node hdss7-22.host.com node-role.kubernetes.io/node=
fi

kubectl get nodes