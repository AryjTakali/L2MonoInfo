#! /bin/bash

if [ !-e $1 ] || [ !-f '/proc/$1/exe' ]; then
    ./myZombie &
fi

i=0
while [ $i -lt 59 ]; do
    ps o pid,ppid,state $!
    sleep 1
    i=$((i+1))
done
