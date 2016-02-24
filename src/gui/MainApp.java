package gui;

import controller.LeerlingController;
import controller.SchermController;
import domein.Leerling;
import java.util.Date;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Matthias
 */
public class MainApp extends Application{
 
    public static final String LOGIN_ID = "login";
    public static final String HOOFDMENU_ID = "hoofdmenu";
    public static final String INFO_LLN_ID = "info_lln";
    public static final String RIJTECHNIEK_ID = "rijtechniek";
    public static final String VERKEERSTECHNIEK_ID = "verkerstechniek";
   
    @Override
    public void start(Stage stage) {
        Leerling lln = new Leerling("Jo De Wit", "2016-02-18-1", "Paul", new Date(), "Rijbewijs B", new Image("resource/man-icon.png"));
        LeerlingController controller = new LeerlingController(lln);
        
        
        LeerlingInfoHouder houder = new LeerlingInfoHouder(lln, controller);
        
        Veld4Evolutie evo = new Veld4Evolutie();
        VeldOpmerkingen opm = new VeldOpmerkingen("- AANDACHT\n- EIGEN RIT\n- CRUISE CONTROL");
        
        SchermController schermenCtrl =new SchermController();
        
        HoofdMenu menu = new HoofdMenu(lln, controller, schermenCtrl);
        InfoScherm info = new InfoScherm(lln, controller, schermenCtrl);
        LoginScherm login = new LoginScherm(schermenCtrl);
        Veld1Rijtechniek rijtechniek = new Veld1Rijtechniek(schermenCtrl);
        Veld2Verkeerstechniek verkeerstechniek = new Veld2Verkeerstechniek(schermenCtrl);
        
        schermenCtrl.addScherm(LOGIN_ID, login);
        schermenCtrl.addScherm(HOOFDMENU_ID, menu);
        schermenCtrl.addScherm(INFO_LLN_ID, info);
        schermenCtrl.addScherm(RIJTECHNIEK_ID, rijtechniek);
        schermenCtrl.addScherm(VERKEERSTECHNIEK_ID, verkeerstechniek);
        
        schermenCtrl.setScherm(LOGIN_ID);
        
        Group root = new Group(schermenCtrl);
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
