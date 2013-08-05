package wcm.ytwhyc.anjar;

import java.util.ArrayList;

import wcm.ytwhyc.anjar.connection.api.GetAnjarList;
import wcm.ytwhyc.anjar.datatype.AnjarListItem;
import wcm.ytwhyc.anjar.runningAnjarListActivity.AnjarListAdapter;
import wcm.ytwhyc.anjar.runningAnjarListActivity.RunningAnjarListActivityView;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;

public class RunningAnjarListActivity extends Activity {
	
	private static final String TAG = "RunningAnjarListActivity";
	
	RunningAnjarListActivityView mView;
	ListView mainListView;
	ArrayList<AnjarListItem> mAnjarList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		mView = new RunningAnjarListActivityView(this);
		mView.setBackgroundColor(Color.WHITE);

		mainListView = mView.listView;
		mainListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View arg1, int position,
					long id) {
				// TODO Auto-generated method stub
				
				//Log.e(TAG,mAnjarList.get(position).toString());
				Intent intent = new Intent(getBaseContext(), StaticAnjarActivity.class);
				intent.putExtra("anjarID", mAnjarList.get(position).anjarID);
				startActivity(intent);
			}
		});
		

		
		
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
					mAnjarList = gn.parseJson();
					Log.e("LOGinACTIVIYT", mAnjarList.toString());
					
					final AnjarListAdapter adapter = new AnjarListAdapter(RunningAnjarListActivity.this, mAnjarList);
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
