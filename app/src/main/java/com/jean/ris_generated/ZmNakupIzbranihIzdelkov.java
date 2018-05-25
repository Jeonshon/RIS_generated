package com.jean.ris_generated;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ZmNakupIzbranihIzdelkov extends AppCompatActivity {
    public KKontroler kKontroler;
    private List<Izdelek> mProductList;
    public String[][] izdelkiVkosari;
    public ListView myListView;
    public ItemAdapter adapter;
    private static final int REQUEST_CODE_NUMBER = 100;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pricniNakupIzbranihIzdelkov();
    }

    public int pricniNakupIzbranihIzdelkov() {
        kKontroler = new KKontroler(this);
        String imena = getResources().getString(R.string.imena_izdelkov);
        izdelkiVkosari = kKontroler.VrniPodrobnostiOKosarici();
        dodajIzdelkeVKosari();
        return 0;
    }

    private void dodajIzdelkeVKosari() {
        myListView = (ListView) findViewById(R.id.list_view_list);
        mProductList = new ArrayList<>();

        //String[] listItems = new String[izdelkiVkosari.length];
        for(int i=0;i<izdelkiVkosari.length;i++) {
            //listItems[i] = izdelkiVkosari[i][0];
            mProductList.add(new Izdelek(izdelkiVkosari[i][2],izdelkiVkosari[i][0],izdelkiVkosari[i][1],izdelkiVkosari[i][3]));
        }

        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listItems);
        //myListView.setAdapter(adapter);
        adapter = new ItemAdapter(getApplicationContext(), mProductList);
        myListView.setAdapter(adapter);

        dodajListenerje();
    }

    private void dodajListenerje() {
        //dodaj listenerje
        myListView.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //Log.d("TAG", "onItemClick: name: " + mProductList.get(position));
                final Izdelek toDelete = (Izdelek) parent.getItemAtPosition(position);
                //Toast.makeText(NakupIzbranihIzdelkov.this,"clicked product " + toDelete.getName(), Toast.LENGTH_SHORT).show();

                AlertDialog.Builder deleteAlert = new AlertDialog.Builder(ZmNakupIzbranihIzdelkov.this);
                deleteAlert.setMessage("Ali ste prepricani da zelite odstraniti "+toDelete.getName()+" iz kosare?")
                        .setCancelable(false)
                        .setPositiveButton("Da", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //finish();
                                odstraniArtikel(toDelete);
                            }
                        }).setNegativeButton("Ne", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alert = deleteAlert.create();
                alert.setTitle("Izbris artikla iz kosare");
                alert.show();
            }
        });
        Button btnKupi = (Button) findViewById(R.id.buttonNakup);
        btnKupi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mProductList.size() != 0) {
                    String messageIme = "";
                    String messageKolicina = "";
                    String messageCena = "";
                    for (int i = 0; i < mProductList.size() - 1; i++) {
                        messageIme += mProductList.get(i).getName() + ",";
                        messageKolicina += mProductList.get(i).getKolicina() + ",";
                        messageCena += mProductList.get(i).getPrice() + ",";
                    }
                    messageIme += mProductList.get(mProductList.size() - 1).getName();
                    messageKolicina += mProductList.get(mProductList.size() - 1).getKolicina();
                    messageCena += mProductList.get(mProductList.size() - 1).getPrice();

                    Intent intent = new Intent(ZmNakupIzbranihIzdelkov.this, SkupnaCenaIzKosarice.class);
                    Bundle bundle = new Bundle();

                    bundle.putString("mIme", messageIme);
                    bundle.putString("mKolicina", messageKolicina);
                    bundle.putString("mCena", messageCena);
                    intent.putExtras(bundle);

                    //startActivityForResult(intent, 100);
                    startActivityForResult(intent, REQUEST_CODE_NUMBER);
                }
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE_NUMBER) {
            if(resultCode == RESULT_OK) {
                while(mProductList.size() != 0) {
                    odstraniArtikel(mProductList.get(0));
                }
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void odstraniArtikel(Izdelek toDelete) {
        mProductList.remove(toDelete);
        adapter = new ItemAdapter(getApplicationContext(), mProductList);
        myListView.setAdapter(adapter);
    }


}
