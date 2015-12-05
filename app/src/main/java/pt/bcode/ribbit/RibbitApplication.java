package pt.bcode.ribbit;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.PushService;

import pt.bcode.ribbit.ui.MainActivity;
import pt.bcode.ribbit.utils.ParseConstants;

/**
 * Created by Sergio on 28-06-2015.
 */
public class RibbitApplication extends Application {
        @Override
        public void onCreate(){
            super.onCreate();
            // Enable Local Datastore.
            Parse.enableLocalDatastore(this);
            Parse.initialize(this, "BAz5XDOx73yEPGaoDbzV0IrTd7WpptwXIVo5d1Sk", "zNd2MyQkLgx9S3LOQLUwRSu3gXTPy7n9R8qysLn6");

            //PushService.setDefaultPushCallback(this, MainActivity.class);
            ParseInstallation.getCurrentInstallation().saveInBackground();
            PushService.setDefaultPushCallback(this, MainActivity.class, R.mipmap.ic_stat_ic_launcher);
        }

        public static void updateParseInstallation(ParseUser user){
            ParseInstallation installation = ParseInstallation.getCurrentInstallation();
            installation.put(ParseConstants.KEY_USER_ID, user.getObjectId());
            installation.saveInBackground();
        }
}
