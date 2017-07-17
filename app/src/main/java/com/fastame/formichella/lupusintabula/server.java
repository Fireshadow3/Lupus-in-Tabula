package com.fastame.formichella.lupusintabula;

import java.util.Random;

/**
 * Created by Alessandro on 17/07/2017.
 */

public class server{
    static private int randomNumber(int n){
        Random rand = new Random();
        int j = rand.nextInt(4); //If bound to 20, gives n such that 0 <= n < 20
        return j;
    }
    //Fetches a response from the com.fastame.formichella.lupusintabula.server. If:
    /*  1: Farmer
    *   2: Wolf
    */
    static public int getGameClass(){
        int n = randomNumber(4);
        return n;
    }
    //Fetches a response from the com.fastame.formichella.lupusintabula.server. If:
    /*  0: Can continue playing
    *   1: Can't continue playing
    */
    static public int isReady(){
        int n = randomNumber(1);
        return n;
    }
}
//https://stackoverflow.com/questions/11434056/how-to-run-a-method-every-x-seconds