package ifpb.edu.br.sineapplication.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 08/11/16.
 */

public class ConnectionServer {

    private static final String URL_BASES =

            "http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/";


    private static SineService service;
    private static ConnectionServer ourInstance = new ConnectionServer();

    public static ConnectionServer getInstance() {
        return ourInstance;
    }

    public SineService getService() {
        return service;
    }

    private ConnectionServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASES)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(SineService.class);
    }


}