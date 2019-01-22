package android.memory;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class lookActivity extends Activity {
	MydatabaseAdapter mMydatabaseAdapter;
	ListView mlistview=null;
	private String name;
	private Button button01;
	private Button button02;
	private EditText edittext01;
	private EditText edittext02;
	private TextView textview01;
	Cursor cur;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.looklayout);
        
        mlistview = (ListView)this.findViewById(R.id.mlistview);
        textview01 = (TextView)this.findViewById(R.id.textview01);
        edittext01 = (EditText)this.findViewById(R.id.edittext01);
        //edittext02 = (EditText)this.findViewById(R.id.edittext02);
        button01 = (Button)this.findViewById(R.id.button01);
        button02 = (Button)this.findViewById(R.id.button02);
        
        //全部数据查询
        mMydatabaseAdapter =new MydatabaseAdapter(this);
        mMydatabaseAdapter.open();
        
        cur = mMydatabaseAdapter.fetchAllData();
        ListAdapter adapter = new SimpleCursorAdapter(this,R.layout.setlistrowlayout,
        		cur,new String[]{MydatabaseAdapter.KEY_NAME,MydatabaseAdapter.KEY_DAY}, 
        		new int[]{R.id.textview01,R.id.textview03});
        mlistview.setAdapter(adapter);
        
        //触摸列表选择
        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
        	{
        		cur.moveToPosition(arg2);
        		//cur = mMydatabaseAdapter.fetchAllData();
        		//edittext02.setText(cur.getString(cur.getColumnIndex(MydatabaseAdapter.KEY_NAME)));
        		
        		name = cur.getString(cur.getColumnIndex(MydatabaseAdapter.KEY_NAME));
        		
        		Intent intent = new Intent();
        		intent.setClass(lookActivity.this, searchActivity.class);
        		// 传值 bundle
        		Bundle bundle = new Bundle();
        		bundle.putString("name", name);
        		intent.putExtras(bundle);
        		
        		startActivity(intent);
        		lookActivity.this.finish();
        	}
		});
        
        //edittext编辑监听
        edittext01.setOnKeyListener(new EditText.OnKeyListener()
        {
        	public boolean onKey(View arg0, int arg1, KeyEvent arg2)
        	{
        		textview01.setText("您输入的食品名称是："+edittext01.getText().toString());
        		return false;
        	}
        });
        
        //详细查询button
        button01.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		name=edittext01.getText().toString();
        		
        		if(name.equals(""))
        		{
        			DisplayToast("什么也没写，没办法查询哦！");
        		}
        		else
        		{
        			Intent intent = new Intent();
            		intent.setClass(lookActivity.this, searchActivity.class);
            		// 传值 bundle
            		Bundle bundle = new Bundle();
            		bundle.putString("name", name);
            		intent.putExtras(bundle);
            		
            		startActivity(intent);
            		lookActivity.this.finish();
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
        		intent.setClass(lookActivity.this, chooseActivity.class);
        		startActivity(intent);
        		lookActivity.this.finish();
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
