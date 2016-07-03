package pe.cibertec.ciclovidaactivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String ENTRADA = "ENTRADA";
    public static final int REQUEST_CONSULTA = 345;
    public static final int REQUEST_CAPTURA_IMAGEN = 123;
    public static final String RESPUESTA = "RESPUESTA";

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("CicloDeVida", this.getLocalClassName() + " onCreate");
        editText = (EditText) findViewById(R.id.txtEntrada);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handler=false;
                if(actionId== EditorInfo.IME_ACTION_NEXT){
                    llamarActivityC(null);
                }
                return false;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CicloDeVida", this.getLocalClassName() + " onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CicloDeVida", this.getLocalClassName() + " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CicloDeVida", this.getLocalClassName() + " onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CicloDeVida", this.getLocalClassName() + " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CicloDeVida", this.getLocalClassName() + " onDestroy");
    }

    public void llamarActivity2(View view) {

        Intent intent = new Intent(getApplicationContext(), ActivityB.class);
        startActivity(intent);


    }

    public void tomarFoto(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAPTURA_IMAGEN);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("Camara", "requestCode " + requestCode);
        Log.d("Camara", "resultCode " + resultCode);


        switch (requestCode) {
            case REQUEST_CAPTURA_IMAGEN:

                if (resultCode == RESULT_OK) {
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");

                    ImageView imageView = (ImageView) findViewById(R.id.imgCamara);
                    imageView.setImageBitmap(bitmap);
                }

                break;
            case REQUEST_CONSULTA:
                Log.d("","respuesta de activity c: "+data.getStringExtra(RESPUESTA));
                break;
        }


    }

    public void llamarActivityC(View view) {


        String campoEntrada = editText.getText().toString();

        Intent intent = new Intent(this, ActivityC.class);
        intent.putExtra(ENTRADA, campoEntrada);
        startActivityForResult(intent, REQUEST_CONSULTA);
    }
}
