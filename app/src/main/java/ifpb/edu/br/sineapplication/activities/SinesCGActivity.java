package ifpb.edu.br.sineapplication.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;
import java.util.concurrent.ExecutionException;

import ifpb.edu.br.sineapplication.R;
import ifpb.edu.br.sineapplication.asynctasks.SinesAsyncTask;
import ifpb.edu.br.sineapplication.listeners.OnClickItem;
import ifpb.edu.br.sineapplication.objects.Sine;

public class SinesCGActivity extends Activity {
    public ListView lvSinesCG;
    public List<Sine> sines;
    public ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sine_campina_grande);
        lvSinesCG = (ListView) findViewById(R.id.lvSinesCG);
        SinesAsyncTask sinesAsyncTask = new SinesAsyncTask();

        try {
            sines = sinesAsyncTask.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/latitude/-7.242662/longitude/-35.9716057/raio/100").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 , sines);
        lvSinesCG.setAdapter(adapter);
        lvSinesCG.setOnItemClickListener(new OnClickItem(this));

    }
}
