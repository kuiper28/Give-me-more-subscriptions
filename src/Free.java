/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 public class Free extends Subscriptie {
     private int timeStampF = 0;
     private int timeins = 0;
     private int timeStampLFU = 0;

     /**
      *
      * @param name
      * @param naming
      * Constructorul care imi seteaza tipul subscriptiei si denumirea acesteia.
      */
     public Free(String name,String naming) {
         super(name,naming);
     }

     /**
      *
      * @return
      * In acest caz nu mai avem acesari de tip premium (suntem in subscriptia
      * de tipul Basic).
      */
     public int getBasicnumber () {
       return -1;
     }

     /**
      *
      * @return
      * In acest caz nu mai avem acesari de tip basic (suntem in subscriptia
      * de tipul Basic).
      */
     public int getPremiumnumber () {
       return -1;
     }

     /**
      *
      */
     public void setPremiumnumber () {

     }

     /**
      *
      */
     public void setBasicnumber () {
     }

     /**
      *
      * @param n
      */
     public void setTimeStamp (int n) {
     }

     /**
      *
      * @return
      */
     public int getTimeStamp () {
       return timeStampF;
     }

     /**
      *
      * @param n
      */
     public void setTimeInsert (int n) {
       this.timeins = n;
     }

     /**
      *
      * @return
      */
     public int getTimeInsert () {
       return this.timeins;
     }

     /**
      *
      * @param n
      */
     public void setTimeStampLFU (int n) {
       if (n == 0)
           this.timeStampLFU = n;
       else
           this.timeStampLFU++;
     }

     /**
      *
      * @return
      */
     public int getTimeStampLFU () {
         return this.timeStampLFU;
     }
 }
