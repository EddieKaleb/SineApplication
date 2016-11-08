package ifpb.edu.br.sineapplication.listeners;

import android.content.Intent;
import android.view.View;

import java.util.List;

import ifpb.edu.br.sineapplication.activities.SinesActivity;
import ifpb.edu.br.sineapplication.activities.MainActivity;
import ifpb.edu.br.sineapplication.objects.Sine;

/**
 * Created by root on 27/10/16.
 */

public class OnClickListarSines implements View.OnClickListener {
    MainActivity main;
    List<Sine> sines;

    public OnClickListarSines(MainActivity main){
        this.main = main;
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(main, SinesActivity.class);
        main.startActivity(intent);

    }
}
