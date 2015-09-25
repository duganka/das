#!/usr/bin/env bash

set -x

mysql --user=root --password=cloudera < ../SQL/create-mysql-db.sql
