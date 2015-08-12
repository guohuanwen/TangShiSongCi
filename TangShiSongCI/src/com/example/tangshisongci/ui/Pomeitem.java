package com.example.tangshisongci.ui;

import com.example.tangshisongci.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.method.ArrowKeyMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class Pomeitem extends Activity{
private TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pomeitem);
		text=(TextView)findViewById(R.id.pomeitemet);
		text.setFocusableInTouchMode(true);
		text.setFocusable(true);
		text.setClickable(true);
		text.setLongClickable(true);
		text.setMovementMethod( ArrowKeyMovementMethod.getInstance());
		text.setText(text.getText(),BufferType.SPANNABLE );
		
		Intent a=getIntent();
		String name=a.getStringExtra("name");
		Resources res =getResources();
		String[]  data=res.getStringArray(R.array.mingzi);
		Resources pome =getResources();
		String[] pomearray=pome.getStringArray(R.array.pome);
		for(int i = 0;i<data.length;i++){
			if(name.equals(data[i])){
				text.setText(pomearray[i]);
				break;
			}
		}
	}
	

}
