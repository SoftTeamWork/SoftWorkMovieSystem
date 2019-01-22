package android.memory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class insertActivity01 extends Activity {
	private ImageButton imagebutton01;
	private ImageButton imagebutton02;
	private ImageButton imagebutton03;
	private Button button01;
	private TextView textview01;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertlayout01);
        
        imagebutton01=(ImageButton)this.findViewById(R.id.imagebutton01);
        imagebutton02=(ImageButton)this.findViewById(R.id.imagebutton02);
        imagebutton03=(ImageButton)this.findViewById(R.id.imagebutton03);
        button01=(Button)this.findViewById(R.id.button01);
        textview01=(TextView)this.findViewById(R.id.textview01);
        
        //imagebutton¼àÌý
        imagebutton01.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent=new Intent();
        		intent.setClass(insertActivity01.this, inserticeActivity.class);
        		startActivity(intent);
        		insertActivity01.this.finish();
        	}
        });  
        
        imagebutton02.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent=new Intent();
        		intent.setClass(insertActivity01.this, insertkitchenActivity.class);
        		startActivity(intent);
        		insertActivity01.this.finish();
        	}
        });  
        
        imagebutton03.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent=new Intent();
        		intent.setClass(insertActivity01.this, insertroomActivity.class);
        		startActivity(intent);
        		insertActivity01.this.finish();
        	}
        }); 
        
        //button¼àÌý
        button01.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent= new Intent();
        		intent.setClass(insertActivity01.this, chooseActivity.class);
        		startActivity(intent);
        		insertActivity01.this.finish();
        	}
        });
	}

}
