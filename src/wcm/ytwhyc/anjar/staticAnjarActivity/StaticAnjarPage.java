package wcm.ytwhyc.anjar.staticAnjarActivity;


import itri.u9lab.towolf.ratiofixer.RatioFixer;
import wcm.ytwhyc.anjar.datatype.AnjarPage;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

public class StaticAnjarPage extends RelativeLayout {

	Context mContext;
	RatioFixer mRatioFixer;
	TextView mSelReply;
	ImageView mImage;
	TextView mOtherReply;
	AnjarPage mPage;
	String curImage;
	int curImageIndex;
	
	
	AllReplysList mReplysView;
	
	public StaticAnjarPage(Context context,RatioFixer pRatioFixer) {
		super(context);
		// TODO Auto-generated constructor stub
		this.setBackgroundColor(Color.WHITE);
		mContext = context;
		
		mRatioFixer = pRatioFixer;
      	mSelReply = new TextView(context);
      	mImage = new ImageView(context);
      	mImage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				curImageIndex = (curImageIndex+1)%mPage.imageURLs.size();
				setImage(curImageIndex);
			}
		});
      	
      	mOtherReply = new TextView(context);
         mOtherReply.setText("Show all replys");
         mOtherReply.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(mReplysView == null && mPage != null)
				{
					mReplysView = new AllReplysList(mContext, mRatioFixer, mPage.allReplys);
					StaticAnjarPage.this.addView(mReplysView, mRatioFixer.getLayoutParam(768, 1230, 0, 0));
				}
			}
		});
         
      	
      	this.addView(mSelReply,mRatioFixer.getLayoutParam(728, 150, 20, 30));
      	this.addView(mImage,mRatioFixer.getLayoutParam(728, 800, 20, 190));
      	this.addView(mOtherReply,mRatioFixer.getLayoutParam(728, 130, 20, 1000));
		 
		//this.setData(anjarPage);
	}
	
	
	//returns true if any replysview dismissed
    public boolean dismissReplysView()
    {
    	if(mReplysView != null)
    	{
    		mReplysView.dismiss();
    		mReplysView = null;
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
	
	public void setData(final AnjarPage pPage)
	{

				clear();
				mPage = pPage;
				mSelReply.setText(pPage.selectedReply.userName+ ":" + pPage.selectedReply.content);
				curImageIndex = 0;
                setImage(curImageIndex);
			
	}
	
	private void setImage(int index)
	{
		curImage = mPage.imageURLs.get(index);
		ImageLoader.getInstance().loadImage(curImage, new SimpleImageLoadingListener() {
			@Override
			public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
				// Do whatever you want with Bitmap
				if(StaticAnjarPage.this.curImage.equals(imageUri) && view != null)
					mImage.setImageBitmap(loadedImage);
			}
		});
	}
	
	public void clear()
	{
		mImage.setImageBitmap(null);
	}
	
	public void clear()
	{
		mImage.setImageBitmap(null);
	}

}
