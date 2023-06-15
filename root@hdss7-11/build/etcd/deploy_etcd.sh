#!/bin/sh
# 部署etcd
# 编号，内网ip

if [ $# -lt 2 ];then
  echo "Input 2 parameter"
  exit 1
fi

HOST_LIST="/root/Kubernetes/template/server.list"
IP12=$(cat $HOST_LIST|sed -n '2p')
IP21=$(cat $HOST_LIST|sed -n '3p')
IP22=$(cat $HOST_LIST|sed -n '4p')

ETCD_SERVER_START_UP="/opt/etcd/etcd-server-startup.sh"
ETCD_SERVER_INI="/etc/supervisord.d/etcd-server.ini"
SERVER_ID=$1
HOST_ID=$2

mkdir /opt/src
cd /opt/src/

useradd -s /sbin/nologin -M etcd
id etcd

wget https://github.com/etcd-io/etcd/releases/download/v3.1.20/etcd-v3.1.20-linux-amd64.tar.gz
tar xf etcd-v3.1.20-linux-amd64.tar.gz -C /opt
cd /opt
mv etcd-v3.1.20-linux-amd64/ etcd-v3.1.20
ln -s /opt/etcd-v3.1.20/ /opt/etcd

cd etcd
mkdir -p /opt/etcd/certs /data/etcd /data/logs/etcd-server
cd certs/
scp hdss7-200:/opt/certs/ca.pem .
scp hdss7-200:/opt/certs/etcd-peer.pem .
cd ..
cp /root/Kubernetes/template/etcd/etcd-server-startup.sh $ETCD_SERVER_START_UP
sed -i "s/serverid/$SERVER_ID/g" $ETCD_SERVER_START_UP
sed -i "s/hostId/$HOST_ID/g" $ETCD_SERVER_START_UP
sed -i "s/host12/$IP12/g" $ETCD_SERVER_START_UP
sed -i "s/host21/$IP21/g" $ETCD_SERVER_START_UP
sed -i "s/host22/$IP22/g" $ETCD_SERVER_START_UP

chmod +x etcd-server-startup.sh
chown -R etcd.etcd /opt/etcd-v3.1.20/
chown -R etcd.etcd /data/etcd/
chown -R etcd.etcd /data/logs/etcd-server/

yum install supervisor -y
systemctl start supervisord
systemctl enable supervisord
cp /root/Kubernetes/template/etcd/etcd-server.ini $ETCD_SERVER_INI
sed -i "s/hostId/$SERVER_ID/g" $ETCD_SERVER_START_UP
supervisorctl update

sleep 20s

supervisorctl status
netstat -luntp|grep etcd

./etcdctl cluster-health
./etcdctl member list


