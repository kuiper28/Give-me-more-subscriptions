/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /**
  *
  * @author kuiper
  */
 public abstract class Subscriptie {
     private String name; // Tipul de subscriptie
     private String naming; // Denumirea obiectului

     /**
      *
      * @param name
      * @param naming
      */
     public Subscriptie(String name,String naming) {
         this.name = name;
         this.naming = naming;
     }

     /**
      *
      * @return
      * Constructorul care seteaza denumirea obiectului(Subscriptiei).
      */
     public String Name () {
       return this.naming;
     }

     /**
      *
      * @return
      * Metoda care intoarce numarul de subscriptii Basic
      */
     public abstract int getBasicnumber ();

     /**
      *
      * @return
      * Metoda care intoarce numarul de subscriptii Premium
      */
     public abstract int getPremiumnumber ();

     /**
      * Seteaza numarul de subscriptii premium
      */
     public abstract void setPremiumnumber ();

     /**
      * Seteaza numarul de subscriptii  basic
      */
     public abstract void setBasicnumber ();

     /**
      *
      * @param n
      * Seteaza numarul de accesari get al unei subscriptii(in principal pentru
      * LRU).
      */
     public abstract void setTimeStamp (int n);

     /**
      *
      * @return
      * Returnaeza numarul de accesari get.
      */
     public abstract int getTimeStamp ();

     /**
      *
      * @param n
      * Seteaza timpul la care un subscriptie a fost adaugata in Cache.
      */
     public abstract void setTimeInsert (int n);

     /**
      *
      * @return
      * Intoarce timpul la care o subscriptie a fost adaugata in Cache.
      */
     public abstract int getTimeInsert ();

     /**
      *
      * @param n
      * Seteaza numarul de accesari get pentru o subscriptie de cand aceasta a
      * fost adaugata in cache-ul de tip LFU .
      */
     public abstract void setTimeStampLFU (int n);

     /**
      *
      * @return
      * Intoarce numarul de accesari get de cand o subscriptie a fost
      * adaugata in cache-ul de tip LFU .
      */
     public abstract int getTimeStampLFU ();
 }
