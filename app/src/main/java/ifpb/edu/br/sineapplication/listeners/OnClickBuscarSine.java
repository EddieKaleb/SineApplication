package ifpb.edu.br.sineapplication.listeners;

import android.view.View;

import ifpb.edu.br.sineapplication.activities.SinesActivity;
import ifpb.edu.br.sineapplication.asynctasks.SinesAsyncTask;

/**
 * Created by root on 27/10/16.
 */

public class OnClickBuscarSine implements View.OnClickListener{
    SinesActivity activity;

    public OnClickBuscarSine(SinesActivity activity){
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        if(SinesActivity.editTxtCod!=null)
        new SinesAsyncTask().execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/cod/"+ SinesActivity.editTxtCod.getText().toString());
    }
}
