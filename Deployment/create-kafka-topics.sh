#!/usr/bin/env bash

for topic in visited-products bought-products; do
    kafka-topics --create --topic ${topic} --partitions 3 --replication-factor 1 --zookeeper localhost:2181
done
