#!/bin/sh
# 配置证书服务器

HOST_LIST="/root/Kubernetes/template/server.list"
CA_CSR_TEMPLATE="/root/Kubernetes/template/cert/ca-csr.json"
CA_CONFIG_TEMPLATE="/root/Kubernetes/template/cert/ca-config.json"
ETCD_PEER_CSR_TEMPLATE="/root/Kubernetes/template/cert/etcd-peer-csr.json"
CLIENT_CSR_TEMPLATE="/root/Kubernetes/template/cert/client-csr.json"
APISERVER_CSR_TEMPLATE="/root/Kubernetes/template/cert/apiserver-csr.json"
KUBELET_CSR_TEMPLATE="/root/Kubernetes/template/cert/kubelet-csr.json"
KUBE_PROXY_CSR_TEMPLATE="/root/Kubernetes/template/cert/kube-proxy-csr.json"

CERT_DIR="/opt/certs"
CA_PEM="/opt/certs/ca.pem"
CA_CSR="/opt/certs/ca-csr.json"
CA_CONFIG="/opt/certs/ca-config.json"
ETCD_PEER_CSR="/opt/certs/etcd-peer-csr.json"
CLIENT_CSR="/opt/certs/client-csr.json"
APISERVER_CSR="/opt/certs/apiserver-csr.json"
KUBELET_CSR="/opt/certs/kubelet-csr.json"
KUBE_PROXY_CSR="/opt/certs/kube-proxy-csr.json"

IP11=$(cat $HOST_LIST|sed -n '1p')
IP12=$(cat $HOST_LIST|sed -n '2p')
IP21=$(cat $HOST_LIST|sed -n '3p')
IP22=$(cat $HOST_LIST|sed -n '4p')
IP200=$(cat $HOST_LIST|sed -n '5p')
IP10=$(cat $HOST_LIST|sed -n '7p')

timedatectl set-timezone Asia/Shanghai
timedatectl set-ntp true

echo "*****************************cfssl server:$IP200*****************************"
echo "*****************************stop firewalld*****************************"
systemctl stop firewalld

echo "*****************************download cfssl*****************************"
wget https://pkg.cfssl.org/R1.2/cfssl_linux-amd64 -O /usr/bin/cfssl
wget https://pkg.cfssl.org/R1.2/cfssljson_linux-amd64 -O /usr/bin/cfssl-json
wget https://pkg.cfssl.org/R1.2/cfssl-certinfo_linux-amd64 -O /usr/bin/cfssl-certinfo

chmod +x /usr/bin/cfssl*
which cfssl
which cfssl-json
which cfssl-certinfo

echo "*****************************build ca*****************************"
mkdir $CERT_DIR
cd $CERT_DIR
cp $CA_CSR_TEMPLATE $CA_CSR
cfssl gencert -initca $CA_CSR | cfssl-json -bare ca
cat $CA_PEM

echo "*****************************build etcd*****************************"
cp $CA_CONFIG_TEMPLATE $CA_CONFIG
cp $ETCD_PEER_CSR_TEMPLATE $ETCD_PEER_CSR
sed -i "s/host11/$IP11/g" $ETCD_PEER_CSR
sed -i "s/host12/$IP12/g" $ETCD_PEER_CSR
sed -i "s/host21/$IP21/g" $ETCD_PEER_CSR
sed -i "s/host22/$IP22/g" $ETCD_PEER_CSR
cfssl gencert -ca=ca.pem -ca-key=ca-key.pem -config=ca-config.json -profile=peer etcd-peer-csr.json |cfssl-json -bare etcd-peer

echo "*****************************build client*****************************"
cp $CLIENT_CSR_TEMPLATE $CLIENT_CSR
cfssl gencert -ca=ca.pem -ca-key=ca-key.pem -config=ca-config.json -profile=client client-csr.json |cfssl-json -bare client

echo "*****************************build apiserver*****************************"
cp $APISERVER_CSR_TEMPLATE $APISERVER_CSR
sed -i "s/host10/$IP10/g" $APISERVER_CSR
sed -i "s/host12/$IP12/g" $APISERVER_CSR
sed -i "s/host21/$IP21/g" $APISERVER_CSR
sed -i "s/host22/$IP22/g" $APISERVER_CSR
sed -i "s/host200/$IP200/g" $APISERVER_CSR
cfssl gencert -ca=ca.pem -ca-key=ca-key.pem -config=ca-config.json -profile=server apiserver-csr.json |cfssl-json -bare apiserver

echo "*****************************build kubelet*****************************"
cp $KUBELET_CSR_TEMPLATE $KUBELET_CSR
sed -i "s/host10/$IP10/g" $KUBELET_CSR
sed -i "s/host11/$IP11/g" $KUBELET_CSR
sed -i "s/host12/$IP12/g" $KUBELET_CSR
sed -i "s/host21/$IP21/g" $KUBELET_CSR
sed -i "s/host22/$IP22/g" $KUBELET_CSR
sed -i "s/host200/$IP200/g" $KUBELET_CSR
cfssl gencert -ca=ca.pem -ca-key=ca-key.pem -config=ca-config.json -profile=server kubelet-csr.json | cfssl-json -bare kubelet

echo "*****************************build kubeproxy*****************************"
cp $KUBE_PROXY_CSR_TEMPLATE $KUBE_PROXY_CSR
cfssl gencert -ca=ca.pem -ca-key=ca-key.pem -config=ca-config.json -profile=client kube-proxy-csr.json |cfssl-json -bare kube-proxy-client