package com.example.gofind;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSAwalBros extends ListActivity {
    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);
        String[] ListAct = new String[] {"Call Center", "SMS Center","Driving Direction",  "Website", "Info Google", "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListAct));
    }
    protected void onListItemClick (ListView l, View v, int position, long id) {
        super.onListItemClick(l,v,position,id);
        Object o = this.getListAdapter().getItem(position);
        String pilih = o.toString();
        tampilkan(pilih);
    }
     private void tampilkan(String pilih) {
        try {
            Intent i = null;
            if (pilih.equals("Call Center")) {
                String telp = "tel: 0761-47333";
                i = new Intent(Intent.ACTION_DIAL, Uri.parse(telp));

            } else if (pilih.equals("SMS Center")) {
                String smsText = "Alya Firmanda E/P";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("sms:089508153487"));
                i.putExtra("sms_body", smsText);

            } else if (pilih.equals("Driving Direction")) {
                String lokasi = "google.navigation:q=0.463823,101.390353";
                i = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasi));

            } else if (pilih.equals("Website")) {
                String web = "https://halowalbros.com";
                i = new Intent(Intent.ACTION_VIEW, Uri.parse(web));

            } else if (pilih.equals("Info Google")) {
                i = new Intent(Intent.ACTION_WEB_SEARCH);
                i.putExtra(SearchManager.QUERY, "Rumah Sakit Awal Bros");
            }
            startActivity(i);
        }catch (Exception e) {
            e.printStackTrace();
        }
     }
}
