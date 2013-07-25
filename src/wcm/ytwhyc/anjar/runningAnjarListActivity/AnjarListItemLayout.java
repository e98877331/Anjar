package wcm.ytwhyc.anjar.runningAnjarListActivity;

import wcm.ytwhyc.anjar.datatype.AnjarListItem;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AnjarListItemLayout extends LinearLayout{

	TextView hostName,topic,hostMessage,startTime,lastUpdateTime;
	public AnjarListItemLayout(Context context,AnjarListItem item) {
		super(context);
		// TODO Auto-generated constructor stub
		this.setOrientation(LinearLayout.VERTICAL);	
		
		hostName = new TextView(context);
	    hostName.setText(item.hostName);
		topic = new TextView(context);
		topic.setText(item.topic);
		hostMessage = new TextView(context);
		hostMessage.setText(item.hostMessage);
		startTime = new TextView(context);
		startTime.setText(item.startTime);
		lastUpdateTime = new TextView(context);
		lastUpdateTime.setText(item.lastUpdateTime);
       
		this.addView(hostName);
		this.addView(topic);
		this.addView(hostMessage);
		this.addView(startTime);
		this.addView(lastUpdateTime);
	}

	
	public void setData(AnjarListItem item)
	{
	    hostName.setText(item.hostName);
		topic.setText(item.topic);
		hostMessage.setText(item.hostMessage);
		startTime.setText(item.startTime);
		lastUpdateTime.setText(item.lastUpdateTime);
	}
	
//	public AnjarListItemLayout(Context context,AnjarListItem item, int width, int height) {
//		super(context, width, height);
//		// TODO Auto-generated constructor stub
//		
//		hostName = new TextView(context);
//	    hostName.setText(item.hostName);
//		topic = new TextView(context);
//		topic.setText(item.topic);
//		hostMessage = new TextView(context);
//		hostMessage.setText(item.hostMessage);
//		startTime = new TextView(context);
//		startTime.setText(item.startTime);
//		lastUpdateTime = new TextView(context);
//		lastUpdateTime.setText(item.lastUpdateTime);
//		
//		this.addView(hostName, 720, 100, 10, 10);
//	}

}
