#!/bin/sh
./flanneld \
  --public-ip=hostId \
  --etcd-endpoints=https://host12:2379,https://host21:2379,https://host22:2379 \
  --etcd-keyfile=./cert/client-key.pem \
  --etcd-certfile=./cert/client.pem \
  --etcd-cafile=./cert/ca.pem \
  --iface=eth0 \
  --subnet-file=./subnet.env \
  --healthz-port=2401