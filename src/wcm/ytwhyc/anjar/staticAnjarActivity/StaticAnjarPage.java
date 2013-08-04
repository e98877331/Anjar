package wcm.ytwhyc.anjar.staticAnjarActivity;


import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

import wcm.ytwhyc.anjar.datatype.AnjarPage;
import wcm.ytwhyc.anjar.runningAnjarListActivity.AnjarListItemLayout;
import wcm.ytwhyc.ratiofixer.RatioFixer;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StaticAnjarPage extends RelativeLayout {

	Context mContext;
	RatioFixer mRatioFixer;
	TextView mSelReply;
	ImageView mImage;
	TextView mOtherReply;
	
	String curImage;
	
	public StaticAnjarPage(Context context,RatioFixer pRatioFixer) {
		super(context);
		// TODO Auto-generated constructor stub
		this.setBackgroundColor(Color.WHITE);
		mContext = context;
		
		mRatioFixer = pRatioFixer;
      	mSelReply = new TextView(context);
      	mImage = new ImageView(context);
      	mOtherReply = new TextView(context);
         mOtherReply.setText("Show all replys");  	
      	
      	this.addView(mSelReply,mRatioFixer.getLayoutParam(728, 150, 20, 30));
      	this.addView(mImage,mRatioFixer.getLayoutParam(728, 800, 20, 190));
      	this.addView(mOtherReply,mRatioFixer.getLayoutParam(728, 130, 20, 1000));
		 
		//this.setData(anjarPage);
	}
	
	public void setData(final AnjarPage pPage)
	{
		((Activity)mContext).runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				mSelReply.setText(pPage.selectedReply.userName+ ":" + pPage.selectedReply.content);
				curImage = pPage.imageURLs.get(0);
				ImageLoader.getInstance().loadImage(pPage.imageURLs.get(0), new SimpleImageLoadingListener() {
					@Override
					public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
						// Do whatever you want with Bitmap
						if(StaticAnjarPage.this.curImage.equals(imageUri) && view != null)
							mImage.setImageBitmap(loadedImage);
					}
				});
			}
		});
	
		
	}

}
