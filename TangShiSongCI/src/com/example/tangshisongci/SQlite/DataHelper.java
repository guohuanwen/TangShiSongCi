package com.example.tangshisongci.SQlite;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;




public  class DataHelper {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_CATEGORY = "title"; 
    public static final String KEY_SUMMARY = "story"; 
    public static final String KEY_DESCRIPTION = "time"; 
    public static final String DATABASE_TABLE = "test";
    private Context context;
	private  SQLiteDatabase db;
	private SqliteHelper dbHelper;

	public DataHelper(Context context){
		 this.context=context;}
	
	 //打开
	 public DataHelper open() throws SQLException 
	    { 
	        dbHelper = new SqliteHelper(context); 
	        db = dbHelper.getWritableDatabase(); 
	        return this; } 
	 //关闭
	 public void Close(){
		 dbHelper.close();
	 }
	//插入
	 public long createTest(String title, String story, String time) 
	    {    
		    if(db == null || !db.isOpen()) {
	        db = dbHelper.getReadableDatabase();}
//	        ContentValues initialValues = createContentValues(title,story,time); 
		    ContentValues initialValues=new ContentValues();
		  
	        initialValues.put("title", title);
	        initialValues.put("story", story);
	        initialValues.put("time", time);
	        return db.insert(DATABASE_TABLE,null,initialValues);
	    } 
	 private ContentValues createContentValues(String title, String story,String time) { 
	        ContentValues values = new ContentValues(); 
	        values.put(KEY_CATEGORY, title); 
	        values.put(KEY_SUMMARY, story); 
	        values.put(KEY_DESCRIPTION,time); 
	        return values; 
	    }
	//修改
	 public boolean updateTest(long rowId, String category, String summary, String description) 
	    { 
	        ContentValues updateValues = createContentValues(category, summary, description); 
	        return db.update(DATABASE_TABLE, updateValues, KEY_ROWID + "=" +rowId, null)>0; 
	    }
	//删除
	 public boolean deleteTest(long rowId) 
	    { 
	        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null)>0; 
	    } 
	//返回数据库中表test的所有游标列表 
	 public Cursor fetchALlTests() 
	    { if(db == null || !db.isOpen()) {
	        db = dbHelper.getReadableDatabase();
	    }
	        return db.query(DATABASE_TABLE, new String[]{KEY_ROWID, 
	                KEY_CATEGORY,KEY_SUMMARY,KEY_DESCRIPTION}, null, null, null, null, null);
	       
	        
	    } 
	  //返回在表test中被定义的某个位置的游标
	 public Cursor fetchTest(long rowId)throws SQLException 
	    { 
	        Cursor mCursor = db.query(true, DATABASE_TABLE, new String[]{KEY_ROWID, 
	                KEY_CATEGORY, KEY_SUMMARY, KEY_DESCRIPTION},  
	                KEY_ROWID + "=" +rowId, null, null, null,null,null); 
	        if(mCursor != null) 
	        {  mCursor.moveToFirst();  } 
	        return mCursor; 
	        
	    }
//	 public Cursor move() 
//	    { if(db == null || !db.isOpen()) {
//	        db = dbHelper.getReadableDatabase();
//	    }
//	        Cursor a= db.query(DATABASE_TABLE, new String[]{KEY_ROWID,KEY_CATEGORY,KEY_SUMMARY,KEY_DESCRIPTION}, null, null, null, null, null);
//	        ArrayList<String> title=new ArrayList<String>();
//	        title.add(a.getColumnIndexOrThrow(""));
//	       
//	        
//	    } 
}

