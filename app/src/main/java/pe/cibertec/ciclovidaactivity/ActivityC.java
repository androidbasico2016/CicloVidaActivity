package pe.cibertec.ciclovidaactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_c);

        //String campo = (String)getIntent().getExtras().get(MainActivity.ENTRADA);

        String campo=getIntent().getStringExtra(MainActivity.ENTRADA);
        TextView txtEntrada=(TextView)findViewById(R.id.txtEntrada);
        txtEntrada.setText("Se ingreso "+campo);


    }


    public void devolverrespuesta(View view) {

        Intent intent= new Intent();
        intent.putExtra(MainActivity.RESPUESTA,"respuesta");
        setResult(RESULT_OK,intent);
        finish();
    }
}
