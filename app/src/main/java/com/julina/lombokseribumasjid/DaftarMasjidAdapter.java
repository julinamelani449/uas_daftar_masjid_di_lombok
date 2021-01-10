package com.julina.lombokseribumasjid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.julina.lombokseribumasjid.model.MasidLombok;


import java.util.List;

public class DaftarMasjidAdapter extends ArrayAdapter<MasidLombok> {
    Context context;

    public DaftarMasjidAdapter(@NonNull Context context, @NonNull List<MasidLombok> objects) {
        super(context, R.layout.row_masjid, objects);
        this.context = context;
    }

    class ViewHolder {
        TextView txNama;
        TextView txDesa;
        TextView txKecamatan;
        TextView txKabupaten;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MasidLombok tr = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_masjid, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txNama = convertView.findViewById(R.id.row_nama_masjid);
            viewHolder.txDesa = convertView.findViewById(R.id.row_desa);
            viewHolder.txKecamatan = convertView.findViewById(R.id.row_kecamatan);
            viewHolder.txKabupaten = convertView.findViewById(R.id.row_kabupaten);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txKecamatan.setText(tr.getKecamatan());
        viewHolder.txDesa.setText(tr.getDesa());
        viewHolder.txNama.setText(tr.getNamaMasjid());
        if (tr.getKabupaten().equals(MasidLombok.LOMBOKBARAT)) {
            viewHolder.txKabupaten.setText("LOMBOK BARAT");
        } else if (tr.getKabupaten().equals(MasidLombok.LOMBOKTENGAH)) {
            viewHolder.txKabupaten.setText("LOMBOK TENGAH");
        } else if (tr.getKabupaten().equals(MasidLombok.LOMBOKTIMUR)) {
            viewHolder.txKabupaten.setText("LOMBOK TIMUR");
        } else if (tr.getKabupaten().equals(MasidLombok.LOMBOKUTARA)) {
            viewHolder.txKabupaten.setText("LOMBOK UTARA");
        } else if (tr.getKabupaten().equals(MasidLombok.MATARAM)) {
            viewHolder.txKabupaten.setText("MATARAM");
        } else {
            viewHolder.txKabupaten.setText("LOMBOK");
        }
        return convertView;
    }
}