a=10
until [ $a -lt 1 ]
do 
	echo $a
	a=`expr $a - 1`
done  
