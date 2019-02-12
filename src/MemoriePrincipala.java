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
public class MemoriePrincipala {
    ArrayList<Subscriptie> objects = new ArrayList<Subscriptie>();
    private int idx = 0;
    private int dim = 0;

    /**
     *
     * @param dim
     * Seteaza dimensiunea Cache-ului.
     */
    public MemoriePrincipala (int dim){
      this.dim = dim;
    }

    /**
     *
     * @param o
     * Aduga un element in Memoria principala.
     */
    public void ADD (Subscriptie o) {
        objects.add (o);
        this.idx ++;
    }

    /**
     *
     * @param o
     * @param index
     * metoda care suprascie elementul de la indexul "index" cu un nou element.
     */
    public void Suprascrie(Subscriptie o, int index) {
         objects.set(index,o);
    }

    /**
     *
     * @return
     * Intoarce indexul curent.
     */
    public int getIdx() {
        return this.idx;
    }

    /**
     *
     * @param o
     * @return
     * Ne da apartenenta la Cache.
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
