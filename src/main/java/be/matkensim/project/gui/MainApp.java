package be.matkensim.project.gui;

import be.matkensim.project.controller.EvaController;
import be.matkensim.project.controller.LeerlingController;
import be.matkensim.project.controller.SchermController;
import be.matkensim.project.domein.Leerling;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static final String LOGIN_ID = "login";
    public static final String HOOFDMENU_ID = "hoofdmenu";
    public static final String INFO_LLN_ID = "info_lln";
    public static final String RIJTECHNIEK_ID = "rijtechniek";
    public static final String VERKEERSTECHNIEK_ID = "verkeerstechniek";
    public static final String VELD3ATTITUDE_ID = "veld3attitude";
    public static final String VELD4EVOLUTIE_ID = "veld4evolutie";
    public static final String NIEUWELEERLING_ID = "nieuweleerling";
    public static final String OPSLAANWAARSCHUWING_ID = "opslaanwaarschuwing";

    public static final String VELD1RIJTECHNIEKHOUDING_ID = "veld1rijtechniekhouding";
    public static final String VELD1RIJTECHNIEKHELLING_ID = "veld1rijtechniekhelling";
    public static final String VELD1RIJTECHNIEKKIJKTECHNIEK_ID = "veld1rijtechniekkijktechniek";
    public static final String VELD1RIJTECHNIEKKOPPELING_ID = "veld1rijtechniekkoppeling";
    public static final String VELD1RIJTECHNIEKREMTECHNIEK_ID = "veld1rijtechniekremtechniek";
    public static final String VELD1RIJTECHNIEKSCHAKELTECHNIEK_ID = "veld1rijtechniekschakeltechniek";
    public static final String VELD1RIJTECHNIEKSTUURTECHNIEK_ID = "veld1rijtechniekstuurtechniek";
    public static final String VELD1RIJTECHNIEKSTUUROEF_ID = "veld1rijtechniekstuuroef";
    public static final String VELD1RIJTECHNIEKACHTERUIT_ID = "veld1rijtechniekachteruit";
    public static final String VELD1RIJTECHNIEKKEREN_ID = "veld1rijtechniekkeren";
    public static final String VELD1RIJTECHNIEKPARKEREN_ID = "veld1rijtechniekparkeren";
    public static final String VELD1RIJTECHNIEKGARAGE_ID = "veld1rijtechniekgarage";

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

    public static ExecutorService service = Executors.newSingleThreadExecutor();

    @Override
    public void start(Stage stage) throws InterruptedException {

        Rectangle2D r = Screen.getPrimary().getVisualBounds();

        LeerlingController controller = new LeerlingController(new Leerling("Dummy leerling", "NULL", "NULL", new Date(), "NULL", new Image("resource/man-icon.png")));
        EvaController evaController = new EvaController(controller);
        SchermController schermenCtrl = new SchermController();

        HoofdMenu menu = new HoofdMenu(controller, schermenCtrl, evaController);
        InfoScherm info = new InfoScherm(controller, schermenCtrl);
        LoginScherm login = new LoginScherm(controller, schermenCtrl);
        Veld1Rijtechniek rijtechniek = new Veld1Rijtechniek(controller, schermenCtrl, evaController);
        Veld2Verkeerstechniek verkeerstechniek = new Veld2Verkeerstechniek(controller, schermenCtrl, evaController);
        Veld3Attitude veld3Attitude = new Veld3Attitude(controller, schermenCtrl, evaController);
        NieuweLeerling nieuweLeerling = new NieuweLeerling(schermenCtrl);
        OpslaanWaarschuwing opslaanWaarschuwing = new OpslaanWaarschuwing(schermenCtrl, menu);

        Veld1RijtechniekHouding veld1RijtechniekHouding = new Veld1RijtechniekHouding(schermenCtrl, evaController, controller);
        Veld1RijtechniekHelling veld1RijtechniekHelling = new Veld1RijtechniekHelling(schermenCtrl, evaController, controller);
        Veld1RijtechniekKijktechniek veld1RijtechniekKijktechniek = new Veld1RijtechniekKijktechniek(schermenCtrl, evaController, controller);
        Veld1RijtechniekKoppeling veld1RijtechniekKoppeling = new Veld1RijtechniekKoppeling(schermenCtrl, evaController, controller);
        Veld1RijtechniekRemtechniek veld1RijtechniekRemtechniek = new Veld1RijtechniekRemtechniek(schermenCtrl, evaController, controller);
        Veld1RijtechniekSchakeltechniek veld1RijtechniekSchakeltechniek = new Veld1RijtechniekSchakeltechniek(schermenCtrl, evaController, controller);
        Veld1RijtechniekStuurtechniek veld1RijtechniekStuurtechniek = new Veld1RijtechniekStuurtechniek(schermenCtrl, evaController, controller);
        Veld1RijtechniekGarage veld1RijtechniekGarage = new Veld1RijtechniekGarage(schermenCtrl, evaController, controller);
        Veld1RijtechniekAchteruit veld1RijtechniekAchteruit = new Veld1RijtechniekAchteruit(schermenCtrl, evaController, controller);
        Veld1RijtechniekParkeren veld1RijtechniekParkeren = new Veld1RijtechniekParkeren(schermenCtrl, evaController, controller);
        Veld1RijtechniekKeren veld1RijtechniekKeren = new Veld1RijtechniekKeren(schermenCtrl, evaController, controller);
        Veld1RijtechniekStuuroef veld1RijtechniekStuuroef = new Veld1RijtechniekStuuroef(schermenCtrl, evaController, controller);

        Veld2VerkeerstechniekAfstand veld2VerkeerstechniekAfstand = new Veld2VerkeerstechniekAfstand(schermenCtrl, evaController, controller);
        Veld2VerkeerstechniekInhalen veld2VerkeerstechniekInhalen = new Veld2VerkeerstechniekInhalen(schermenCtrl, evaController, controller);
        Veld2VerkeerstechniekKruisen veld2VerkeerstechniekKruisen = new Veld2VerkeerstechniekKruisen(schermenCtrl, evaController, controller);
        Veld2VerkeerstechniekLinksaf veld2VerkeerstechniekLinksaf = new Veld2VerkeerstechniekLinksaf(schermenCtrl, evaController, controller);
        Veld2VerkeerstechniekPlaats veld2VerkeerstechniekPlaats = new Veld2VerkeerstechniekPlaats(schermenCtrl, evaController, controller);
        Veld2VerkeerstechniekRechtsaf veld2VerkeerstechniekRechtsaf = new Veld2VerkeerstechniekRechtsaf(schermenCtrl, evaController, controller);
        Veld2VerkeerstechniekRichtingaanwijzers veld2VerkeerstechniekRichtingaanwijzers = new Veld2VerkeerstechniekRichtingaanwijzers(schermenCtrl, evaController, controller);
        Veld2VerkeerstechniekSnelheid veld2VerkeerstechniekSnelheid = new Veld2VerkeerstechniekSnelheid(schermenCtrl, evaController, controller);
        Veld2VerkeerstechniekVerkeerstekens veld2VerkeerstechniekVerkeerstekens = new Veld2VerkeerstechniekVerkeerstekens(schermenCtrl, evaController, controller);
        Veld2VerkeerstechniekVoorrang veld2VerkeerstechniekVoorrang = new Veld2VerkeerstechniekVoorrang(schermenCtrl, evaController, controller);

        schermenCtrl.addScherm(LOGIN_ID, login);
        schermenCtrl.addScherm(HOOFDMENU_ID, menu);
        schermenCtrl.addScherm(INFO_LLN_ID, info);
        schermenCtrl.addScherm(RIJTECHNIEK_ID, rijtechniek);
        schermenCtrl.addScherm(VERKEERSTECHNIEK_ID, verkeerstechniek);
        schermenCtrl.addScherm(VELD3ATTITUDE_ID, veld3Attitude);
        schermenCtrl.addScherm(NIEUWELEERLING_ID, nieuweLeerling);
        schermenCtrl.addScherm(OPSLAANWAARSCHUWING_ID, opslaanWaarschuwing);

        schermenCtrl.addScherm(VELD1RIJTECHNIEKHOUDING_ID, veld1RijtechniekHouding);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKHELLING_ID, veld1RijtechniekHelling);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKKIJKTECHNIEK_ID, veld1RijtechniekKijktechniek);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKKOPPELING_ID, veld1RijtechniekKoppeling);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKREMTECHNIEK_ID, veld1RijtechniekRemtechniek);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKSCHAKELTECHNIEK_ID, veld1RijtechniekSchakeltechniek);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKSTUURTECHNIEK_ID, veld1RijtechniekStuurtechniek);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKSTUUROEF_ID, veld1RijtechniekStuuroef);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKACHTERUIT_ID, veld1RijtechniekAchteruit);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKKEREN_ID, veld1RijtechniekKeren);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKPARKEREN_ID, veld1RijtechniekParkeren);
        schermenCtrl.addScherm(VELD1RIJTECHNIEKGARAGE_ID, veld1RijtechniekGarage);

        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKAFSTAND_ID, veld2VerkeerstechniekAfstand);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKINHALEN_ID, veld2VerkeerstechniekInhalen);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKKRUISEN_ID, veld2VerkeerstechniekKruisen);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKLINKSAF_ID, veld2VerkeerstechniekLinksaf);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKPLAATS_ID, veld2VerkeerstechniekPlaats);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKRECHTSAF_ID, veld2VerkeerstechniekRechtsaf);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKRICHTINGAANWIJZERS_ID, veld2VerkeerstechniekRichtingaanwijzers);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKSNELHEID_ID, veld2VerkeerstechniekSnelheid);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKVERKEERSTEKENS_ID, veld2VerkeerstechniekVerkeerstekens);
        schermenCtrl.addScherm(VELD2VERKEERSTECHNIEKVOORRANG_ID, veld2VerkeerstechniekVoorrang);

        schermenCtrl.setScherm(LOGIN_ID);

        Group root = new Group(schermenCtrl);
        Scene scene = new Scene(root, r.getWidth(), r.getHeight());

        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(e -> service.shutdownNow());

        // Scenic View voor GUI makkelijker te begrijpen en fouten te vinden
        // ScenicView.show(scene);
    }
}
