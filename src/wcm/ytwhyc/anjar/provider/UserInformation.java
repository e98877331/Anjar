package wcm.ytwhyc.anjar.provider;

import android.provider.UserDictionary;

public class UserInformation {

	private static UserInformation mInstance = new UserInformation();
	
	public String mUserName;
	
	public static UserInformation getInstance()
	{
         return mInstance;		
	}
	
    public void setUserName(String name)
    {
    	mUserName = name;
    }
   
    public String getUserName()
    {
    	return mUserName;
    }
	
}
