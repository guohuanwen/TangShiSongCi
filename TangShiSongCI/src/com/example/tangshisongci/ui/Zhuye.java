package com.example.tangshisongci.ui;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.tangshisongci.R;



public class Zhuye extends Activity {

@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
	if(keyCode==KeyEvent.KEYCODE_BACK){
		new AlertDialog.Builder(Zhuye.this)
		.setTitle("亲爱的用户")
		.setMessage("您确定要退出吗？")
		.setPositiveButton("确定",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				setResult(RESULT_OK);
				finish();
			}
		})
		.setNegativeButton("取消",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		}).show();
	}
		return super.onKeyDown(keyCode, event);
	}


final int RIGHT=0;
final int LEFT=1;
private ImageButton ib1;
private ImageButton ib2;
private ImageButton ib3;
private ImageButton ib4;
private ImageButton ib6;
private static int yanse;
//private Touch touch;
//???????????????
private GestureDetector gestureDetector;
private static LinearLayout ll;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhuye);
		
		
		
		
		

		ib1=(ImageButton)findViewById(R.id.imageButton1);
		ib2=(ImageButton)findViewById(R.id.imageButton2);
		ib3=(ImageButton)findViewById(R.id.imageButton3);
		ib4=(ImageButton)findViewById(R.id.imageButton4);
		ll=(LinearLayout)findViewById(R.id.LinearLayout1);
		setcolor(yanse);
		ib1.setOnClickListener(new OnClickListener() {
	    
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Zhuye.this,Tangshi.class));
			}
		});
ib2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Zhuye.this,Songci.class));
			}
		});
ib3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		startActivity(new Intent(Zhuye.this,Chuangzuo1.class));
	}
});
ib4.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		startActivity(new Intent(Zhuye.this,Langsong.class));
	}
});

/*ib6.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		startActivity(new Intent(Zhuye.this,Setting.class));
	}
});*/
//		touch=new Touch();
//		System.out.println("touch");
//		touch.setButtonStateChangeListener(ib1);
		//?????????????
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
		gestureDetector=new GestureDetector(Zhuye.this,onGestureListener);}
	
	
		private GestureDetector.OnGestureListener onGestureListener=
				new GestureDetector.SimpleOnGestureListener(){
			public boolean onFling(MotionEvent e1,MotionEvent e2,float velocityX,float velocityY){
				float x=e2.getX()-e1.getX();
				float y=e2.getY()-e1.getY();
				if(Math.abs(x)>=Math.abs(y)){
				if(x>0){doResult(RIGHT);}
				else if(x<0){doResult(LEFT);}
				}
				return true;
			}
			
		};
		
		public boolean onTouchEvent  (MotionEvent event){
			return gestureDetector.onTouchEvent(event);
			
		}


	public void doResult (int action){
		   switch(action){
		   case RIGHT:
			   startActivity(new Intent(Zhuye.this,Tangshi.class));
			   break;
		   case LEFT:
			   startActivity(new Intent(Zhuye.this,Langsong.class));
			   break;
		   }
	   }
	
public void setcolor(int i){
	switch (i) {
case 0:ll.setBackgroundColor(Color.parseColor("#fffefe"));yanse=0;break;
case 1:ll.setBackgroundColor(Color.parseColor("#ff0101"));yanse=1;break;
case 2:ll.setBackgroundColor(Color.parseColor("#010101"));yanse=2;break;
case 3:ll.setBackgroundColor(Color.parseColor("#031afb"));yanse=3;break;
case 4:ll.setBackgroundColor(Color.parseColor("#fb8f03"));yanse=4;break;
case 5:ll.setBackgroundColor(Color.parseColor("#03fb09"));yanse=5;break;
	default:
		break;
	}
}


@Override
public boolean onCreateOptionsMenu(Menu menu) {

	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	int id = item.getItemId();
	if (id == R.id.action_settings) {
		startActivity(new Intent(Zhuye.this,Setting.class));
		return true;
	}
	return super.onOptionsItemSelected(item);
}

}
