package android.memory;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MemorySystemActivity extends Activity {
	private TextView textview01;
	private Button button01;
	private Button button02;
	Calendar c = Calendar.getInstance();
	//数据库
	private SQLiteDatabase mSQLiteDatabase=null;
	private static final String KEY_ID="id";
	private static final String KEY_NAME="name";
	private static final String KEY_DATE="date";
	private static final String KEY_DAY="day";
	private static final String DB_NAME="Mydata.db";
	private static final String DB_TABLE1="food";
	//private static final String DB_TABLE2="list";
	//创建表
	//private static final String DB_CREATE1="CREATE TABLE"+DB_TABLE1+"("+KEY_ID+"INTEGER PRIMARY KEY"+KEY_NAME+"TEXT"+KEY_DATE+"TEXT"+KEY_DAY+"TEXT)";
	//private static final String DB_CREATE2="CREATE TABLE"+DB_TABLE2+"("+KEY_ID+"INTEGER PRIMARY KEY"+KEY_NAME+"TEXT"+KEY_DATE+"TEXT"+KEY_DAY+"TEXT)";
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //修改数据库使用
        //mMydatabaseAdapter =new MydatabaseAdapter(this);
        //mMydatabaseAdapter.open();
        //打开创建数据库，创建表
        //this.deleteDatabase("Mydata.db");
        //mSQLiteDatabase=this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
        //String DB_CREATE1="CREATE TABLE food(id INTEGER PRIMARY KEY,name TEXT,date TEXT,day TEXT)";
        //String DB_CREATE2="CREATE TABLE list(id INTEGER PRIMARY KEY,name TEXT,date TEXT,day TEXT)";	
        //mSQLiteDatabase.execSQL(DB_CREATE1);
        //mSQLiteDatabase.execSQL(DB_CREATE2);
        //mSQLiteDatabase.execSQL("DROP TABLE food");
        //mSQLiteDatabase.execSQL("DROP TABLE list");
    	//mSQLiteDatabase.close();
        
        textview01=(TextView)this.findViewById(R.id.textview01);
        String string="家庭食物存储系统";
        textview01.setTextColor(Color.CYAN);
        textview01.setText(string);
        
        button01=(Button)this.findViewById(R.id.button01);
        button02=(Button)this.findViewById(R.id.button02);
        
        button01.setOnClickListener(new Button.OnClickListener()
        {
        	
        	public void onClick(View v)
        	{
        		//取得服务启动后一天的0点0分0秒的millstime（）
        		c.add(Calendar.DATE, 1);
        		c.set(Calendar.HOUR_OF_DAY, 0);
        		c.set(Calendar.MINUTE, 0);
        		c.set(Calendar.SECOND, 0);
        		c.set(Calendar.MILLISECOND, 0);
        		//启动时间
        		long startTime = c.getTimeInMillis();
        		//重复运行间隔时间	
        		long repeatTime = 24*60*60*1000;
        		
        		//创建进程 添加进alarmManager
        		Intent intent = new Intent(MemorySystemActivity.this,Callupdata.class);
        		//创建对象
        		PendingIntent sender = PendingIntent.getBroadcast(MemorySystemActivity.this, 0, intent, 0);
        		//创建对象
        		AlarmManager am01 = (AlarmManager)getSystemService(ALARM_SERVICE);
        		//setRepeating()可让排程重复运行
        		//startIime 为开始运行时间
        		//repeatTime为重复运行间隔
        		//AlarmManager。RTC  服务休眠时仍然会运行
        		am01.setRepeating(AlarmManager.RTC, startTime, repeatTime, sender);
        		
        		/*
        		Toast toast=Toast.makeText(MemorySystemActivity.this, "你点击了“"+button01.getText()+"”按钮！", Toast.LENGTH_SHORT);
        		toast.setGravity(Gravity.TOP, 0, 150);
        		toast.show();
        		*/
        		
        		Intent intent01=new Intent();
        		intent01.setClass(MemorySystemActivity.this, chooseActivity.class);
        		startActivity(intent01);
        		MemorySystemActivity.this.finish();
        	}
        });
        
        button02.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		MemorySystemActivity.this.finish();
        	}
        });
        
    }
}