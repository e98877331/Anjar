package wcm.ytwhyc.anjar;

import java.util.ArrayList;

import wcm.ytwhyc.anjar.connection.api.GetAnjarList;
import wcm.ytwhyc.anjar.datatype.AnjarListItem;
import wcm.ytwhyc.anjar.runningAnjarListActivity.AnjarListAdapter;
import wcm.ytwhyc.anjar.runningAnjarListActivity.RunningAnjarListActivityView;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class RunningAnjarListActivity extends Activity {

	RunningAnjarListActivityView mView;
	ListView mainListView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		mView = new RunningAnjarListActivityView(this);
		mView.setBackgroundColor(Color.WHITE);

		mainListView = mView.listView;
		
		LayoutParams layoutParams = new LayoutParams(
				android.view.ViewGroup.LayoutParams.MATCH_PARENT,
				android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		layoutParams.gravity = Gravity.CENTER;
		setContentView(mView, layoutParams);


		
		loadAnjarList();
		
	}
	
	

	private void loadAnjarList()
	{
		final ProgressDialog pg = ProgressDialog.show(RunningAnjarListActivity.this,"讀取中","請稍候");
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					GetAnjarList gn = new GetAnjarList("3");
					gn.execute();
					ArrayList<AnjarListItem> list = gn.parseJson();
					Log.e("LOGinACTIVIYT", list.toString());
					
					final AnjarListAdapter adapter = new AnjarListAdapter(RunningAnjarListActivity.this, list);
					runOnUiThread(new  Runnable() {
						public void run() {
							
							mainListView.setAdapter(adapter);
						}
					});
					
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
	
}
