package com.src;

public class Main {

    public static void main(String[] args) {
        for(int i=0;i<args.length;i++){
            if(args[i].equals("--network-enable")){
                Global.network_enable=true;
                Global.network_port=Integer.parseInt(args[++i]);
            } else{
                Global.script_root=args[i];
            }
        }
    }
}
