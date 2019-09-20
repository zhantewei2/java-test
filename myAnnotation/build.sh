#!/usr/bin/env bash
various="mf"
my_path=$(cd `dirname $0`;pwd)
src_path=$my_path/src/main/java/cm
resources_path=$my_path/src/main/resources
target_path=$my_path/target
meta_path=$target_path/META-INF/MANIFEST.MF
output_path=$my_path/dist

echo "hostPath:" $my_path


function compiler(){
    if [ ! -d $my_path/target ]; then
        mkdir $target_path
    fi
    javac $src_path/*.java -d $target_path
    cp -rf $resources_path/* $target_path
}
function checkOutput(){
    if [ ! -d $output_path ];then
        mkdir $output_path
    fi
}


if [ "$various" == "mf" ] ;then
    compiler
    cd $target_path
    checkOutput
    jar cvfM $my_path/dist/myAnnotation.jar `ls $target_path`
fi
