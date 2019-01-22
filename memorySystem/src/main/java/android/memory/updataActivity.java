package android.memory;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;

public class updataActivity extends Activity {
	MydatabaseAdapter mMydatabaseAdapter;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
      //创建对象，打开数据库
        mMydatabaseAdapter =new MydatabaseAdapter(this);
        mMydatabaseAdapter.open();
        
        //数据库更新
        Cursor cur = mMydatabaseAdapter.updataData();
        if(cur.isAfterLast())
        {
        	mMydatabaseAdapter.close();
        	updataActivity.this.finish();
        }
        
        //关闭数据库 关掉Activity
        mMydatabaseAdapter.close();
        updataActivity.this.finish();
	}

}
