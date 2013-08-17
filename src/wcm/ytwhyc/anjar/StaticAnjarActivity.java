package wcm.ytwhyc.anjar;

import java.util.ArrayList;

import wcm.ytwhyc.anjar.connection.api.GetRunningAnjarData;
import wcm.ytwhyc.anjar.connection.api.GetStaticAnjarData;
import wcm.ytwhyc.anjar.datatype.AnjarPage;
import wcm.ytwhyc.anjar.staticAnjarActivity.StaticAnjarPage;
import wcm.ytwhyc.ratiofixer.RatioRelativeLayout;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;

public class StaticAnjarActivity extends Activity {

	private static final String TAG = "StaticAnjarActivity";
	
	ArrayList<AnjarPage> mPages;
    int currentPage = 0;
    
	Button mPrevBtn,mNextBtn;
	RatioRelativeLayout mView;
	StaticAnjarPage mPageView;
	String currentAnjarID;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		mView = new RatioRelativeLayout(this);
		mView.setBackgroundColor(Color.GRAY);

		LayoutParams layoutParams = new LayoutParams(
				android.view.ViewGroup.LayoutParams.MATCH_PARENT,
				android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		layoutParams.gravity = Gravity.CENTER;
		setContentView(mView, layoutParams);

		mPageView =  new StaticAnjarPage(this, mView.getRatioFixer());
		
		mView.addView(mPageView,768,1100,0,0);
		
		mPrevBtn = new Button(this);
		mPrevBtn.setText("previous");
		mPrevBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 if(currentPage > 0 && mPages!=null)
			 {
				 mPageView.setData(mPages.get(--currentPage));
				 mPageView.dismissReplysView();
			 }
			}
		});
		
		mNextBtn = new Button(this);
		mNextBtn.setText("next");
		mNextBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			   if(currentPage < mPages.size() -1 && mPages!= null)
			   {
				   mPageView.setData(mPages.get(++currentPage));
				   mPageView.dismissReplysView();
			   }
			   else if(currentPage == mPages.size() -1)
			   {
					Intent intent = new Intent(StaticAnjarActivity.this, RunningAnjarActivity.class);
					intent.putExtra("anjarID", currentAnjarID);
					intent.putExtra("currentPageNumber", currentPage);
					//startActivity(intent);
					startActivityForResult(intent, 0);
//					Intent intent = new Intent(getBaseContext(), StaticAnjarActivity.class);
//					intent.putExtra("anjarID", mAnjarList.get(position).anjarID);
//					startActivity(intent);
					
			   }
			}
		});
		
		
		mView.addView(mPrevBtn, 200, 100, 20, 1130);
		mView.addView(mNextBtn, 200, 100, 548, 1130);

		currentAnjarID =getIntent().getExtras().getString("anjarID");
        init(currentAnjarID,true);
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode == Activity.RESULT_OK)
		{
			if(data.getExtras().getBoolean("isNeedRefresh") == true)
			{
				  init(currentAnjarID,false);
			}
		}
	}
	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	    //only dismiss ReplysView if any.
		if(mPageView.dismissReplysView() == false)
			super.onBackPressed();
	}
	
	public void init(final String anjarID,final boolean isStartFromFirst )
	{
		currentPage = 0;
		final ProgressDialog pg = ProgressDialog.show(StaticAnjarActivity.this,"讀取中","請稍候");
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				GetStaticAnjarData gsad = new GetStaticAnjarData(anjarID);
				try {
					gsad.execute();
					mPages= gsad.parseJson();
					//Log.e(TAG,item.toString());
					
					runOnUiThread(new Runnable() {
						public void run() {
						    if(isStartFromFirst == true)
						    {
							mPageView.setData(mPages.get(0));
						    }
						    else
						    {
						    currentPage = mPages.size()-1; 
						    mPageView.setData(mPages.get(mPages.size()-1));
						    }
						    	
						}
					});
					
					
				GetRunningAnjarData grad = new GetRunningAnjarData(anjarID);
					grad.execute();
					GetRunningAnjarData.Result res = grad.parseJson();
                    Log.e(TAG,res.toString());					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pg.dismiss();
			}
		}).start();
	}
}
