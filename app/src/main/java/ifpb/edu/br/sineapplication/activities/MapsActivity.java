package ifpb.edu.br.sineapplication.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import ifpb.edu.br.sineapplication.R;
import ifpb.edu.br.sineapplication.objects.Sine;
import ifpb.edu.br.sineapplication.service.APISine;
import ifpb.edu.br.sineapplication.service.ConnectionServer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<Sine> sines;
    double latitude;
    double longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle extras = getIntent().getExtras();
        latitude = extras.getDouble("latitude");
        longitude = extras.getDouble("longitude");

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setMapToolbarEnabled(false);

        LatLng myPlace = new LatLng(latitude,  longitude);
        MarkerOptions centralPoint = new MarkerOptions()
                .position(myPlace)
                .title("Posição atual");

        mMap.addMarker(centralPoint);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPlace, 8));

        new Thread(new Runnable() {
            @Override
            public void run() {
                //Referencing the service's interface
                APISine APISine = ConnectionServer.getInstance().getService();
                //Calling the request method with two parameters
                Call<List<Sine>> call = APISine.getSinesWithCoordinates(latitude,longitude,"100");
                //Executing de request GET
                call.enqueue(new Callback<List<Sine>>() {
                    @Override
                    public void onResponse(Call<List<Sine>> call, Response<List<Sine>> response) {
                        sines = response.body();
                        for (Sine sine : sines) {
                            double lati = Double.parseDouble(sine.getLat());
                            double longLat = Double.parseDouble(sine.getLongitude());
                            mMap.addMarker(new MarkerOptions().position(
                                    new LatLng(lati,longLat))
                                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.placeholder))
                                    .title(sine.getNome()));
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
