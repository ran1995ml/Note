#!/bin/sh

if [ $# -lt 1 ];then
  echo "Input 1 parameter"
  exit 1
fi

HOST_LIST="/root/Kubernetes/template/server.list"
IP12=$(cat $HOST_LIST|sed -n '2p')
IP21=$(cat $HOST_LIST|sed -n '3p')
IP22=$(cat $HOST_LIST|sed -n '4p')
HOST_ID=$1

KUBE_CONTROLLER_MANAGER="/opt/kubernetes/server/bin/kube-controller-manager.sh"
KUBE_CONTROLLER_MANAGER_INI="/etc/supervisord.d/kube-conntroller-manager.ini"
KUBE_SCHEDULER="/opt/kubernetes/server/bin/kube-scheduler.sh"
KUBE_SCHEDULER_INI="/etc/supervisord.d/kube-scheduler.ini"

echo "*****************************config controller manager*****************************"
cp /root/Kubernetes/template/kube-controller-manager/kube-controller-manager.sh $KUBE_CONTROLLER_MANAGER
chmod +x $KUBE_CONTROLLER_MANAGER

mkdir -p /data/logs/kubernetes/kube-controller-manager
cp /root/Kubernetes/template/kube-controller-manager/kube-controller-manager.ini $KUBE_CONTROLLER_MANAGER_INI
sed -i "s/hostId/$HOST_ID/g" $KUBE_CONTROLLER_MANAGER_INI
supervisorctl update

echo "*****************************config scheduler*****************************"
cp /root/Kubernetes/template/kube-controller-manager/kube-scheduler.sh $KUBE_SCHEDULER
chmod +x $KUBE_SCHEDULER

mkdir -p /data/logs/kubernetes/kube-scheduler
cp /root/Kubernetes/template/kube-controller-manager/kube-scheduler.ini $KUBE_SCHEDULER_INI
sed -i "s/hostId/$HOST_ID/g" $KUBE_SCHEDULER_INI
supervisorctl update

echo "*****************************sleep*****************************"
sleep 30s

supervisorctl status

ln -s /opt/kubernetes/server/bin/kubectl /usr/bin/kubectl
kubectl get cs