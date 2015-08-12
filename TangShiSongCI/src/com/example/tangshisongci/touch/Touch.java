package com.example.tangshisongci.touch;

import android.graphics.ColorMatrixColorFilter;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class Touch {
private final static float[] Button_press=new float []{
	2.0f,0,0,0,-50,
	0,2.0f,0,0,-50,
	0,0,2.0f,0,-50,
	0,0,0,5,0};

private final static float[] Button_relesce=new float[]{
	1,0,0,0,0,
	0,1,0,0,0,
	0,0,1,0,0,
	0,0,0,1,0};
private static final OnTouchListener touchListener=new OnTouchListener() {
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		System.out.println("touch1");
		if(event.getAction()==MotionEvent.ACTION_DOWN){
			v.getBackground().setColorFilter(new ColorMatrixColorFilter(Button_press));
		}
		else if(event.getAction()==MotionEvent.ACTION_UP){
			v.getBackground().setColorFilter(new ColorMatrixColorFilter(Button_relesce));
			v.setBackgroundDrawable(v.getBackground());
		}
		return false;
	}
};
public void setButtonStateChangeListener(View v){
	v.setOnTouchListener(touchListener);
}

}