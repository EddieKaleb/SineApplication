package ifpb.edu.br.sineapplication.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.sineapplication.R;
import ifpb.edu.br.sineapplication.asynctasks.SinesAsyncTask;
import ifpb.edu.br.sineapplication.listeners.OnClickBuscarSine;
import ifpb.edu.br.sineapplication.objects.Sine;

public class SinesActivity extends Activity {
    public static Button btnBuscar;
    public static EditText editTxtCod;
    public static ListView lvSines;
    public static List<Sine> sines;
    public static ArrayAdapter<Sine> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_sines);

        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        editTxtCod = (EditText) findViewById(R.id.editTxtCod);
        lvSines = (ListView) findViewById(R.id.lvSines);

        btnBuscar.setOnClickListener(new OnClickBuscarSine(this));

        sines = new ArrayList<Sine>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , sines);
        lvSines.setAdapter(adapter);
    }
}
