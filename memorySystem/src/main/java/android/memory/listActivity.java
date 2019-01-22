package android.memory;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class listActivity extends Activity {
	MydatabaseAdapter  mMydatabaseAdapter;
	private ListView mlistview = null;
	private TextView textview01;
	private Button button01;
	private Button button02;
	private String rowDay;
	private int rowday;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlayout);
        
        //构造MydatabaseAdapter对象
        mMydatabaseAdapter = new MydatabaseAdapter(this);
        mMydatabaseAdapter.open();
      //获取bundle传值
		Bundle bundle = getIntent().getExtras();
		rowDay=bundle.getString("day");
        
        mlistview = (ListView)this.findViewById(R.id.mlistview);
        textview01 = (TextView)this.findViewById(R.id.textview01);
        button01 = (Button)this.findViewById(R.id.button01);
        //button02 = (Button)this.findViewById(R.id.button02);
        
        
        rowday = Integer.parseInt(rowDay);
        //查询显示清单
        Cursor cur = mMydatabaseAdapter.searchData(rowday);
        if(cur.moveToFirst())
        {
        	ListAdapter adapter = new SimpleCursorAdapter(this,R.layout.setlistrowlayout,
            		cur,new String[]{MydatabaseAdapter.KEY_NAME,MydatabaseAdapter.KEY_DAY}, 
            		new int[]{R.id.textview01,R.id.textview03});
            mlistview.setAdapter(adapter);
        }
        else
        {
        	textview01.setText("没有符合条件的购买清单...");
        }
        
        //Button 事件 返回
        button01.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		mMydatabaseAdapter.close();
        		Intent intent = new Intent();
        		intent.setClass(listActivity.this, setlistActivity.class);
        		startActivity(intent);
        		listActivity.this.finish();
        	}
        });
        
        /*button02.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		mMydatabaseAdapter.close();
        		Intent intent = new Intent();
        		intent.setClass(listActivity.this, setlistActivity.class);
        		startActivity(intent);
        		listActivity.this.finish();
        	}
        });*/
	}

}
