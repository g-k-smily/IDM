echo "Enter a Value"
read a
if [ $((a%2)) == 0 ]
then 
	echo "$a is even"
else
	echo "$a is odd"
fi
