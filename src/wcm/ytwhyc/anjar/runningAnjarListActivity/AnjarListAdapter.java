package wcm.ytwhyc.anjar.runningAnjarListActivity;

import java.util.ArrayList;

import wcm.ytwhyc.anjar.datatype.AnjarListItem;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class AnjarListAdapter extends BaseAdapter{
    
	ArrayList<AnjarListItem> mList;
	Context mContext;

	
	public AnjarListAdapter(Context pContext,ArrayList<AnjarListItem> pList)
	{
		mList =pList;
		mContext = pContext;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return mList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return  arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		if(convertView == null)
		{
		  convertView = new AnjarListItemLayout(mContext, mList.get(position));	
		}
		else
		{
			((AnjarListItemLayout)convertView).setData(mList.get(position));
		}
		
		
		return convertView;
	}

	
}
