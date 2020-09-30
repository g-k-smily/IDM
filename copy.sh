echo "present working directory"
pwd
read TargetDir
ls
if [ -d $TargetDir ]
then
        mv *sh $TargetDir
else
        mkdir $TargetDir
        mv *sh $TargetDir
fi
