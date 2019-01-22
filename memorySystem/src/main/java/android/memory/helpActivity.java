package android.memory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class helpActivity extends Activity {
	
	private Button button01;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helplayout);
        
        button01=(Button)this.findViewById(R.id.button01);
        
        button01.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent=new Intent();
        		intent.setClass(helpActivity.this, chooseActivity.class);
        		startActivity(intent);
        		helpActivity.this.finish();
        	}
        }); 
	}

}
