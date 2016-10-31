package ifpb.edu.br.sineapplication.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import ifpb.edu.br.sineapplication.R;

public class DetalharSineActivity extends Activity {
    public TextView tvSine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhar_sine);
        tvSine = (TextView) findViewById(R.id.tvSineDetalhado);
        tvSine.setText(getIntent().getSerializableExtra("sine").toString());
    }

}
