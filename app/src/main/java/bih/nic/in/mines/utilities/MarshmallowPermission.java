package bih.nic.in.mines.utilities;


import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;


public class MarshmallowPermission {

	
	public int result=-1;
	final  int state=0;
	
  public MarshmallowPermission(Context context, String permission)
  {
		try
		{
		if(Build.VERSION.SDK_INT>=23)
		{
		  if (ActivityCompat.checkSelfPermission(context, permission)
	                == PackageManager.PERMISSION_GRANTED) {
		
			this.result=0;
		  }
		  else
		  {
			  ActivityCompat.requestPermissions((Activity) context,
		                new String[]{permission},
		               state);
			  
		  }
		}

		
		}
		catch(Exception e){
			e.printStackTrace();
		}
  }
	
}
