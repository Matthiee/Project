package be.matkensim.project.persistentie;

import be.matkensim.project.async.GetLeerlingListTask;
import be.matkensim.project.comparators.LeerlingComparator;
import be.matkensim.project.domein.Leerling;
import be.matkensim.project.gui.MainApp;
import static java.lang.Math.E;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class LeerlingMapper {

    private static List<Leerling> leerlingen;
    private static LeerlingComparator vergelijker;
    
    static {
        vergelijker=new LeerlingComparator();
        leerlingen = new ArrayList<Leerling>();
//        leerlingen.add(new Leerling("Lisa Su", "1969-11-01", "Paul", new Date(), "Rijbewijs B", new Image("resource/lisa.jpg")));
//        leerlingen.add(new Leerling("Mark Zuckerberg", "1984-05-14", "Paul", new Date(), "Rijbewijs B", new Image("resource/mark.jpg")));
//        leerlingen.add(new Leerling("Bill Gates", "1955-10-28", "Paul", new Date(), "Rijbewijs B", new Image("resource/bill.jpg")));
//        leerlingen.add(new Leerling("Marissa Mayer", "1975-05-30", "Paul", new Date(), "Rijbewijs B", new Image("resource/marissa.jpg")));
    }

    public static void getLeerlingen(ObservableList<Leerling> lln) {

        GetLeerlingListTask task = new GetLeerlingListTask();
        task.setOnSucceeded(e -> {
            leerlingen.clear();
            lln.clear();
            try {
                leerlingen.addAll(task.get());
                sort(vergelijker, leerlingen);
                lln.addAll(leerlingen);
            } catch (InterruptedException ex) {
                Logger.getLogger(LeerlingMapper.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(LeerlingMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        task.setOnFailed(e -> {
            leerlingen.clear();
            lln.clear();
            lln.addAll(leerlingen);
        });
        
        MainApp.service.submit(task);
    }

    public static void getLeerlingenMetNaam(ObservableList<Leerling> lln, String naam) {
        // TODO: Database
        GetLeerlingListTask task = new GetLeerlingListTask();
        task.setOnSucceeded(e -> {
            lln.clear();
            leerlingen.clear();
            try {
                List<Leerling> llnreturn = task.get();
                leerlingen.addAll(llnreturn);
                sort(vergelijker, leerlingen);
                
                for (Leerling l : llnreturn) {
                    if (l.getNaam().toLowerCase().contains(naam.toLowerCase())) {
                        lln.add(l);
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(LeerlingMapper.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(LeerlingMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        task.setOnFailed(e -> {
            lln.clear();
            leerlingen.clear();
            lln.addAll(leerlingen);
        });
        
        MainApp.service.submit(task);

    }

    public static Leerling getLeerling(String naam) {
        for (Leerling l : leerlingen) {
            if (l.getNaam().equalsIgnoreCase(naam)) {
                return l;
            }
        }

        return null;
    }

    public static boolean voegLeerlingToe(Leerling lln) {
        boolean x = leerlingen.add(lln);
        leerlingen.sort(vergelijker);
        return x;
    }

    public static boolean bestaat(String lln) {
        for (Leerling l : leerlingen) {
            if (l.getNaam().equalsIgnoreCase(lln)) {
                return true;
            }
        }
        return false;
    }
    
    private static void sort(Comparator<Leerling> c, List<Leerling> l) {
        Object[] a = l.toArray();
        Arrays.sort(a, (Comparator) c);
        l.clear();
        for (Object e : a) {
            l.add((Leerling)e);
        }
    }
}
