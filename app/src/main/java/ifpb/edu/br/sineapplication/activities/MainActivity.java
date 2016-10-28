package ifpb.edu.br.sineapplication.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import ifpb.edu.br.sineapplication.R;
import ifpb.edu.br.sineapplication.listeners.OnClickListarSines;
import ifpb.edu.br.sineapplication.listeners.OnClickListarSinesCG;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new OnClickListarSines(this));
        btn2.setOnClickListener(new OnClickListarSinesCG(this));
    }
}
