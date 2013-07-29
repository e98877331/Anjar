package wcm.ytwhyc.anjar.staticAnjarActivity;

import wcm.ytwhyc.anjar.datatype.AnjarItem;
import wcm.ytwhyc.ratiofixer.RatioFixer;
import android.content.Context;
import android.widget.RelativeLayout;

public class StaticAnjarPage extends RelativeLayout {

	RatioFixer mRatioFixer;
	
	public StaticAnjarPage(Context context,AnjarItem anjarItem,RatioFixer pRatioFixer) {
		super(context);
		// TODO Auto-generated constructor stub
		mRatioFixer = pRatioFixer;
		
	}

}
