#!/usr/bin/env bash

DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )

run_report() {
    local report_script=$1
    local target_table=$2
    local days=$3

    local today=$(date +"%Y_%m_%d")
    local start_date=$(date -d "${days} days ago" +"%Y-%m-%d")
    local temp_table="${target_table}_${today}"

    beeline -u jdbc:hive2://localhost:10000/default \
        --hiveconf RESULT_TABLE=${temp_table}     \
        --hiveconf START_DATE=${start_date}          \
        -f ${DIR}/../sql/${report_script}

    echo "TRUNCATE ${target_table};" | mysql --user=root --password=cloudera das

    sqoop export                                \
        --connect jdbc:mysql://localhost/das    \
        --username root                         \
        --password cloudera                     \
        --table ${target_table}              \
        --input-fields-terminated-by '\t'       \
        --export-dir /user/hive/warehouse/das.db/${temp_table}

    beeline -u jdbc:hive2://localhost:10000/default -e "DROP TABLE das.${temp_table};"
}
