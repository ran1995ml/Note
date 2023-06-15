#!/bin/sh
# 配置DNS服务器，hdss7-11

HOST_LIST="/root/Kubernetes/template/server.list"
OD_ZONE_TEMPLATE="/root/Kubernetes/template/dns/od.com.zone"
HOST_ZONE_TEMPLATE="/root/Kubernetes/template/dns/host.com.zone"
RFC_1912_TEMP="/root/Kubernetes/template/dns/rfc1912.zone"

NAMED_CONF="/etc/named.conf"
OD_ZONE="/var/named/od.com.zone"
HOST_ZONE="/var/named/host.com.zone"
RFC_1912="/etc/named.rfc1912.zones"
DNS_CONF="/etc/resolv.conf"

IP11=$(cat $HOST_LIST|sed -n '1p')
IP12=$(cat $HOST_LIST|sed -n '2p')
IP21=$(cat $HOST_LIST|sed -n '3p')
IP22=$(cat $HOST_LIST|sed -n '4p')
IP200=$(cat $HOST_LIST|sed -n '5p')
PUBLIC_DNS=$(cat $HOST_LIST|sed -n '6p')

timedatectl set-timezone Asia/Shanghai
timedatectl set-ntp true

echo "*****************************dns server:$IP11*****************************"
echo "*****************************stop firewalld*****************************"
systemctl stop firewalld

echo "*****************************install tools*****************************"
yum install epel-release -y
yum install wget net-tools telnet tree nmap sysstat lrzsz dos2unix bind-utils -y

echo "*****************************install bind*****************************"
yum install bind -y
rpm -qa bind

echo "*****************************edit named.conf*****************************"
sed -i "s/listen-on port 53 { 127.0.0.1; };/listen-on port 53 { $IP11; };/g" $NAMED_CONF
sed -i "s/listen-on-v6 port 53 { ::1; };/# listen-on-v6 port 53 { ::1; };/g" $NAMED_CONF
sed -i "s/allow-query     { localhost; };/allow-query     { any; };/g" $NAMED_CONF
sed -i "/allow-query     { any; };/a\        forwarders      { $PUBLIC_DNS; };" $NAMED_CONF
sed -i "s/dnssec-enable no;/dnssec-enable yes;/g" $NAMED_CONF
sed -i "s/dnssec-validation no;/dnssec-validation yes;/g" $NAMED_CONF

echo "*****************************check named.conf*****************************"
named-checkconf

echo "*****************************edit zone*****************************"
cp $HOST_ZONE_TEMPLATE $HOST_ZONE
sed -i "s/host11/$IP11/g" $HOST_ZONE
sed -i "s/host12/$IP12/g" $HOST_ZONE
sed -i "s/host21/$IP21/g" $HOST_ZONE
sed -i "s/host22/$IP22/g" $HOST_ZONE
sed -i "s/host200/$IP200/g" $HOST_ZONE

cp $OD_ZONE_TEMPLATE $OD_ZONE
sed -i "s/host11/$IP11/g" $OD_ZONE
sed -i "s/host200/$IP200/g" $OD_ZONE

echo "*****************************check zone*****************************"
named-checkconf

cat $RFC_1912_TEMP >> $RFC_1912
sed -i "s/host11/$IP11/g" $RFC_1912

echo "*****************************start named*****************************"
systemctl start named
netstat -luntp|grep 53

echo "*****************************set dns*****************************"
sed -i "2i nameserver $IP11" $DNS_CONF
sed -i "2i search host.com" $DNS_CONF
cat $DNS_CONF