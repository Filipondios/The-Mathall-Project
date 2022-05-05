#!/bin/bash
# If the folder that contains the project is named diferently than The-Mathall-Project be sure to rename it or it wont work.
# Don't forget to run "chmod +x mathallInit.sh" before "./mathallInit.sh"

{ # try?
    clear && java -jar "Mathall/dist/Mathall.jar"
} || { # catch?
    echo -e "Mathall couldn't start due some error... \nCheck that everything is in the correct folder."
}