package com.fastame.formichella.lupusintabula;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class gameScreen extends Activity {

    private Button typeInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen_activity);
        View view = LayoutInflater.from(this).inflate(R.layout.game_screen_activity,null, false);
        setContentView(view);

        //If player == farmer then
        //wolfButton = gone (invisible)

        //If player == wolf then nothing

        //Code for textview
        final TextView chat = (TextView)findViewById(R.id.chat);
        final EditText input = (EditText) findViewById(R.id.typeInChat);

        //Code for buttons
        typeInButton = view.findViewById(R.id.typeInButton);

        typeInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringChat;
                String stringInput;
                stringChat = chat.getText().toString();
                stringInput = input.getText().toString();
                stringChat = stringChat + "\n" + stringInput;
                chat.setText(stringChat);
            }
        });
    }
}
