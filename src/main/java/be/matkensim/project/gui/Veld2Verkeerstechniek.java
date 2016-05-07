package be.matkensim.project.gui;

import be.matkensim.project.controller.EvaController;
import be.matkensim.project.controller.LeerlingController;
import be.matkensim.project.controller.SchermController;
import java.util.function.Consumer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Veld2Verkeerstechniek extends HBox implements View {

    //de controllers
    private final SchermController schermController;
    private final EvaController evaController;
    private final LeerlingController llnController;
    //Afbeeldingen
    private Onderdeel afstandImg, inhalenImg, kruisenImg, linksafImg, rechtsafImg, openbareWegImg,
            richtingaanwijzersImg, snelheidImg, verkeerstekensImg, voorrangImg;
    private ImageView achtergrond;
    //GridPanes
    private GridPane links, rechts, mainGP;
    private Pijlen pijlen;
    //button
    private Button exit;
    //evaselector
    private EvaSelector eva;
    //labels
    private Button kleur, venster;
    private HBox labels;
    private int labelSelected;
    //hoogte breedte scherm
    private int hoogte, breedte;

    public Veld2Verkeerstechniek(LeerlingController llnCntrl, SchermController schermCtrl, EvaController evaCtrl) {
        evaController = evaCtrl;
        schermController = schermCtrl;
        llnController = llnCntrl;
        llnController.getLeerling().addView(this);
        hoogte = schermController.getHoogte();
        breedte = schermController.getBreedte();
        mainGP = new GridPane();

        //evaSelector
        eva = new EvaSelector(evaController);

        //labels
        kleur = new Button("Kleur kiezen");
        venster = new Button("Extra vensters");

        kleur.setMinSize(120, 30);
        kleur.setMaxSize(120, 30);
        venster.setMinSize(120, 30);
        venster.setMaxSize(120, 30);

        kleur.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: WHITE");
        kleur.setAlignment(Pos.CENTER);
        venster.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: WHITE");
        venster.setAlignment(Pos.CENTER);

        kleur.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                selecteerKleur();
            }
        });
        venster.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                selecteerVenster();
            }
        });

        labels = new HBox();
        labels.setSpacing(15);
        labels.setTranslateY(-hoogte * 0.75);
        labels.setTranslateX(20);
        labels.getChildren().addAll(kleur, venster);

        //alle afbeeldingen
        //Links
        links = new GridPane();
        openbareWegImg = new Onderdeel("resource/Verkeerstechniek/openbareWeg", -140, 160, evaController);
        openbareWegImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKPLAATS_ID);
            }
        });
        richtingaanwijzersImg = new Onderdeel("resource/Verkeerstechniek/richtingaanwijzers", 120, 140, evaController);
        richtingaanwijzersImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKRICHTINGAANWIJZERS_ID);
            }
        });
        rechtsafImg = new Onderdeel("resource/Verkeerstechniek/rechtsaf", 220, 160, evaController);
        rechtsafImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKRECHTSAF_ID);
            }
        });
        linksafImg = new Onderdeel("resource/Verkeerstechniek/linksaf", 120, 190, evaController);
        linksafImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKLINKSAF_ID);
            }
        });
        kruisenImg = new Onderdeel("resource/Verkeerstechniek/kruisen", 60, 155, evaController);
        kruisenImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKKRUISEN_ID);
            }
        });
        //Rechts
        rechts = new GridPane();
        voorrangImg = new Onderdeel("resource/Verkeerstechniek/voorrang", -140, 160, evaController);
        voorrangImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKVOORRANG_ID);
            }
        });
        verkeerstekensImg = new Onderdeel("resource/Verkeerstechniek/verkeerstekens", -25, 140, evaController);
        verkeerstekensImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKVERKEERSTEKENS_ID);
            }
        });
        snelheidImg = new Onderdeel("resource/Verkeerstechniek/snelheid", 30, 155, evaController);
        snelheidImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKSNELHEID_ID);
            }
        });
        afstandImg = new Onderdeel("resource/Verkeerstechniek/afstand", -25, 190, evaController);
        afstandImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKAFSTAND_ID);
            }
        });
        inhalenImg = new Onderdeel("resource/Verkeerstechniek/inhalen", 220, 160, evaController);
        inhalenImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKINHALEN_ID);
            }
        });
        //pijlen center
        pijlen = new Pijlen(evaController, 300);

        //GridPane links
        links.add(inhalenImg, 0, 0);
        links.add(richtingaanwijzersImg, 0, 1);
        links.add(kruisenImg, 0, 2);
        links.add(linksafImg, 0, 3);
        links.add(rechtsafImg, 0, 4);

        //GridPane rechts
        rechts.add(voorrangImg, 0, 0);
        rechts.add(verkeerstekensImg, 0, 1);
        rechts.add(snelheidImg, 0, 2);
        rechts.add(afstandImg, 0, 3);
        rechts.add(openbareWegImg, 0, 4);

        //opmaak
        //algemeen
        mainGP.setHgap(50);
        //links
        links.setAlignment(Pos.CENTER);
        links.setVgap(20);
        links.setMaxWidth(80);
        inhalenImg.setFitHeight(80);
        inhalenImg.setFitWidth(80);
        inhalenImg.setTranslateX(180);
        richtingaanwijzersImg.setFitHeight(80);
        richtingaanwijzersImg.setFitWidth(80);
        richtingaanwijzersImg.setTranslateX(75);
        richtingaanwijzersImg.setTranslateY(-30);
        kruisenImg.setFitHeight(80);
        kruisenImg.setFitWidth(80);
        kruisenImg.setTranslateX(10);
        linksafImg.setFitHeight(80);
        linksafImg.setFitWidth(80);
        linksafImg.setTranslateX(75);
        linksafImg.setTranslateY(30);
        rechtsafImg.setFitHeight(80);
        rechtsafImg.setFitWidth(80);
        rechtsafImg.setTranslateX(180);
        //rechts
        rechts.setAlignment(Pos.CENTER);
        rechts.setVgap(20);
        rechts.setMaxWidth(80);
        voorrangImg.setFitHeight(80);
        voorrangImg.setFitWidth(80);
        voorrangImg.setTranslateX(-180);
        verkeerstekensImg.setFitHeight(80);
        verkeerstekensImg.setFitWidth(80);
        verkeerstekensImg.setTranslateX(-75);
        verkeerstekensImg.setTranslateY(-30);
        snelheidImg.setFitHeight(80);
        snelheidImg.setFitWidth(80);
        snelheidImg.setTranslateX(-10);
        afstandImg.setFitHeight(80);
        afstandImg.setFitWidth(80);
        afstandImg.setTranslateX(-75);
        afstandImg.setTranslateY(30);
        openbareWegImg.setFitHeight(80);
        openbareWegImg.setFitWidth(80);
        openbareWegImg.setTranslateX(-180);
        //pijlen center
        pijlen.setAlignment(Pos.CENTER);
        pijlen.setTranslateY(10);

        //Exit button
        exit = new Button("ga terug");
        exit.setTranslateX(50);
        exit.setTranslateY(75);

        eva.setTranslateX(-50);
        eva.setTranslateY(75);

        //eventhandler
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                exitVerkeerstechniek();
            }
        });
        exit.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");

        for (Node c : links.getChildren()) {
            if (c instanceof Onderdeel) {
                c.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        KleurKiezerHouder.show(links, (Onderdeel) c);
                    }
                });
            }
        }
        
        for (Node c : rechts.getChildren()) {
            if (c instanceof Onderdeel) {
                c.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        KleurKiezerHouder.show(rechts, (Onderdeel) c);
                    }
                });
            }
        }
        
        eva.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                update();
            }
        });
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                update();
            }
        });

        //achtergrond
        achtergrond = new ImageView("resource/Verkeerstechniek/achtergrondVt.png");
        achtergrond.setTranslateX(breedte / 2);
        mainGP.setTranslateX(-breedte * 0.53);
        mainGP.setTranslateY(5);
        mainGP.setMinWidth(breedte);
        mainGP.setMaxWidth(breedte);

        //Alle Gridpanes toevoegen an hoofd GridPane
        //volgorde is belangrijk, niet aanpassen!
        mainGP.add(pijlen, 2, 0);
        mainGP.add(rechts, 3, 0);
        mainGP.add(links, 1, 0);
        mainGP.add(exit, 3, 1);
        mainGP.add(labels, 2, 1);
        mainGP.add(eva, 1, 1);
        mainGP.setAlignment(Pos.CENTER);
        //mainGP.setStyle("-fx-background-color: #003399");

        this.getChildren().add(achtergrond);
        this.getChildren().add(mainGP);
        this.setAlignment(Pos.CENTER);

        selecteerKleur();
        update();
    }

    public void exitVerkeerstechniek() {
        llnController.getLeerling().update();
        this.schermController.setScherm(MainApp.HOOFDMENU_ID);
    }

    public void selecteerKleur() {
        venster.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");
        kleur.setStyle("-fx-background-color: GREEN; -fx-text-fill:white");
        labelSelected = 0;

        for (Node c : links.getChildren()) {
            if (c instanceof Onderdeel) {
                c.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        KleurKiezerHouder.show(links, (Onderdeel) c);
                    }
                });
            }
        }

        for (Node c : rechts.getChildren()) {
            if (c instanceof Onderdeel) {
                c.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        KleurKiezerHouder.show(rechts, (Onderdeel) c);
                    }
                });
            }
        }
        
        eva.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                update();
            }
        });
    }

    public void selecteerVenster() {
        venster.setStyle("-fx-background-color: GREEN; -fx-text-fill:white");
        kleur.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");
        labelSelected = 1;

        openbareWegImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKPLAATS_ID);
            }
        });
        richtingaanwijzersImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKRICHTINGAANWIJZERS_ID);
            }
        });
        rechtsafImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKRECHTSAF_ID);
            }
        });
        linksafImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKLINKSAF_ID);
            }
        });
        kruisenImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKKRUISEN_ID);
            }
        });
        voorrangImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKVOORRANG_ID);
            }
        });
        verkeerstekensImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKVERKEERSTEKENS_ID);
            }
        });
        snelheidImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKSNELHEID_ID);
            }
        });
        afstandImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKAFSTAND_ID);
            }
        });
        inhalenImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld2Verkeerstechniek.this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKINHALEN_ID);
            }
        });
    }

    public void updateLabels() {
        if (labelSelected == 0) {
            selecteerKleur();
        }
        if (labelSelected == 1) {
            selecteerVenster();
        }
    }

    public void updateOnderdelen() {
        evaController.loadColorData(openbareWegImg);
        evaController.loadColorData(richtingaanwijzersImg);
        evaController.loadColorData(rechtsafImg);
        evaController.loadColorData(linksafImg);
        evaController.loadColorData(kruisenImg);
        evaController.loadColorData(voorrangImg);
        evaController.loadColorData(verkeerstekensImg);
        evaController.loadColorData(afstandImg);
        evaController.loadColorData(inhalenImg);
    }

    public void updateEvaSelector() {
        eva.update();
    }

    public void updatePijlen() {
        pijlen.update();
    }

    @Override
    public void update() {
        updateOnderdelen();
        updateLabels();
        updateEvaSelector();
        updatePijlen();
    }
}
