package com.kioskmodereactnative;

import com.facebook.react.ReactActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

public class MainActivity extends ReactActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Thread.UncaughtExceptionHandler oldHandler = Thread.getDefaultUncaughtExceptionHandler();

        Thread.setDefaultUncaughtExceptionHandler(
          new Thread.UncaughtExceptionHandler() {
              @Override
              public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                  restartApp();
                  if (oldHandler != null)
                      oldHandler.uncaughtException(paramThread, paramThrowable); //Delegates to Android's error handling
                  else
                      System.exit(2); //Prevents the service/app from freezing
              }
        });
    }

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "KioskModeReactNative";
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            throw new RuntimeException("Boom!");
            // return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void restartApp(){
        Intent i = getBaseContext().getPackageManager()
            .getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                   | Intent.FLAG_ACTIVITY_CLEAR_TASK
                   | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(i);
    }

}
