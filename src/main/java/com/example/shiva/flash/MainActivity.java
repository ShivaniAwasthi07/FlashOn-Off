package com.example.shiva.flash;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton ib;
    CameraManager cm;
    private boolean flash=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib=(ImageButton)findViewById(R.id.imageButton);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flash==false)
                {
                    try {
                        String cameraid = cm.getCameraIdList()[0];
                        cm.setTorchMode(cameraid, true);
                        flash =true;
                        ib.setImageResource(R.drawable.onn);
                    }
                    catch (CameraAccessException e)
                    {

                    }
                }
                else
                {
                    try
                    {
                        String cameraid=cm.getCameraIdList()[0];
                        cm.setTorchMode(cameraid,false);
                        flash=false;
                        ib.setImageResource(R.drawable.off);
                    }
                    catch(CameraAccessException e)
                    {

                    }
                }
            }
        });
    }
}
