package android.memory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class modifyiceActivity extends Activity {
	MydatabaseAdapter mMydatabaseAdapter;
	private String name;
	private String date;
	private String day;
	private int Day;
	private int alertday;
	private TextView textview01;
	private TextView textview02;
	private TextView textview03;
	private EditText edittext01;
	private EditText edittext02;
	private EditText edittext03;
	private Button button01;
	private Button button02;
	private Button button03;
	private Spinner spinner01;
	private static final String[] mDays={"不提醒","1天","2天","3天","4天","5天","6天","7天"};
	private ArrayAdapter<String> adapter;
	DatePicker datepicker;
	Calendar c;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifyicelayout);
        
        c = Calendar.getInstance();
        
        mMydatabaseAdapter =new MydatabaseAdapter(this);
        mMydatabaseAdapter.open();
      //获取bundle传值
		Bundle bundle = getIntent().getExtras();
		name=bundle.getString("name");
        
        textview01=(TextView)this.findViewById(R.id.textview01);
        textview02=(TextView)this.findViewById(R.id.textview02);
        textview03=(TextView)this.findViewById(R.id.textview03);
        //edittext01=(EditText)this.findViewById(R.id.edittext01);
        edittext02=(EditText)this.findViewById(R.id.edittext02);
        edittext03=(EditText)this.findViewById(R.id.edittext03);
        button01=(Button)this.findViewById(R.id.button01);
        button02=(Button)this.findViewById(R.id.button02);
        button03=(Button)this.findViewById(R.id.button03);
        spinner01=(Spinner)this.findViewById(R.id.spinner01);
        
        //将可选内容与ArrayAdapter 连接
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mDays);
        //设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter添加spinner01中
        spinner01.setAdapter(adapter);
        
        //spinner监听
        spinner01.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
        {
        	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
        	{
        		if(mDays[arg2].equals("不提醒"))
        		{
        			alertday=0;
        		}
        		else if(mDays[arg2].equals("1天"))
        		{
        			alertday=1;
        		}
        		else if(mDays[arg2].equals("2天"))
        		{
        			alertday=2;
        		}
        		else if(mDays[arg2].equals("3天"))
        		{
        			alertday=3;
        		}
        		else if(mDays[arg2].equals("4天"))
        		{
        			alertday=4;
        		}
        		else if(mDays[arg2].equals("5天"))
        		{
        			alertday=5;
        		}
        		else if(mDays[arg2].equals("6天"))
        		{
        			alertday=6;
        		}
        		else if(mDays[arg2].equals("7天"))
        		{
        			alertday=7;
        		}
        		arg0.setVisibility(View.VISIBLE);
        	}
        	public void onNothingSelected(AdapterView<?> arg0)
        	{
        		
        	}
        });
        
        
        //点击 设置日期
        button03.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		int mYear = c.get(Calendar.YEAR);
        		int mMonth = c.get(Calendar.MONTH);
        		int mDayofmonth = c.get(Calendar.DAY_OF_MONTH);
        		
        		new DatePickerDialog(modifyiceActivity.this,
        				new DatePickerDialog.OnDateSetListener() {
							
							@Override
							public void onDateSet(DatePicker view, int year, int monthOfYear,
									int dayOfMonth) {
								// TODO Auto-generated method stub
								
								c.set(Calendar.YEAR,year);
								c.set(Calendar.MONTH, monthOfYear);
								c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
								
								date = format(year) + "-" + format(monthOfYear+1) + "-" + format(dayOfMonth);
								
								edittext02.setText(date);
								
							}
						},mYear,mMonth,mDayofmonth)
        		.show();
        	}
        });
        
        
        
        edittext02.setOnKeyListener(new EditText.OnKeyListener()
        {
        	public boolean onKey(View arg0, int arg1, KeyEvent arg2)
        	{
        		textview02.setText("您输入的食品购买日期是："+ edittext02.getText().toString());
        	
        		return false;
        	}
        });
        
        
        edittext03.setOnKeyListener(new EditText.OnKeyListener()
        {
        	public boolean onKey(View arg0, int arg1, KeyEvent arg2)
        	{
        		textview03.setText("您输入的食品食用天数是："+ edittext03.getText().toString());
        		return false;
        	}
        });
        
        
        
        button01.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		//name=edittext01.getText().toString();
        		date=edittext02.getText().toString();
        		day=edittext03.getText().toString();
        		
        		//判断是否输入值
        		if(name.equals("")||date.equals("")||day.equals(""))
        		{
        			DisplayToast("不能有空白不写哦！");
        		}
        		else
        		{
        			Day = Integer.parseInt(day);
        			//添加进数据库
            		mMydatabaseAdapter.modifyData(name, name, date, Day, alertday);
            		mMydatabaseAdapter.modifyDataice(name, name, date, Day, alertday);
            		//mMydatabaseAdapter.modifyDatakitchen(name, name, date, Day);
            		//mMydatabaseAdapter.modifyDataroom(name, name, date, Day);
            		Toast toast=Toast.makeText(modifyiceActivity.this, "添加成功！", Toast.LENGTH_LONG);
            		toast.setGravity(Gravity.TOP, 0, 220);
            		toast.show();
        		}
        		
        		mMydatabaseAdapter.close();
        		Intent intent= new Intent();
        		intent.setClass(modifyiceActivity.this, searchiceActivity.class);
        		// 传值 bundle
        		Bundle bundle = new Bundle();
        		bundle.putString("name", name);
        		intent.putExtras(bundle);
        		
        		startActivity(intent);
        		modifyiceActivity.this.finish();
        	}
        });
        
        button02.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		mMydatabaseAdapter.close();
        		Intent intent= new Intent();
        		intent.setClass(modifyiceActivity.this, searchiceActivity.class);
        		// 传值 bundle
        		Bundle bundle = new Bundle();
        		bundle.putString("name", name);
        		intent.putExtras(bundle);
        		
        		startActivity(intent);
        		modifyiceActivity.this.finish();
        	}
        });
	}
	//toast显示
	public void DisplayToast(String str)
	{
		Toast toast = Toast.makeText(this, str, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.TOP, 0, 220);
		toast.show();
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

}