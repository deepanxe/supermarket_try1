package super_market.supermarket;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class Registration_activity extends AppCompatActivity {
    Spinner reg_area;
    APIInterface apiInterface;
    List<AreaDetail> AreaDetailList = new ArrayList<>();
    Activity thisActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        reg_area=findViewById(R.id.reg_area);
        thisActivity = this;
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<AreaDetailList> area_name = apiInterface.get_area_name(100);

        area_name.enqueue(new Callback<AreaDetailList>() {
            @Override
            public void onResponse(Call<AreaDetailList> call, retrofit2.Response<AreaDetailList> response) {
                AreaDetailList = response.body().getAreaDetails();
                GenerateAreaName();
            }

            @Override
            public void onFailure(Call<AreaDetailList> call, Throwable t) {
            }
        });
    }


    public void GenerateAreaName(){
        String[] items = new String[AreaDetailList.size()];

        for (int i = 0; i < AreaDetailList.size(); i++){
            items[i] = AreaDetailList.get(i).getAreaName();

            ArrayAdapter<String> adapter;
            adapter = new ArrayAdapter<String>(thisActivity, android.R.layout.simple_list_item_activated_1, items);
            reg_area.setAdapter(adapter);
        }
    }
}
