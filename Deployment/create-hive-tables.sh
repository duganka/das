#!/usr/bin/env bash

set -x

cat ../SQL/create-hive-db.sql > hive.sql

for day in 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25; do
    echo "ALTER TABLE visited_products ADD PARTITION (YEAR=2015, MONTH=9, DAY=${day}) LOCATION '/data/visited_products/2015/09/${day}';" >> hive.sql
    echo "ALTER TABLE bought_products ADD PARTITION (YEAR=2015, MONTH=9, DAY=${day}) LOCATION '/data/bought_products/2015/09/${day}';" >> hive.sql
done

beeline -u jdbc:hive2://localhost:10000/default -f hive.sql

rm hive.sql
