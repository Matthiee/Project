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
    public void start(Stage stage) throws Exception {
        Leerling lln = new Leerling("Jo De Wit", "2016-02-18-1", "Paul", new Date(), "Rijbewijs B", new Image("resource/man-icon.png"));
        LeerlingController controller = new LeerlingController(lln);
        
        InfoScherm scherm = new InfoScherm(lln, controller);
        LeerlingInfoHouder houder = new LeerlingInfoHouder(lln, controller);
        
        Scene scene = new Scene(scherm);
        
        stage.setScene(scene);
        stage.show();
    }
    
}