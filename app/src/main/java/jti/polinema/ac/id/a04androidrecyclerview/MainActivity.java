package jti.polinema.ac.id.a04androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    private ArrayList<AnggotaKls> agtArrayList;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDataAnggota(DataAnggota.dataAgt());

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        AnggotaAdapter adapter = new AnggotaAdapter(agtArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void setDataAnggota(String data){
        try {
            JSONArray jsonArray = new JSONArray(data);
            agtArrayList = new ArrayList<>();
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                AnggotaKls agt = new AnggotaKls(jsonObject.getString("nama"),
                        jsonObject.getString("absen"));
                agtArrayList.add(agt);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}