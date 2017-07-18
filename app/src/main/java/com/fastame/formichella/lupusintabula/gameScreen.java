package com.fastame.formichella.lupusintabula;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fastame.formichella.lupusintabula.server;
import java.util.Random;

import static android.content.ContentValues.TAG;
import static com.fastame.formichella.lupusintabula.server.*;

public class gameScreen extends Activity {

    private Button typeInButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen_activity);
        View view = LayoutInflater.from(this).inflate(R.layout.game_screen_activity,null, false);
        setContentView(view);

        //If player == farmer then
        //wolfButton = gone (invisible)

        //If player == wolf then nothing

        //Code for textview (chat moved to top)
        final EditText input = (EditText) findViewById(R.id.typeInChat);
        final TextView chat = (TextView)findViewById(R.id.chat);
        final Button wolfButton = (Button) findViewById(R.id.wolfButton);
        final Button farmerButton = (Button) findViewById(R.id.farmerButton);

        //Code for spinner http://corsiandroid.it/spinner/esempio-spinner
        Spinner farmerSpinner = (Spinner)findViewById(R.id.farmerSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                new String[]{"pippo","pluto","paperino","topolino"}
        );
        farmerSpinner.setAdapter(adapter);

        farmerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapter, View view,int pos, long id) {
                String selected = (String)adapter.getItemAtPosition(pos);
                Toast.makeText(
                        getApplicationContext(),
                        "Hai selezionato "+selected,
                        Toast.LENGTH_LONG
                ).show();
            }
            public void onNothingSelected(AdapterView<?> arg0) {}
        });

        //Code for scrolling textView
        chat.setMovementMethod(new ScrollingMovementMethod());

        //Code for buttons
        typeInButton = view.findViewById(R.id.typeInButton);


        typeInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringChat;
                String stringInput;
                stringChat = chat.getText().toString();
                stringInput = input.getText().toString();
                stringChat = stringChat + "\n" + "Tu: " + stringInput;
                chat.setText(stringChat);
            }
        });

        tickCycle(chat,wolfButton,farmerButton,farmerSpinner);
    }


    //https://stackoverflow.com/questions/11434056/how-to-run-a-method-every-x-seconds
    public void tickCycle(final TextView chat, final Button wolfButton, final Button farmerButton, Spinner farmerSpinner){
        final Handler h = new Handler();
        final int delay = 1; //milliseconds
        //We start a simulated server
        final server gameServer;
        //Code for spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                new String[]{server.players[0].name,"pluto","paperino","topolino"}
        );
        farmerSpinner.setAdapter(adapter);

        //h.postDelayed(new Runnable(){...}, delay)
        h.postDelayed(new Runnable(){
            public void run(){
                //Cycle start
                int turns;
                int role;
                role = server.getGameClass();
                turns = server.getTurns();
                //Decide whatever to delete the wolfButton
                switch (role){
                    case 0: //Farmer
                        wolfButton.setVisibility(View.GONE);
                        break;
                    case 1: //Wolf
                        break;
                }
                //If it's night
                if(turns%2==0){

                }

                switch (server.isReady()){
                    case 0: //Can continue
                        chat.setText(chat.getText().toString() + "\nLet's continue!");
                        break;
                    case 1:
                        chat.setText(chat.getText().toString() + "\nThere was a problem!");
                        break; //Can't continue
                    default:
                        chat.setText(chat.getText().toString() + "\nThis can't be true!");
                        break;
                }


                //Cycle end
                h.postDelayed(this, delay);
            }
        }, delay);
    }
}