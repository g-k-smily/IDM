filename=$1
if [ -f $filename ]
then 
	read start
	read end
	i=1
	while [ $i -le $end ]
	do 
	read -r line
	if [ $i -lt $start ]
	then
		i=`expr $i + 1` 
		continue
		echo "Do Nothing"
	else
		echo $line
	fi
	i=`expr $i + 1` 
	done < $filename
fi
