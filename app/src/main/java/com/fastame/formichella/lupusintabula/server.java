package com.fastame.formichella.lupusintabula;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Alessandro on 17/07/2017.
 */

public class server{
    //Number of current turns (first turn is night)
    private static int turns;

    //SOLUTION TO ALLOCATION OF MULTIPLE OBJECTS IN AN ARRAY https://stackoverflow.com/questions/5364278/creating-an-array-of-objects-in-java
    public static player[] players = new player[8];

    players[0] = new player();
    players[1] = new player();
    players[2] = new player();
    players[3] = new player();
    players[4] = new player();
    players[5] = new player();
    players[6] = new player();
    players[7] = new player();

    //public static player[] players = new player[8];

    /*
     * This function registers all of the players with saved data
     */
    public void registerPlayers(){
        server.players[0].name = "Pino"; //Name
        server.players[0].alive = true; //Alive
        server.players[0].role = 0; //Farmer
        server.players[1].name = "Gino";
        server.players[1].alive = true;
        server.players[1].role = 0;
        server.players[2].name = "Rino";
        server.players[2].alive = true;
        server.players[2].role = 0;
        server.players[3].name = "Ermenegildo";
        server.players[3].alive = true;
        server.players[3].role = 0;
        server.players[4].name = "Belardo";
        server.players[4].alive = true;
        server.players[4].role = 0;
        server.players[5].name = "Ursulo";
        server.players[5].alive = true;
        server.players[5].role = 1; //Wolf
        server.players[6].name = "Caio";
        server.players[6].alive = true;
        server.players[6].role = 0;
        server.players[7].name = "VonLowester";
        server.players[7].alive = true;
        server.players[7].role = 0;
    }
    static private int randomNumber(int n){
        Random rand = new Random();
        int j = rand.nextInt(n); //If bound to 20, gives n such that 0 <= n < 20
        return j;
    }
    //Fetches a response from the com.fastame.formichella.lupusintabula.server. If:
    /*  0: Farmer
    *   1: Wolf
    */
    static public int getGameClass(){
        int n = randomNumber(1);
        return n;
    }
    //Fetches a response from the com.fastame.formichella.lupusintabula.server. If:
    /*  0: Can continue playing
    *   1: Can't continue playing
    */
    static public int isReady(){
        int n = randomNumber(1);
        //If the server is ready
        if(n==0){
            server.turns = server.turns+1;
        }
        return n;
    }
    static public int getTurns(){
        return server.turns;
    }
}
//https://stackoverflow.com/questions/11434056/how-to-run-a-method-every-x-seconds