package wcm.ytwhyc.anjar.runningAnjarActivity;

import java.util.ArrayList;

import wcm.ytwhyc.anjar.datatype.Reply;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ReplyAdapter extends BaseAdapter
{

	ArrayList<Reply> mReplys;
	Context mContext;
	
	public ReplyAdapter(Context context,ArrayList<Reply> replys)
	{
		mContext = context;
		mReplys = replys;
	}
	
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
		  convertView = new TextView(mContext);
		  ((TextView)convertView).setText(mReplys.get(position).userName+":"+mReplys.get(position).content);
		}
		else
		{
			((TextView)convertView).setText(mReplys.get(position).userName+":"+mReplys.get(position).content);
		}
		
		
		return convertView;
	}
	
}