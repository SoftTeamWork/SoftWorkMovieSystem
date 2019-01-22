package android.memory;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class remindActivity extends Activity {
	//声明timepicker对象
	TimePicker timepicker01;
	private String SetTime = "SetTime";
	private String SetDay = "SetDay";
	private String SetService = "SetService";
	private TextView textview;
	private TextView textview01;
	private TextView textview02;
	private TextView textview03;
	private TextView textview04;
	private TextView textview05;
	private EditText edittext;
	private Button button01;
	private Button button02;
	private Button button03;
	private Button button04;
	Calendar c = Calendar.getInstance();
	private String TM;
	private String SETDAY;
	private String tm;
	private String rowDay;
	private String DataService;
	private String dataservice;
	

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remindlayout);
        
        textview = (TextView)this.findViewById(R.id.textview);
        //textview01 = (TextView)this.findViewById(R.id.textview01);
        //textview02 = (TextView)this.findViewById(R.id.textview02);
        textview03 = (TextView)this.findViewById(R.id.textview03);
        textview04 = (TextView)this.findViewById(R.id.textview04);
        //button01 = (Button)this.findViewById(R.id.button01);
        button02 = (Button)this.findViewById(R.id.button02);
        button03 = (Button)this.findViewById(R.id.button03);
        button04 = (Button)this.findViewById(R.id.button04);
        
        //获取一个SharedPreferences对象
        SharedPreferences preferences01 = getSharedPreferences(SetTime,0);
        //获取SharedPreferences里面的值
        tm = preferences01.getString(TM, "");
        
        //SharedPreferences preferences02 = getSharedPreferences(SetDay,0);
        //rowDay = preferences02.getString(SETDAY, "");
        
        //SharedPreferences preferences03 = getSharedPreferences(SetService,0);
        //dataservice = preferences03.getString(DataService, "");
        
        //textview02.setText(rowDay);
        textview04.setText(tm);
        
        //设置提醒时间按键button01
        button02.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		//取得单击按键的时间作为默认时间
        		c.setTimeInMillis(System.currentTimeMillis());
        		int mHour = c.get(Calendar.HOUR_OF_DAY);
        		int mMinute = c.get(Calendar.MINUTE);
        		
        		//跳出timepickerdialog来设置时间
        		new TimePickerDialog(remindActivity.this,
        				new TimePickerDialog.OnTimeSetListener() {
        			
        			public void onTimeSet(TimePicker view, int hourOfDay, int minute)
        			{
        				//取得设置后的时间
        				c.setTimeInMillis(System.currentTimeMillis());
        				c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        				c.set(Calendar.MINUTE, minute);
        				c.set(Calendar.SECOND, 0);
        				c.set(Calendar.MILLISECOND, 0);
        				//启动时间
        				long startTime = c.getTimeInMillis();
        				//重复启动间隔
        				long repeatTime = 24*60*60*1000;
        				
        				//指定闹钟设置的时间到时运行
        				Intent intent = new Intent();
        				
        				intent.setClass(remindActivity.this, CallAlarm.class);
        				//创建PendingIntent
        				PendingIntent sender = PendingIntent.getBroadcast(remindActivity.this, 0, intent, 0);
        				
        				//AlarmManager.RTC_WAKEUP设置服务再系统休眠时同样运行
        				//setRepeating()设置的pendingintent会重复运行
        				AlarmManager am;
        				am = (AlarmManager)getSystemService(ALARM_SERVICE);
        				am.setRepeating(AlarmManager.RTC_WAKEUP, startTime, repeatTime, sender);
        				//更新显示设置的提醒时间
        				tm = format(hourOfDay)+ ":" +format(minute);
        				
        				//获取对象
        				SharedPreferences sharedpreferences01 = getSharedPreferences(SetTime,0);
        				//存入
        				sharedpreferences01.edit().putString(TM, tm).commit();
        				
        				textview04.setText(tm);
        				//提醒设置成功
        				//DisplayToast("时间设置成功，闹钟提醒也开启！");
        			}	
        	    },mHour,mMinute,true).show();
        		
        	}
        });
        
        //关闭闹钟提醒按键监听
        button03.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent(remindActivity.this,CallAlarm.class);
        		PendingIntent sender = PendingIntent.getBroadcast(remindActivity.this, 0, intent, 0);
        		
        		//由AlarmManager 中删除
        		AlarmManager am;
        		am = (AlarmManager)getSystemService(ALARM_SERVICE);
        		am.cancel(sender);
        		
        		tm="";
        		//rowDay="";
        		//获取对象
				SharedPreferences sharedpreferences01 = getSharedPreferences(SetTime,0);
				//存入
				sharedpreferences01.edit().putString(TM, tm).commit();
				
				textview04.setText(tm);
				
				//SharedPreferences sharedpreferences02 = getSharedPreferences(SetDay,0);
				//存入
				//sharedpreferences02.edit().putString(SETDAY, rowDay).commit();
				//显示食品剩余设置
				//textview02.setText(rowDay);
				
				//操作提示
				DisplayToast("闹钟提醒已经关闭！");
        	}
        });
        
        //button启动数据管理服务
        /*button02.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		//对话框  开启数据管理
        		AlertDialog dialog = new AlertDialog.Builder(remindActivity.this)
        		.setTitle("数据服务设置")
        		.setMessage("点击确定，系统将自动管理您所输入的信息，每天更新")
        		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
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
		        		Intent intent = new Intent(remindActivity.this,Callupdata.class);
		        		//创建对象
		        		PendingIntent sender = PendingIntent.getBroadcast(remindActivity.this, 0, intent, 0);
		        		//创建对象
		        		AlarmManager am01 = (AlarmManager)getSystemService(ALARM_SERVICE);
		        		//setRepeating()可让排程重复运行
		        		//startIime 为开始运行时间
		        		//repeatTime为重复运行间隔
		        		//AlarmManager。RTC  服务休眠时仍然会运行
		        		am01.setRepeating(AlarmManager.RTC, startTime, repeatTime, sender);
		        		
		        		
		        		dataservice = "开启";
		        		//获取对象
						SharedPreferences sharedpreferences01 = getSharedPreferences(SetService,0);
						//存入
						sharedpreferences01.edit().putString(DataService, dataservice).commit();
						
						textview06.setText(dataservice);
						
		        		//提示
		        		DisplayToast("数据管理服务已启动！");
		        		dialog.dismiss();
		        		//启动服务时 就调用一次更新Activity
		        		//Intent i = new Intent(remindActivity.this,updataActivity.class);
		        		//startActivity(i);
					}
				})
				.setNegativeButton("退出", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
		        		
		        		dialog.dismiss();
					}
				})
				.create();
        		
        		dialog.show();
        		
        	}
        });
        
        //关闭数据管理服务
        button03.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		
				Intent intent = new Intent(remindActivity.this,Callupdata.class);
        		PendingIntent sender = PendingIntent.getBroadcast(remindActivity.this, 0, intent, 0);
        		
        		AlarmManager am01 = (AlarmManager)getSystemService(ALARM_SERVICE);
        		am01.cancel(sender);
        		
        		
        		dataservice = "关闭";
        		//获取对象
				SharedPreferences sharedpreferences01 = getSharedPreferences(SetService,0);
				//存入
				sharedpreferences01.edit().putString(DataService, dataservice).commit();
				
				textview06.setText(dataservice);
        		
        		//提示 
        		DisplayToast("数据管理服务已关闭！");
        	}
        });
      
        
        //设置食品剩余提醒按键
        button01.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		//得到自定义的对话框
        		LayoutInflater factory = LayoutInflater.from(remindActivity.this);
        		final View DialogView = factory.inflate(R.layout.dialog,null);
        		
        		//通过DialogView来找寻dialog中的控件
        		edittext = (EditText)DialogView.findViewById(R.id.edittext);
        		textview05 = (TextView)DialogView.findViewById(R.id.textview05);
        		
        		
        		//编辑内容监听
				edittext.setOnKeyListener(new EditText.OnKeyListener()
		        {
		        	public boolean onKey(View arg0, int arg1, KeyEvent arg2)
		        	{
		        		textview05.setText("您输入的食品剩余提醒为："+edittext.getText().toString());
		        		return false;
		        	}
		        });
				
				
        		//设置编辑对话框
        		AlertDialog dialog = new AlertDialog.Builder(remindActivity.this)
        		.setTitle("设置剩余提醒")
        		.setView(DialogView)
        		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
						
						rowDay = edittext.getText().toString();
						
						if(rowDay.equals(""))
						{
							DisplayToast("没有输入没办法提醒呀！");
						}
						else
						{
							SharedPreferences sharedpreferences02 = getSharedPreferences(SetDay,0);
	        				//存入
	        				sharedpreferences02.edit().putString(SETDAY, rowDay).commit();
	        				//显示食品剩余设置
	        				textview02.setText(rowDay);
	        				//设置提醒
	        				//DisplayToast("设置成功！");
	        				dialog.dismiss();
						}
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				})
				.create();
        		dialog.show();
        	}
        });
        */
        
        //返回按键
        button04.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent= new Intent();
        		intent.setClass(remindActivity.this, chooseActivity.class);
        		startActivity(intent);
        		remindActivity.this.finish();
        	}
        });
        
	}
	
	//日期时间显示两位数的方法
	public String format(int x)
	{
		String s = "" + x;
		if(s.length()==1)
		{
			s = "0" + s;
		}
		return s;
	}
	
	//设置toast提醒显示
	public void DisplayToast(String str)
	{
		Toast toast = Toast.makeText(this, str, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.TOP, 0, 220);
		toast.show();
	}
}
