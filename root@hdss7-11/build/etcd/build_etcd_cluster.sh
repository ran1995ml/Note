#!/bin/sh

echo "*****************************hdss7-12*****************************"
ssh hdss7-12
bash deploy_docker.sh 21
exit

echo "*****************************hdss7-21*****************************"
ssh hdss7-22
bash deploy_docker.sh 22
exit

echo "*****************************hdss7-22*****************************"
ssh hdss7-200
bash deploy_docker.sh 200
exit