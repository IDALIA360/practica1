package com.example.ciclodevida;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class camara extends AppCompatActivity {
ImageView imagen;
Button btnCaptura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);
        imagen=(ImageView) findViewById(R.id.imageView);
        btnCaptura=(Button) findViewById(R.id.btnCapturar);
        btnCaptura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Camara.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));

            }
        });
    }

    ActivityResultLauncher<Intent>Camara=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode()==RESULT_OK)
            {
                Bundle extras=result.getData().getExtras();
                Bitmap img=(Bitmap) extras.get("data");
                imagen.setImageBitmap(img);
            }
        }
    }

    );
}