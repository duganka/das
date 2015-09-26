#!/usr/bin/env bash

set -x

. report-functions.sh

run_report "top-views.sql" "last_day_top_views" 1
run_report "top-sales.sql" "last_day_top_sales" 1
