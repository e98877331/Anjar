package wcm.ytwhyc.anjar.runningAnjarActivity;

import wcm.ytwhyc.ratiofixer.RatioRelativeLayout;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class RunningAnjarActivityView extends RatioRelativeLayout{

	public TextView targetFloor;
	public Button refreshBtn;
	public ListView mainListView;
	public Button addReply;
	public Button mPrevBtn;
	
	
	public RunningAnjarActivityView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		targetFloor = new TextView(context);
		this.addView(targetFloor, 300, 200, 20, 20);
		
		refreshBtn = new Button(context);
		refreshBtn.setText("Refresh");
		this.addView(refreshBtn,200,200,400,20);
		mainListView = new ListView(context);
		this.addView(mainListView,728,830,20,250);
		addReply = new Button(context);
		addReply.setText("Add Reply");
		this.addView(addReply, 200, 100, 300, 1130);
		
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
