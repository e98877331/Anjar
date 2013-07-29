package wcm.ytwhyc.anjar;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class AnjarApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
        .cacheInMemory(true)
        .cacheOnDisc(true)
        .build();
ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
        .defaultDisplayImageOptions(defaultOptions)
        .build();
        
        // Create global configuration and initialize ImageLoader with this configuration
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
//            .build();
        ImageLoader.getInstance().init(config);
    }
	
}
