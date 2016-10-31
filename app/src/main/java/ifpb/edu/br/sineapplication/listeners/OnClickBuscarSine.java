package ifpb.edu.br.sineapplication.listeners;

import android.view.View;

import java.util.List;
import java.util.concurrent.ExecutionException;

import ifpb.edu.br.sineapplication.activities.SinesCodActivity;
import ifpb.edu.br.sineapplication.asynctasks.SinesAsyncTask;
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
            SinesAsyncTask sinesAsyncTask = new SinesAsyncTask();
            try {
                List<Sine> list = sinesAsyncTask.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/cod/"+SinesCodActivity.editTxtCod.getText().toString()+"/").get();
                String sine = list.get(0).toStringDetalhado();
                SinesCodActivity.tvSine.setText(sine);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
