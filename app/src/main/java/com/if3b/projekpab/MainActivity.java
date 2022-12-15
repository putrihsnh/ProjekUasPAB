package com.if3b.projekpab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvAlamatMixue;
    private ArrayList<ModeMixue> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Mode Card View");

        rvAlamatMixue = findViewById(R.id.rv_alamatMixue);
        rvAlamatMixue.setHasFixedSize(true);

        data.addAll(DataAlamat.ambilDataPahlawan());
        tampilDataCard();
    }
    private void tampilDataCard(){
        rvAlamatMixue.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard varAdapterCard = new AdapterCard(data,MainActivity.this);
        rvAlamatMixue.setAdapter(varAdapterCard);
    }
    private void tampilDataGrid(){
        rvAlamatMixue.setLayoutManager(new GridLayoutManager(this, 2));
        AdapterGrid varAdapterGrid = new AdapterGrid(data,MainActivity.this );
        rvAlamatMixue.setAdapter(varAdapterGrid);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mode, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_mode_card:
                tampilDataCard();
                break;
            case R.id.menu_mode_grid:
                tampilDataGrid();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
