import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.lang.*;

/**
 *
 * @author kuiper
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * In aceasta clasa fac parsarea elementelor din fisier si adugarea lor
     * corespunzatoare in memoria principala sau in Cache.
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String operation;
        String cacheType = null;
        int cacheLength = 0;
        int count = 0;
        int countNumber = 0;
        int numberOfOperations = 0;
        int timeInsert = 0;
        int countLFU = 0;
        LRUCache lru = null;
        FIFOCache fifo = null;
        LFUCache lfu = null;
        MemoriePrincipala m = new MemoriePrincipala(0);
        int index = 0;
        try {
        FileInputStream fstream = new FileInputStream(args[0]);
            try (DataInputStream in = new DataInputStream(fstream)) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine;
                int i = 0;
           while (i < 3 && ((strLine = br.readLine()) != null ) )   {
               if (i == 0)
                cacheType = strLine;
               else
               if (i == 1)
                cacheLength = Integer.parseInt(strLine);
               else
                if(i == 2)
                 numberOfOperations = Integer.parseInt(strLine);
		             i++;
           }

           // Initializare memorie Cache.
           if (cacheType.equals("LRU")) {
               lru = new LRUCache(cacheLength);
           }
           else if (cacheType.equals("FIFO")){
               fifo = new FIFOCache(cacheLength);
             }
            else if (cacheType.equals("LFU")) {
                lfu = new LFUCache(cacheLength);
            }
           String str =  br.readLine();
           while (numberOfOperations > 0) {
            count = 0;
            String [] tokens;
	          int idx_f = -1;
            tokens = str.split(" ");
            operation = tokens[0];
            for( String w : tokens)
            {
              count++;
            }

            // Daca operatia este de tipul "ADD" efectuam urmatoarele.
            if(operation.equals("ADD")) {
            Subscriptie s;

            // Declar un tip de subscriptie in functie de numarul elementelor
            // citite pe o linie (Cu alte cuvinte daca exista numarul de accesari
            // premium subscriptia va fi de tipul premium).

            if (count == 4) {
                  s = new Premium("Premium",tokens[1],Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]));
            }
            else {
                  s = new Basic("Basic",tokens[1],Integer.parseInt(tokens[2]));
                 }
            for (int j = 0; j < m.getIdx(); j++) {
                if (m.objects.get(j).Name().equals(s.Name()))
                  idx_f = j;
            }

            // daca o subscriptie exista deja in memoria principala, atunci
            // ea va fi suprascrisa.
            if(idx_f != -1)
                m.Suprascrie(s,idx_f);
            else
            m.ADD(s);

            // Daca o subscriptie exista in memoria de tip Cache,
            // atunci ea va fi eliminata.
            if (lfu != null) {
              for (int y = 0; y < lfu.getIdx(); y++) {
                if (lfu.objects.get(y).Name().equals(s.Name())){
                  lfu.removeExisting(y);
                }
              }
            }
            else if (lru != null) {
              for (int y = 0; y < lru.getIdx(); y++) {
                if (lru.objects.get(y).Name().equals(s.Name())){
                  lru.removeExisting(y);
                }
              }
            }
            else if (fifo != null) {
              for ( int q = 0; q < fifo.getIdx(); q++) {
                if (fifo.objects.get(q).Name().equals(s.Name())){
                  fifo.removeExisting(q);
                }
              }
            }
          }

          // Daca operatia este de tipul "GET" efectuam urmatoarele.
          else if (operation.equals("GET")) {
                int ok = 0;
                int numberOfSubs = 0;

                // Cazul in care avem memorie Cache de tipul "LFU".
                if (lfu != null) {
                   for (int l = 0; l < lfu.getIdx(); l++) {
                     if(lfu.objects.get(l).Name().equals(tokens[1]))
                     {
                       countLFU++; // numarul de accesari get ale unui elenent
                       // de cand se afla in LFU.
                       lfu.objects.get(l).setTimeStampLFU(countLFU);
                       ok = 1;
                       writer.write("0");
                       writer.write(" ");
                       if (lfu.objects.get(l).getPremiumnumber() > 0) {
                       writer.write("Premium");
                       writer.newLine();
                       }
                       else
                       if (lfu.objects.get(l).getBasicnumber() > 0) {
                         writer.write("Basic");
                         writer.newLine();
                       }
                       else {
                         writer.write("Free");
                         writer.newLine();
                    }
                    numberOfSubs = lfu.Get(lfu.objects.get(l)); // actualizez
                    // aparteneta la Cache prin intermediul metodei "Get".

                   }
                 }
               }
              // Cazul in care avem memorie Cache de tipul "LRU".
               else if (lru != null) {
                  for (int l = 0; l < lru.getIdx(); l++) {
                    if(lru.objects.get(l).Name().equals(tokens[1]))
                    {
                      countNumber++; // numarul de accesari get ale elementului
                      // cu denumirea "tokens[1]" este incrementat.

                      lru.objects.get(l).setTimeStamp(countNumber);
                      ok = 1;
                      writer.write("0");
                      writer.write(" ");
                      if (lru.objects.get(l).getPremiumnumber() > 0) {
                      writer.write("Premium");
                      writer.newLine();
                      }
                      else
                      if (lru.objects.get(l).getBasicnumber() > 0) {
                        writer.write("Basic");
                        writer.newLine();
                      }
                      else {
                        writer.write("Free");
                        writer.newLine();
                   }
                   numberOfSubs = lru.Get(lru.objects.get(l)); // actualizez
                   // aparteneta la Cache prin intermediul metodei "Get".

                  }
                }
              }

              // Cazul in care avem memorie Cache de tipul "FIFO".
              else if (fifo != null) {
                  for (int f = 0; f < fifo.getIdx(); f++) {
                    if (fifo.objects.get(f).Name().equals(tokens[1]))
                    {
                      ok = 1;
                      writer.write("0");
                      writer.write(" ");
                      if (fifo.objects.get(f).getPremiumnumber() > 0) {
                      writer.write("Premium");
                      writer.newLine();
                      }
                      else
                      if (fifo.objects.get(f).getBasicnumber() > 0) {
                        writer.write("Basic");
                        writer.newLine();
                        }
                        else {
                          writer.write("Free");
                          writer.newLine();
                        }
                        numberOfSubs = fifo.Get(fifo.objects.get(f)); // actualizez
                        // aparteneta la Cache prin intermediul metodei "Get".
                      }

                   }
                 }
                 // Cazul in care nu a fost inca initializata memoria de tip Cache (
                 // LRU, LFU sau FIFO) .
                  if (ok == 0) {
    	               for (int k = 0; k < m.getIdx(); k++) {

                       // daca in urma unei accesari "GET" subscriptia
                       // este gasiata in memoria atunci ea va fi introdusa
                       // in cache si se va constata aparteneta acesteia la
                       // memoria pricipala.

                       if (m.objects.get(k).Name().equals(tokens[1])) {
                        ok = 2;
                        countNumber++; // numarul de accesari get ale elementului
                        // cu denumirea "tokens[1]" este incrementat.

                        m.objects.get(k).setTimeStamp(countNumber);
                        if(lfu != null) {
                          if (lfu.getIdx() > cacheLength-1) {
                            countLFU = 0;
                            timeInsert++;
                            index = lfu.remove();
                            lfu.Suprascrie(m.objects.get(k),index);
                            lfu.objects.get(index).setTimeStampLFU(countLFU);
                            lfu.objects.get(index).setTimeInsert(timeInsert);

                          } else {
                          countLFU = 0;
                          timeInsert++;
                          lfu.ADD(m.objects.get(k));
                          lfu.objects.get(lfu.getIdx() - 1).setTimeStampLFU(countLFU);
                          lfu.objects.get(lfu.getIdx() - 1).setTimeInsert(timeInsert);
                          }

                        }
                        if(lru != null) {
                          if (lru.getIdx() > cacheLength-1) {
                            index = lru.remove();
                            lru.Suprascrie(m.objects.get(k),index);
                          } else {
                          lru.ADD(m.objects.get(k));
                          }

                        }
                        if (fifo != null) {
                          if (fifo.getIdx() > cacheLength-1) {
                            System.out.println(fifo.getIdx());
                            index = fifo.remove();
                            fifo.ADD(m.objects.get(k));
                          }
                          else {
                          fifo.ADD(m.objects.get(k));
                        }
                        }
                	      writer.write("1");
                        writer.write(" ");
                        if (m.objects.get(k).getPremiumnumber() > 0) {
                        writer.write("Premium");
                        writer.newLine();
                      }
                         else
                          if (m.objects.get(k).getBasicnumber() > 0) {
                        writer.write("Basic");
                        writer.newLine();
                      }
                       else
                     {
                        writer.write("Free");
                        writer.newLine();
                      }

                      numberOfSubs = m.Get(m.objects.get(k)); // actualizez
                      // aparteneta la Cache prin intermediul metodei "Get".

                    }
                    }
                  }
                   if (ok == 0) {
                       writer.write("2");
                       writer.newLine();

                    }
                  }
              numberOfOperations--;
              str = br.readLine();

                }
                writer.close();
           }
            }catch (IOException e){
         System.err.println("Error: " + e.getMessage());
       }
     }
    }
