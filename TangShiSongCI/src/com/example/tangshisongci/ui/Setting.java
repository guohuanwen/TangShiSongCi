package com.example.tangshisongci.ui;


import com.example.tangshisongci.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.example.tangshisongci.shared.*;

public class Setting extends Activity{
	private ListView setlist;
	private Zhuye cz1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		cz1=new Zhuye();
		setContentView(R.layout.setting);
		LinearLayout ll=(LinearLayout)findViewById(R.id.settingl);
		setlist=new ListView(this);
		String[] data={"背景"};
		ArrayAdapter<String> adapt=new ArrayAdapter<String>(this,R.layout.settingitem, R.id.settingitemtx,data);
		setlist.setAdapter(adapt);
		ll.addView(setlist);
		setlist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switch ((int)id) {
				case 0:{
					CharSequence[] a={"白","红","黑","蓝","黄","绿"};
					new AlertDialog.Builder(Setting.this)
					.setTitle("设置颜色")
					.setItems(a, new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							switch (which) {
							case 0:cz1.setcolor(0);break;
							case 1:cz1.setcolor(1);break;
                            case 2:cz1.setcolor(2);break;
                            case 3:cz1.setcolor(3);break;
                            case 4:cz1.setcolor(4);break;
                            case 5:cz1.setcolor(5);break;
                          default:
								break;
							}
						}
					}
					)
					.setNegativeButton("取消",new  DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							}
					}).show();
					}
					break;
                case 1:
					
					break;
				default:
					break;
				}
				
			}
		});
	}
	

}
