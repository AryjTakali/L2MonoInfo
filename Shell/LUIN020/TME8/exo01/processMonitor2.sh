#! /bin/bash

if [ !-e $1 ] || [ !-f '/proc/$1/exe' ]; then
    echo "Usage : $0 <PID>"
    exit
fi

for i in {1..60}; do
	ps o pid,ppid,state,command $1
	sleep 1
done
