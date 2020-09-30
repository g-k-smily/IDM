FN=$1
#echo "enter filename"
#read FN
if [ -f $FN ]
then
	sed 's/[!@#\$%^&*(){}!;.><|]//g' < $FN
else
	echo "$FN doestnot exist"
fi
