package com.fastame.formichella.lupusintabula;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import static android.content.ContentValues.TAG;

public class chooseGame extends Activity {

    private Button signUpButton;
    private Button joinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_game_activity);
        View view = LayoutInflater.from(this).inflate(R.layout.choose_game_activity,null, false);
        setContentView(view);

        signUpButton = view.findViewById(R.id.createButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chooseGame.this, gameScreen.class);
                startActivity(intent);
            }
        });

        joinButton = view.findViewById(R.id.joinButton);
        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chooseGame.this, gameScreen.class);
                startActivity(intent);
            }
        });
    }
}
