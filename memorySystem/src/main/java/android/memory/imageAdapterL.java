package android.memory;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;

public class imageAdapterL extends BaseAdapter {
	
	private Context mcontext;
	private Integer[] mimageids =
	{
			R.drawable.ice,
			R.drawable.kitchen,
			R.drawable.storeroom,
			R.drawable.all,
	};

	public imageAdapterL(Context c)
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
		imageview01.setLayoutParams(new Gallery.LayoutParams(120,120));
		imageview01.setScaleType(ImageView.ScaleType.FIT_CENTER);
		return imageview01;
	}

}
