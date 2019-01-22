package android.memory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class chooseActivity extends Activity {
	private TextView textview01;
	private ImageButton imagebutton01;
	private ImageButton imagebutton02;
	private ImageButton imagebutton03;
	private ImageButton imagebutton04;
	private Button button01;
	private Button button02;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooselayout);
        
        textview01=(TextView)this.findViewById(R.id.textview01);
        String string="请选择您需要的选项...";
        textview01.setTextSize(15);
        textview01.setText(string);
        
        imagebutton01=(ImageButton)this.findViewById(R.id.imagebutton01);
        imagebutton02=(ImageButton)this.findViewById(R.id.imagebutton02);
        imagebutton03=(ImageButton)this.findViewById(R.id.imagebutton03);
        imagebutton04=(ImageButton)this.findViewById(R.id.imagebutton04);
        
        //imagebutton 监听
        imagebutton01.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent=new Intent();
        		intent.setClass(chooseActivity.this, insertActivity01.class);
        		startActivity(intent);
        		chooseActivity.this.finish();
        	}
        });  
       
        imagebutton02.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent=new Intent();
        		intent.setClass(chooseActivity.this, choose01Activity.class);
        		startActivity(intent);
        		chooseActivity.this.finish();
        	}
        });
        
        imagebutton03.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent=new Intent();
        		intent.setClass(chooseActivity.this, remindActivity.class);
        		startActivity(intent);
        		chooseActivity.this.finish();
        	}
        });
        
        imagebutton04.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent=new Intent();
        		intent.setClass(chooseActivity.this, setlistActivity.class);
        		startActivity(intent);
        		chooseActivity.this.finish();
        	}
        });
        
        button01=(Button)this.findViewById(R.id.button01);
        button02=(Button)this.findViewById(R.id.button02);
       
        //帮助
        button01.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent=new Intent();
        		intent.setClass(chooseActivity.this, helpActivity.class);
        		startActivity(intent);
        		chooseActivity.this.finish();
        	}
        }); 
        
        //返回
        button02.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		chooseActivity.this.finish();
        	}
        });  
    }
    
    
    //提示
    public void DisplayToast(String str)
    {
    	Toast toast=Toast.makeText(this, str, Toast.LENGTH_SHORT);
    	toast.setGravity(Gravity.TOP, 0, 220);
    	toast.show();
    }

}
