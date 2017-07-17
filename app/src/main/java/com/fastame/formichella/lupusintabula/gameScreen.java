package com.fastame.formichella.lupusintabula;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

        tickCycle(chat);
    }


    //https://stackoverflow.com/questions/11434056/how-to-run-a-method-every-x-seconds
    public void tickCycle(final TextView chat){
        final Handler h = new Handler();
        final int delay = 1; //milliseconds
        //h.postDelayed(new Runnable(){...}, delay)
        h.postDelayed(new Runnable(){
            public void run(){
                //Cycle start
                switch (server.isReady()){
                    case 0: //Can continue
                        chat.setText(chat.getText().toString() + "\n 0");
                        break;
                    case 1:
                        chat.setText(chat.getText().toString() + "\n 1");
                        break; //Can't continue
                    default:
                        break;
                }


                //Cycle end
                h.postDelayed(this, delay);
            }
        }, delay);
    }
}