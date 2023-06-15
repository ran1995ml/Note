#!/bin/sh

HOST_LIST="/root/Kubernetes/template/server.list"
IP11=$(cat $HOST_LIST|sed -n '1p')

K8S_YAML_OD_CONF="/etc/nginx/conf.d/k8s-yaml.od.com.conf"
RABC_YAML="rbac.yaml"
CM_YAML="cm.yaml"
DP_YAML="dp.yaml"
SVC_YAML="svc.yaml"


echo "*****************************config k8s yaml*****************************"
cd /etc/nginx/conf.d/
cp /root/Kubernetes/build/coredns/k8s-yaml.od.com.conf $K8S_YAML_OD_CONF
mkdir /data/k8s-yaml
nginx -t
nginx -s reload

cd /data/k8s-yaml/

echo "*****************************config coredns*****************************"
docker pull coredns/coredns:1.6.1
docker images|grep coredns
docker tag c0f6e815079e harbor.od.com/public/coredns:v1.6.1
docker push !$

mkdir coredns
cd /data/k8s-yaml/coredns
cp /root/Kubernetes/build/coredns/rbac.yaml $RABC_YAML
cp /root/Kubernetes/build/coredns/cm.yaml $CM_YAML
sed -i "s/host11/$IP11/g" $CM_YAML
cp /root/Kubernetes/build/coredns/dp.yaml $DP_YAML
cp /root/Kubernetes/build/coredns/svc.yaml $SVC_YAML

