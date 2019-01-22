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
        
        //删除按键
        button01.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		rowName = edittext01.getText().toString();
        		
        		if(rowName.equals(""))
        		{
        			DisplayToast("不能什么都不写哦！");
        		}
        		else
        		{
        			Cursor cur = mMydatabaseAdapter.CursorfetchData(rowName);
            		if(cur.moveToFirst())
            		{
            			mMydatabaseAdapter.deleteData(rowName);
                		DisplayToast("成功删除！");
            		}
            		else
            		{
            			DisplayToast("没有该食品！！！");
            		}
        		}
        		edittext01.setText("");
        	}
        });
        
        //返回按键
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
        
        //全部删除
        button03.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		AlertDialog dialog = new AlertDialog.Builder(deleteActivity.this)
        		.setTitle("重要提醒！")
        		.setMessage("点击确定，将删除数据库中的所有数据！慎重！！！")
        		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
						mMydatabaseAdapter.deleteAlldata();
		        		DisplayToast("成功删除全部数据！");
		        		dialog.dismiss();
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
        
	}
	
	public void DisplayToast(String str)
    {
    	Toast toast=Toast.makeText(this, str, Toast.LENGTH_SHORT);
    	toast.setGravity(Gravity.TOP, 0, 220);
    	toast.show();
    }

}
