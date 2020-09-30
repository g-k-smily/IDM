echo "Enter A String"
read Str
echo "Enter character You wanted find in $Str"
read C
awk -v a="$Str" -v b="$C" 'BEGIN{print index(a,b)}'
