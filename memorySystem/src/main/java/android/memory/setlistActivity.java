package android.memory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class setlistActivity extends Activity {
	private TextView textview01;
	private EditText edittext01;
	private Button button01;
	private Button button02;
	private Button button03;
	private Button button04;
	private Button button05;
	private Button button06;
	private String rowDay;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setlistlayout);
        
        textview01 = (TextView)this.findViewById(R.id.textview01);
        edittext01 = (EditText)this.findViewById(R.id.edittext01);
        button01 = (Button)this.findViewById(R.id.button01);
        button02 = (Button)this.findViewById(R.id.button02);
        button03 = (Button)this.findViewById(R.id.button03);
        button04 = (Button)this.findViewById(R.id.button04);
        button05 = (Button)this.findViewById(R.id.button05);
        button06 = (Button)this.findViewById(R.id.button06);
        
        //edittext�༭����
        edittext01.setOnKeyListener(new EditText.OnKeyListener()
        {
        	public boolean onKey(View arg0, int arg1, KeyEvent arg2)
        	{
        		textview01.setText("�������ʳ������Ϊ��"+edittext01.getText().toString());
        		return false;
        	}
        });
        
        // button�������� ȷ����
        button01.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		rowDay = edittext01.getText().toString();
        		
        		if(rowDay.equals(""))
        		{
        			DisplayToast("û��������û�취���ɲο��嵥��Ŷ��");
        		}
        		else
        		{
            		Intent intent = new Intent();
            		intent.setClass(setlistActivity.this, listActivity.class);
            		//��ֵ
            		Bundle bundle = new Bundle();
            		bundle.putString("day", rowDay);
            		intent.putExtras(bundle);
            		
            		startActivity(intent);
            		setlistActivity.this.finish();
        		}
        		
        	}
        });
        
        //���ؼ�
        button02.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent();
        		intent.setClass(setlistActivity.this, chooseActivity.class);
        		startActivity(intent);
        		setlistActivity.this.finish();
        	}
        });
        
        //�鿴�Ѿ����ѵ�ʳ���嵥
        button03.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent();
        		intent.setClass(setlistActivity.this, listalertActivity.class);
        		startActivity(intent);
        		setlistActivity.this.finish();
        	}
        });
        
        //�鿴ʳ������3����嵥
        button04.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		rowDay=Integer.toString(3);
        		Intent intent = new Intent();
        		intent.setClass(setlistActivity.this, listActivity.class);
        		//��ֵ
        		Bundle bundle = new Bundle();
        		bundle.putString("day", rowDay);
        		intent.putExtras(bundle);
        		
        		startActivity(intent);
        		setlistActivity.this.finish();
        	}
        });
        
      //�鿴ʳ������5����嵥
        button05.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		rowDay=Integer.toString(5);
        		Intent intent = new Intent();
        		intent.setClass(setlistActivity.this, listActivity.class);
        		//��ֵ
        		Bundle bundle = new Bundle();
        		bundle.putString("day", rowDay);
        		intent.putExtras(bundle);
        		
        		startActivity(intent);
        		setlistActivity.this.finish();
        	}
        });
        
      //�鿴ʳ������7����嵥
        button06.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		rowDay=Integer.toString(7);
        		Intent intent = new Intent();
        		intent.setClass(setlistActivity.this, listActivity.class);
        		//��ֵ
        		Bundle bundle = new Bundle();
        		bundle.putString("day", rowDay);
        		intent.putExtras(bundle);
        		
        		startActivity(intent);
        		setlistActivity.this.finish();
        	}
        });
	}
	//������ʾ
	public void DisplayToast(String str)
	{
		Toast toast = Toast.makeText(this, str, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.TOP, 0, 220);
		toast.show();
	}

}
