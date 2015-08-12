package com.example.tangshisongci.bofang;

import com.example.tangshisongci.R;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class Mp3service extends Service{

	static MediaPlayer mediaplarer=null;
	private int key;
	private int msg;
	
	
	
	
@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
	    key=intent.getIntExtra("key", -1);
	    msg=intent.getIntExtra("msg",-1);
	    System.out.println(key+"zhe"+msg);
	    if(msg==1){
	    	start(key);
	    }
	    if(msg==2){
	    	pause();
	    }
	    if(msg==3){
	    	stop();
	    }
		return super.onStartCommand(intent, flags, startId);
	}


	public void onCreate() {
		// TODO Auto-generated method stub
	
		super.onCreate();
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	
	public void start(int a) {
		try {
			if (mediaplarer != null) {
				if (mediaplarer.isPlaying()) {
					return;
				}
			}
//			 stop();
			
			switch (a) {
			case 0:mediaplarer = MediaPlayer.create(this,R.raw.a1);break;
			case 1:mediaplarer = MediaPlayer.create(this,R.raw.a2);break;
			case 2:mediaplarer = MediaPlayer.create(this,R.raw.a3);break;
			case 3:mediaplarer = MediaPlayer.create(this,R.raw.a4);break;
			case 4:mediaplarer = MediaPlayer.create(this,R.raw.a5);break;
			case 5:mediaplarer = MediaPlayer.create(this,R.raw.a6);break;
			case 6:mediaplarer = MediaPlayer.create(this,R.raw.a7);break;
			case 7:mediaplarer = MediaPlayer.create(this,R.raw.a8);break;
			case 8:mediaplarer = MediaPlayer.create(this,R.raw.a9);break;
			case 9:mediaplarer = MediaPlayer.create(this,R.raw.a10);break;
			case 10:mediaplarer = MediaPlayer.create(this,R.raw.a11);break;
			case 11:mediaplarer = MediaPlayer.create(this,R.raw.a12);break;
			case 12:mediaplarer = MediaPlayer.create(this,R.raw.a13);break;
			case 13:mediaplarer = MediaPlayer.create(this,R.raw.a14);break;
			case 14:mediaplarer = MediaPlayer.create(this,R.raw.a15);break;
			case 15:mediaplarer = MediaPlayer.create(this,R.raw.a16);break;
			case 16:mediaplarer = MediaPlayer.create(this,R.raw.a17);break;
			case 17:mediaplarer = MediaPlayer.create(this,R.raw.a18);break;
			case 18:mediaplarer = MediaPlayer.create(this,R.raw.a19);break;
			case 19:mediaplarer = MediaPlayer.create(this,R.raw.a20);break;
			case 20:mediaplarer = MediaPlayer.create(this,R.raw.a21);break;
			case 21:mediaplarer = MediaPlayer.create(this,R.raw.a22);break;
			case 22:mediaplarer = MediaPlayer.create(this,R.raw.a23);break;
			case 23:mediaplarer = MediaPlayer.create(this,R.raw.a24);break;
			case 24:mediaplarer = MediaPlayer.create(this,R.raw.a25);break;
			case 25:mediaplarer = MediaPlayer.create(this,R.raw.a26);break;
			case 26:mediaplarer = MediaPlayer.create(this,R.raw.a27);break;
			case 27:mediaplarer = MediaPlayer.create(this,R.raw.a28);break;
			case 28:mediaplarer = MediaPlayer.create(this,R.raw.a29);break;
			case 29:mediaplarer = MediaPlayer.create(this,R.raw.a30);break;
			case 30:mediaplarer = MediaPlayer.create(this,R.raw.a31);break;
			case 31:mediaplarer = MediaPlayer.create(this,R.raw.a32);break;
			case 32:mediaplarer = MediaPlayer.create(this,R.raw.a33);break;
			case 33:mediaplarer = MediaPlayer.create(this,R.raw.a34);break;
			case 34:mediaplarer = MediaPlayer.create(this,R.raw.a35);break;
			case 35:mediaplarer = MediaPlayer.create(this,R.raw.a36);break;
			case 36:mediaplarer = MediaPlayer.create(this,R.raw.a37);break;
			case 37:mediaplarer = MediaPlayer.create(this,R.raw.a38);break;
			case 38:mediaplarer = MediaPlayer.create(this,R.raw.a39);break;
			case 39:mediaplarer = MediaPlayer.create(this,R.raw.a40);break;
			case 40:mediaplarer = MediaPlayer.create(this,R.raw.a41);break;
			case 41:mediaplarer = MediaPlayer.create(this,R.raw.a42);break;
			case 42:mediaplarer = MediaPlayer.create(this,R.raw.a43);break;
			case 43:mediaplarer = MediaPlayer.create(this,R.raw.a44);break;
			case 44:mediaplarer = MediaPlayer.create(this,R.raw.a45);break;
			case 45:mediaplarer = MediaPlayer.create(this,R.raw.a46);break;
			case 46:mediaplarer = MediaPlayer.create(this,R.raw.a47);break;
			case 47:mediaplarer = MediaPlayer.create(this,R.raw.a48);break;
			case 48:mediaplarer = MediaPlayer.create(this,R.raw.a49);break;
			case 49:mediaplarer = MediaPlayer.create(this,R.raw.a50);break;
			case 50:mediaplarer = MediaPlayer.create(this,R.raw.a51);break;
			case 51:mediaplarer = MediaPlayer.create(this,R.raw.a52);break;
			case 52:mediaplarer = MediaPlayer.create(this,R.raw.a53);break;
			case 53:mediaplarer = MediaPlayer.create(this,R.raw.a54);break;
			case 54:mediaplarer = MediaPlayer.create(this,R.raw.a55);break;
			case 55:mediaplarer = MediaPlayer.create(this,R.raw.a56);break;
			case 56:mediaplarer = MediaPlayer.create(this,R.raw.a57);break;
			case 57:mediaplarer = MediaPlayer.create(this,R.raw.a58);break;
			case 58:mediaplarer = MediaPlayer.create(this,R.raw.a59);break;
			case 59:mediaplarer = MediaPlayer.create(this,R.raw.a60);break;
			case 60:mediaplarer = MediaPlayer.create(this,R.raw.a61);break;
			case 61:mediaplarer = MediaPlayer.create(this,R.raw.a62);break;
			case 62:mediaplarer = MediaPlayer.create(this,R.raw.a63);break;
			case 63:mediaplarer = MediaPlayer.create(this,R.raw.a64);break;
			case 64:mediaplarer = MediaPlayer.create(this,R.raw.a65);break;
			case 65:mediaplarer = MediaPlayer.create(this,R.raw.a66);break;
			case 66:mediaplarer = MediaPlayer.create(this,R.raw.a67);break;
			case 67:mediaplarer = MediaPlayer.create(this,R.raw.a68);break;
			case 68:mediaplarer = MediaPlayer.create(this,R.raw.a69);break;
			case 69:mediaplarer = MediaPlayer.create(this,R.raw.a70);break;
			case 70:mediaplarer = MediaPlayer.create(this,R.raw.a71);break;
			case 71:mediaplarer = MediaPlayer.create(this,R.raw.a72);break;
			case 72:mediaplarer = MediaPlayer.create(this,R.raw.a73);break;
			case 73:mediaplarer = MediaPlayer.create(this,R.raw.a74);break;
			case 74:mediaplarer = MediaPlayer.create(this,R.raw.a75);break;
			case 75:mediaplarer = MediaPlayer.create(this,R.raw.a76);break;
			default:
				break;
			}

			mediaplarer
					.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

						@Override
						public void onCompletion(MediaPlayer mp) {
							// TODO Auto-generated method stub
//							Toast toast=Toast.makeText(getApplicationContext(), "播放完毕", Toast.LENGTH_SHORT); 
//							toast.show();
//							anjian = 0;
//							ib1.setImageDrawable(getResources().getDrawable(R.drawable.abc_ic_go));
//							 mediaplarer.release();  
//					            mediaplarer = null; 
						}
					});
			mediaplarer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
				@Override
				public boolean onError(MediaPlayer mp, int what, int extra) {
					// TODO Auto-generated method stub
					mediaplarer.release();onDestroy();
					return false;
				}
			});
			mediaplarer.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void stop() {
		// TODO Auto-generated method stub
		try {
			if (mediaplarer != null) {
				onDestroy();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void pause() {
		try {
			if (mediaplarer != null) {
				if (mediaplarer.isPlaying()) {
					mediaplarer.pause();
				} else {
					mediaplarer.start();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (mediaplarer != null) {  
            mediaplarer.release();  
            mediaplarer = null;  
            
        } 
	}


}
