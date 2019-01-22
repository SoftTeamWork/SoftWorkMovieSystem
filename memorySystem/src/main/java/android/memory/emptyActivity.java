package android.memory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class emptyActivity extends Activity {
	private Button button01;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emptylayout);
		
		button01 = (Button)this.findViewById(R.id.button01);
		
		//·µ»Ø
		button01.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setClass(emptyActivity.this, lookActivity.class);
				startActivity(intent);
				emptyActivity.this.finish();
			}
		});
	}

}
