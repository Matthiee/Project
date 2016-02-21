package gui;

import controller.LeerlingController;
import domein.Leerling;
import java.util.Date;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Matthias
 */
public class MainApp extends Application{
 
    @Override
    public void start(Stage stage) {
        Leerling lln = new Leerling("Jo De Wit", "2016-02-18-1", "Paul", new Date(), "Rijbewijs B", new Image("resource/man-icon.png"));
        LeerlingController controller = new LeerlingController(lln);
        
        InfoScherm scherm = new InfoScherm(lln, controller);
        LeerlingInfoHouder houder = new LeerlingInfoHouder(lln, controller);
        
        Veld4Evolutie evo = new Veld4Evolutie();
        VeldOpmerkingen opm = new VeldOpmerkingen("- AANDACHT\n- EIGEN RIT\n- CRUISE CONTROL");
        
        HoofdMenu menu = new HoofdMenu(lln, controller);
        
        Onderdeel deel = new Onderdeel("resource/Hoofdmenu/attitude.png", "", "", "");
        
        
        Scene scene = new Scene(menu);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
