/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /**
  *
  * @author kuiper
  */
 public class Premium extends Basic {
     private int premiumNumber = 0;
     private int timeStamp = 0;
     private int timeins = 0;
     private int timeStampLFU = 0;

     /**
      *
      * @param name
      * @param naming
      * @param basicNumber
      * @param premiumNumber
      */
     public Premium (String name, String naming ,int basicNumber,int premiumNumber) {
         super(name,naming,basicNumber);
         this.premiumNumber = premiumNumber;
     }
     public void setPremiumnumber () {
         this.premiumNumber--;
     }

     public int getPremiumnumber() {
         return this.premiumNumber;
     }

     // urc in lantul de mostenire cu "super"
     public int getBasicnumber () {
       return super.getBasicnumber();
     }

     // urc in lantul de mostenire cu "super".
     public void setBasicnumber () {
       super.setBasicnumber();
     }

     public void setTimeStamp (int n) {
           this.timeStamp = n;
     }
     public int getTimeStamp () {
         return this.timeStamp;
     }
     public void setTimeStampLFU (int n) {
       if (n == 0)
           this.timeStampLFU = 0;
       else
           this.timeStampLFU++;
     }
     public int getTimeStampLFU () {
         return this.timeStampLFU;
     }
     public void setTimeInsert (int n) {
         this.timeins = n;
     }
     public int getTimeInsert () {
       return this.timeins;
     }
 }
