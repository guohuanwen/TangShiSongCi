package com.example.tangshisongci.SQlite;

import java.io.File;
import java.io.FileOutputStream;

import com.example.tangshisongci.R;
import com.example.tangshisongci.ui.Chuangzuo1;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

public class Filesave extends Service{

	
	private DataHelper dh;
	private long b;
@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
	}
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		dh=new DataHelper(this);
		dh.open();
		b= Long.valueOf(intent.getStringExtra("name"));
		Cursor cs=dh.fetchTest(b);
		String filename=cs.getString(cs.getColumnIndexOrThrow("title"))+".txt";
		String text=cs.getString(cs.getColumnIndexOrThrow("story"));
		writeFile(filename,text);
		
		
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	public IBinder onBinder(Intent intent) {
		return null;
		// TODO Auto-generated method stub
		
	}
public void writeFile(String filename,String text){
	System.out.println("1234");
	try{//设置路径
		File saveFile=new File(Environment.getExternalStorageDirectory().toString()+"/唐诗宋词导出文件");
		if(!saveFile.exists()){
			File dir=new File(saveFile.getParent());
			saveFile.mkdirs();
			saveFile.createNewFile();}
	//创建FileOutputStream对象，MODE_PRIVATE：默认模式
	FileOutputStream fileoutputstream=new FileOutputStream(saveFile);
	//text转化为byte数组
	byte[] buffer=text.getBytes();
	//数组写入文件
	fileoutputstream.write(buffer);
	//清空缓存
	fileoutputstream.flush();
	//关闭fileoutputstream对象
	fileoutputstream.close();
	Toast.makeText(Filesave.this,"导出成功",Toast.LENGTH_LONG).show();
	}catch (Exception e){e.printStackTrace();}
	
}
@Override
public IBinder onBind(Intent intent) {
	// TODO Auto-generated method stub
	return null;
}
	

}
