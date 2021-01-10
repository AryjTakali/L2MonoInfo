#!/bin/bash

trap '' SIGINT

echo "il ne doit en rester qu'un"
sleep 1
./$0
