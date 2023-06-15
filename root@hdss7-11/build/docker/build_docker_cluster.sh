#!/bin/sh
# 搭建Docker集群

echo "*****************************hdss7-21*****************************"
ssh hdss7-21
bash deploy_docker.sh 21
exit

echo "*****************************hdss7-22*****************************"
ssh hdss7-22
bash deploy_docker.sh 22
exit

echo "*****************************hdss7-200*****************************"
ssh hdss7-200
bash deploy_docker.sh 200
exit