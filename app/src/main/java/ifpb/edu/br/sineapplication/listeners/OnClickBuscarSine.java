package ifpb.edu.br.sineapplication.listeners;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.concurrent.ExecutionException;

import ifpb.edu.br.sineapplication.activities.MainActivity;
import ifpb.edu.br.sineapplication.activities.SinesActivity;
import ifpb.edu.br.sineapplication.activities.SinesCodActivity;
import ifpb.edu.br.sineapplication.asynctasks.SinesAsyncTask;
import ifpb.edu.br.sineapplication.asynctasks.SinesCodAsyncTask;
import ifpb.edu.br.sineapplication.objects.Sine;

/**
 * Created by root on 27/10/16.
 */

public class OnClickBuscarSine implements View.OnClickListener{
    SinesCodActivity activity;
    public OnClickBuscarSine(SinesCodActivity activity){
        this.activity = activity;

    }

    @Override
    public void onClick(View v) {
        if(SinesCodActivity.editTxtCod!=null) {
            SinesCodAsyncTask sinesCodAsyncTask = new SinesCodAsyncTask();
            try {
                SinesCodActivity.tvSine.setText(sinesCodAsyncTask.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/cod/"+SinesCodActivity.editTxtCod.getText().toString()+"/").get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
