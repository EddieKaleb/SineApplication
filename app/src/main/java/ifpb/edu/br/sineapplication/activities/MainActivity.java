package ifpb.edu.br.sineapplication.activities;

import android.app.Activity;
import android.os.Bundle;

import android.widget.Button;

import ifpb.edu.br.sineapplication.R;
import ifpb.edu.br.sineapplication.listeners.OnClickListarSines;
import ifpb.edu.br.sineapplication.listeners.OnClickListarSinesCG;
import ifpb.edu.br.sineapplication.listeners.OnClickMapaProx;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSines = (Button) findViewById(R.id.btnSines);
        Button btnSinesCG = (Button) findViewById(R.id.btnSinesCG);
        Button btnProx = (Button) findViewById(R.id.btnProx);

        btnSines.setOnClickListener(new OnClickListarSines(this));
        btnSinesCG.setOnClickListener(new OnClickListarSinesCG(this));
        btnProx.setOnClickListener(new OnClickMapaProx(this));

    }

}
