#!/usr/bin/env bash

set -x

DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )

mysql --user=root --password=cloudera < ${DIR}/../../SQL/create-mysql-db.sql
