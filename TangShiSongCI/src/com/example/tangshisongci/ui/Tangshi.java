package com.example.tangshisongci.ui;



import com.example.tangshisongci.R;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.tangshisongci.tab.*;

public class Tangshi extends Activity{
private Tab tab;

//@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// TODO Auto-generated method stub
//	getMenuInflater().inflate(R.menu.main, menu);
//		return super.onCreateOptionsMenu(menu);
//	}
//
//
//@Override
//	public boolean onMenuItemSelected(int featureId, MenuItem item) {
//		// TODO Auto-generated method stub
//	int id = item.getItemId();
//	if (id == R.id.action_settings) {
//		startActivity(new Intent(Tangshi.this,Setting.class));
//		return true;
//	}
//		return super.onMenuItemSelected(featureId, item);
//	}


ArrayAdapter<String> adapter;
EditText edittext;


	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.tangshi);
		edittext=(EditText)findViewById(R.id.editText1);
//		tab=this.getTab
		LinearLayout myLayout=(LinearLayout) findViewById(R.id.Layout);
		Resources res =getResources();
        String[] data=res.getStringArray(R.array.tangshi);
		ListView mylistview=new ListView(this);
		//android.R.layout.simple_expandable_list_item_1一行显示
		adapter =new ArrayAdapter<String>(this,R.layout.list_item, R.id.product_name,data);
		mylistview.setAdapter(adapter);
		myLayout.addView(mylistview);
		edittext.clearFocus();
		//默认不弹键盘
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		edittext.addTextChangedListener(new TextWatcher() {
	            public void onTextChanged(CharSequence cs,int arg1, int arg2, int arg3) {
	              Tangshi.this.adapter.getFilter().filter(cs);}
	            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) { }
	            public void afterTextChanged(Editable arg0){} });
		edittext.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				//添加过滤器
				Tangshi.this.adapter.getFilter().filter(s);
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mylistview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String name=Tangshi.this.adapter.getItem((int)id);
				Intent a=new Intent(Tangshi.this,Pomeitem.class);
				a.putExtra("name", name);
				startActivity(a);
			}
			
		});
		}
	   

		
	
	}
	


