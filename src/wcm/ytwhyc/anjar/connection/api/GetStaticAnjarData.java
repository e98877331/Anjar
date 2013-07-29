package wcm.ytwhyc.anjar.connection.api;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import wcm.ytwhyc.anjar.connection.JSONRequest;
import wcm.ytwhyc.anjar.datatype.AnjarItem;
import wcm.ytwhyc.anjar.datatype.AnjarListItem;

public class GetStaticAnjarData extends JSONRequest {

	@Override
	public String getApiUrl() {
		// TODO Auto-generated method stub
		return APIURL.getStaticAnjarData;
	}

	public GetStaticAnjarData(String anjarID)
	{
		this.addParamPair("anjar_id", anjarID);
	}
	

	public ArrayList<AnjarItem> parseJson() throws JSONException
	{
		//AnjarListItem res = new AnjarListItem(json.getString(name));
        ArrayList<AnjarItem> retArrList = new ArrayList<AnjarItem>();
		JSONArray ja = json.getJSONArray("PageList");
	    
	    for(int i = 0; i< ja.length();i++)
	    {
	       retArrList.add(new AnjarItem(((JSONObject)ja.get(i))));
	      
	    }
		
		
		return retArrList;
	}
	
	
	
}
