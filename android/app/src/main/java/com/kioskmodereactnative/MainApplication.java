package com.kioskmodereactnative;

import android.app.Application;
import android.util.Log;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import java.util.Arrays;
import java.util.List;

import android.content.Context;
import java.lang.Thread;


public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    protected boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage()
      );
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
      return mReactNativeHost;
  }

  private static Context mContext;

  public static MainApplication instace;

  @Override
  public void onCreate() {
      super.onCreate();
      mContext = getApplicationContext();
      instace = this;
  }

  @Override
  public Context getApplicationContext() {
      return super.getApplicationContext();
  }

  public static MainApplication getIntance() {
      return instace;
  }

}
