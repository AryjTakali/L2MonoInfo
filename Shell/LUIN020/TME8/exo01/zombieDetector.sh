#! /bin/bash

if [ ! -e $1 ] || [ ! -f '/proc/$1/exe' ]; then
    echo "Usage : $0 <PID>"
fi

ppid=$(ps o pid,ppid,state $1 | grep $1 | cut -d ' ' -f 2)

while [ ! -f '/proc/$1/exe' ]; do
       	if [ $ppid -ne $(ps o pid,ppid,state $! | grep $1 | cut -d ' ' -f 2) ]; then
		echo "Le processus est devenu zombie !!!"
		break
	fi
done
