if [ $# -lt 1 ]
then
	echo "invalid args"
else
	FILE=$1
	LOF=`cat $FILE | wc -1`
fi
if [ $LOF < 1 ]
then
	exit
else
	while [ $LOF -ge 1 ]
	do
		read LINE
		if [ [[ $LINE == [0-9]{10} ]] || [[ $LINE == [0-9]{3}[-][0-9]{3}[-][0-9]{4} ]] ]
		then
			echo "$LINE valid"
		else
			echo "$LINE invalid"
		fi
		LOF=$(($LOF -1))
	done < $FILE
fi
