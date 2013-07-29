package wcm.ytwhyc.anjar.datatype;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnjarItem {

	String anjarPageNumber,hostMessage;
	Reply selectedReply;
	ArrayList<String> imageURLs;
	ArrayList<Reply> allReplys; 
	
	public AnjarItem(JSONObject jobj) throws JSONException
	{
		imageURLs= new ArrayList<String>();
        allReplys = new ArrayList<Reply>();
		
		
		
		anjarPageNumber = jobj.getString("AnjarPageNumber");
		hostMessage = jobj.getString("HostMessage");
		selectedReply  = new Reply(jobj.getJSONObject("SelectedReply"));
		JSONArray imgarr = jobj.getJSONArray("ImageUrls");
		for(int i = 0; i< imgarr.length();i++)
		{
			imageURLs.add(((JSONObject)imgarr.get(i)).getString("ImageURL"));
		}
		
		JSONArray replysarr = jobj.getJSONArray("AllReplys");
		for(int i = 0; i<replysarr.length();i++)
		{
			allReplys.add(new Reply(((JSONObject)replysarr.get(i))));
		}
		
		
	}
	
	

//	 "AnjarPageNumber": "1",
//     "HostMessage": "this is google",
//     "ImageUrls": [
//         {
//             "ImageURL": "http://54.213.18.97/pics/image1.jpg"
//         },
//         {
//             "ImageURL": "http://54.213.18.97/pics/image2.jpg"
//         }
//     ],
//     "SelectedReply": {
//         "UserName": "guest",
//         "UserID": "3456",
//         "FloorNumber": "2",
//         "Content": "hello world2",
//         "PostTime": "2013-07-20 21:12:29"
//     },
//     "AllReplys": [
	
	
	
	
}
