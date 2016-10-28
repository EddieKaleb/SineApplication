package ifpb.edu.br.sineapplication.listeners;

import android.content.Intent;
import android.view.View;

import ifpb.edu.br.sineapplication.activities.MainActivity;
import ifpb.edu.br.sineapplication.activities.SinesCGActivity;
import ifpb.edu.br.sineapplication.asynctasks.SinesAsyncTask;
import ifpb.edu.br.sineapplication.asynctasks.SinesCGAsyncTask;

/**
 * Created by root on 27/10/16.
 */

public class OnClickListarSinesCG implements View.OnClickListener{
    MainActivity main;

    public OnClickListarSinesCG(MainActivity main){
        this.main = main;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(main, SinesCGActivity.class);
        main.startActivity(intent);
        SinesCGAsyncTask sinesCGAsyncTask = new SinesCGAsyncTask();

        sinesCGAsyncTask.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/latitude/-7.242662/longitude/-35.9716057/raio/100");
    }
}