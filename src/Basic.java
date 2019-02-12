/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /**
  *
  * @author kuiper
  */
 public class Basic extends Free {
     private int premiumNumber = -1;
     private int basicNumber = 0;
     private int timeStampLFU = 0;
     private int timeins = 0;
     private int timeStamp = 0;
     /**
      *
      * @param name
      * @param naming
      * @param basicNumber
      * Constructorul care imi seteaza ,pe langa,tip si denumire si numarul
      * de accesari basic.
      */
     public Basic (String name, String naming, int basicNumber) {
         super(name,naming);
         this.basicNumber = basicNumber;
     }

     /**
      *
      * @return
      */
     public int getBasicnumber() {
         return this.basicNumber;
     }

     /**
      *
      */
     public void setBasicnumber () {
         this.basicNumber--;
     }

     /**
      *
      * @return
      * In acest caz nu mai avem acesari de tip premium.(sumtem in subscriptia
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
      * @param n
      */
     public void setTimeStamp (int n) {
       this.timeStamp = n;
     }

     /**
      *
      * @return
      */
     public int getTimeStamp () {
       return this.timeStamp;
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
           this.timeStampLFU = 0;
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
