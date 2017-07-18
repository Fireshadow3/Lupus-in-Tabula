package com.fastame.formichella.lupusintabula;

/**
 * Created by Alessandro on 18/07/2017.
 */

public class player {
    public static String name;
    public static boolean alive;
    public static int role; //wolf 1 farmer 0

    /*
    * Kills another player by setting its "alive" value to false
    */
    static public void killPlayer(player guyToKill){
        guyToKill.alive = false;
    }
    /*int m=8;
    int array[int m];

    int array[0]= 1;

    for(int u=7, u>0, u--){
        array[u]=0;
        //se il vettore con indice x = 0 wolf, altrimenti farmer
    }
    if (array[m]=0){
        role=1;//Wolf = 1
    }
    else {
        role=0;
    }*/
}
