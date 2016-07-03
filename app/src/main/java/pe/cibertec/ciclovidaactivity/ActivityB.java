package pe.cibertec.ciclovidaactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_b);
        Log.d("CicloDeVida", this.getLocalClassName()+" onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CicloDeVida", this.getLocalClassName()+" onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CicloDeVida", this.getLocalClassName()+" onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CicloDeVida", this.getLocalClassName()+" onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CicloDeVida", this.getLocalClassName()+" onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CicloDeVida", this.getLocalClassName()+" onDestroy");
    }

}
