package android.memory;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;

public class updataActivity extends Activity {
	MydatabaseAdapter mMydatabaseAdapter;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
      //�������󣬴����ݿ�
        mMydatabaseAdapter =new MydatabaseAdapter(this);
        mMydatabaseAdapter.open();
        
        //���ݿ����
        Cursor cur = mMydatabaseAdapter.updataData();
        if(cur.isAfterLast())
        {
        	mMydatabaseAdapter.close();
        	updataActivity.this.finish();
        }
        
        //�ر����ݿ� �ص�Activity
        mMydatabaseAdapter.close();
        updataActivity.this.finish();
	}

}
