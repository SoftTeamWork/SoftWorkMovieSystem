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
	//����timepicker����
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
        
        //��ȡһ��SharedPreferences����
        SharedPreferences preferences01 = getSharedPreferences(SetTime,0);
        //��ȡSharedPreferences�����ֵ
        tm = preferences01.getString(TM, "");
        
        //SharedPreferences preferences02 = getSharedPreferences(SetDay,0);
        //rowDay = preferences02.getString(SETDAY, "");
        
        //SharedPreferences preferences03 = getSharedPreferences(SetService,0);
        //dataservice = preferences03.getString(DataService, "");
        
        //textview02.setText(rowDay);
        textview04.setText(tm);
        
        //��������ʱ�䰴��button01
        button02.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		//ȡ�õ���������ʱ����ΪĬ��ʱ��
        		c.setTimeInMillis(System.currentTimeMillis());
        		int mHour = c.get(Calendar.HOUR_OF_DAY);
        		int mMinute = c.get(Calendar.MINUTE);
        		
        		//����timepickerdialog������ʱ��
        		new TimePickerDialog(remindActivity.this,
        				new TimePickerDialog.OnTimeSetListener() {
        			
        			public void onTimeSet(TimePicker view, int hourOfDay, int minute)
        			{
        				//ȡ�����ú��ʱ��
        				c.setTimeInMillis(System.currentTimeMillis());
        				c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        				c.set(Calendar.MINUTE, minute);
        				c.set(Calendar.SECOND, 0);
        				c.set(Calendar.MILLISECOND, 0);
        				//����ʱ��
        				long startTime = c.getTimeInMillis();
        				//�ظ��������
        				long repeatTime = 24*60*60*1000;
        				
        				//ָ���������õ�ʱ�䵽ʱ����
        				Intent intent = new Intent();
        				
        				intent.setClass(remindActivity.this, CallAlarm.class);
        				//����PendingIntent
        				PendingIntent sender = PendingIntent.getBroadcast(remindActivity.this, 0, intent, 0);
        				
        				//AlarmManager.RTC_WAKEUP���÷�����ϵͳ����ʱͬ������
        				//setRepeating()���õ�pendingintent���ظ�����
        				AlarmManager am;
        				am = (AlarmManager)getSystemService(ALARM_SERVICE);
        				am.setRepeating(AlarmManager.RTC_WAKEUP, startTime, repeatTime, sender);
        				//������ʾ���õ�����ʱ��
        				tm = format(hourOfDay)+ ":" +format(minute);
        				
        				//��ȡ����
        				SharedPreferences sharedpreferences01 = getSharedPreferences(SetTime,0);
        				//����
        				sharedpreferences01.edit().putString(TM, tm).commit();
        				
        				textview04.setText(tm);
        				//�������óɹ�
        				//DisplayToast("ʱ�����óɹ�����������Ҳ������");
        			}	
        	    },mHour,mMinute,true).show();
        		
        	}
        });
        
        //�ر��������Ѱ�������
        button03.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent(remindActivity.this,CallAlarm.class);
        		PendingIntent sender = PendingIntent.getBroadcast(remindActivity.this, 0, intent, 0);
        		
        		//��AlarmManager ��ɾ��
        		AlarmManager am;
        		am = (AlarmManager)getSystemService(ALARM_SERVICE);
        		am.cancel(sender);
        		
        		tm="";
        		//rowDay="";
        		//��ȡ����
				SharedPreferences sharedpreferences01 = getSharedPreferences(SetTime,0);
				//����
				sharedpreferences01.edit().putString(TM, tm).commit();
				
				textview04.setText(tm);
				
				//SharedPreferences sharedpreferences02 = getSharedPreferences(SetDay,0);
				//����
				//sharedpreferences02.edit().putString(SETDAY, rowDay).commit();
				//��ʾʳƷʣ������
				//textview02.setText(rowDay);
				
				//������ʾ
				DisplayToast("���������Ѿ��رգ�");
        	}
        });
        
        //button�������ݹ������
        /*button02.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		//�Ի���  �������ݹ���
        		AlertDialog dialog = new AlertDialog.Builder(remindActivity.this)
        		.setTitle("���ݷ�������")
        		.setMessage("���ȷ����ϵͳ���Զ����������������Ϣ��ÿ�����")
        		.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
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
		        		Intent intent = new Intent(remindActivity.this,Callupdata.class);
		        		//��������
		        		PendingIntent sender = PendingIntent.getBroadcast(remindActivity.this, 0, intent, 0);
		        		//��������
		        		AlarmManager am01 = (AlarmManager)getSystemService(ALARM_SERVICE);
		        		//setRepeating()�����ų��ظ�����
		        		//startIime Ϊ��ʼ����ʱ��
		        		//repeatTimeΪ�ظ����м��
		        		//AlarmManager��RTC  ��������ʱ��Ȼ������
		        		am01.setRepeating(AlarmManager.RTC, startTime, repeatTime, sender);
		        		
		        		
		        		dataservice = "����";
		        		//��ȡ����
						SharedPreferences sharedpreferences01 = getSharedPreferences(SetService,0);
						//����
						sharedpreferences01.edit().putString(DataService, dataservice).commit();
						
						textview06.setText(dataservice);
						
		        		//��ʾ
		        		DisplayToast("���ݹ��������������");
		        		dialog.dismiss();
		        		//��������ʱ �͵���һ�θ���Activity
		        		//Intent i = new Intent(remindActivity.this,updataActivity.class);
		        		//startActivity(i);
					}
				})
				.setNegativeButton("�˳�", new DialogInterface.OnClickListener() {
					
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
        
        //�ر����ݹ������
        button03.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		
				Intent intent = new Intent(remindActivity.this,Callupdata.class);
        		PendingIntent sender = PendingIntent.getBroadcast(remindActivity.this, 0, intent, 0);
        		
        		AlarmManager am01 = (AlarmManager)getSystemService(ALARM_SERVICE);
        		am01.cancel(sender);
        		
        		
        		dataservice = "�ر�";
        		//��ȡ����
				SharedPreferences sharedpreferences01 = getSharedPreferences(SetService,0);
				//����
				sharedpreferences01.edit().putString(DataService, dataservice).commit();
				
				textview06.setText(dataservice);
        		
        		//��ʾ 
        		DisplayToast("���ݹ�������ѹرգ�");
        	}
        });
      
        
        //����ʳƷʣ�����Ѱ���
        button01.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		//�õ��Զ���ĶԻ���
        		LayoutInflater factory = LayoutInflater.from(remindActivity.this);
        		final View DialogView = factory.inflate(R.layout.dialog,null);
        		
        		//ͨ��DialogView����Ѱdialog�еĿؼ�
        		edittext = (EditText)DialogView.findViewById(R.id.edittext);
        		textview05 = (TextView)DialogView.findViewById(R.id.textview05);
        		
        		
        		//�༭���ݼ���
				edittext.setOnKeyListener(new EditText.OnKeyListener()
		        {
		        	public boolean onKey(View arg0, int arg1, KeyEvent arg2)
		        	{
		        		textview05.setText("�������ʳƷʣ������Ϊ��"+edittext.getText().toString());
		        		return false;
		        	}
		        });
				
				
        		//���ñ༭�Ի���
        		AlertDialog dialog = new AlertDialog.Builder(remindActivity.this)
        		.setTitle("����ʣ������")
        		.setView(DialogView)
        		.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
						
						rowDay = edittext.getText().toString();
						
						if(rowDay.equals(""))
						{
							DisplayToast("û������û�취����ѽ��");
						}
						else
						{
							SharedPreferences sharedpreferences02 = getSharedPreferences(SetDay,0);
	        				//����
	        				sharedpreferences02.edit().putString(SETDAY, rowDay).commit();
	        				//��ʾʳƷʣ������
	        				textview02.setText(rowDay);
	        				//��������
	        				//DisplayToast("���óɹ���");
	        				dialog.dismiss();
						}
					}
				})
				.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
					
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
        
        //���ذ���
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
	
	//����ʱ����ʾ��λ���ķ���
	public String format(int x)
	{
		String s = "" + x;
		if(s.length()==1)
		{
			s = "0" + s;
		}
		return s;
	}
	
	//����toast������ʾ
	public void DisplayToast(String str)
	{
		Toast toast = Toast.makeText(this, str, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.TOP, 0, 220);
		toast.show();
	}
}
