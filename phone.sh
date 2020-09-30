echo "enter a filename"
read filename
if [ -f $filename ]
then
	grep -P '^(\d{3}-\d{3}-\d{4}|\d{3}\d{3}\d{4})$' < $filename
else
        echo "Invalid"
fi

