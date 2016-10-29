package ifpb.edu.br.sineapplication.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ifpb.edu.br.sineapplication.R;
import ifpb.edu.br.sineapplication.listeners.OnClickBuscarSine;

public class SinesCodActivity extends Activity {
    public Button btnBuscar;
    public static EditText editTxtCod;
    public static TextView tvSine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sines_cod);

        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        editTxtCod = (EditText) findViewById(R.id.editTxtCod);
        tvSine = (TextView) findViewById(R.id.tvSine);

        btnBuscar.setOnClickListener(new OnClickBuscarSine(this));

    }
}
