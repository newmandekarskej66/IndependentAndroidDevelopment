package com.example.jacob.carly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//To import the layout to utilize it
import android.widget.RelativeLayout;
//To import the button widget
import android.widget.Button;
//Lets you use color
import android.graphics.Color;
//Import text widget
import android.widget.EditText;

//The following two imports are needed to convert DIP values to Pixel value because a function later
//in the code only takes pixel values.
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Layout
        RelativeLayout jacobsLayout = new RelativeLayout(this);
        //Adds a green color to the background in the layout
        jacobsLayout.setBackgroundColor(Color.GREEN);

        //Button
        Button redButton = new Button(this);

        //Adds text to button
        redButton.setText("Login!");

        //Sets color of the button
        redButton.setBackgroundColor(Color.RED);


        //Username input
        EditText username = new EditText(this);

        //Setting IDs for later usage
        redButton.setId(1);
        username.setId(2);


        //This is the section of code where I set the rules for my buttons placement
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        //Section of code where I set the rules for the text placement
        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //Give rules to position widgets

        usernameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.setMargins(0,0,0,50);

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        //Utilizes the imported libraries to convert Androids DIP values into Pixel Values
        Resources r = getResources();
        //This is the actual conversion from DIP to pixel values.
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200,
                r.getDisplayMetrics());
        //This line of code is where the width of the box for the username is set
        username.setWidth(px);

        //Add widget to layout (button is now a child of layout)
        //Also add Details to place my widgets in accordance to my placement values.
        jacobsLayout.addView(redButton, buttonDetails);
        jacobsLayout.addView(username, usernameDetails);

        //Sets this activities content/display to this view
        setContentView(jacobsLayout);

    }
}
