package wcm.ytwhyc.anjar.connection.api;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import wcm.ytwhyc.anjar.connection.JSONRequest;
import wcm.ytwhyc.anjar.datatype.AnjarListItem;

public class GetAnjarList extends JSONRequest{
	
	public GetAnjarList(String displayNumber)
	{
		this.addParamPair("display_num", displayNumber);
	}
	public String getApiUrl() {
		
		return APIURL.getAnjarList;
	}

	public ArrayList<AnjarListItem> parseJson() throws JSONException
	{
		//AnjarListItem res = new AnjarListItem(json.getString(name));
        ArrayList<AnjarListItem> retArrList = new ArrayList<AnjarListItem>();
		JSONArray ja = json.getJSONArray("AnjarList");
	    
	    for(int i = 0; i< ja.length();i++)
	    {
	      JSONObject obj = ja.getJSONObject(i);
	      AnjarListItem ali = new AnjarListItem(obj.getString("AnjarID"), obj.getString("HostName"), obj.getString("Topic"), obj.getString("HostMessage"),
	    		  obj.getString("StartTime"), obj.getString("LastTime"), obj.getString("ImageURL"));
	      retArrList.add(ali);
	      
	    }
		
		
		return retArrList;
	}

}
