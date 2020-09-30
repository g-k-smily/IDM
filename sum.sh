i="y"
while [ $i = "y" ]
do
	echo "1.ADD"
	echo "2.SUB"
	echo "3.MUL"
	echo "4.DIV"
	echo "5.MOD"
	echo "Enter your choice"
	read ch
case $ch in
	1)ADD=$(($1+$2))
	echo "ADD = "$ADD;;
	2)SUB=$(($1-$2))
	echo "sub ="$SUB;;
	3)MUL=$(($1*$2))
	echo  "mul ="$MUL;;
	4)DIV=$(($1/$2))
	echo  "div ="$DIV;;
	5)MOD=$(($1%$2))
	echo  "mod is"$MOD;;
	*)echo "Invalid choice"
esac
echo "If You Want to Continue"
read i
if [ $i != y ]
then 
	exit
fi
done
