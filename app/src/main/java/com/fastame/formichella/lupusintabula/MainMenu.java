package com.fastame.formichella.lupusintabula;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);

        //Code to change font
        Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "from_cartoon_blocks.ttf");
        TextView myTitle = (TextView)findViewById(R.id.title);
        myTitle.setTypeface(myTypeFace);
        //End of code
    }
}
