package wcm.ytwhyc.anjar.staticAnjarActivity;

import itri.u9lab.towolf.ratiofixer.RatioFixer;

import java.util.ArrayList;

import wcm.ytwhyc.anjar.datatype.Reply;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AllReplysList extends RelativeLayout{

	ArrayList<Reply> mReplys;
	ListView mListView;
	RatioFixer mRatioFixer;
	
	public AllReplysList(Context context,RatioFixer pRatioFixer,ArrayList<Reply> pReplys) {
		super(context);
		// TODO Auto-generated constructor stub
		mRatioFixer = pRatioFixer;
		mReplys = pReplys;
		this.setBackgroundColor(Color.argb(100,0, 0, 0));
		
		mListView = new ListView(context);
		mListView.setAdapter(new ReplyAdapter());
        this.addView(mListView,mRatioFixer.getLayoutParam(700, 1100, 34, 65));	    
		
		
	}

	public void dismiss()
	{
		((ViewGroup)this.getParent()).removeView(this);
	}
	
	private class ReplyAdapter extends BaseAdapter
	{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mReplys.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return mReplys.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup arg2) {
			// TODO Auto-generated method stub
			Log.e("adapter","postion: "+Integer.toString( position));
			if(convertView == null)
			{
			  convertView = new TextView(AllReplysList.this.getContext());
			  ((TextView)convertView).setText(mReplys.get(position).userName+":"+mReplys.get(position).content);
			}
			else
			{
				((TextView)convertView).setText(mReplys.get(position).userName+":"+mReplys.get(position).content);
			}
			
			
			return convertView;
		}
		
	}
}
