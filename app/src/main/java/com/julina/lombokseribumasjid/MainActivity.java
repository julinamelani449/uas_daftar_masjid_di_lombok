package com.julina.lombokseribumasjid;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.julina.lombokseribumasjid.model.MasidLombok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton btnTambahMasjid;
    TextView txNoData;
    ListView lvDaftarMasjid;
    DaftarMasjidAdapter adapter;
    List<MasidLombok> daftarMasjid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        inisialisasiView();
        loadDataWisata();
        setupListview();

    }

    private void inisialisasiView() {
        btnTambahMasjid = findViewById(R.id.fabAddMasjid);
        btnTambahMasjid.setOnClickListener(view -> bukaFormTambahMasjid());
        lvDaftarMasjid = findViewById(R.id.lv_masjid_lombok);
        txNoData = findViewById(R.id.tx_nodata);
    }

    private void setupListview() {
        adapter = new DaftarMasjidAdapter(this, daftarMasjid);
        lvDaftarMasjid.setAdapter(adapter);
    }

    private void loadDataWisata() {
        daftarMasjid = SharedPreferenceUtility.getAllMasjid(this);
        if (daftarMasjid.size() > 0) {
            txNoData.setVisibility(View.GONE);
        } else {
            txNoData.setVisibility(View.VISIBLE);
        }

    }

    private void refreshListView() {
        adapter.clear();
        loadDataWisata();
        adapter.addAll(daftarMasjid);
    }

    private void bukaFormTambahMasjid() {
        Intent intent = new Intent(this, FormMasjidActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}