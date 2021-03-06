package be.matkensim.project.gui;

import be.matkensim.project.controller.EvaController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Stuur extends GridPane {

    private EvaController evaController;

    private final ImageView stuur1, stuur2, stuur3;
    private int zijde;

    //Images voor stuur
    Image stuur1Neutraal = new Image("resource/Stuur/stuur1Neutraal.png");
    Image stuur1Groen = new Image("resource/Stuur/stuur1Groen.png");
    Image stuur1Oranje = new Image("resource/Stuur/stuur1Oranje.png");
    Image stuur1Rood = new Image("resource/Stuur/stuur1Rood.png");

    Image stuur2Neutraal = new Image("resource/Stuur/stuur2Neutraal.png");
    Image stuur2Groen = new Image("resource/Stuur/stuur2Groen.png");
    Image stuur2Oranje = new Image("resource/Stuur/stuur2Oranje.png");
    Image stuur2Rood = new Image("resource/Stuur/stuur2Rood.png");

    Image stuur3Neutraal = new Image("resource/Stuur/stuur3Neutraal.png");
    Image stuur3Groen = new Image("resource/Stuur/stuur3Groen.png");
    Image stuur3Oranje = new Image("resource/Stuur/stuur3Oranje.png");
    Image stuur3Rood = new Image("resource/Stuur/stuur3Rood.png");

    public Stuur(EvaController evaCtrl, int size) {
        evaController = evaCtrl;

        zijde = size;

        stuur1 = new ImageView("resource/Stuur/stuur1Neutraal.png");
        stuur2 = new ImageView("resource/Stuur/stuur2Neutraal.png");
        stuur3 = new ImageView("resource/Stuur/stuur3Neutraal.png");

        stuur1.setFitHeight(zijde / 2);
        stuur1.setFitWidth(zijde);
        stuur2.setFitHeight(zijde / 2);
        stuur2.setFitWidth(zijde / 2);
        stuur3.setFitHeight(zijde / 2);
        stuur3.setFitWidth(zijde / 2);

        this.setMinSize(zijde, zijde);
        this.setMaxSize(zijde, zijde);

        this.add(stuur1, 0, 0, 2, 1);
        this.add(stuur2, 0, 1);
        this.add(stuur3, 1, 1);

        update();
    }

    public void update() {
        int stuur[] = evaController.loadStuur();

        //stuur1
        if (stuur[0] == 0) {
            stuur1.setImage(stuur1Neutraal);
        }
        if (stuur[0] == 1) {
            stuur1.setImage(stuur1Groen);
        }
        if (stuur[0] == 2) {
            stuur1.setImage(stuur1Oranje);
        }
        if (stuur[0] == 3) {
            stuur1.setImage(stuur1Rood);
        }
        //stuur2
        if (stuur[1] == 0) {
            stuur2.setImage(stuur2Neutraal);
        }
        if (stuur[1] == 1) {
            stuur2.setImage(stuur2Groen);
        }
        if (stuur[1] == 2) {
            stuur2.setImage(stuur2Oranje);
        }
        if (stuur[1] == 3) {
            stuur2.setImage(stuur2Rood);
        }
        //stuur3
        if (stuur[2] == 0) {
            stuur3.setImage(stuur3Neutraal);
        }
        if (stuur[2] == 1) {
            stuur3.setImage(stuur3Groen);
        }
        if (stuur[2] == 2) {
            stuur3.setImage(stuur3Oranje);
        }
        if (stuur[2] == 3) {
            stuur3.setImage(stuur3Rood);
        }
    }
}
