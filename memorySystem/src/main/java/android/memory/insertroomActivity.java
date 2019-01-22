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

public class insertroomActivity extends Activity {

	MydatabaseAdapter mMydatabaseAdapter;
	private TextView textview01;
	private TextView textview02;
	private GridView gridview01;
	private EditText edittext01;
	private Button button01;
	private Button button02;
	private String food01="白萝卜";
	private String food02="香蕉";
	private String food03="白菜";
	private String food04="茄子";
	private String food05="面粉";
	private String food06="大蒜";
	private String food07="青椒";
	private String food08="莲藕";
	private String food09="玉米";
	private String food10="小米";
	private String food11="香菇";
	private String food12="洋葱";
	private String food13="花生";
	private String food14="辣椒";
	private String food15="土豆";
	private String food16="南瓜";
	private String food17="胡萝卜";
	private String food18="大米";
	private String food19="菠菜";
	private String food20="红薯";
	private String name;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertroomlayout);
        
        mMydatabaseAdapter =new MydatabaseAdapter(this);
        mMydatabaseAdapter.open();
        
        textview01=(TextView)this.findViewById(R.id.textview01);
        textview02=(TextView)this.findViewById(R.id.textview02);
        gridview01=(GridView)this.findViewById(R.id.gridview01);
        edittext01=(EditText)this.findViewById(R.id.edittext01);
        button01=(Button)this.findViewById(R.id.button01);
        button02=(Button)this.findViewById(R.id.button02);
        
        //添加元素给gridview
        gridview01.setAdapter(new imageAdapterR(this));
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
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food01);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
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
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food02);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
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
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food03);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
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
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food04);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==5)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food05);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food05);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==6)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food06);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food06);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==7)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food07);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food07);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==8)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food08);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food08);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==9)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food09);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food09);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==10)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food10);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food10);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==11)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food11);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food11);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==12)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food12);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food12);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==13)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food13);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food13);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==14)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food14);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food14);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==15)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food15);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food15);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==16)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food16);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food16);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==17)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food17);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food17);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==18)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food18);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food18);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==19)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food19);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food19);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
            		}
        		}
        		else if(position+1==20)
        		{
        			//查询是否已经存在该食品
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food20);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("该食品已经存在！可以去查询页面修改信息哦~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food20);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
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
            			intent.setClass(insertroomActivity.this, addroomActivity.class);
            			// 传值 bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", name);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertroomActivity.this.finish();
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
        		intent.setClass(insertroomActivity.this, insertActivity01.class);
        		startActivity(intent);
        		insertroomActivity.this.finish();
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
