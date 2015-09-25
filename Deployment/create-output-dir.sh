#!/usr/bin/env bash

set -x

sudo su - hdfs
hadoop fs -mkdir -p /data/bought-products
hadoop fs -mkdir -p /data/visited-products
hadoop fs -chmod 777 /data
hadoop fs -chmod 777 /data/bought-products
hadoop fs -chmod 777 /data/visited-products

hadoop fs -chmod 777 /user