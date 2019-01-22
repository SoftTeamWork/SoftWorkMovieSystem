package android.memory;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;

public class alarmActivity extends Activity {
	MydatabaseAdapter mMydatabaseAdapter;
	private String rowDay;
	private String SETDAY;
	private int rowday;
	private String SetDay = "SetDay";
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		//获取sharedpreferences 中的数据rowDay
		//SharedPreferences preferences02 = getSharedPreferences(SetDay,0);
        //rowDay = preferences02.getString(SETDAY, "");
        
        //创建对象，打开数据库
        mMydatabaseAdapter =new MydatabaseAdapter(this);
        mMydatabaseAdapter.open();
        
        //强制转换
        //rowday = Integer.parseInt(rowDay);
        //查询数据库中  是否有满足条件的数据
        Cursor cur = mMydatabaseAdapter.alertData();
        
        //如果满足条件
        if(cur.moveToFirst())
        {
        	//设置对话提醒框
        	new AlertDialog.Builder(alarmActivity.this)
        	.setTitle("定时提醒！！")
        	.setMessage("家里某些食物快吃完了，赶快去买吧，小心断粮哦~！")
        	.setPositiveButton("关掉它", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
					mMydatabaseAdapter.close();
					alarmActivity.this.finish();
				}
			})
			.setNegativeButton("查看", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					mMydatabaseAdapter.close();
					Intent intent = new Intent();
					intent.setClass(alarmActivity.this, listalertActivity.class);
					startActivity(intent);
					alarmActivity.this.finish();
				}
			}).show();
        	
        }
        else
        {
        	alarmActivity.this.finish();
        }
        cur.close();
	}

}
