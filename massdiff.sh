#!/bin/bash

filename=$1
folderfiles=*
rm output.log
touch output.log
for f in $folderfiles
do
	echo $f
	if [ "$f" = "$filename" ]; then
		echo "f and file are the same"
	else
		diff $filename $f >> output.log
	fi
done