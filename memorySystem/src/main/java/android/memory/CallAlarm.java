package android.memory;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class CallAlarm extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub

		//����intent ����alarmActivity
		Intent i = new Intent(context,alarmActivity.class);
		
		Bundle bundleRet = new Bundle();
		bundleRet.putString("STR_CALLER", "");
		i.putExtras(bundleRet);
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);
		
	}

}
