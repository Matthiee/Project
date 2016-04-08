package be.matkensim.project.gui;

import be.matkensim.project.controller.EvaController;
import be.matkensim.project.controller.LeerlingController;
import be.matkensim.project.controller.SchermController;
import java.util.function.Consumer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Veld1Rijtechniek extends HBox implements View {

    //de controllers
    private final SchermController schermController;
    private final LeerlingController llnController;
    private EvaController evaController;
    //Afbeeldingen
    private Onderdeel hellingImg, houdingImg, kijkImg, koppelingImg, remImg, schakelImg, stuurImg;
    private Onderdeel stuuroefImg, achteruitImg, garageImg, kerenImg, parkerenImg;
    private Stuur stuur;
    //GridPanes
    private GridPane links;
    private GridPane rechts;
    private GridPane mainGP;
    //button
    private Button exit;
    //evaSelector
    private EvaSelector evaSelector;
    //achtergrond
    private ImageView achtergrond;
    //hoogte en breedte scherm
    private int hoogte, breedte;
    //labels
    private Label kleur, venster;
    private int labelSelected;
    private HBox labels;

    public Veld1Rijtechniek(LeerlingController llnCntrl, SchermController schermCtrl, EvaController evaCtrl) {
        schermController = schermCtrl;
        evaController = evaCtrl;
        llnController = llnCntrl;
        llnController.getLeerling().addView(this);
        hoogte = schermController.getHoogte();
        breedte = schermController.getBreedte();
        mainGP = new GridPane();

        //labels
        kleur = new Label("Kleur kiezen");
        venster = new Label("Extra vensters");

        kleur.setMinSize(80, 30);
        kleur.setMaxSize(80, 30);
        venster.setMinSize(80, 30);
        venster.setMaxSize(80, 30);

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
        labels.setTranslateY(-hoogte * 0.83);
        labels.setTranslateX(21);
        labels.getChildren().addAll(kleur, venster);

        //alle afbeeldingen aanmaken
        //Links
        links = new GridPane();
        remImg = new Onderdeel("resource/Rijtechniek/rem", 215, 170, evaController);
        koppelingImg = new Onderdeel("resource/Rijtechniek/koppeling", 110, 147, evaController);
        houdingImg = new Onderdeel("resource/Rijtechniek/houding", 30, 147, evaController);
        hellingImg = new Onderdeel("resource/Rijtechniek/helling", 30, 147, evaController);
        stuuroefImg = new Onderdeel("resource/Rijtechniek/stuuroef", 110, 147, evaController);
        achteruitImg = new Onderdeel("resource/Rijtechniek/achteruit", 215, 117, evaController);
        remImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld1Rijtechniek.this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKREMTECHNIEK_ID);
            }
        });
        koppelingImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld1Rijtechniek.this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKKOPPELING_ID);
            }
        });
        houdingImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld1Rijtechniek.this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKHOUDING_ID);
            }
        });
        //Rechts
        rechts = new GridPane();
        stuurImg = new Onderdeel("resource/Rijtechniek/stuur", -135, 170, evaController);
        schakelImg = new Onderdeel("resource/Rijtechniek/schakel", -25, 147, evaController);
        kijkImg = new Onderdeel("resource/Rijtechniek/kijk", 40, 147, evaController);
        parkerenImg = new Onderdeel("resource/Rijtechniek/parkeren", 40, 147, evaController);
        kerenImg = new Onderdeel("resource/Rijtechniek/keren", -25, 147, evaController);
        garageImg = new Onderdeel("resource/Rijtechniek/garage", -135, 117, evaController);
        stuurImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld1Rijtechniek.this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKSTUURTECHNIEK_ID);
            }
        });
        schakelImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld1Rijtechniek.this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKSCHAKELTECHNIEK_ID);
            }
        });
        kijkImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld1Rijtechniek.this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKKIJKTECHNIEK_ID);
            }
        });
        //Stuur center
        stuur = new Stuur(evaController, 250);

        //GridPane links
        links.add(remImg, 0, 0);
        links.add(koppelingImg, 0, 1);
        links.add(houdingImg, 0, 2);
        links.add(hellingImg, 0, 3);
        links.add(stuuroefImg, 0, 4);
        links.add(achteruitImg, 0, 5);

        //GridPane rechts
        rechts.add(stuurImg, 0, 0);
        rechts.add(schakelImg, 0, 1);
        rechts.add(kijkImg, 0, 2);
        rechts.add(parkerenImg, 0, 3);
        rechts.add(kerenImg, 0, 4);
        rechts.add(garageImg, 0, 5);

        //Opmaak
        //algemeen
        mainGP.setHgap(50);
        mainGP.setPadding(new Insets(50, 50, 50, 50));
        //links
        links.setAlignment(Pos.CENTER);
        links.setVgap(30);
        links.setMaxWidth(50);
        remImg.setFitHeight(70);
        remImg.setFitWidth(70);
        remImg.setTranslateX(180);
        remImg.setTranslateY(30);
        koppelingImg.setFitHeight(70);
        koppelingImg.setFitWidth(70);
        koppelingImg.setTranslateX(75);
        houdingImg.setFitHeight(70);
        houdingImg.setFitWidth(70);
        hellingImg.setFitHeight(70);
        hellingImg.setFitWidth(70);
        stuuroefImg.setFitHeight(70);
        stuuroefImg.setFitWidth(70);
        stuuroefImg.setTranslateX(75);
        achteruitImg.setFitHeight(70);
        achteruitImg.setFitWidth(70);
        achteruitImg.setTranslateX(180);
        achteruitImg.setTranslateY(-30);
        //Rechts
        rechts.setAlignment(Pos.CENTER);
        rechts.setVgap(30);
        rechts.setMaxWidth(50);
        stuurImg.setFitHeight(70);
        stuurImg.setFitWidth(70);
        stuurImg.setTranslateX(-180);
        stuurImg.setTranslateY(30);
        schakelImg.setFitHeight(70);
        schakelImg.setFitWidth(70);
        schakelImg.setTranslateX(-75);
        kijkImg.setFitHeight(70);
        kijkImg.setFitWidth(70);
        parkerenImg.setFitHeight(70);
        parkerenImg.setFitWidth(70);
        kerenImg.setFitHeight(70);
        kerenImg.setFitWidth(70);
        kerenImg.setTranslateX(-75);
        garageImg.setFitHeight(70);
        garageImg.setFitWidth(70);
        garageImg.setTranslateX(-180);
        garageImg.setTranslateY(-30);
        //Stuur center
        stuur.setAlignment(Pos.CENTER);
        stuur.setTranslateX(-15);

        //exit button + evaSelector
        exit = new Button("ga terug");
        evaSelector = new EvaSelector(evaController);
        evaSelector.setTranslateX(-50);
        exit.setTranslateX(50);
        //eventhandeler
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                exitRijtechniek();
            }
        });

        //Achtergrond
        achtergrond = new ImageView("resource/Rijtechniek/achtergrondRijtechniek.png");

        //Alle GridPanes toevoegen aan hoofd GridPane
        //moet in deze volgorde anders werkt kleurkiezer niet!!!!
        mainGP.add(stuur, 2, 0);
        mainGP.add(rechts, 3, 0);
        mainGP.add(links, 1, 0);
        mainGP.add(exit, 3, 1);
        mainGP.add(evaSelector, 1, 1);
        mainGP.add(labels, 2, 1);
        mainGP.setAlignment(Pos.CENTER);
        mainGP.setMaxSize(schermCtrl.getBreedte(), schermCtrl.getHoogte());
        mainGP.setMinSize(schermCtrl.getBreedte(), schermCtrl.getHoogte());
        mainGP.setTranslateX(-20);

        achtergrond.setTranslateX(breedte / 2);
        mainGP.setTranslateX(-breedte / 2 - 30);
        mainGP.setTranslateY(15);

        this.getChildren().add(achtergrond);
        this.getChildren().add(mainGP);

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

        evaSelector.setOnMouseClicked(new EventHandler<MouseEvent>() {
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

        selecteerKleur();
        update();
    }

    public void exitRijtechniek() {
        llnController.getLeerling().update();
        this.schermController.setScherm(MainApp.HOOFDMENU_ID);
    }

    public void selecteerKleur() {
        venster.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: WHITE");
        kleur.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: GREEN");
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
        
        evaSelector.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                update();
            }
        });

        stuuroefImg.setVisible(true);
        achteruitImg.setVisible(true);
        garageImg.setVisible(true);
        kerenImg.setVisible(true);
        parkerenImg.setVisible(true);
    }

    public void selecteerVenster() {
        venster.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: GREEN");
        kleur.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: WHITE");
        labelSelected = 1;

        remImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld1Rijtechniek.this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKREMTECHNIEK_ID);
            }
        });
        koppelingImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld1Rijtechniek.this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKKOPPELING_ID);
            }
        });
        houdingImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld1Rijtechniek.this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKHOUDING_ID);
            }
        });
        stuurImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld1Rijtechniek.this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKSTUURTECHNIEK_ID);
            }
        });
        schakelImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld1Rijtechniek.this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKSCHAKELTECHNIEK_ID);
            }
        });
        kijkImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld1Rijtechniek.this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKKIJKTECHNIEK_ID);
            }
        });
        hellingImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Veld1Rijtechniek.this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKHELLING_ID);
            }
        });
        stuuroefImg.setVisible(false);
        achteruitImg.setVisible(false);
        garageImg.setVisible(false);
        kerenImg.setVisible(false);
        parkerenImg.setVisible(false);
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
        evaController.loadColorData(stuuroefImg);
        evaController.loadColorData(kerenImg);
        evaController.loadColorData(achteruitImg);
        evaController.loadColorData(parkerenImg);
        evaController.loadColorData(garageImg);
        evaController.loadColorData(remImg);
        evaController.loadColorData(koppelingImg);
        evaController.loadColorData(houdingImg);
        evaController.loadColorData(hellingImg);
        evaController.loadColorData(stuurImg);
        evaController.loadColorData(schakelImg);
        evaController.loadColorData(kijkImg);
    }

    public void updateEvaSelector() {
        evaSelector.update();
    }

    public void updateStuur() {
        stuur.update();
    }

    @Override
    public void update() {
        updateOnderdelen();
        updateEvaSelector();
        updateLabels();
        updateStuur();
    }
}
