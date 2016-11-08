package ifpb.edu.br.sineapplication.service;

import java.util.List;

import ifpb.edu.br.sineapplication.objects.Sine;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by root on 07/11/16.
 */

public interface APISine {

    @GET("emprego?quantidade=10000")
    Call<List<Sine>> getSines();

    @GET("emprego/cod/{codPosto}")
    Call<List<Sine>> getSineByCode(
            @Path("codPosto") String cod);

    @GET("emprego/latitude/{lat}/longitude/{long}/raio/{r}")
    Call<List<Sine>> getSinesWithCoordinates(
            @Path("lat") Double lat,
            @Path("long") Double longitude,
            @Path("r") String raio
    );

}
