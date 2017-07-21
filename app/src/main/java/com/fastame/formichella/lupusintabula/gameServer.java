package com.fastame.formichella.lupusintabula;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.fastame.formichella.lupusintabula.player;

/**
 * Created by Alessandro on 17/07/2017.
 */

public class gameServer {
    //Number of current turns (first turn is night)
    public static int turns;
    public boolean isReady = true;
    //This variable says if there was already said text
    public boolean alreadyWrote = false;
    //SOLUTION TO ALLOCATION OF MULTIPLE OBJECTS IN AN ARRAY https://stackoverflow.com/questions/5364278/creating-an-array-of-objects-in-java
    static public List<player> players = new ArrayList<>();

    //public static player[] players = new player[8];

    /*
     * This function registers all of the players with saved data
     */
    public List<player> registerPlayers() {

        for (int i = 0; i < 8; i++) {

            player user = new player();
            user.name = "User";
            user.alive = true;
            user.role = 0;

            players.add(i, user);
        }


        players.get(0).name = "Pino"; //Name
        players.get(0).alive = true; //Alive
        players.get(0).role = 0; //Farmer
        players.get(1).name = "Gino";
        players.get(1).alive = true;
        players.get(1).role = 0;
        players.get(2).name = "Rino";
        players.get(2).alive = true;
        players.get(2).role = 0;
        players.get(3).name = "Ermenegildo";
        players.get(3).alive = true;
        players.get(3).role = 0;
        players.get(4).name = "Belardo";
        players.get(4).alive = true;
        players.get(4).role = 0;
        players.get(5).name = "Ursulo";
        players.get(5).alive = true;
        players.get(5).role = 1; //Wolf
        players.get(6).name = "Caio";
        players.get(6).alive = true;
        players.get(6).role = 0;
        players.get(7).name = "VonLowester";
        players.get(7).alive = true;
        players.get(7).role = 0;
        return players;
    }

    static public boolean isEveryoneDead() {
        boolean everyoneDead = true;
        for (int i = 0; i < 8; i++) {
            if (gameServer.players.get(i).alive == true) {
                everyoneDead = false;
            }
        }
        return everyoneDead;
    }
    private int randomNumber(int n) {
        Random rand = new Random();
        int j = rand.nextInt(n); //If bound to 20, gives n such that 0 <= n < 20
        return j;
    }

    //Fetches a response from the com.fastame.formichella.lupusintabula.server. If:
    /*  0: Farmer
    *   1: Wolf
    */
    public int getGameClass() {
        int n = randomNumber(2);
        return n;
    }

    //Fetches a response from the com.fastame.formichella.lupusintabula.server. If:
    /*  0: Can continue playing
    *   1: Can't continue playing
    */
    /*public int isReady(){
        int n = randomNumber(1);
        //If the server is ready
        if(n==0){
            gameServer.turns = gameServer.turns+1;
        }
        return n;
    }*/
    static public int getTurns() {
        return gameServer.turns;
    }


}
//https://stackoverflow.com/questions/11434056/how-to-run-a-method-every-x-seconds