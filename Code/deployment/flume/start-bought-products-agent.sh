#!/usr/bin/env bash

flume-ng agent --conf conf --conf-file flume.conf --name bought-products -Dflume.root.logger=INFO,console
