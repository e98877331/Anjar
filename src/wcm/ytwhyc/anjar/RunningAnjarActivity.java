package wcm.ytwhyc.anjar;

import wcm.ytwhyc.anjar.connection.api.GetRunningAnjarData;
import wcm.ytwhyc.anjar.runningAnjarActivity.ReplyAdapter;
import wcm.ytwhyc.anjar.runningAnjarActivity.RunningAnjarActivityView;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;

public class RunningAnjarActivity extends Activity {
	private static final String TAG = "RunningAnjarActivity";
	ListView mListView;
	RunningAnjarActivityView mView;
	TextView mTargetFloor;
	Button mPrevBtn;
	Button mRefreshBtn;
	String mAnjarID;
	String mCurPageNumber;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		mView = new RunningAnjarActivityView(this);
		mView.setBackgroundColor(Color.WHITE);

		LayoutParams layoutParams = new LayoutParams(
				android.view.ViewGroup.LayoutParams.MATCH_PARENT,
				android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		layoutParams.gravity = Gravity.CENTER;
		setContentView(mView, layoutParams);

		mAnjarID =getIntent().getExtras().getString("anjarID");
		mTargetFloor = mView.targetFloor;
		mListView = mView.mainListView;
		mPrevBtn = mView.mPrevBtn;
		mPrevBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			   RunningAnjarActivity.this.onBackPressed();	
			}
		});
		
		mRefreshBtn = mView.refreshBtn;
		mRefreshBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				refresh(mAnjarID);
			}
		});
		
		init();
	}

	public void init()
	{
		refresh(mAnjarID);
	}
	
	public void refresh(final String anjarID)
	{
		final ProgressDialog pg = ProgressDialog.show(RunningAnjarActivity.this,"讀取中","請稍候");
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {

				GetRunningAnjarData grad = new GetRunningAnjarData(anjarID);
					grad.execute();
					final GetRunningAnjarData.Result res = grad.parseJson();
					
					runOnUiThread(new Runnable() {
						public void run() {
						    mTargetFloor.setText("Target Floor: "+res.targetFloor);
							mListView.setAdapter(new ReplyAdapter(RunningAnjarActivity.this, res.allReplys));
							mCurPageNumber = res.currentPageNumber;
						}
					});
					
                  //  Log.e(TAG,res.toString());					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pg.dismiss();
			}
		}).start();
	}
	
}
