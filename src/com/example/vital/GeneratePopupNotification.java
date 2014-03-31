package com.example.vital;

import android.app.*;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;

public class GeneratePopupNotification extends Activity {

	
	//code to generate popup notification to the screen with an inputted message
	
    PopupWindow popUp;
    LinearLayout layout;
    Button popupButton, insidePopupButton;
    TextView popupText;
    LayoutParams params;
    LinearLayout mainLayout;
    Button but;
    boolean click = true;
 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        popUp = new PopupWindow(this);
        layout = new LinearLayout(this);
        mainLayout = new LinearLayout(this);
        popupText = new TextView(this);
        but = new Button(this);
        but.setText("Click Me");
        but.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                if (click) {
                    popUp.showAtLocation(mainLayout, Gravity.BOTTOM, 10, 10);
                    popUp.update(50, 50, 300, 80);
                    click = false;
                } else {
                    popUp.dismiss();
                    click = true;
                }
            }

        });
        params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        popupText.setText("Hi this is a sample text for popup window");
        layout.addView(popupText, params);
        popUp.setContentView(layout);
        // popUp.showAtLocation(layout, Gravity.BOTTOM, 10, 10);
        mainLayout.addView(but, params);
        setContentView(mainLayout);
    }
    
 
//    public void init() {
//        popupButton = (Button) findViewById(R.id.popupbutton);
//        popupText = new TextView(this);
//        insidePopupButton = new Button(this);
//        layoutOfPopup = new LinearLayout(this);
//        insidePopupButton.setText("OK");
//        popupText.setText("This is Popup Window.press OK to dismiss         it.");
//        popupText.setPadding(0, 0, 0, 20);
//        layoutOfPopup.setOrientation(1);
//        layoutOfPopup.addView(popupText);
//        layoutOfPopup.addView(insidePopupButton);
//    }
// 
//    public void popupInit() {
//        popupButton.setOnClickListener(this);
//        insidePopupButton.setOnClickListener(this);
//        popupMessage = new PopupWindow(layoutOfPopup, LayoutParams.FILL_PARENT,
//                LayoutParams.WRAP_CONTENT);
//        popupMessage.setContentView(layoutOfPopup);
//    }
// 
//    @Override
//    public void onClick(View v) {
// 
//        if (v.getId() == R.id.popupbutton) {
//            popupMessage.showAsDropDown(popupButton, 0, 0);
//        }
// 
//        else {
//            popupMessage.dismiss();
//        }
//    }
	
	
}
