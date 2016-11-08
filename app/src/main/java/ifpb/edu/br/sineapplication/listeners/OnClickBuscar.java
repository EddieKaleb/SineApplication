package ifpb.edu.br.sineapplication.listeners;

import android.util.Log;
import android.view.View;

import java.util.List;

import ifpb.edu.br.sineapplication.activities.SinesActivity;
import ifpb.edu.br.sineapplication.objects.Sine;
import ifpb.edu.br.sineapplication.service.APISine;
import ifpb.edu.br.sineapplication.service.ConnectionServer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by root on 07/11/16.
 */

public class OnClickBuscar implements View.OnClickListener{

    SinesActivity sinesActivity;

    public OnClickBuscar(SinesActivity sinesActivity){
        this.sinesActivity = sinesActivity;
    }


    @Override
    public void onClick(View v) {
        if(sinesActivity.editTxtCod != null){
            buscarSine();
        }
    }

    private void buscarSine() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                //Referencing the service's interface
                APISine APISine = ConnectionServer.getInstance().getService();
                //Calling the request method with two parameters
                Call<List<Sine>> call = APISine.getSineByCode(sinesActivity.editTxtCod.getText().toString());
                //Executing de request GET
                call.enqueue(new Callback<List<Sine>>() {
                    @Override
                    public void onResponse(Call<List<Sine>> call, Response<List<Sine>> response) {
                        if (response.isSuccessful()) {
                            List<Sine> sine = response.body();
                            sinesActivity.sines.clear();
                            sinesActivity.sines.addAll(sine);
                            sinesActivity.adapter.notifyDataSetChanged();
                            Log.i("onResponse", "OK \n" + sine.get(0));
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
