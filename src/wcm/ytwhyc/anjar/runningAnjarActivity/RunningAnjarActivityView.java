package wcm.ytwhyc.anjar.runningAnjarActivity;

import wcm.ytwhyc.ratiofixer.RatioRelativeLayout;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class RunningAnjarActivityView extends RatioRelativeLayout{

	TextView targetFloor;
	Button refresh;
	ListView mainListView;
	EditText addReply;
	
	public RunningAnjarActivityView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		targetFloor = new TextView(context);
		this.addView(targetFloor, 300, 200, 20, 20);
		
		refresh = new Button(context);
		this.addView(refresh,200,200,400,20);
		mainListView = new ListView(context);
		addReply = new EditText(context);
	}

	
}
