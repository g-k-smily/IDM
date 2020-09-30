echo "Enter filename"
read FN
echo "content of $FN before converting into UpeerCase"
cat $FN
echo "Content of $FN After Converting into UpperCase"
tr '[ a-z ]' '[ A-Z ]' < $FN
