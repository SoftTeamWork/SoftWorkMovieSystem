package android.memory;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Callupdata extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub

		//创建intent 调用updataActivity
		Intent i = new Intent(context,updataActivity.class);
		
		Bundle bundleRet = new Bundle();
		bundleRet.putString("STR_CALLER", "");
		i.putExtras(bundleRet);
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);
	}

}
