package com.example.ciclodevida;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText num1, num2;
RadioButton rbtSuma, rbtResta;
TextView resultado;
Button btnAceptar;
double total, n1,n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=(EditText) findViewById(R.id.edtNumero1);
        num2=(EditText)findViewById(R.id.edtNumero2);
        btnAceptar=(Button)findViewById(R.id.btnAceptar);
        rbtSuma=(RadioButton)findViewById(R.id.rbtSuma);
        rbtResta=(RadioButton)findViewById(R.id.rbtResta);
        resultado=(TextView)findViewById(R.id.txtResultado);


        Toast.makeText(this, "EVENTO: OnCreate", Toast.LENGTH_SHORT).show();
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1=Double.parseDouble(num1.getText().toString());
                n2=Double.parseDouble(num2.getText().toString());
               if(rbtResta.isChecked())
                {
                    total=n1-n2;
                    resultado.setText("."+total);
                }
                else if(rbtSuma.isChecked())
                {
                    total=n1+n2;
                    resultado.setText(""+total);
                }
            }

        });
        Intent in=new Intent(this,camara.class);
        startActivity(in);


    }
   /* public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case 1:
                if (checked)
                    break;
            case 2:
                if (checked)
                    break;
            default:
                Toast t= Toast.makeText(this,"Seleccione una opcion",Toast.LENGTH_LONG);
                t.show();
                break;
        }

    }*/



    protected void onStart() {

        super.onStart();
        Toast.makeText(this, "EVENTO: OnStart", Toast.LENGTH_SHORT).show();

    }
    protected void onResume() {

        super.onResume();
        Toast.makeText(this, "EVENTO: OnResume", Toast.LENGTH_SHORT).show();

    }
    protected void onPause() {

        super.onPause();
        Toast.makeText(this, "EVENTO: OnPause", Toast.LENGTH_SHORT).show();

    }
    protected void onStop() {

        super.onStop();
        Toast.makeText(this, "EVENTO: OnStop", Toast.LENGTH_SHORT).show();

    }
    protected void onDestroy() {

        super.onDestroy();
        Toast.makeText(this, "EVENTO: OnDestroy", Toast.LENGTH_SHORT).show();

    }

}