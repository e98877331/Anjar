package wcm.ytwhyc.anjar;

import wcm.ytwhyc.anjar.connection.api.GetRunningAnjarData;
import wcm.ytwhyc.anjar.connection.api.NewReply;
import wcm.ytwhyc.anjar.provider.UserInformation;
import wcm.ytwhyc.anjar.runningAnjarActivity.ReplyAdapter;
import wcm.ytwhyc.anjar.runningAnjarActivity.RunningAnjarActivityView;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;

public class RunningAnjarActivity extends Activity {
	private static final String TAG = "RunningAnjarActivity";
	
	ListView mListView;
	RunningAnjarActivityView mView;
	TextView mTargetFloor;
	Button mPrevBtn;
	Button mRefreshBtn;
	Button mReplyBtn;
	String mAnjarID;
	EditText mReplyText;
	int mCurPageNumber;
	
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
		
		 //hide keyboard at first
		 this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
		 
  
		 
		mAnjarID =getIntent().getExtras().getString("anjarID");
		mCurPageNumber = getIntent().getExtras().getInt("currentPageNumber") +1;
		
		mTargetFloor = mView.mTargetFloor;
		mListView = mView.mMainListView;
		mPrevBtn = mView.mPrevBtn;
		mPrevBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			   RunningAnjarActivity.this.onBackPressed();	
			}
		});
		
		mRefreshBtn = mView.mRefreshBtn;
		mRefreshBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				refresh(mAnjarID);
			}
		});
		
		mReplyText = mView.mReplyText;
		mReplyText.setFilters( new InputFilter[] {
			   new InputFilter.LengthFilter(20)});
		mReplyText.setSingleLine();
		mReplyBtn = mView.mNewReplyBtn;
		mReplyBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				newReply(mReplyText.getText().toString());
				mReplyText.setText("");
				refresh(mAnjarID);
			}
		});
		
		init();
	}

	public void init()
	{
		refresh(mAnjarID);
	}
	
    private void onNewPageAdded()
    {
		Intent resultIntent = new Intent();
		resultIntent.putExtra("isNeedRefresh", true);
		setResult(Activity.RESULT_OK, resultIntent);
		finish();
    }
	
    public void newReply(final String content)
    {
final ProgressDialog pg = ProgressDialog.show(RunningAnjarActivity.this,"讀取中","請稍候");
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {

				NewReply nr = new NewReply("guestID", UserInformation.getInstance().getUserName(),mAnjarID, String.valueOf(mCurPageNumber+1), content);
					nr.execute();
					final NewReply.Result res = nr.parseJson();
					
					runOnUiThread(new Runnable() {
						public void run() {
                             if(res.status.equals("success"))
                             {
                            	showDialog("reply success");
                             }
                             else if(res.status.equals("failure"))
                             {
                            	 showDialog("reply failed");
                             }
							
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
							
							//TODO: server returned currentPageNumber is start from 1 instead of 0
							if(mCurPageNumber != Integer.parseInt(res.currentPageNumber)-1)
							{
								onNewPageAdded();
							
							}
							
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
	
	
    private void showDialog(String text)
    {
    	AlertDialog.Builder dialog = new AlertDialog.Builder(this);
    	dialog.setMessage(text);
    	dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {  
    	    public void onClick(DialogInterface dialog, int which) {  
    	      dialog.dismiss();
    	    }  
    	}); 
    	dialog.show();
    }
	
}
