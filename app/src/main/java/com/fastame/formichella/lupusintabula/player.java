package com.fastame.formichella.lupusintabula;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alessandro on 18/07/2017.
 */
  //public List<player> players = new ArrayList<>();
public class player {
    public String name;
    public boolean alive;
    public boolean isKilled;
    public int role; //wolf 1 farmer 0

    /*
    * Kills another player by setting its "alive" value to false
    */
    static public void killPlayer(player guyToKill){
        guyToKill.alive = false;
    }

    public player(){}

    public String getPlayerName(){
        return name;
    }
    public void setPlayerName(String string){
        name = string;
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
