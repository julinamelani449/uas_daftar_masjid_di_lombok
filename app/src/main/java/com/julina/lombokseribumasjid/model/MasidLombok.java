package com.julina.lombokseribumasjid.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;


public class MasidLombok {
    public static final String LOMBOKBARAT = "LOMBOK BARAT";
    public static final String LOMBOKTIMUR = "LOMBOK TIMUR";
    public static final String LOMBOKUTARA = "LOMBOK UTARA";
    public static final String LOMBOKTENGAH = "LOMBOK TENGAH";
    public static final String MATARAM = "MATARAM";


    private String id;
    private String nama_masjid;
    private String desa;
    private String kecamatan;
    private String kabupaten;

    public MasidLombok() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaMasjid() {
        return nama_masjid;
    }

    public void setNamaMasjid(String nama_masjid) {
        this.nama_masjid = nama_masjid;
    }

    public String getDesa() {
        return desa;
    }

    public void setDesa(String desa) {
        this.desa = desa;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public static MasidLombok fromJSONObject(JSONObject obj) {
        MasidLombok tr = new MasidLombok();
        try {
            tr.setId(obj.getString("id"));
            tr.setNamaMasjid(obj.getString("nama_masjid"));
            tr.setDesa(obj.getString("desa"));
            tr.setKecamatan(obj.getString("kecamatan"));
            tr.setKabupaten(obj.getString("kabupaten"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tr;
    }

    public JSONObject toJSONObject() {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("id", this.id);
            jsonObj.put("nama_masjid", this.nama_masjid);
            jsonObj.put("desa", this.desa);
            jsonObj.put("kecamatan", this.kecamatan);
            jsonObj.put("kabupaten", this.kabupaten);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }
}
