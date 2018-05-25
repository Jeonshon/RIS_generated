/***********************************************************************
 * Module:  KKontroler.java
 * Author:  jeanm
 * Purpose: Defines the Class KKontroler
 ***********************************************************************/

package com.jean.ris_generated;

import android.content.Context;
import android.widget.ListView;

import java.util.*;

public class KKontroler {
   public Kosarica kosarica;
   public java.util.Collection izdelek;
   public SvSistemZaEposto svSistemZaEposto;
   public SvBanka svBanka;
   public SvReferentZaProdajo svReferentZaProdajo;



   public String[][] izdelkiVkosari;

   public KKontroler(Context con) {
      kosarica = new Kosarica(con);
   }

   public String[][] VrniPodrobnostiOKosarici() {
      return izdelkiVkosari = kosarica.VrniPodrobnostiOKosariciZaNakup();

   }











   public int PrikaziKosarico() {
      // TODO: implement
      return 0;
   }
   
   public int PrikaziPodrobnePodatkeKosarice() {
      // TODO: implement
      return 0;
   }
   

   public int ZakljucekNakupa() {
      // TODO: implement
      return 0;
   }
   
   
   /** @pdGenerated default parent getter */
   public Kosarica getKosarica() {
      return kosarica;
   }
   
   /** @pdGenerated default parent setter
     * @param newKosarica */
   public void setKosarica(Kosarica newKosarica) {
      this.kosarica = newKosarica;
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
   /** @pdGenerated default parent getter */
   public SvSistemZaEposto getSvSistemZaEposto() {
      return svSistemZaEposto;
   }
   
   /** @pdGenerated default parent setter
     * @param newSvSistemZaEposto */
   public void setSvSistemZaEposto(SvSistemZaEposto newSvSistemZaEposto) {
      this.svSistemZaEposto = newSvSistemZaEposto;
   }
   /** @pdGenerated default parent getter */
   public SvBanka getSvBanka() {
      return svBanka;
   }
   
   /** @pdGenerated default parent setter
     * @param newSvBanka */
   public void setSvBanka(SvBanka newSvBanka) {
      this.svBanka = newSvBanka;
   }
   /** @pdGenerated default parent getter */
   public SvReferentZaProdajo getSvReferentZaProdajo() {
      return svReferentZaProdajo;
   }
   
   /** @pdGenerated default parent setter
     * @param newSvReferentZaProdajo */
   public void setSvReferentZaProdajo(SvReferentZaProdajo newSvReferentZaProdajo) {
      this.svReferentZaProdajo = newSvReferentZaProdajo;
   }

}