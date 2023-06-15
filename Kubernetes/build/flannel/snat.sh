#!/bin/sh

if [ $# -lt 1 ];then
  echo "Input 1 parameter"
  exit 1
fi

SERVER_ID=$1

iptables-save |grep -i postrouting
yum install iptables-services -y
systemctl start iptables
systemctl enable iptables

iptables -t nat -D POSTROUTING -s 172.7.$SERVER_ID.0/24 ! -o docker0 -j MASQUERADE
iptables -t nat -I POSTROUTING -s 172.7.$SERVER_ID.0/24 ! -d 172.7.0.0/16 ! -o docker0 -j MASQUERADE

iptables-save |grep -i postrouting
iptables-save > /etc/sysconfig/iptables
