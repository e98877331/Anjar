package wcm.ytwhyc.anjar;

import java.util.ArrayList;

import wcm.ytwhyc.anjar.connection.api.GetStaticAnjarData;
import wcm.ytwhyc.anjar.datatype.AnjarPage;
import wcm.ytwhyc.anjar.staticAnjarActivity.StaticAnjarPage;
import wcm.ytwhyc.ratiofixer.RatioRelativeLayout;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout.LayoutParams;

public class StaticAnjarActivity extends Activity {

	private static final String TAG = "StaticAnjarActivity";
	
	ArrayList<AnjarPage> mPages;
	
	RatioRelativeLayout mView;
	
	StaticAnjarPage mPageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		mView = new RatioRelativeLayout(this);
		mView.setBackgroundColor(Color.GRAY);

		LayoutParams layoutParams = new LayoutParams(
				android.view.ViewGroup.LayoutParams.MATCH_PARENT,
				android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		layoutParams.gravity = Gravity.CENTER;
		setContentView(mView, layoutParams);

		mPageView =  new StaticAnjarPage(this, mView.getRatioFixer());
		
		mView.addView(mPageView,768,1100,0,0);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				GetStaticAnjarData gsad = new GetStaticAnjarData("1");
				try {
					gsad.execute();
					mPages= gsad.parseJson();
					//Log.e(TAG,item.toString());
					mPageView.setData(mPages.get(0));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		

		
	}
	
}
