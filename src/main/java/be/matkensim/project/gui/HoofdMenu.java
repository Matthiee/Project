package be.matkensim.project.gui;

import be.matkensim.project.async.SaveEvaTask;
import be.matkensim.project.controller.EvaController;
import be.matkensim.project.controller.LeerlingController;
import be.matkensim.project.controller.SchermController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class HoofdMenu extends HBox implements View {

    //objecten en controllers
    private LeerlingController llnController;
    private final SchermController schermController;
    private EvaController evaController;

    //main borderpane
    private BorderPane bp;

    //hoogte en breedte van het venster
    private int hoogte, breedte;
    //achtergrond
    private ImageView achtergrond;
    //top
    private GridPane top;

    private LeerlingInfoHouder llnInfo;
    //Left
    private GridPane left;
    private Onderdeel schakelaars, vloeistoffen, banden;
    //right
    private GridPane right;
    private Onderdeel gps, stop, tanken;
    //center
    private GridPane center, iconen;
    private Onderdeel rotonde, rijstroken, stad, snelweg;
    private ImageView attitudeImg;
    private Stuur stuur;
    private Pijlen pijlen;
    //bottom
    private GridPane bottom;
    private EvaSelector evaSelector;
    private Veld4Evolutie graphImg;
    private ImageView saveImg;
    private ListView<String> listViewCommentaar = new ListView<String>();
    private ObservableList<String> listCommentaar = FXCollections.observableArrayList();

    public HoofdMenu(LeerlingController llnController, SchermController schermCtrl, EvaController evaCtrl) {
        //hoogte en breedte
        hoogte = schermCtrl.getHoogte();
        breedte = schermCtrl.getBreedte();

        //Top of the borderpane
        top = new GridPane();
        //De leerlingen en controller toewijzen           
        this.llnController = llnController;
        this.llnController.getLeerling().addView(this);
        this.schermController = schermCtrl;
        this.evaController = evaCtrl;

        //de nodes
        llnInfo = new LeerlingInfoHouder(llnController);

        llnInfo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                schermController.setScherm(MainApp.INFO_LLN_ID);
            }
        });

        attitudeImg = new ImageView("resource/Hoofdmenu/attitude.png");
        attitudeImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                schermController.setScherm(MainApp.VELD3ATTITUDE_ID);
            }
        });

        //de opmaak
        top.setPadding(new Insets(30, 20, 5, 20));
        top.setHgap(650);
        top.setMinHeight(140);
        //nodes toevoegen

        top.add(attitudeImg, 0, 0);
        top.add(llnInfo, 1, 0);

        //Left side borderpane
        left = new GridPane();
        //de nodes
        schakelaars = new Onderdeel("resource/Hoofdmenu/schakelaars", 10, 35, evaController);

        vloeistoffen = new Onderdeel("resource/Hoofdmenu/vloeistoffen", -10, 35, evaController);

        banden = new Onderdeel("resource/Hoofdmenu/banden", 10, 35, evaController);

        //opmaak
        schakelaars.setFitHeight(60);
        schakelaars.setFitWidth(60);
        schakelaars.setTranslateX(20);
        vloeistoffen.setFitHeight(60);
        vloeistoffen.setFitWidth(60);
        banden.setFitHeight(60);
        banden.setFitWidth(60);
        banden.setTranslateX(20);
        left.setVgap(30);
        left.setPadding(new Insets(20, 20, 20, 50));
        left.setMaxHeight(400);
        left.setMinHeight(400);
        left.setMaxWidth(120);
        left.setMinWidth(120);
        //de nodes toevoegen
        left.add(schakelaars, 0, 0);
        left.add(vloeistoffen, 0, 1);
        left.add(banden, 0, 2);

        //Right side borderpane
        right = new GridPane();
        //de nodes
        tanken = new Onderdeel("resource/Hoofdmenu/tanken", 0, 35, evaController);

        gps = new Onderdeel("resource/Hoofdmenu/gps", 15, 35, evaController);

        stop = new Onderdeel("resource/Hoofdmenu/stop", 0, 35, evaController);
        //opmaak
        tanken.setFitHeight(60);
        tanken.setFitWidth(60);
        tanken.setTranslateX(-20);
        gps.setFitHeight(60);
        gps.setFitWidth(60);

        stop.setFitHeight(60);
        stop.setFitWidth(60);
        stop.setTranslateX(-20);
        right.setVgap(30);
        right.setPadding(new Insets(20, 50, 20, 20));
        right.setMaxHeight(400);
        right.setMinHeight(400);
        right.setMaxWidth(120);
        right.setMinWidth(120);
        right.setTranslateX(8);
        //de nodes toevoegen
        right.add(tanken, 0, 0);
        right.add(gps, 0, 1);
        right.add(stop, 0, 2);

        //Center borderpane
        center = new GridPane();
        //opmaak center
        center.setHgap(100);
        center.setVgap(50);
        //Deze is opgedeeld in 3 onderdelen: iconen(boven), evaluatie(midden) en attitude(onderaan)
        //iconen boven
        iconen = new GridPane();
        //de nodes
        stad = new Onderdeel("resource/Hoofdmenu/stad", 35, 125, evaController);
        snelweg = new Onderdeel("resource/Hoofdmenu/snelweg", 35, 100, evaController);
        rotonde = new Onderdeel("resource/Hoofdmenu/rotonde", 35, 100, evaController);
        rijstroken = new Onderdeel("resource/Hoofdmenu/rijstroken", 35, 125, evaController);
        //opmaak
        stad.setFitHeight(60);
        stad.setFitWidth(60);
        snelweg.setFitHeight(60);
        snelweg.setFitWidth(60);
        snelweg.setTranslateY(-20);
        rotonde.setFitHeight(60);
        rotonde.setFitWidth(60);
        rotonde.setTranslateY(-20);
        rijstroken.setFitHeight(60);
        rijstroken.setFitWidth(60);
        iconen.setAlignment(Pos.CENTER);
        iconen.setMaxSize(800, 80);
        iconen.setMinSize(800, 80);
        iconen.setPadding(new Insets(5, 5, 5, 5));
        iconen.setHgap(30);
        //nodes toevoegen aan iconen
        iconen.add(stad, 0, 0);
        iconen.add(snelweg, 1, 0);
        iconen.add(rotonde, 2, 0);
        iconen.add(rijstroken, 3, 0);
        //evaluatie midden
        //de nodes
        stuur = new Stuur(evaController, 160);
        pijlen = new Pijlen(evaController, 160);

        //opmaak
        stuur.setTranslateX(205);
        pijlen.setTranslateX(195);

        //eventhandler
        stuur.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                schermController.setScherm(MainApp.RIJTECHNIEK_ID);
            }
        });
        pijlen.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                schermController.setScherm(MainApp.VERKEERSTECHNIEK_ID);
            }
        });

        //alle 3 de onderdelen toevoegen aan center
        //volgorde laten staan! anders werkt schermcontroller niet goed!
        center.add(iconen, 0, 0, 2, 1);
        center.add(pijlen, 1, 1);
        center.add(stuur, 0, 1);

        //Bottom of the borderpane
        bottom = new GridPane();
        //de nodes
        saveImg = new ImageView("resource/Hoofdmenu/save.png");
        graphImg = new Veld4Evolutie(schermController, this.llnController);
        evaSelector = new EvaSelector(evaController);

        //de opmaak
        saveImg.setFitHeight(60);
        saveImg.setFitWidth(60);
        saveImg.setTranslateY(-60);

        graphImg.minWidth(300);
        graphImg.maxWidth(300);
        graphImg.setTranslateX(100);
        graphImg.setTranslateY(-20);
        evaSelector.setTranslateX(-120);
        evaSelector.setTranslateY(-60);
        attitudeImg.setFitHeight(50);
        attitudeImg.setFitWidth(50);

        //de aandacht lijst
        listCommentaar.addAll(llnController.getAandachtsPuntenLijst());

        listViewCommentaar.setItems(listCommentaar);
        listViewCommentaar.setMaxSize(350, 200);
        listViewCommentaar.setMinSize(350, 200);
        listViewCommentaar.setTranslateX(65);
        listViewCommentaar.setTranslateY(-20);
        bottom.setAlignment(Pos.CENTER);

        //de nodes toevoegen      
        bottom.add(evaSelector, 0, 0);
        bottom.add(saveImg, 0, 0);
        bottom.add(listViewCommentaar, 1, 0);
        bottom.add(graphImg, 2, 0);
        //eventhandler
        saveImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                save();
            }
        });

        evaSelector.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                update();
            }
        });
        //achtergrond
        //this.setStyle("-fx-background-image: url('resource/Hoofdmenu/achtergrondHoofdmenu.jpg')");
        achtergrond = new ImageView("resource/Hoofdmenu/achtergrondHoofdmenu.png");
        achtergrond.setFitHeight(hoogte);
        achtergrond.setFitWidth(breedte);
        achtergrond.setTranslateX(breedte / 2 + 8);

        //alle onderdelen toevoegen aan de borderpane
        bp = new BorderPane();
        bp.setTop(top);
        bp.setBottom(bottom);
        bp.setCenter(center);
        bp.setLeft(left);
        bp.setRight(right);
        bp.setTranslateX(-breedte / 2);

        this.getChildren().add(achtergrond);
        this.getChildren().add(bp);
        //opmaak
        this.maxHeight(hoogte);
        this.maxWidth(breedte);
        this.setAlignment(Pos.CENTER);

        top.setAlignment(Pos.CENTER);
        left.setAlignment(Pos.CENTER);
        right.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);
        center.setAlignment(Pos.CENTER);
        center.setTranslateY(-30);

        for (Node node : left.getChildren()) {
            if (node instanceof Onderdeel) {
                node.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent me) {
                        KleurKiezerHouder.show(left, (Onderdeel) node);
                    }
                });
            }
        };

        for (Node node : right.getChildren()) {

            if (node instanceof Onderdeel) {
                node.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent me) {
                        KleurKiezerHouder.show(right, (Onderdeel) node);
                    }
                });
            }
        };

        for (Node node : iconen.getChildren()) {

            if (node instanceof Onderdeel) {
                node.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent me) {
                        KleurKiezerHouder.show(center, (Onderdeel) node);
                    }
                });
            }
        }
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                update();
            }
        });

        update();

        /* //Is voor kleur te veranderen lijst
        listViewCommentaar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                veranderKleurAandachtlijstItem();
            }
        });
         */
        //bandenImg.setOnMousePressed((e) -> KleurKiezerHouder.show(left, bandenImg));
    }

    public void save() {
        System.out.println("test");

        SaveEvaTask t1 = new SaveEvaTask(llnController.getInschrijvingsnr(), 1, llnController.getEva1());
        SaveEvaTask t2 = new SaveEvaTask(llnController.getInschrijvingsnr(), 2, llnController.getEva2());
        SaveEvaTask t3 = new SaveEvaTask(llnController.getInschrijvingsnr(), 3, llnController.getEva3());

        MainApp.service.submit(t1);
        MainApp.service.submit(t2);
        MainApp.service.submit(t3);

        System.out.println("test");
    }

    public void updateOnderdelen() {
        //left
        evaController.loadColorData(schakelaars);
        evaController.loadColorData(vloeistoffen);
        evaController.loadColorData(banden);
        //right
        evaController.loadColorData(gps);
        evaController.loadColorData(stop);
        evaController.loadColorData(tanken);
        //center
        evaController.loadColorData(rotonde);
        evaController.loadColorData(rijstroken);
        evaController.loadColorData(stad);
        evaController.loadColorData(snelweg);
    }

    public void updateEvaSelector() {
        evaSelector.update();
    }

    public void updateGrafiek() {
        graphImg.update();
    }

    public void updateStuurEnPijlen() {
        pijlen.update();
        stuur.update();
    }

    public void updateAandachtsLijst() {
        listCommentaar.clear();
        listCommentaar.addAll(llnController.getAandachtsPuntenLijst());
    }

    /* //Is voor kleur te veranderen lijst
    private void veranderKleurAandachtlijstItem() {
        //toestand 1= wit, 2= blauw
        if ("1".equals(toestand)) 
        {
            listViewCommentaar.setStyle("-fx-background-color: #4682B4;");
            listViewCommentaar.getSelectionModel().getSelectedItem();

            toestand = "2";
        }
        else
        {
            listViewCommentaar.setStyle("-fx-background-color: white;");
            toestand="1";
        }
    }*/
    @Override
    public void update() {
        updateOnderdelen();
        updateEvaSelector();
        updateGrafiek();
        updateStuurEnPijlen();
        updateAandachtsLijst();
    }

}
