#!/bin/sh
# 部署docker

if [ $# -lt 1 ];then
  echo "Input 1 parameter"
  exit 1
fi

DAEMON_TEMPLATE="/root/Kubernetes/template/docker/daemon.json"
SERVER_ID=$1

DAEMON_JSON="/etc/docker/daemon.json"

echo "*****************************download docker*****************************"
curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun

mkdir -p /data/docker /etc/docker
cp $DAEMON_TEMPLATE $DAEMON_JSON

sed -i "s/serverid/$SERVER_ID/g" $DAEMON_JSON

echo "*****************************start docker*****************************"
systemctl start docker
docker version
docker ps -a