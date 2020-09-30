echo "enter a number"
read n
i=1
while [ $i -le 10 ]
do
	echo "$n * $i = $(($n*$i))"
	i=`expr $i + 1`
done
