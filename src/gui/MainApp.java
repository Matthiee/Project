package gui;

import controller.EvaController;
import controller.LeerlingController;
import controller.SchermController;
import domein.EvaluatieMoment;
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
    public static final String VERKEERSTECHNIEK_ID = "verkeerstechniek";
    public static final String VELD3ATTITUDE_ID = "veld3attitude";
    public static final String VELD4EVOLUTIE_ID = "veld4evolutie";
    public static final String NIEUWELEERLING_ID = "nieuweleerling";
    
    public static final String VELD1RIJTECHNIEKHOUDING_ID = "veld1rijtechniekhouding";
    public static final String VELD1RIJTECHNIEKKIJKTECHNIEK_ID = "veld1rijtechniekkijktechniek";
    public static final String VELD1RIJTECHNIEKKOPPELING_ID = "veld1rijtechniekkoppeling";
    public static final String VELD1RIJTECHNIEKREMTECHNIEK_ID = "veld1rijtechniekremtechniek";
    public static final String VELD1RIJTECHNIEKSCHAKELTECHNIEK_ID = "veld1rijtechniekschakeltechniek";
    public static final String VELD1RIJTECHNIEKSTUURTECHNIEK_ID = "veld1rijtechniekstuurtechniek";
   
    @Override
    public void start(Stage stage) throws InterruptedException {
        EvaluatieMoment eva = new EvaluatieMoment();
        LeerlingController controller = new LeerlingController(new Leerling("Dummy leerling", "NULL", "NULL", new Date(), "NULL", new Image("resource/man-icon.png")));
        EvaController evaController = new EvaController(controller);
        SchermController schermenCtrl =new SchermController();
        
        HoofdMenu menu = new HoofdMenu(controller, schermenCtrl, evaController);
        InfoScherm info = new InfoScherm(controller, schermenCtrl);
        LoginScherm login = new LoginScherm(controller, schermenCtrl);
        Veld1Rijtechniek rijtechniek = new Veld1Rijtechniek(controller, schermenCtrl, evaController);
        Veld2Verkeerstechniek verkeerstechniek = new Veld2Verkeerstechniek(schermenCtrl);
        Veld3Attitude veld3Attitude = new Veld3Attitude(schermenCtrl);
        NieuweLeerling nieuweLeerling = new NieuweLeerling(schermenCtrl);
        
        Veld1RijtechniekHouding veld1RijtechniekHouding = new Veld1RijtechniekHouding(schermenCtrl);
        Veld1RijtechniekKijktechniek veld1RijtechniekKijktechniek = new Veld1RijtechniekKijktechniek(schermenCtrl);
        Veld1RijtechniekKoppeling veld1RijtechniekKoppeling = new Veld1RijtechniekKoppeling(schermenCtrl);
        Veld1RijtechniekRemtechniek veld1RijtechniekRemtechniek = new Veld1RijtechniekRemtechniek(schermenCtrl);
        Veld1RijtechniekSchakeltechniek veld1RijtechniekSchakeltechniek = new Veld1RijtechniekSchakeltechniek(schermenCtrl);
        Veld1RijtechniekStuurtechniek veld1RijtechniekStuurtechniek = new Veld1RijtechniekStuurtechniek(schermenCtrl);
        
        schermenCtrl.addScherm(LOGIN_ID, login);
        schermenCtrl.addScherm(HOOFDMENU_ID, menu);
        schermenCtrl.addScherm(INFO_LLN_ID, info);
        schermenCtrl.addScherm(RIJTECHNIEK_ID, rijtechniek);
        schermenCtrl.addScherm(VERKEERSTECHNIEK_ID, verkeerstechniek);
        schermenCtrl.addScherm(VELD3ATTITUDE_ID, veld3Attitude);
        schermenCtrl.addScherm(NIEUWELEERLING_ID, nieuweLeerling);
        
        schermenCtrl.addScherm(VELD1RIJTECHNIEKHOUDING_ID, veld1RijtechniekHouding);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKKIJKTECHNIEK_ID, veld1RijtechniekKijktechniek);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKKOPPELING_ID, veld1RijtechniekKoppeling);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKREMTECHNIEK_ID, veld1RijtechniekRemtechniek);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKSCHAKELTECHNIEK_ID, veld1RijtechniekSchakeltechniek);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKSTUURTECHNIEK_ID, veld1RijtechniekStuurtechniek);
        
        schermenCtrl.setScherm(LOGIN_ID);
        
        Group root = new Group(schermenCtrl);
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        // Scenic View voor GUI makkelijker te begrijpen en fouten te vinden
        // ScenicView.show(scene);
    }
    
}
