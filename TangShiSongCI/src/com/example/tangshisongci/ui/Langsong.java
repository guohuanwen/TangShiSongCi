package com.example.tangshisongci.ui;



import java.util.ArrayList;
import com.example.tangshisongci.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.tangshisongci.bofang.Bofang;

public class Langsong extends Activity{
private TextView tv1;
ArrayAdapter<String> adapter;
private EditText edittext;
private static  ArrayList<String> tempList;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.langsong);
		edittext=(EditText)findViewById(R.id.langsonget);
		LinearLayout myLayout=(LinearLayout) findViewById(R.id.langsongLayout);
		//获取list列表
		Resources res =getResources();
        String[] data=res.getStringArray(R.array.langsong);
		ListView mylistview=new ListView(this);
		
		//android.R.layout.simple_expandable_list_item_1一行显示
		adapter =new ArrayAdapter<String>(this,R.layout.list_item, R.id.product_name,data);
		mylistview.setAdapter(adapter);
		myLayout.addView(mylistview);
		
		//默认不弹键盘
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
	
		//搜索功能
		edittext.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				//添加过滤器
				Langsong.this.adapter.getFilter().filter(s);
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
		
		//list监听
		mylistview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String name=Langsong.this.adapter.getItem((int)id);
				Intent a=new Intent(Langsong.this,Bofang.class);
				a.putExtra("name", name);
				startActivity(a);
				
		
		}});

		}

}
	


