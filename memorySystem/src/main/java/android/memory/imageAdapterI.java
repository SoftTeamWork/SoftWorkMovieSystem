package android.memory;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;

public class imageAdapterI extends BaseAdapter {
	
	private Context mcontext;
	private Integer[] mimageids =
	{
			R.drawable.apple,
			R.drawable.beer,
			R.drawable.bread,
			R.drawable.cherry,
			R.drawable.coke,
			R.drawable.cucumber,
			R.drawable.egg,
			R.drawable.fruit,
			R.drawable.grape,
			R.drawable.hamimelon,
			R.drawable.icecream,
			R.drawable.lemon,
			R.drawable.pear,
			R.drawable.strawberry,
			R.drawable.tangerine,
			R.drawable.tea,
			R.drawable.tomato,
			R.drawable.watermelon,
			
	};

	public imageAdapterI(Context c)
	{
		mcontext=c;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mimageids.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView imageview01 = new ImageView(mcontext);
		imageview01.setImageResource(mimageids[position]);
		imageview01.setLayoutParams(new GridView.LayoutParams(90,90));
		imageview01.setScaleType(ImageView.ScaleType.FIT_CENTER);
		return imageview01;
	}

}
