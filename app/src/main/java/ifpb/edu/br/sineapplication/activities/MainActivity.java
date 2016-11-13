package ifpb.edu.br.sineapplication.activities;

import android.app.Activity;
import android.os.Bundle;

import android.widget.Button;

import ifpb.edu.br.sineapplication.R;
import ifpb.edu.br.sineapplication.listeners.OnClickBuscar;
import ifpb.edu.br.sineapplication.listeners.OnClickListarSines;
import ifpb.edu.br.sineapplication.listeners.OnClickListarSinesCG;
import ifpb.edu.br.sineapplication.listeners.OnClickMapa;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSines = (Button) findViewById(R.id.btnSines);
        Button btnSinesCG = (Button) findViewById(R.id.btnSinesCG);
        Button btnMapa = (Button) findViewById(R.id.btnMapa);

        btnSines.setOnClickListener(new OnClickListarSines(this));
        btnSinesCG.setOnClickListener(new OnClickListarSinesCG(this));
        btnMapa.setOnClickListener(new OnClickMapa(this));
    }

}
