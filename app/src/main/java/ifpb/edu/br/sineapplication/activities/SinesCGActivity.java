package ifpb.edu.br.sineapplication.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.sineapplication.R;
import ifpb.edu.br.sineapplication.objects.Sine;

public class SinesCGActivity extends Activity {
    public static ListView lvSinesCG;
    public static List<Sine> sines;
    public static ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sine_campina_grande);
        lvSinesCG = (ListView) findViewById(R.id.lvSinesCG);

        sines = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 , sines);
        lvSinesCG.setAdapter(adapter);
    }
}
