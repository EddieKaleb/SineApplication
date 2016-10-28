package ifpb.edu.br.sineapplication.asynctasks;

import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.sineapplication.activities.SinesActivity;
import ifpb.edu.br.sineapplication.objects.Sine;

/**
 * Created by root on 27/10/16.
 */

public class SinesAsyncTask extends AsyncTask<String, Void, List<Sine>> {
    @Override
    protected List<Sine> doInBackground(String... params) {
        HttpURLConnection connection=null;
        BufferedReader reader=null;
        try {
            URL urlBase=new URL(params[0]);
            connection=(HttpURLConnection)urlBase.openConnection();
            connection.connect();

            InputStream stream=connection.getInputStream();

            reader=new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer=new StringBuffer();

            String line="";
            while((line=reader.readLine())!=null){
                buffer.append(line);
            }

            String jsonString = buffer.toString();

            JSONArray jsonArray = new JSONArray(jsonString);
            List<Sine> sines = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String codPosto = jsonObject.getString("codPosto");
                String nome = jsonObject.getString("nome");
                String entidadeConveniada = jsonObject.getString("entidadeConveniada");
                String endereco = jsonObject.getString("endereco");
                String bairro = jsonObject.getString("bairro");
                String cep = jsonObject.getString("cep");
                String telefone = jsonObject.getString("telefone");
                String municipio = jsonObject.getString("municipio");
                String uf = jsonObject.getString("uf");
                long lat = jsonObject.getLong("lat");
                long longitude = jsonObject.getLong("long");
                Sine sine = new Sine(codPosto, nome, entidadeConveniada, endereco, bairro, cep, telefone, municipio, uf, lat, longitude);
                sines.add(sine);
            }

            return sines;


        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }finally{
            if(connection!=null)
                connection.disconnect();
            try{
                if(reader!=null)
                    reader.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(List <Sine> sines) {
        super.onPostExecute(sines);
        SinesActivity.sines = sines;
        SinesActivity.adapter.notifyDataSetChanged();
    }
}
