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
	private String food01="ʳ����";
	private String food02="ʳ����";
	private String food03="����";
	private String food04="��";
	
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
        
        //���Ԫ�ظ�gridview
        gridview01.setAdapter(new imageAdapterK(this));
        //gridview ����
        gridview01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View v, int position, long id)
        	{
        		if(position+1==1)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food01);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertkitchenActivity.this, addkitchenActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food01);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertkitchenActivity.this.finish();
            		}
        		}
        		else if(position+1==2)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food02);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertkitchenActivity.this, addkitchenActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food02);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertkitchenActivity.this.finish();
            		}
        		}
        		else if(position+1==3)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food03);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertkitchenActivity.this, addkitchenActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food03);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertkitchenActivity.this.finish();
            		}
        		}
        		else if(position+1==4)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food04);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertkitchenActivity.this, addkitchenActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food04);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertkitchenActivity.this.finish();
            		}
        		}
        	}
        });
        
      //edittext�༭����
        edittext01.setOnKeyListener(new EditText.OnKeyListener()
        {
        	public boolean onKey(View arg0, int arg1, KeyEvent arg2)
        	{
        		textview02.setText("�������ʳƷ�����ǣ�"+edittext01.getText().toString());
        		return false;
        	}
        });
        
      //�ύbutton
        button01.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		name=edittext01.getText().toString();
        		//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
        		Cursor cur = mMydatabaseAdapter.CursorfetchData(name);
        		
        		if(name.equals(""))
        		{
        			DisplayToast("ʲôҲûд�ɲ���Ŷ��");
        		}
        		else
        		{
        			if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(insertkitchenActivity.this, addkitchenActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", name);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			insertkitchenActivity.this.finish();
            		}
        		}
        		
        	}
        });
        
      //����button
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
