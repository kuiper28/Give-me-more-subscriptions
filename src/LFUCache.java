import java.util.ArrayList;

/**
 *
 * @author kuiper
 */
public class LFUCache implements Cache {
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
    public LFUCache (int dim) {
        this.dim = dim;
    }

    /**
     *
     * @param o
     * Metoda de adugare a unui element in cache-ul de tip LFU.
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
     * Metoda de stergere a unui elenent din cache-ul de tip LFU.
     */
    public int remove () {
      int min = 10000;
      int timeofinsertion = 1000;
      for (int j = 0; j < this.idx ; j++) {
        if (this.objects.get(j).getTimeStampLFU() < min) {
          min = this.objects.get(j).getTimeStampLFU();
          timeofinsertion = this.objects.get(j).getTimeInsert();
          index = j;
        } else
        if(this.objects.get(j).getTimeStampLFU() == min &&
         this.objects.get(j).getTimeInsert() < timeofinsertion) {
           min = this.objects.get(j).getTimeStampLFU();
           timeofinsertion = this.objects.get(j).getTimeInsert();
           index = j;
         }
      }
      return index;
    }

    /**
     *
     * @param o
     * @param index
     * Elimina un element deja existent in LFU.
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
     * Elimina un element deja existent in LFU.
     */
    public void removeExisting (int ind) {
       this.objects.remove(ind);
       this.idx--;
        }
    }
