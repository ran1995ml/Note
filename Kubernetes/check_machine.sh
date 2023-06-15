#!/bin/bash
my_array=(
#rccp301-6a.iad6.prod.conviva.com
#rccp301-34a.iad6.prod.conviva.com
#rccp302-34a.iad6.prod.conviva.com
#rccp303-34a.iad6.prod.conviva.com
#rccp304-34a.iad6.prod.conviva.com
#rccp305-34a.iad6.prod.conviva.com
#rccp306-34a.iad6.prod.conviva.com
rccp307-34a.iad6.prod.conviva.com
)
command="echo '############## df ########################';"
command+='df -h /;'
command+="echo '############## memory #################################';"
command+='free -g;'
command+="echo '############## cpu ####################################';"
command+='cat /proc/cpuinfo | grep processor;'
command+="echo '############## version ################################';"
command+='lsb_release -a;'
command+="echo '############## telnet #################################';"
command+="echo -e '\x1dclose\x0d' | telnet cc.imply.io 443;"
command+="echo '############## finish ################################';"
for i in "${my_array[@]}"
do
	echo -e "\nstart check server:$i"
    ssh -i /Users/rwei/Documents/conviva_cm_private_key.pem root@$i $command
    echo -e "end check server:$i \n"
done