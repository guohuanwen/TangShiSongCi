package com.example.tangshisongci.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.tangshisongci.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.tangshisongci.SQlite.*;
public class Chuangzuo4 extends Activity{
private EditText et1;
private EditText et2;
private DataHelper dh;
private ImageButton bn;
private long b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chuangzuo4);
		dh=new DataHelper(this);
		dh.open();
		et1=(EditText)findViewById(R.id.chuangzuo4ex1);
		et2=(EditText)findViewById(R.id.chuangzuo4ex2);
		bn=(ImageButton)findViewById(R.id.chuangzuo4bn);
		Intent a=getIntent();
		 b = Long.valueOf(a.getStringExtra("name"));
		Cursor cs=dh.fetchTest(b);
		String title = cs.getString(cs.getColumnIndexOrThrow("title"));
		String text = cs.getString(cs.getColumnIndexOrThrow("story"));
		et1.setText(title);
		et2.setText(text);
		bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String title1=et1.getText().toString();
				String text1=et2.getText().toString();
				Date a=new Date();
				SimpleDateFormat SDF=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
				String time1=SDF.format(a);
				dh.updateTest(b, title1, text1, time1);
				startActivity(new Intent(Chuangzuo4.this,Chuangzuo1.class));
				finish();
			}
		});
//		System.out.println(b);
		
	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode==KeyEvent.KEYCODE_BACK){startActivity(new Intent(Chuangzuo4.this,Chuangzuo1.class));
		finish();
		}
		return super.onKeyDown(keyCode, event);
	}
}