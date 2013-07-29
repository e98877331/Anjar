package wcm.ytwhyc.anjar;

import java.util.ArrayList;

import wcm.ytwhyc.anjar.connection.api.GetStaticAnjarData;
import wcm.ytwhyc.anjar.datatype.AnjarItem;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class StaticAnjarActivity extends Activity {

	private static final String TAG = "StaticAnjarActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				GetStaticAnjarData gsad = new GetStaticAnjarData("1");
				try {
					gsad.execute();
					ArrayList<AnjarItem> item = gsad.parseJson();
					Log.e(TAG,item.toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		

		
	}
	
}
