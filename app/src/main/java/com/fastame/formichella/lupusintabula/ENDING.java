package com.fastame.formichella.lupusintabula;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


public class ENDING extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_ending,null, false);
        setContentView(view);

        //Code to change font
        Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "from_cartoon_blocks.ttf");
        TextView myTitle = (TextView)findViewById(R.id.title);
        myTitle.setTypeface(myTypeFace);
        //End of code
    }

}
