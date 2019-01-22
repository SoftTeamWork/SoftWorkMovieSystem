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
	//���ݿ�
	private SQLiteDatabase mSQLiteDatabase=null;
	private static final String KEY_ID="id";
	private static final String KEY_NAME="name";
	private static final String KEY_DATE="date";
	private static final String KEY_DAY="day";
	private static final String DB_NAME="Mydata.db";
	private static final String DB_TABLE1="food";
	//private static final String DB_TABLE2="list";
	//������
	//private static final String DB_CREATE1="CREATE TABLE"+DB_TABLE1+"("+KEY_ID+"INTEGER PRIMARY KEY"+KEY_NAME+"TEXT"+KEY_DATE+"TEXT"+KEY_DAY+"TEXT)";
	//private static final String DB_CREATE2="CREATE TABLE"+DB_TABLE2+"("+KEY_ID+"INTEGER PRIMARY KEY"+KEY_NAME+"TEXT"+KEY_DATE+"TEXT"+KEY_DAY+"TEXT)";
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //�޸����ݿ�ʹ��
        //mMydatabaseAdapter =new MydatabaseAdapter(this);
        //mMydatabaseAdapter.open();
        //�򿪴������ݿ⣬������
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
        String string="��ͥʳ��洢ϵͳ";
        textview01.setTextColor(Color.CYAN);
        textview01.setText(string);
        
        button01=(Button)this.findViewById(R.id.button01);
        button02=(Button)this.findViewById(R.id.button02);
        
        button01.setOnClickListener(new Button.OnClickListener()
        {
        	
        	public void onClick(View v)
        	{
        		//ȡ�÷���������һ���0��0��0���millstime����
        		c.add(Calendar.DATE, 1);
        		c.set(Calendar.HOUR_OF_DAY, 0);
        		c.set(Calendar.MINUTE, 0);
        		c.set(Calendar.SECOND, 0);
        		c.set(Calendar.MILLISECOND, 0);
        		//����ʱ��
        		long startTime = c.getTimeInMillis();
        		//�ظ����м��ʱ��	
        		long repeatTime = 24*60*60*1000;
        		
        		//�������� ��ӽ�alarmManager
        		Intent intent = new Intent(MemorySystemActivity.this,Callupdata.class);
        		//��������
        		PendingIntent sender = PendingIntent.getBroadcast(MemorySystemActivity.this, 0, intent, 0);
        		//��������
        		AlarmManager am01 = (AlarmManager)getSystemService(ALARM_SERVICE);
        		//setRepeating()�����ų��ظ�����
        		//startIime Ϊ��ʼ����ʱ��
        		//repeatTimeΪ�ظ����м��
        		//AlarmManager��RTC  ��������ʱ��Ȼ������
        		am01.setRepeating(AlarmManager.RTC, startTime, repeatTime, sender);
        		
        		/*
        		Toast toast=Toast.makeText(MemorySystemActivity.this, "�����ˡ�"+button01.getText()+"����ť��", Toast.LENGTH_SHORT);
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