package com.example.tangshisongci.shared;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

@SuppressLint("Instantiatable")
public class Sharedpreferences extends Activity{
private SharedPreferences sp;
private Editor editor;
private Context context;

public  Sharedpreferences(Context context){
	 this.context=context;
	 }

	public void savedata(String a,String b){
		//创建sharedpreferences，“info”为共享文件名字
		sp=getSharedPreferences("info",0);
	    //打开sharedpreferences的编辑状态
		editor=sp.edit();
		editor.putString(a,b);
		editor.commit();
	}
	public  String getdata(String a){
		try{
		sp=getSharedPreferences("info",0);
		return sp.getString(a,"");}
		catch(Exception e){e.printStackTrace();return null;}
		
	}
}
