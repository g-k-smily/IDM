echo "enter two numbers"
read a b
if [ $a -gt $b ]
then 
	echo "$a is greater"
elif [ $a -lt $b ]
then 
	echo "$b is greater"
elif [ $a == $b ]
then
	echo "same"
elif [ $a != $b ]
then
	echo "not equal"
else 
	echo "invalid num"
fi
