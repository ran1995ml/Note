#!/bin/sh

kubectl apply -f http://k8s-yaml.od.com/coredns/rbac.yaml
kubectl apply -f http://k8s-yaml.od.com/coredns/cm.yaml
kubectl apply -f http://k8s-yaml.od.com/coredns/dp.yaml
kubectl apply -f http://k8s-yaml.od.com/coredns/svc.yaml
kubectl get all -n kube-system