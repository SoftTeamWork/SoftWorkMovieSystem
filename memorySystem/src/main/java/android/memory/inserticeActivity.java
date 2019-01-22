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

public class inserticeActivity extends Activity {

	MydatabaseAdapter mMydatabaseAdapter;
	private TextView textview01;
	private TextView textview02;
	private GridView gridview01;
	private EditText edittext01;
	private Button button01;
	private Button button02;
	private String food01="ƻ��";
	private String food02="ơ��";
	private String food03="�������";
	private String food04="ӣ��";
	private String food05="����";
	private String food06="�ƹ�";
	private String food07="����";
	private String food08="��֭";
	private String food09="����";
	private String food10="���ܹ�";
	private String food11="������";
	private String food12="����";
	private String food13="Ѽ��";
	private String food14="��ݮ";
	private String food15="����";
	private String food16="������";
	private String food17="������";
	private String food18="����";
	private String name;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inserticelayout);
        
        mMydatabaseAdapter =new MydatabaseAdapter(this);
        mMydatabaseAdapter.open();
        
        textview01=(TextView)this.findViewById(R.id.textview01);
        textview02=(TextView)this.findViewById(R.id.textview02);
        gridview01=(GridView)this.findViewById(R.id.gridview01);
        edittext01=(EditText)this.findViewById(R.id.edittext01);
        button01=(Button)this.findViewById(R.id.button01);
        button02=(Button)this.findViewById(R.id.button02);
        
        //���Ԫ�ظ�gridview
        gridview01.setAdapter(new imageAdapterI(this));
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
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food01);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
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
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food02);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
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
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food03);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
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
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food04);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
            		}
        		}
        		else if(position+1==5)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food05);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food05);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
            		}
        		}
        		else if(position+1==6)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food06);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food06);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
            		}
        		}
        		else if(position+1==7)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food07);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food07);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
            		}
        		}
        		else if(position+1==8)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food08);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food08);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
            		}
        		}
        		else if(position+1==9)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food09);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food09);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
            		}
        		}
        		else if(position+1==10)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food10);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food10);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
            		}
        		}
        		else if(position+1==11)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food11);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food11);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
            		}
        		}
        		else if(position+1==12)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food12);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food12);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
            		}
        		}
        		else if(position+1==13)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food13);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food13);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
            		}
        		}
        		else if(position+1==14)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food14);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food14);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
            		}
        		}
        		else if(position+1==15)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food15);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food15);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
            		}
        		}
        		else if(position+1==16)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food16);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food16);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
            		}
        		}
        		else if(position+1==17)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food17);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food17);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
            		}
        		}
        		else if(position+1==18)
        		{
        			//��ѯ�Ƿ��Ѿ����ڸ�ʳƷ
            		Cursor cur = mMydatabaseAdapter.CursorfetchData(food18);
            		if(cur.moveToFirst())
            		{
            			DisplayToast("��ʳƷ�Ѿ����ڣ�����ȥ��ѯҳ���޸���ϢŶ~");
            		}
            		else
            		{
            			mMydatabaseAdapter.close();
            			Intent intent = new Intent();
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", food18);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
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
            			intent.setClass(inserticeActivity.this, addiceActivity.class);
            			// ��ֵ bundle
                		Bundle bundle = new Bundle();
                		bundle.putString("name", name);
                		intent.putExtras(bundle);
                		
            			startActivity(intent);
            			inserticeActivity.this.finish();
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
        		intent.setClass(inserticeActivity.this, insertActivity01.class);
        		startActivity(intent);
        		inserticeActivity.this.finish();
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
