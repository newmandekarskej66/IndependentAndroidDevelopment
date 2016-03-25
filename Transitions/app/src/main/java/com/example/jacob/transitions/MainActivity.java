package com.example.jacob.transitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.transition.TransitionManager;

public class MainActivity extends AppCompatActivity {


    ViewGroup jacobsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jacobsLayout = (ViewGroup) findViewById(R.id.jacobsLayout);

        jacobsLayout.setOnTouchListener(

                new RelativeLayout.OnTouchListener(){

                    public boolean onTouch(View v, MotionEvent event){
                            moveButton();
                            return true;
                     }
                 }
        );


    }

    public void moveButton(){
        View jacobsButton = findViewById(R.id.jacobsButton);

        //Applies smooth transistion
        TransitionManager.beginDelayedTransition(jacobsLayout);

        //Change the position of the button
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        jacobsButton.setLayoutParams(positionRules);


        //Change the size of the button
        ViewGroup.LayoutParams sizeRules = jacobsButton.getLayoutParams();
        sizeRules.width = 450;
        sizeRules.height = 300;
        jacobsButton.setLayoutParams(sizeRules);

    }

}
