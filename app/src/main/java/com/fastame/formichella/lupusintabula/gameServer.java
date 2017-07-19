package com.fastame.formichella.lupusintabula;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.fastame.formichella.lupusintabula.player;

/**
 * Created by Alessandro on 17/07/2017.
 */

public class gameServer{
    //Number of current turns (first turn is night)
    private static int turns;

    //SOLUTION TO ALLOCATION OF MULTIPLE OBJECTS IN AN ARRAY https://stackoverflow.com/questions/5364278/creating-an-array-of-objects-in-java
    public List<player> players = new ArrayList<>();

    //public static player[] players = new player[8];

    /*
     * This function registers all of the players with saved data
     */
    public List<player> registerPlayers(){
        player user = new player();
        user.name = "User";
        user.alive = true;
        user.role = 0;

        players.add(0,user);
        players.set(0,user).name = "Pino"; //Name
        players.set(0,user).alive = true; //Alive
        players.set(0,user).role = 0; //Farmer
        players.add(1,user);
        players.set(1,user).name = "Gino";
        players.set(1,user).alive = true;
        players.set(1,user).role = 0;
        players.add(2,user);
        players.set(2,user).name = "Rino";
        players.set(2,user).alive = true;
        players.set(2,user).role = 0;
        players.add(3,user);
        players.set(3,user).name = "Ermenegildo";
        players.set(3,user).alive = true;
        players.set(3,user).role = 0;
        players.add(4,user);
        players.set(4,user).name = "Belardo";
        players.set(4,user).alive = true;
        players.set(4,user).role = 0;
        players.add(5,user);
        players.set(5,user).name = "Ursulo";
        players.set(5,user).alive = true;
        players.set(5,user).role = 1; //Wolf
        players.add(6,user);
        players.set(6,user).name = "Caio";
        players.set(6,user).alive = true;
        players.set(6,user).role = 0;
        players.add(7,user);
        players.set(7,user).name = "VonLowester";
        players.set(7,user).alive = true;
        players.set(7,user).role = 0;
        return players;
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
    public int isReady(){
        int n = randomNumber(1);
        //If the server is ready
        if(n==0){
            gameServer.turns = gameServer.turns+1;
        }
        return n;
    }
    static public int getTurns(){
        return gameServer.turns;
    }
}
//https://stackoverflow.com/questions/11434056/how-to-run-a-method-every-x-seconds