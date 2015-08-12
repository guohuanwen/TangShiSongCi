package com.example.tangshisongci.ui;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.example.tangshisongci.R;
import com.example.tangshisongci.SQlite.DataHelper;

public class Chuangzuo1 extends Activity {

	private ImageButton button;
	private DataHelper dh;
	private Cursor cursor;
	private ListView list;
	ArrayAdapter<String> adapter;
	private LinearLayout ll;
	// 主键值的list
	ArrayList<String> _id;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chaungzuo1);

		ll = (LinearLayout) findViewById(R.id.chuangzuo1ll);
		dh = new DataHelper(this);
		dh.open();
		list = new ListView(this);
		fillData();
		// 为list设置适配器
		list.setAdapter(adapter);
		// 在linearlayout中添加list
		ll.addView(list);

		// registerForContextMenu(getListView());
		button = (ImageButton) findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Chuangzuo1.this, Chuangzuo2.class));
				finish();
			}
		});

		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent a = new Intent(Chuangzuo1.this, Chuangzuo3.class);
				a.putExtra("_id", Long.valueOf(_id.get((int) id)));
				startActivity(a);
			}
		});
		// 设置长按选项
		list.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {

			@Override
			public void onCreateContextMenu(ContextMenu menu, View v,
					ContextMenuInfo menuInfo) {
				// TODO Auto-generated method stub
				// ?????????????????????
				final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
				menu.setHeaderTitle("");
				menu.add(0, 0, 0, "删除");
				menu.add(0, 1, 0, "修改");
				// menu.add(0,2,0,"导入sd卡");
			}

		});

	}

	// 设置长按跳转选项 子菜单
	public boolean onContextItemSelected(MenuItem item) {
		// ?
		AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item
				.getMenuInfo();
		dh.open();
		switch (item.getItemId()) {
		case 0:// 删除
			try {
				dh.deleteTest(Long.valueOf(_id.get((int) menuInfo.position)));
				// 刷新界面
				startActivity(new Intent(Chuangzuo1.this, Chuangzuo1.class));
				finish();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			break;
		case 1:// 修改
			try {
				Intent a = new Intent(Chuangzuo1.this, Chuangzuo4.class);
				a.putExtra("name", _id.get((int) menuInfo.position));
				startActivity(a);
				finish();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			break;
		// case 2://导出sd卡
		// try{
		// Intent aa=new Intent(Chuangzuo1.this,Filesave.class);
		// aa.putExtra("name",_id.get((int)menuInfo.position));
		// startService(aa);
		// }catch(Exception ex){
		// ex.printStackTrace();
		// }break;
		}
		return true;
	}

	// list点击跳转
	// protected void onListItemClick(ListView l, View v, int position, long id)
	// {
	// // TODO Auto-generated method stub
	// super.onListItemClick(l, v, position, id);
	// Intent a=new Intent(this,Chuangzuo3.class);
	// a.putExtra("_id",id);
	// System.out.println(id);
	// startActivity(a); }

	// 填充list
	@SuppressWarnings("deprecation")
	private void fillData() {
		cursor = dh.fetchALlTests();
		// 填充list的title
		ArrayList<String> title = new ArrayList<String>();
		_id = new ArrayList<String>();
		startManagingCursor(cursor);
		boolean aa = cursor.moveToFirst();
		// 循环读取所以主键值
		for (int i = 0; i < cursor.getCount(); i++) {
			if (cursor.getString(cursor.getColumnIndexOrThrow("_id")).equals(0)) {
				break;
			}
			_id.add(cursor.getString(cursor.getColumnIndexOrThrow("_id")));
			cursor.moveToNext();
		}
		// 循环读入title
		for (int i = 0; i < cursor.getCount(); i++) {
			Cursor cur = dh.fetchTest(Long.valueOf(_id.get(i)));
			startManagingCursor(cur);
			String ti = cur.getString(cur.getColumnIndexOrThrow("title"));
			title.add(ti);
			adapter = new ArrayAdapter<String>(this,
					R.layout.chuangzuo1list_item, R.id.chuangzuo1item, title);
		}
	}
}
