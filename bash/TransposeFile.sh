#!/usr/bin/env bash
awk '
{
    for(i = 1; i <= NF; i += 1){
        if(NR == 1){
            s[i]=$i;
        }else{
            s[i] = s[i] " " $i;
        }
    }
}
END{
    for(i = 1; s[i] != ""; i += 1){
        print s[i];
    }
}
' file.txt