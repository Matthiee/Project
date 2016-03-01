package persistentie;

import domein.Leerling;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.image.Image;

/**
 *
 * @author Matthias
 */
public class LeerlingMapper {

    private static List<Leerling> leerlingen;

    static {
       leerlingen=new ArrayList<Leerling>();
       leerlingen.add(new Leerling("Lisa Su", "1969-11-01", "Paul", new Date(), "Rijbewijs B", new Image("resource/lisa.jpg")));
       leerlingen.add(new Leerling("Mark Zuckerberg", "1984-05-14", "Paul", new Date(), "Rijbewijs B", new Image("resource/mark.jpg")));
       leerlingen.add(new Leerling("Bill Gates", "1955-10-28", "Paul", new Date(), "Rijbewijs B", new Image("resource/bill.jpg")));
       leerlingen.add(new Leerling("Marissa Mayer", "1975-05-30", "Paul", new Date(), "Rijbewijs B", new Image("resource/marissa.jpg")));
    }

    public static List<Leerling> getLeerlingen() {
        // TODO: Database
        return leerlingen;
    }
    
    public static List<Leerling> getLeerlingenMetNaam(String naam){
        // TODO: Database
        
        return leerlingen.stream().filter(l -> l.getNaam().contains(naam)).collect(Collectors.toList());
        
    }
    
    public static boolean voegLeerlingToe(Leerling lln){
        return leerlingen.add(lln);
    }
    
    public static boolean bestaat(String lln){
        return leerlingen.stream().anyMatch(l -> l.getNaam().equalsIgnoreCase(lln));
    }

}
