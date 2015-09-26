#!/usr/bin/env bash

set -x

. report-functions.sh

run_report "top-views.sql" "last_week_top_views" 7
run_report "top-sales.sql" "last_week_top_sales" 7
