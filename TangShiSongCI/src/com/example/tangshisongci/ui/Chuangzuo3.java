package com.example.tangshisongci.ui;

import com.example.tangshisongci.R;
import com.example.tangshisongci.SQlite.*;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ArrowKeyMovementMethod;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class Chuangzuo3 extends Activity{
private static final String Chaungzuo1 = null;
private TextView textview1;
private TextView textview2;
private TextView textview3;
private DataHelper dh;
private Long mRowId=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		dh=new DataHelper(this);
		dh.open();
		setContentView(R.layout.chuangzuo3);
		textview1=(TextView) findViewById(R.id.chuangzuo3text1);
		textview1.setFocusableInTouchMode(true);
		textview1.setFocusable(true);
		textview1.setClickable(true);
		textview1.setLongClickable(true);
		textview1.setMovementMethod( ArrowKeyMovementMethod.getInstance());
		textview1.setText(textview1.getText(),BufferType.SPANNABLE );
		
		textview2=(TextView) findViewById(R.id.chuangzuo3text2);
		textview2.setFocusableInTouchMode(true);
		textview2.setFocusable(true);
		textview2.setClickable(true);
		textview2.setLongClickable(true);
		textview2.setMovementMethod( ArrowKeyMovementMethod.getInstance());
		textview2.setText(textview2.getText(),BufferType.SPANNABLE );
		
		textview3=(TextView) findViewById(R.id.chuangzuo3text3);
		textview3.setFocusableInTouchMode(true);
		textview3.setFocusable(true);
		textview3.setClickable(true);
		textview3.setLongClickable(true);
		textview3.setMovementMethod( ArrowKeyMovementMethod.getInstance());
		textview3.setText(textview3.getText(),BufferType.SPANNABLE );
		
		Bundle extras=getIntent().getExtras();
		mRowId=(long)extras.getLong("_id");
//		System.out.println(mRowId);
		Cursor cursor = dh.fetchTest(mRowId);
//		我们将获得的Cursor对象交与Activity 来管理，这样Cursor对象的生命周期便能与当前的Activity自动同步，省去了自己管理Cursor。
		startManagingCursor(cursor);
		//取出cursor中的值
		String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
		String text = cursor.getString(cursor.getColumnIndexOrThrow("story"));
		String time =cursor.getString(cursor.getColumnIndexOrThrow("time"));
		textview1.setText(title);
		textview2.setText(text);
		textview3.setText(time);
		
	}

}
