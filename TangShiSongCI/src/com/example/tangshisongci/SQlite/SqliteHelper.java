package com.example.tangshisongci.SQlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteHelper extends SQLiteOpenHelper {
private static final String DATABASE_NAME = "user";
private static final int DATABASE_VERSION= 1;

private static final String sql=" CREATE TABLE IF NOT EXISTS test ( _id integer primary key autoincrement , title text not null , story text not null , time text not null ) ; ";
public SqliteHelper(Context context) { 
	// 第一个参数是应用的上下文  
    // 第二个参数是应用的数据库名字  
    // 第三个参数CursorFactory指定在执行查询时获得一个游标实例的工厂类,设置为null,代表使用系统默认的工厂类  
    // 第四个参数是数据库版本，必须是大于0的int（即非负数
    super(context, DATABASE_NAME, null, DATABASE_VERSION); 
}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS test"); 
        onCreate(db);
	}
	
}

