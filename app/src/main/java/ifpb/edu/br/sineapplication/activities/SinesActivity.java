package ifpb.edu.br.sineapplication.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import ifpb.edu.br.sineapplication.R;
import ifpb.edu.br.sineapplication.asynctasks.SinesAsyncTask;
import ifpb.edu.br.sineapplication.listeners.OnClickBuscarSine;
import ifpb.edu.br.sineapplication.objects.Sine;

public class SinesActivity extends Activity {

    public ListView lvSines;
    public List<Sine> sines;
    public ArrayAdapter<Sine> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_sines);


        lvSines = (ListView) findViewById(R.id.lvSines);

        SinesAsyncTask sinesAsyncTask = new SinesAsyncTask();

        try {
            sines =  sinesAsyncTask.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , sines);
        lvSines.setAdapter(adapter);
    }
}
