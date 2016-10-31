package ifpb.edu.br.sineapplication.listeners;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import ifpb.edu.br.sineapplication.activities.DetalharSineActivity;
import ifpb.edu.br.sineapplication.activities.SinesActivity;
import ifpb.edu.br.sineapplication.activities.SinesCGActivity;

/**
 * Created by root on 31/10/16.
 */

public class OnClickItem implements AdapterView.OnItemClickListener {

    SinesActivity sinesActivity = null;
    SinesCGActivity sinesCGActivity = null;

    public OnClickItem(SinesActivity sinesActivity){
        this.sinesActivity = sinesActivity;
    }

    public OnClickItem(SinesCGActivity sinesCGActivity){
        this.sinesCGActivity = sinesCGActivity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(sinesActivity != null) {
            Intent intent = new Intent(sinesActivity, DetalharSineActivity.class);
            intent.putExtra("sine", sinesActivity.sines.get(position).toStringDetalhado());
            sinesActivity.startActivity(intent);
        }else if(sinesCGActivity != null){
            Intent intent = new Intent(sinesCGActivity, DetalharSineActivity.class);
            intent.putExtra("sine", sinesCGActivity.sines.get(position).toStringDetalhado());
            sinesCGActivity.startActivity(intent);
        }
    }
}
