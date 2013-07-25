package wcm.ytwhyc.anjar;

import wcm.ytwhyc.anjar.connection.api.GetNEWS;
import wcm.ytwhyc.anjar.loginAcitvity.LoginActivityView;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;

public class LoginActivity extends Activity {

	LoginActivityView mView;

	Button browseBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		mView = new LoginActivityView(this);
		mView.setBackgroundColor(Color.WHITE);

		LayoutParams layoutParams = new LayoutParams(
				android.view.ViewGroup.LayoutParams.MATCH_PARENT,
				android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		layoutParams.gravity = Gravity.CENTER;
		setContentView(mView, layoutParams);

		browseBtn = mView.browseButton;
		browseBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub


			}
		});
		
		loadNEWS();

	}

	private void loadNEWS()
	{
		final ProgressDialog pg = ProgressDialog.show(LoginActivity.this,"讀取中","請稍候");
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					GetNEWS gn = new GetNEWS();
					gn.execute();
					GetNEWS.Result ret = gn.parseJson();
					Log.e("LOGinACTIVIYT", ret.status + " "
							+ ret.content);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				runOnUiThread(new Runnable() {
					public void run() {
						pg.dismiss();
					}
				});
				
			}
		}).start();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
