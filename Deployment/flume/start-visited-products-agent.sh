#!/usr/bin/env bash

flume-ng agent --conf conf --conf-file flume.conf --name visited-products -Dflume.root.logger=INFO,console
