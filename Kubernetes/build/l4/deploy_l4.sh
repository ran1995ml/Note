#!/bin/sh

if [ $# -lt 1 ];then
  echo "Input 1 parameter"
  exit 1
fi

HOST_ID=$1
HOST_LIST="/root/Kubernetes/template/server.list"
IP11=$(cat $HOST_LIST|sed -n '1p')
IP12=$(cat $HOST_LIST|sed -n '2p')
IP21=$(cat $HOST_LIST|sed -n '3p')
IP22=$(cat $HOST_LIST|sed -n '4p')
IP10=$(cat $HOST_LIST|sed -n '7p')
IP="127.0.0.1"

if (( $HOST_ID == 12 )); then
    IP=$IP12
elif (( $HOST_ID == 21 )); then
    IP=$IP21
elif (( $HOST_ID == 22 )); then
    IP=$IP22
elif (( $HOST_ID == 11 )); then
    IP=$IP11
else
    echo "Error Input"
    exit 1
fi

echo $IP

NGINX_CONF="/etc/nginx/nginx.conf"
CHECK_PORT="/etc/keepalived/check_port.sh"
KEEP_ALIVED_CONF="/etc/keepalived/keepalived.conf"

echo "*****************************config nginx*****************************"
yum install nginx nginx-mod-stream -y
cat /root/Kubernetes/template/l4/nginx.conf >> $NGINX_CONF
sed -i "s/host21/$IP21/g" $NGINX_CONF
sed -i "s/host22/$IP22/g" $NGINX_CONF
nginx -t
systemctl start nginx
systemctl enable nginx

echo "*****************************config check_port*****************************"
yum install keepalived -y
cp /root/Kubernetes/template/l4/check_port.sh $CHECK_PORT
chmod +x $CHECK_PORT

echo "*****************************config keepalived*****************************"
if (( $HOST_ID == 11 )); then
    cp /root/Kubernetes/template/l4/keepalived_master.conf $KEEP_ALIVED_CONF
else
    cp /root/Kubernetes/template/l4/keepalived_slave.conf $KEEP_ALIVED_CONF
fi

sed -i "s/hostId/$IP/g" $KEEP_ALIVED_CONF
sed -i "s/host10/$IP10/g" $KEEP_ALIVED_CONF

systemctl start keepalived
systemctl enable keepalived

ip add

