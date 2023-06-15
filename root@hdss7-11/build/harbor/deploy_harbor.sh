#!/bin/sh

HARBOR_YAML="harbor.yml"
HARBOR_OD_COM_CONF_TEMPLATE="/root/Kubernetes/template/harbor/harbor.od.com.conf"
HARBOR_OD_COM_CONF="/etc/nginx/conf.d/harbor.od.com.conf"

mkdir /opt/src  && cd /opt/src
wget https://storage.googleapis.com/harbor-releases/release-1.8.0/harbor-offline-installer-v1.8.3.tgz
tar xf harbor-offline-installer-v1.8.3.tgz -C /opt/

cd /opt/
mv harbor/ harbor-v1.8.3
ln -s /opt/harbor-v1.8.3/ /opt/harbor
cd harbor
sed -i "s/hostname: reg.mydomain.com/hostname: harbor.od.com/g" $HARBOR_YAML
sed -i "s/port: 180/port: 80/g" $HARBOR_YAML

mkdir -p /data/harbor/logs
yum install docker-compose -y
rpm -qa docker-compose

./install.sh

docker-compose ps
docker ps -a

yum install nginx -y
cp $HARBOR_OD_COM_CONF_TEMPLATE $HARBOR_OD_COM_CONF

nginx -t
systemctl start nginx
systemctl enable nginx