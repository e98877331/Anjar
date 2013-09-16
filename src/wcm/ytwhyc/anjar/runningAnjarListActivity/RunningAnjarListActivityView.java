package wcm.ytwhyc.anjar.runningAnjarListActivity;

import itri.u9lab.towolf.ratiofixer.RatioRelativeLayout;
import android.content.Context;
import android.graphics.Color;
import android.widget.ListView;
import android.widget.TextView;

public class RunningAnjarListActivityView extends RatioRelativeLayout{

	TextView title;
	
	public ListView listView;
	
	public RunningAnjarListActivityView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.setBackgroundColor(Color.WHITE);
		title = new TextView(context);
		title.setText("正在進行的安價");
		this.addView(title, 748, 100, 10,10 );
		
//		LinearLayout ll = new LinearLayout(context);
//		this.addView(ll,748, 1110, 10, 120);
	
		listView = new ListView(context);
		
//		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//		ll.addView(listView,lp);
		this.addView(listView, 748, 1110, 10, 120);
		
		
	}

}
