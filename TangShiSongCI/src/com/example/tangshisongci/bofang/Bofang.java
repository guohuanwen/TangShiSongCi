package com.example.tangshisongci.bofang;

import com.example.tangshisongci.R;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ArrowKeyMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView.BufferType;
import android.widget.TextView;

public class Bofang extends Activity {
	private ImageButton ib1=null;
	private ImageButton ib2=null;
	private int key;
	private int anjian;
	private SeekBar sb1=null;
	private TextView nowplaytime=null;
	private TextView tv=null;
	private Mp3service mp3;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bofang);
		ib1 = (ImageButton) findViewById(R.id.bofangib1);
		ib2 = (ImageButton) findViewById(R.id.bofangib2);
		tv=(TextView)findViewById(R.id.bofangtv);
		sb1 = (SeekBar) findViewById(R.id.bofangsb1);
		nowplaytime = (TextView) findViewById(R.id.bofangtv1);
		
		tv.setFocusableInTouchMode(true);
		tv.setFocusable(true);
		tv.setClickable(true);
		tv.setLongClickable(true);
		tv.setMovementMethod( ArrowKeyMovementMethod.getInstance());
		tv.setText(tv.getText(),BufferType.SPANNABLE );
		
		Intent a=getIntent();
		String name=a.getStringExtra("name");
		Resources res =getResources();
		String[]  data=res.getStringArray(R.array.langsong);
		Resources pome =getResources();
		
		String[] pomearray=pome.getStringArray(R.array.langsongpome);
		
		for(int i = 0;i<data.length;i++){
			if(name.equals(data[i])){
				tv.setText(pomearray[i]);
				key=i;
				break;
			}
		}
		
		
		
		
		ib1.setImageDrawable(getResources().getDrawable(
				R.drawable.abc_ic_go_search_api_mtrl_alpha));
		sb1.setOnSeekBarChangeListener(new seekbar());
		
		ib1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (anjian) {
				case 0:
					anjian = 1;
					ib1.setImageDrawable(getResources().getDrawable(
							R.drawable.pause));
					start(key);
					break;
				case 1:
					anjian = 2;
					pause();
					ib1.setImageDrawable(getResources().getDrawable(
							R.drawable.abc_ic_go_search_api_mtrl_alpha));
					break;
				case 2:
					anjian = 1;
					pause();
					
					ib1.setImageDrawable(getResources().getDrawable(
							R.drawable.pause));
					break;
				default:
					break;
				}
			}
		});
		
		ib2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stop();
				int CurrentPosition = 0;
				nowplaytime.setText(null);
				sb1.setProgress(CurrentPosition);
				anjian = 0;
				ib1.setImageDrawable(getResources().getDrawable(
						R.drawable.abc_ic_go_search_api_mtrl_alpha));
				
			}
		});
		

	}
public void start(int key) {
	Intent intent = new Intent();  
    intent.putExtra("key",key);
    intent.putExtra("msg",1);
    intent.setClass(Bofang.this,Mp3service.class);  
    System.out.println(key+"zhe");
    startService(intent);
    StrartbarUpdate();
}
public void pause(){
	Intent intent = new Intent();
    intent.putExtra("msg",2);
    intent.setClass(Bofang.this,Mp3service.class);  
    startService(intent);
}
public void stop(){
	Intent intent = new Intent();  
	intent.putExtra("msg", 3);
    intent.setClass(Bofang.this, Mp3service.class);  
    startService(intent); 
    
}

	class seekbar implements OnSeekBarChangeListener {

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// TODO Auto-generated method stub
			try {
				if (fromUser == true) {
					Mp3service.mediaplarer.seekTo(progress);
					if((progress-Mp3service.mediaplarer.getDuration()+1)>=0){
						ib1.setImageDrawable(getResources().getDrawable(
								R.drawable.abc_ic_go_search_api_mtrl_alpha));
						stop();
						nowplaytime.setText(null);
						sb1.setProgress(0);
						anjian = 0;
						
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// else{
			// mediaplarer.seekTo(0);
			// nowplaytime.setText(null);
			// }
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
		}

	}
	public static String ShowTime(int time) {
		time /= 1000;
		int min = time / 60;
		int sec = time % 60;
		 min %= 60;
		return String.format("%02d:%02d", min, sec);
	}

	Handler handler = new Handler();

	public void StrartbarUpdate() {
		handler.post(r);
	}

	private Runnable r = new Runnable() {
		public void run() {
			
			int CurrentPosition = 0;
			if (Mp3service.mediaplarer != null) {
				try {
					CurrentPosition = Mp3service.mediaplarer.getCurrentPosition();
					nowplaytime.setText(ShowTime(CurrentPosition));
					int max = Mp3service.mediaplarer.getDuration();
					sb1.setMax(max);
					sb1.setProgress(CurrentPosition);
					handler.postDelayed(r,100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

	};
	

	

	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent();  
			intent.putExtra("msg", 3);
		    intent.setClass(Bofang.this, Mp3service.class);  
		    startService(intent);
		}
		return super.onKeyDown(keyCode, event);

	}
//public tingzhi (){
	
//}
	
}
