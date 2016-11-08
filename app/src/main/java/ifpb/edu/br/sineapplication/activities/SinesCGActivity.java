package ifpb.edu.br.sineapplication.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import ifpb.edu.br.sineapplication.R;
import ifpb.edu.br.sineapplication.listeners.OnClickItem;
import ifpb.edu.br.sineapplication.objects.Sine;
import ifpb.edu.br.sineapplication.service.ConnectionServer;
import ifpb.edu.br.sineapplication.service.APISine;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SinesCGActivity extends Activity {
    public ListView lvSinesCG;
    public ArrayList<Sine> sines;
    public ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sine_campina_grande);
        lvSinesCG = (ListView) findViewById(R.id.lvSinesCG);
        sines = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 , sines);
        lvSinesCG.setAdapter(adapter);
        lvSinesCG.setOnItemClickListener(new OnClickItem(this));
        updateSines();
    }

    private void updateSines() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //Referencing the service's interface
                APISine APISine = ConnectionServer.getInstance().getService();
                //Calling the request method with two parameters
                Call<List<Sine>> call = APISine.getSinesWithCoordinates(-7.242662,-35.971605,"100");
                //Executing de request GET
                call.enqueue(new Callback<List<Sine>>() {
                    @Override
                    public void onResponse(Call<List<Sine>> call, Response<List<Sine>> response) {
                        if (response.isSuccessful()) {
                            List<Sine> allSines = response.body();
                            sines.addAll(allSines);
                            adapter.notifyDataSetChanged();
                            Log.i("onResponse", "OK");
                        } else {
                            Log.i("onResponse", "ERRO");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Sine>> call, Throwable t) {
                        Log.i("onFailure", t.getMessage().toString());
                    }
                });
            }
        }).start();
    }

}
