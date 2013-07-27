package wcm.ytwhyc.anjar.runningAnjarListActivity;

import wcm.ytwhyc.ratiofixer.RatioRelativeLayout;
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
		
	
		listView = new ListView(context);
		this.addView(listView, 748, 1110, 10, 120);
		
		
	}

}
