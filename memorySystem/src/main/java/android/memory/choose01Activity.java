package android.memory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.TextView;

public class choose01Activity extends Activity {
	private TextView textview01;
	private Gallery gallery01;
	private Button button01;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose01layout);
        
        textview01=(TextView)this.findViewById(R.id.textview01);
        gallery01=(Gallery)this.findViewById(R.id.gallery01);
        button01=(Button)this.findViewById(R.id.button01);
        
        //添加元素给gallery
        gallery01.setAdapter(new imageAdapterL(this));
        
        gallery01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View v, int position, long id)
        	{
        		if(position+1==1)
        		{
        			Intent intent = new Intent();
        			intent.setClass(choose01Activity.this, lookiceActivity.class);
        			startActivity(intent);
        			choose01Activity.this.finish();
        		}
        		else if(position+1==2)
        		{
        			Intent intent = new Intent();
        			intent.setClass(choose01Activity.this, lookkitchenActivity.class);
        			startActivity(intent);
        			choose01Activity.this.finish();
        		}
        		else if(position+1==3)
        		{
        			Intent intent = new Intent();
        			intent.setClass(choose01Activity.this, lookroomActivity.class);
        			startActivity(intent);
        			choose01Activity.this.finish();
        		}
        		else if(position+1==4)
        		{
        			Intent intent = new Intent();
        			intent.setClass(choose01Activity.this, lookActivity.class);
        			startActivity(intent);
        			choose01Activity.this.finish();
        		}
        	}
        });
        
      //返回button
        button01.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent();
        		intent.setClass(choose01Activity.this, chooseActivity.class);
        		startActivity(intent);
        		choose01Activity.this.finish();
        	}
        });
        
	}

}
