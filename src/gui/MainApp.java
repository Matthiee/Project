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
    
    public static final String VELD2VERKEERSTECHNIEKAFSTAND_ID = "veld2verkeerstechniekafstand";
    public static final String VELD2VERKEERSTECHNIEKINHALEN_ID = "veld2verkeerstechniekinhalen";
    public static final String VELD2VERKEERSTECHNIEKKRUISEN_ID = "veld2verkeerstechniekkruisen";
    public static final String VELD2VERKEERSTECHNIEKLINKSAF_ID = "veld2verkeerstechnieklinksaf";
    public static final String VELD2VERKEERSTECHNIEKPLAATS_ID = "veld2verkeerstechniekplaats";
    public static final String VELD2VERKEERSTECHNIEKRECHTSAF_ID = "veld2verkeerstechniekrechtsaf";
    public static final String VELD2VERKEERSTECHNIEKRICHTINGAANWIJZERS_ID = "veld2verkeerstechniekrichtingaanwijzers";
    public static final String VELD2VERKEERSTECHNIEKSNELHEID_ID = "veld2verkeerstechnieksnelheid";
    public static final String VELD2VERKEERSTECHNIEKVERKEERSTEKENS_ID = "veld2verkeerstechniekverkeerstekens";
    public static final String VELD2VERKEERSTECHNIEKVOORRANG_ID = "veld2verkeerstechniekvoorrang";
   
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
        Veld2Verkeerstechniek verkeerstechniek = new Veld2Verkeerstechniek(schermenCtrl, evaController);
        Veld3Attitude veld3Attitude = new Veld3Attitude(schermenCtrl);
        NieuweLeerling nieuweLeerling = new NieuweLeerling(schermenCtrl);
        
        Veld1RijtechniekHouding veld1RijtechniekHouding = new Veld1RijtechniekHouding(schermenCtrl);
        Veld1RijtechniekKijktechniek veld1RijtechniekKijktechniek = new Veld1RijtechniekKijktechniek(schermenCtrl);
        Veld1RijtechniekKoppeling veld1RijtechniekKoppeling = new Veld1RijtechniekKoppeling(schermenCtrl);
        Veld1RijtechniekRemtechniek veld1RijtechniekRemtechniek = new Veld1RijtechniekRemtechniek(schermenCtrl);
        Veld1RijtechniekSchakeltechniek veld1RijtechniekSchakeltechniek = new Veld1RijtechniekSchakeltechniek(schermenCtrl);
        Veld1RijtechniekStuurtechniek veld1RijtechniekStuurtechniek = new Veld1RijtechniekStuurtechniek(schermenCtrl);
        
        Veld2VerkeerstechniekAfstand veld2VerkeerstechniekAfstand = new Veld2VerkeerstechniekAfstand(schermenCtrl);
        Veld2VerkeerstechniekInhalen veld2VerkeerstechniekInhalen = new Veld2VerkeerstechniekInhalen(schermenCtrl);
        Veld2VerkeerstechniekKruisen veld2VerkeerstechniekKruisen = new Veld2VerkeerstechniekKruisen(schermenCtrl);
        Veld2VerkeerstechniekLinksaf veld2VerkeerstechniekLinksaf = new Veld2VerkeerstechniekLinksaf(schermenCtrl);
        Veld2VerkeerstechniekPlaats veld2VerkeerstechniekPlaats = new Veld2VerkeerstechniekPlaats(schermenCtrl);
        Veld2VerkeerstechniekRechtsaf veld2VerkeerstechniekRechtsaf = new Veld2VerkeerstechniekRechtsaf(schermenCtrl);
        Veld2VerkeerstechniekRichtingaanwijzers veld2VerkeerstechniekRichtingaanwijzers = new Veld2VerkeerstechniekRichtingaanwijzers(schermenCtrl);
        Veld2VerkeerstechniekSnelheid veld2VerkeerstechniekSnelheid = new Veld2VerkeerstechniekSnelheid(schermenCtrl);
        Veld2VerkeerstechniekVerkeerstekens veld2VerkeerstechniekVerkeerstekens = new Veld2VerkeerstechniekVerkeerstekens(schermenCtrl);
        Veld2VerkeerstechniekVoorrang veld2VerkeerstechniekVoorrang = new Veld2VerkeerstechniekVoorrang(schermenCtrl);
        
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
        
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKAFSTAND_ID, veld2VerkeerstechniekAfstand);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKINHALEN_ID,veld2VerkeerstechniekInhalen);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKKRUISEN_ID,veld2VerkeerstechniekKruisen);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKLINKSAF_ID,veld2VerkeerstechniekLinksaf);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKPLAATS_ID,veld2VerkeerstechniekPlaats);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKRECHTSAF_ID,veld2VerkeerstechniekRechtsaf);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKRICHTINGAANWIJZERS_ID,veld2VerkeerstechniekRichtingaanwijzers);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKSNELHEID_ID,veld2VerkeerstechniekSnelheid);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKVERKEERSTEKENS_ID,veld2VerkeerstechniekVerkeerstekens);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKVOORRANG_ID,veld2VerkeerstechniekVoorrang);
        
        schermenCtrl.setScherm(LOGIN_ID);
        
        Group root = new Group(schermenCtrl);
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        // Scenic View voor GUI makkelijker te begrijpen en fouten te vinden
        // ScenicView.show(scene);
    }
    
}
