package wcm.ytwhyc.anjar.connection.api;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import wcm.ytwhyc.anjar.connection.JSONRequest;
import wcm.ytwhyc.anjar.datatype.AnjarPage;
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
	

	public ArrayList<AnjarPage> parseJson() throws JSONException
	{
		//AnjarListItem res = new AnjarListItem(json.getString(name));
        ArrayList<AnjarPage> retArrList = new ArrayList<AnjarPage>();
		JSONArray ja = json.getJSONArray("PageList");
	    
	    for(int i = 0; i< ja.length();i++)
	    {
	       retArrList.add(new AnjarPage(((JSONObject)ja.get(i))));
	      
	    }
		
		
		return retArrList;
	}
	
	
	
}
