package com.example.my_kotlin_groovydsl_uniappx_app
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import io.dcloud.feature.sdk.DCUniMPSDK

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnGoToMiniApp = findViewById<Button>(R.id.btnGoToMiniApp)
        btnGoToMiniApp.setOnClickListener(View.OnClickListener {
                // Thay "__UNI__04E3A11" bằng AppID của bạn
                DCUniMPSDK.getInstance().openUniMP(this, "__UNI__GC9DBD06")
        })
    }
}