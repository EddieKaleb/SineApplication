package ifpb.edu.br.sineapplication.listeners;

import android.content.Intent;
import android.view.View;

import ifpb.edu.br.sineapplication.activities.MainActivity;
import ifpb.edu.br.sineapplication.activities.SinesCodActivity;

/**
 * Created by root on 29/10/16.
 */

public class OnClickBuscar implements View.OnClickListener {
    MainActivity main;

    public OnClickBuscar(MainActivity main) {
        this.main = main;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(main, SinesCodActivity.class);
        main.startActivity(intent);
    }
}
