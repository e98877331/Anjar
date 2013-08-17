package wcm.ytwhyc.anjar.runningAnjarActivity;

import wcm.ytwhyc.ratiofixer.RatioRelativeLayout;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class RunningAnjarActivityView extends RatioRelativeLayout{

	public TextView mTargetFloor;
	public Button mRefreshBtn;
	public ListView mMainListView;
	public EditText mReplyText;
	public Button mNewReplyBtn;
	public Button mPrevBtn;
	
	
	public RunningAnjarActivityView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		mTargetFloor = new TextView(context);
		this.addView(mTargetFloor, 300, 200, 20, 20);
		
		mRefreshBtn = new Button(context);
		mRefreshBtn.setText("Refresh");
		this.addView(mRefreshBtn,200,200,400,20);
		mMainListView = new ListView(context);
		this.addView(mMainListView,728,730,20,250);
		
		mReplyText = new EditText(context);
		mReplyText.setSelected(false);
		this.addView(mReplyText, 728, 100, 20, 980);
      
		
		mNewReplyBtn = new Button(context);
		mNewReplyBtn.setText("Add Reply");
		this.addView(mNewReplyBtn, 200, 100, 300, 1130);
		
		mPrevBtn = new Button(context);
		mPrevBtn.setText("previous");
		mPrevBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                
			}
		});
		this.addView(mPrevBtn, 200, 100, 20, 1130);
	}

	
}
