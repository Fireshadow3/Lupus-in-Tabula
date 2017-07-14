package com.fastame.formichella.lupusintabula;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        TextView chat = (TextView)findViewById(R.id.chat);

        //Code for buttons
        typeInButton = view.findViewById(R.id.typeInButton);

        
    }
}
