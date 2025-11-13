package com.example.my_java_kotlindsl_uniappx_app;
//các thư viện cần khai báo
import android.app.Application;
import io.dcloud.feature.sdk.DCSDKInitConfig;
import io.dcloud.feature.sdk.DCUniMPSDK;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Cấu hình SDK
        DCSDKInitConfig config = new DCSDKInitConfig.Builder().build();
        // Khởi tạo SDK
        DCUniMPSDK.getInstance().initialize(this, config);
    }
}
