/***********************************************************************
 * Module:  Izdelek.java
 * Author:  andra
 * Purpose: Defines the Class Izdelek
 ***********************************************************************/

package com.jean.ris_generated;

import java.util.*;

public class Izdelek {
   private String ime;
   private String cena;
   private String opis;
   private String iDprodukta;
   private String kolicina;

   public Izdelek(String id, String name, String price, String kolicina) {
      this.iDprodukta = id;
      this.ime = name;
      this.cena = price;
      this.kolicina = kolicina;
   }


   public String getId() {
      return iDprodukta;
   }

   public void setId(String id) {
      this.iDprodukta = id;
   }

   public String getName() {
      return ime;
   }

   public void setName(String name) {
      this.ime = name;
   }

   public String getPrice() {
      return cena;
   }

   public void setPrice(String price) {
      this.cena = price;
   }

   public String getKolicina() {
      return kolicina;
   }

   public void setKolicina(String kolicina) {
      this.kolicina = kolicina;
   }





   
   public int VrniSeznamIzdelkovZaKosarico() {
      // TODO: implement
      return 0;
   }
   
   public int ProdajIzdelekIzKosarice() {
      // TODO: implement
      return 0;
   }
   
   public int ZmanjsajZalogoIzdelka() {
      // TODO: implement
      return 0;
   }

}