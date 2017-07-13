package com.fastame.formichella.lupusintabula;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class MainMenu extends Activity {

    private Button playButton;
    private Button optionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);
        View view = LayoutInflater.from(this).inflate(R.layout.main_menu_activity,null, false);
        setContentView(view);

        //Code to change font
        Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "from_cartoon_blocks.ttf");
        TextView myTitle = (TextView)findViewById(R.id.title);
        myTitle.setTypeface(myTypeFace);
        //End of code
        //Code for buttons
        playButton = view.findViewById(R.id.playButton);
        optionButton = view.findViewById(R.id.optionButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Go to the main activity
                Intent intent = new Intent(MainMenu.this, chooseGame.class);
                startActivity(intent);
            }
        });

        optionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Go to the main activity
                Intent intent = new Intent(MainMenu.this, options.class);
                startActivity(intent);
            }
        });
    }
}
