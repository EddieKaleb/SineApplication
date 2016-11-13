package ifpb.edu.br.sineapplication.listeners;

import android.content.Intent;
import android.view.View;

import ifpb.edu.br.sineapplication.activities.MainActivity;
import ifpb.edu.br.sineapplication.activities.MapsActivity;

/**
 * Created by root on 08/11/16.
 */

public class OnClickMapa implements View.OnClickListener {
    MainActivity main;


    public OnClickMapa(MainActivity mainActivity) {
        this.main = mainActivity;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(main, MapsActivity.class);
        main.startActivity(intent);
    }
}
