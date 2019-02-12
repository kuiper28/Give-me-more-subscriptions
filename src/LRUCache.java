/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 import java.util.*;
/**
 *
 * @author kuiper
 */
public class LRUCache implements Cache {
    ArrayList<Subscriptie> objects = new ArrayList<Subscriptie>();
    int idx = 0;
    int dim = 0;
    int index = 0;
    int count = 0;

    /**
     *
     * @param dim
     * Seteaza dimensiunea Cache-ului.
     */
    public LRUCache (int dim) {
        this.dim = dim;
    }

    /**
     *
     * @param o
     * Metoda de adugare a unui element in cache-ul de tip LRU.
     */
    public void ADD (Subscriptie o) {
            objects.add(o);
            this.idx += 1;
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
     * @return
     * Metoda de stergere a unui elenent din cache-ul de tip LRU.
     */
    public int remove () {
      int min = 10000;
      for (int j = 0; j < this.idx ; j++) {
        if (this.objects.get(j).getTimeStamp() < min) {
          min = this.objects.get(j).getTimeStamp();
          index = j;
        }
      }
      return index;
    }

    /**
     *
     * @param o
     * @param index
     * Suprascrie subscriptia de la indexul "index" cu noua subscriptie.
     */
    public void Suprascrie(Subscriptie o, int index) {
         objects.set(index,o);
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

    /**
     *
     * @param ind
     * Elimina un element deja existent in LRU.
     */
    public void removeExisting (int ind) {
       this.objects.remove(ind);
       this.idx--;
        }
    }
