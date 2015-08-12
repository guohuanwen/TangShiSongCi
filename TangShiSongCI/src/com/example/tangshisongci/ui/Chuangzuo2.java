package com.example.tangshisongci.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.tangshisongci.R;
import com.example.tangshisongci.SQlite.*;

public class Chuangzuo2 extends Activity {

	private ImageButton button = null;
	private EditText edittext1 = null;
	private EditText edittext2 = null;
	private Long mRowId;
	private DataHelper datahelper;
	private Spinner mCategory;

	@SuppressLint("SimpleDateFormat")
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		datahelper = new DataHelper(this);
		datahelper.open();
		setContentView(R.layout.chuangzuo2);
		button = (ImageButton) findViewById(R.id.button1);
		edittext1 = (EditText) findViewById(R.id.editText1);
		edittext2 = (EditText) findViewById(R.id.editText2);
		edittext2.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
		edittext2.setSingleLine(false);
		edittext2.setHorizontallyScrolling(false);
		// SimpleDateFormat timedate=new
		// SimpleDateFormat("yyyy年MM月DD日HH时MM分SS秒");
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name = edittext1.getText().toString();
				String text = edittext2.getText().toString();
				Date nowtime = new Date();
				SimpleDateFormat SDF = new SimpleDateFormat(
						"yyyy-MM-dd-HH:mm:ss");
				String time = SDF.format(nowtime);
				datahelper.createTest(name, text, time);
				startActivity(new Intent(Chuangzuo2.this, Chuangzuo1.class));
				finish();
			}
		});

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			startActivity(new Intent(Chuangzuo2.this, Chuangzuo1.class));
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}
}
