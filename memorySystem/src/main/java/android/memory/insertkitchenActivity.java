package android.memory;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class insertkitchenActivity extends Activity {
	
	MydatabaseAdapter mMydatabaseAdapter;
	private TextView textview01;
	private TextView textview02;
	private GridView gridview01;
	private EditText edittext01;
	private Button button01;
	private Button button02;
	private String name;
	private String food01="食用油";
	private String food02="食用盐";
	private String food03="酱油";
	private String food04="醋";
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertkitchenlayout);
        
        mMydatabaseAdapter =new MydatabaseAdapter(this);
        mMydatabaseAdapter.open();
        
        textview01=(TextView)this.findViewById(R.id.textview01);
        textview02=(TextView)this.findViewById(R.id.textview02);
        gridview01=(GridView)this.findViewById(R.id.gridview01);
        edittext01=(EditText)this.findViewById(R.id.edittext01);
        button01=(Button)this.findViewById(R.id.button01);
        button02=(Button)this.findViewById(R.id.button02);
        
        //添加元素给gridview
        gridview01.setAdapter(new imageAdapterK(this));
        //gridview 监听
        gridview01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View v, int position, long id)
        	{
        		if(position+1==1)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food01);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertkitchenActivity.this, addkitchenActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food01);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertkitchenActivity.this.finish();
            		}
        		}
        		else if(position+1==2)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food02);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertkitchenActivity.this, addkitchenActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food02);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertkitchenActivity.this.finish();
            		}
        		}
        		else if(position+1==3)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food03);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertkitchenActivity.this, addkitchenActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food03);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertkitchenActivity.this.finish();
            		}
        		}
        		else if(position+1==4)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food04);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertkitchenActivity.this, addkitchenActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food04);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertkitchenActivity.this.finish();
            		}
        		}
        	}
        });
        
      //edittext编辑监听
        edittext01.setOnKeyListener(new EditText.OnKeyListener()
        {
        	public boolean onKey(View arg0, int arg1, KeyEvent arg2)
        	{
        		textview02.setText("您输入的食品名称是："+edittext01.getText().toString());
        		return false;
        	}
        });
        
      //提交button
        button01.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		name=edittext01.getText().toString();
        		//查询是否已经存在该食品
        		Cursor cur = mMydatabaseAdapter.CursorfetchData(name);
        		
        		if(name.equals(""))
        		{
        			DisplayToast("什么也没写可不行哦！");
        		}
        		else
        		{
        			if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertkitchenActivity.this, addkitchenActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", name);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertkitchenActivity.this.finish();
            		}
        		}
        		
        	}
        });
        
      //返回button
        button02.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		mMydatabaseAdapter.close();
        		Intent intent = new Intent();
        		intent.setClass(insertkitchenActivity.this, insertActivity01.class);
        		startActivity(intent);
        		insertkitchenActivity.this.finish();
        	}
        });
        
	}
	
	public void DisplayToast(String str)
	{
		Toast toast = Toast.makeText(this, str, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.TOP, 0, 220);
		toast.show();
	}

}
