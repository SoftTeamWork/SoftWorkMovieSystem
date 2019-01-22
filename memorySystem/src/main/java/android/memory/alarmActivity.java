package android.memory;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;

public class alarmActivity extends Activity {
	MydatabaseAdapter mMydatabaseAdapter;
	private String rowDay;
	private String SETDAY;
	private int rowday;
	private String SetDay = "SetDay";
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		//��ȡsharedpreferences �е�����rowDay
		//SharedPreferences preferences02 = getSharedPreferences(SetDay,0);
        //rowDay = preferences02.getString(SETDAY, "");
        
        //�������󣬴����ݿ�
        mMydatabaseAdapter =new MydatabaseAdapter(this);
        mMydatabaseAdapter.open();
        
        //ǿ��ת��
        //rowday = Integer.parseInt(rowDay);
        //��ѯ���ݿ���  �Ƿ�����������������
        Cursor cur = mMydatabaseAdapter.alertData();
        
        //�����������
        if(cur.moveToFirst())
        {
        	//���öԻ����ѿ�
        	new AlertDialog.Builder(alarmActivity.this)
        	.setTitle("��ʱ���ѣ���")
        	.setMessage("����ĳЩʳ�������ˣ��Ͽ�ȥ��ɣ�С�Ķ���Ŷ~��")
        	.setPositiveButton("�ص���", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
					mMydatabaseAdapter.close();
					alarmActivity.this.finish();
				}
			})
			.setNegativeButton("�鿴", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					mMydatabaseAdapter.close();
					Intent intent = new Intent();
					intent.setClass(alarmActivity.this, listalertActivity.class);
					startActivity(intent);
					alarmActivity.this.finish();
				}
			}).show();
        	
        }
        else
        {
        	alarmActivity.this.finish();
        }
        cur.close();
	}

}
