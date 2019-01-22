package android.memory;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class addkitchenActivity extends Activity {
	MydatabaseAdapter mMydatabaseAdapter;
	private String name;
	private String date;
	private String day;
	private int alertday;
	private String seat="����";
	private int Day;
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
	private static final String[] mDays={"������","1��","2��","3��","4��","5��","6��","7��"};
	private ArrayAdapter<String> adapter;
	DatePicker datepicker;
	Calendar c;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addkitchenlayout);
        
        c = Calendar.getInstance();
        
        mMydatabaseAdapter =new MydatabaseAdapter(this);
        mMydatabaseAdapter.open();
      //��ȡbundle��ֵ
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
        
      //����ѡ������ArrayAdapter ����
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mDays);
        //���������б�ķ��
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //��adapter���spinner01��
        spinner01.setAdapter(adapter);
        
        //spinner����
        spinner01.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
        {
        	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
        	{
        		if(mDays[arg2].equals("������"))
        		{
        			alertday=0;
        		}
        		else if(mDays[arg2].equals("1��"))
        		{
        			alertday=1;
        		}
        		else if(mDays[arg2].equals("2��"))
        		{
        			alertday=2;
        		}
        		else if(mDays[arg2].equals("3��"))
        		{
        			alertday=3;
        		}
        		else if(mDays[arg2].equals("4��"))
        		{
        			alertday=4;
        		}
        		else if(mDays[arg2].equals("5��"))
        		{
        			alertday=5;
        		}
        		else if(mDays[arg2].equals("6��"))
        		{
        			alertday=6;
        		}
        		else if(mDays[arg2].equals("7��"))
        		{
        			alertday=7;
        		}
        		arg0.setVisibility(View.VISIBLE);
        	}
        	public void onNothingSelected(AdapterView<?> arg0)
        	{
        		
        	}
        });
        
        
        //��� ��������
        button03.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		int mYear = c.get(Calendar.YEAR);
        		int mMonth = c.get(Calendar.MONTH);
        		int mDayofmonth = c.get(Calendar.DAY_OF_MONTH);
        		
        		new DatePickerDialog(addkitchenActivity.this,
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
        		textview02.setText("�������ʳƷ���������ǣ�"+ edittext02.getText().toString());
        	
        		return false;
        	}
        });
        
        
        edittext03.setOnKeyListener(new EditText.OnKeyListener()
        {
        	public boolean onKey(View arg0, int arg1, KeyEvent arg2)
        	{
        		textview03.setText("�������ʳƷʳ�������ǣ�"+ edittext03.getText().toString());
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
        		
        		//�ж��Ƿ�����ֵ
        		if(name.equals("")||date.equals("")||day.equals(""))
        		{
        			DisplayToast("�����пհײ�дŶ��");
        		}
        		else
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(name);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ���������������޸���Ϣ...");
            		}
            		else
            		{
            			
            			Day = Integer.parseInt(day);
            			//��ӽ����ݿ�
                		mMydatabaseAdapter.insertData(name, date, Day, alertday, seat);
                		mMydatabaseAdapter.insertDatakitvhen(name, date, Day,alertday, seat);
                		Toast toast=Toast.makeText(addkitchenActivity.this, "��ӳɹ���", Toast.LENGTH_LONG);
                		toast.setGravity(Gravity.TOP, 0, 220);
                		toast.show();
            		}
        		}
        		
        		mMydatabaseAdapter.close();
        		Intent intent= new Intent();
        		intent.setClass(addkitchenActivity.this, insertkitchenActivity.class);
        		startActivity(intent);
        		addkitchenActivity.this.finish();
        	}
        });
        
        button02.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		mMydatabaseAdapter.close();
        		Intent intent= new Intent();
        		intent.setClass(addkitchenActivity.this, insertActivity01.class);
        		startActivity(intent);
        		addkitchenActivity.this.finish();
        	}
        });
	}
	//toast��ʾ
	public void DisplayToast(String str)
	{
		Toast toast = Toast.makeText(this, str, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.TOP, 0, 220);
		toast.show();
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
	
}


