package android.memory;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class deleteActivity extends Activity {
	MydatabaseAdapter mMydatabaseAdapter;
	private String rowName;
	private TextView textview01;
	private EditText edittext01;
	private Button button01;
	private Button button02;
	private Button button03;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletelayout);
        
        textview01 = (TextView)this.findViewById(R.id.textview01);
        edittext01 = (EditText)this.findViewById(R.id.edittext01);
        button01 = (Button)this.findViewById(R.id.button01);
        button02 = (Button)this.findViewById(R.id.button02);
        button03 = (Button)this.findViewById(R.id.button03);
        
        
        mMydatabaseAdapter =new MydatabaseAdapter(this);
        mMydatabaseAdapter.open();
        
        //ɾ������
        button01.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		rowName = edittext01.getText().toString();
        		
        		if(rowName.equals(""))
        		{
        			DisplayToast("����ʲô����дŶ��");
        		}
        		else
        		{
        			Cursor cur = mMydatabaseAdapter.CursorfetchData(rowName);
            		if(cur.moveToFirst())
            		{
            			mMydatabaseAdapter.deleteData(rowName);
                		DisplayToast("�ɹ�ɾ����");
            		}
            		else
            		{
            			DisplayToast("û�и�ʳƷ������");
            		}
        		}
        		edittext01.setText("");
        	}
        });
        
        //���ذ���
        button02.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		mMydatabaseAdapter.close();
        		Intent intent = new Intent();
        		intent.setClass(deleteActivity.this, chooseActivity.class);
        		startActivity(intent);
        		deleteActivity.this.finish();
        	}
        });
        
        //ȫ��ɾ��
        button03.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		AlertDialog dialog = new AlertDialog.Builder(deleteActivity.this)
        		.setTitle("��Ҫ���ѣ�")
        		.setMessage("���ȷ������ɾ�����ݿ��е��������ݣ����أ�����")
        		.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
						mMydatabaseAdapter.deleteAlldata();
		        		DisplayToast("�ɹ�ɾ��ȫ�����ݣ�");
		        		dialog.dismiss();
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
        
	}
	
	public void DisplayToast(String str)
    {
    	Toast toast=Toast.makeText(this, str, Toast.LENGTH_SHORT);
    	toast.setGravity(Gravity.TOP, 0, 220);
    	toast.show();
    }

}
