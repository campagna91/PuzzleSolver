#!bin/bash

killall rmiregistry
rmiregistry& java server/PuzzleSolver $1
killall rmiregistry