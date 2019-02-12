/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 import java.util.ArrayList;
 /**
  *
  * @author kuiper
  */
 public class FIFOCache implements Cache {
      ArrayList<Subscriptie> objects = new ArrayList<Subscriptie>();
      int dim = 0;
      int idx = 0;

     /**
      *
      * @param dim
      * Seteaza dimensiunea Cache-ului.
      */
     public FIFOCache (int dim) {
          this.dim = dim;
      }

     /**
      *
      * @param o
      * Metoda de adugare a unui element in cache-ul de tip FIFO.
      */
     public void ADD (Subscriptie o) {
             objects.add(0,o);
             this.idx += 1;
     }

     /**
      *
      * @return
      * Metoda de stergere a unui elenent din cache-ul de tip FIFO.
      */
     public int remove () {
              this.objects.remove(this.idx - 1);
              this.idx -= 1;
          return 1;
      }

     /**
      *
      * @return
      * Intoarce indexul curent din arrayList.
      */
     public int getIdx () {
        return this.idx;
      }

     /**
      *
      * @param index
      * Elimina un element deja existent in FIFO.
      */
     public void removeExisting (int index) {
          objects.remove(index);
          this.idx--;
         }

     /**
      *
      * @param o
      * @return
      * Ne da apartenenta unui element la Cache.
      */
     public int Get (Subscriptie o) {
             for (int i = 0; i < this.idx; i++) {
                 if (objects.get(i).Name().equals(o.Name())){
                     if(objects.get(i).getPremiumnumber() > 0)
                     {
                         objects.get(i).setPremiumnumber();
                     }
                     else
                     if (objects.get(i).getBasicnumber() > 0)
                     {
                         objects.get(i).setBasicnumber();
                     }
                     return 1;
                 }
             }
             return 0;
         }

 }
