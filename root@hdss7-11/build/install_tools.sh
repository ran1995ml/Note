#!/bin/sh
# 安装通用下载工具
HOST_LIST="../template/server.list"
IP11=$(cat $HOST_LIST|sed -n '1p')
DNS_CONF="/etc/resolv.conf"

timedatectl set-timezone Asia/Shanghai
timedatectl set-ntp true

echo "*****************************install tools*****************************"
yum install epel-release -y
yum install wget net-tools telnet tree nmap sysstat lrzsz dos2unix bind-utils -y

echo "*****************************set dns*****************************"
sed -i "2i nameserver $IP11" $DNS_CONF
sed -i "2i search host.com" $DNS_CONF
cat $DNS_CONF