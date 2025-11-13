package com.example.my_java_kotlindsl_uniappx_app;

import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
//thư viện cần khai báo
import io.dcloud.feature.sdk.DCUniMPSDK;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btnGoToMiniApp = findViewById(R.id.btnGoToMiniApp);
        btnGoToMiniApp.setOnClickListener(v -> {
            try {
                // Thay "__UNI__GC9DBD06" bằng AppID của bạn
                DCUniMPSDK.getInstance().openUniMP(this, "__UNI__GC9DBD06");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
