package com.example.tangshisongci.tab;

import com.example.tangshisongci.R;
import com.example.tangshisongci.ui.*;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class Tab extends TabActivity{
private static TabHost tabHost;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab);
		tabHost=getTabHost();
		LayoutInflater.from(this).inflate(R.layout.tab,tabHost.getTabContentView(),true);
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("",getResources().getDrawable(R.drawable.tangshi)).setContent(new Intent(Tab.this,Tangshi.class)));
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("",getResources().getDrawable(R.drawable.songci)).setContent(new Intent(Tab.this,Songci.class)));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("",getResources().getDrawable(R.drawable.chuangzuo)).setContent(new Intent(Tab.this,Chuangzuo1.class)));

		for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
			tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#fefcfc"));
		}
		

		
	}
	
	

}