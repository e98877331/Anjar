package wcm.ytwhyc.anjar.runningAnjarListActivity;

import wcm.ytwhyc.anjar.datatype.AnjarListItem;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

public class AnjarListItemLayout extends LinearLayout{

	TextView hostName,topic,hostMessage,startTime,lastUpdateTime;
	ImageView imageView;
	String imageURL;
	public AnjarListItemLayout(Context context,AnjarListItem item) {
		super(context);
		// TODO Auto-generated constructor stub
		this.setOrientation(LinearLayout.VERTICAL);	
		
		imageView = new ImageView(context);
		
		
		hostName = new TextView(context);
	 //   hostName.setText(item.hostName);
		topic = new TextView(context);
//		topic.setText(item.topic);
		hostMessage = new TextView(context);
//		hostMessage.setText(item.hostMessage);
		startTime = new TextView(context);
//		startTime.setText(item.startTime);
		lastUpdateTime = new TextView(context);
//		lastUpdateTime.setText(item.lastUpdateTime);
       
		
		this.addView(imageView);
		this.addView(hostName);
		this.addView(topic);
		this.addView(hostMessage);
		this.addView(startTime);
		this.addView(lastUpdateTime);
		
		setData(item);
	}

	
	public void setData(AnjarListItem item)
	{
		imageURL = item.imageUrl;
		
		ImageLoader.getInstance().loadImage(item.imageUrl, new SimpleImageLoadingListener() {
		    @Override
		    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
		        // Do whatever you want with Bitmap
		    	if(AnjarListItemLayout.this.imageURL.equals(imageUri) && view != null)
		    	imageView.setImageBitmap(loadedImage);
		    }
		});
		
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
