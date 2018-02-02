#!/bin/bash

clear
javac src/*.java -d bin
cd bin
rm ../LiraPhysics.jar
jar cfm ../LiraPhysics.jar ../manifest.mf *.class ../lang ../styles ../img

if [ "$1" == "e" ]; then
  cd ..
  ./executar.sh
fi
