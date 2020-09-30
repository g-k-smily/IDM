echo "Enter a file name"
read FN
if [ -f $FN ]
then

        echo "Number of words in File are: $(cat $FN | wc -w)"
        echo "Number of Lines in File are: $(cat $FN | wc -l)"
        echo "Number of White spaces in File are: $(cat $FN | grep -o " "| wc -l)"
        echo "Number of Charcaters in File : $(cat $FN | wc -c)"
else
        echo "$FN not exist"
fi
