/***********************************************************************
 * Module:  Kosarica.java
 * Author:  andra
 * Purpose: Defines the Class Kosarica
 ***********************************************************************/

package com.jean.ris_generated;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.AppLaunchChecker;
import android.widget.ListView;

import java.util.*;

public class Kosarica{
   private int idArtikla;
   private int idKosarice;
   private int idUporabnika;
   
   public java.util.Collection izdelek;

   public String[][] izdelkiVkosari;

   public ListView myLsitView;
   public String uporabnik = "Janez Novak";

   private Context context;

   public Kosarica(Context current){
      this.context = current;
   }


   public String[][] VrniPodrobnostiOKosariciZaNakup() {

      String imena = context.getResources().getString(R.string.imena_izdelkov);
      String cena = context.getResources().getString(R.string.cene_izdelkov);
      String id = context.getResources().getString(R.string.id_slike_izdelka);
      String st = context.getResources().getString(R.string.st_izdelkov);
      String idUporabnikaKosare = context.getResources().getString(R.string.id_uporabnika_kosare);
      String idUporabnika= context.getResources().getString(R.string.id_uporabnikov);
      String imeUporabnika= context.getResources().getString(R.string.ime_uporabnika);

      int stIzdelkov = imena.split(",").length;
      boolean uporabnikObstaja = false;
      String[] imenaTab = imena.split(",");
      String[] cenaTab = cena.split(",");
      String[] idTab = id.split(",");
      String[] stTab = st.split(",");
      String[] idKosareTab = idUporabnikaKosare.split(","); //id uporabnika, od katerega je artikel
      String[] idUporabnikaTab = idUporabnika.split(",");
      String[] imeUporabnikaTab = imeUporabnika.split(",");


      for(int i=0;i<idUporabnikaTab.length;i++) {
         if(uporabnik.equals(imeUporabnikaTab[i])) {
            uporabnikObstaja = true;
            idUporabnika = idUporabnikaTab[i];
         }
      }

      if (uporabnikObstaja) {
         int counter = 0;
         for (int i = 0; i < stIzdelkov; i++) {
            if (idKosareTab[i].equals(idUporabnika)) {
               counter++;
            }
         }

         izdelkiVkosari = new String[counter][4];
         counter = 0;
         for (int i = 0; i < stIzdelkov; i++) {
            if (idKosareTab[i].equals(idUporabnika)) {
               izdelkiVkosari[counter][0] = imenaTab[i];
               izdelkiVkosari[counter][1] = cenaTab[i];
               izdelkiVkosari[counter][2] = idTab[i];
               izdelkiVkosari[counter][3] = stTab[i];
               counter++;
            }
         }


      }

      return izdelkiVkosari;
   }
















   public int VrniSkupnoCenoKosarice() {
      // TODO: implement
      return 0;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection getIzdelek() {
      if (izdelek == null)
         izdelek = new java.util.HashSet();
      return izdelek;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIzdelek() {
      if (izdelek == null)
         izdelek = new java.util.HashSet();
      return izdelek.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIzdelek */
   public void setIzdelek(java.util.Collection newIzdelek) {
      removeAllIzdelek();
      for (java.util.Iterator iter = newIzdelek.iterator(); iter.hasNext();)
         addIzdelek((Izdelek)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newIzdelek */
   public void addIzdelek(Izdelek newIzdelek) {
      if (newIzdelek == null)
         return;
      if (this.izdelek == null)
         this.izdelek = new java.util.HashSet();
      if (!this.izdelek.contains(newIzdelek))
         this.izdelek.add(newIzdelek);
   }
   
   /** @pdGenerated default remove
     * @param oldIzdelek */
   public void removeIzdelek(Izdelek oldIzdelek) {
      if (oldIzdelek == null)
         return;
      if (this.izdelek != null)
         if (this.izdelek.contains(oldIzdelek))
            this.izdelek.remove(oldIzdelek);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIzdelek() {
      if (izdelek != null)
         izdelek.clear();
   }

}