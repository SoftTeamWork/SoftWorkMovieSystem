package android.memory;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class searchiceActivity extends Activity {
	ListView mlistview = null;
	MydatabaseAdapter mMydatabaseAdapter;
	private String rowName;
	private TextView textview01;
	private Button button01;
	private Button button02;
	private Button button03;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchicelayout);
		
		mMydatabaseAdapter = new MydatabaseAdapter(this);
		mMydatabaseAdapter.open();
		//��ȡbundle��ֵ
		Bundle bundle = getIntent().getExtras();
		rowName=bundle.getString("name");
		
		textview01 = (TextView)this.findViewById(R.id.textview01);
		mlistview = (ListView)this.findViewById(R.id.mlistview);
		button01 = (Button)this.findViewById(R.id.button01);
		button02 = (Button)this.findViewById(R.id.button02);
		button03 = (Button)this.findViewById(R.id.button03);
		//String string = rowName;
		//textview01.setText(string);
		
		Cursor cur = mMydatabaseAdapter.CursorfetchData(rowName);
		
		//name=cur.getString(cur.getColumnIndex("name"));
		//textview01.setText(name);
		/*if(cur!=null)
		{
			name=cur.getString(cur.getColumnIndex("name"));
			textview01.setText(name);
		}*/
		//��ѯ��ʳƷ
		if(cur.moveToFirst())
		{
			ListAdapter adapter =  new SimpleCursorAdapter(this,R.layout.row,
					cur,new String[]{MydatabaseAdapter.KEY_NAME,MydatabaseAdapter.KEY_DATE,MydatabaseAdapter.KEY_DAY,MydatabaseAdapter.KEY_SEAT
					,MydatabaseAdapter.KEY_ALERTDAY},
					new int[]{R.id.textview01,R.id.textview02,R.id.textview03,R.id.textview04,R.id.textview05});
			mlistview.setAdapter(adapter);
		}
		else
		{
			mMydatabaseAdapter.close();
			//���û�и�ʳƷ����ת����һ����
			Intent intent = new Intent();
			intent.setClass(searchiceActivity.this, emptyActivity.class);
			startActivity(intent);
			searchiceActivity.this.finish();
			
		}
		
		//����
		button01.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View v)
			{
				mMydatabaseAdapter.close();
				Intent intent = new Intent();
				intent.setClass(searchiceActivity.this, lookiceActivity.class);
				startActivity(intent);
				searchiceActivity.this.finish();
			}
		});
		
		//�޸�
		button02.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setClass(searchiceActivity.this, modifyiceActivity.class);
				
				Bundle bundle = new Bundle();
        		bundle.putString("name", rowName);
        		intent.putExtras(bundle);
        		
        		startActivity(intent);
        		searchiceActivity.this.finish();
			}
		});
		
		button03.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View v)
			{
				mMydatabaseAdapter.deleteData(rowName);
				mMydatabaseAdapter.deleteDataice(rowName);
				DisplayToast("�ɹ�ɾ����");
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
