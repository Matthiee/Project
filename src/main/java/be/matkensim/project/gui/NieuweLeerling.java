package be.matkensim.project.gui;

import be.matkensim.project.async.AddLeerlingTask;
import be.matkensim.project.async.SaveEvaTask;
import be.matkensim.project.controller.SchermController;
import be.matkensim.project.domein.EvaluatieMoment;
import be.matkensim.project.domein.Leerling;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import be.matkensim.project.persistentie.LeerlingMapper;

public class NieuweLeerling extends StackPane {

    private final SchermController schermController;

    private Label lblNaam, lblInschrijvingsNr, lblInstructeur, lblVerval, lblType, lblInfo;
    private ImageView img;

    private TextField txtNaam, txtInschrijvingsNr, txtInstructeur, txtVerval, txtType;

    private Button btnUpload, btnOpslaan, btnTerug;

    private VBox vbox2, vbox3;
    
    private int hoogte, breedte;

    public NieuweLeerling(SchermController schermController1) {
        setPadding(new Insets(10));

        this.setMaxSize(665, 440);

        schermController = schermController1;
        hoogte = schermController.getHoogte();
        breedte = schermController.getBreedte();

        lblNaam = new Label("Naam: ");
        lblInschrijvingsNr = new Label("Inschrijvingsnr: ");
        lblInstructeur = new Label("Instructeur: ");
        lblVerval = new Label("Verval: ");
        lblType = new Label("Type: ");
        lblInfo = new Label();
        
        lblNaam.setStyle("-fx-text-fill:white");
        lblInschrijvingsNr.setStyle("-fx-text-fill:white");
        lblInstructeur.setStyle("-fx-text-fill:white");
        lblVerval.setStyle("-fx-text-fill:white");
        lblType.setStyle("-fx-text-fill:white");
        lblInfo.setStyle("-fx-text-fill:white");
        
        lblNaam.setMinHeight(30);
        lblInschrijvingsNr.setMinHeight(30);
        lblInstructeur.setMinHeight(30);
        lblVerval.setMinHeight(30);
        lblType.setMinHeight(30);
        lblInfo.setMinHeight(30);
        lblNaam.setMaxHeight(30);
        lblInschrijvingsNr.setMaxHeight(30);
        lblInstructeur.setMaxHeight(30);
        lblVerval.setMaxHeight(30);
        lblType.setMaxHeight(30);
        lblInfo.setMaxHeight(30);

        txtInschrijvingsNr = new TextField();
        txtNaam = new TextField();
        txtInstructeur = new TextField();
        txtVerval = new TextField();
        txtType = new TextField();
        
        txtInschrijvingsNr.setMinHeight(30);
        txtNaam.setMinHeight(30);
        txtInstructeur.setMinHeight(30);
        txtVerval.setMinHeight(30);
        txtType.setMinHeight(30);
        txtInschrijvingsNr.setMaxHeight(30);
        txtNaam.setMaxHeight(30);
        txtInstructeur.setMaxHeight(30);
        txtVerval.setMaxHeight(30);
        txtType.setMaxHeight(30);
        
        txtInschrijvingsNr.setStyle("-fx-background-color:#789EBF; -fx-text-fill:white");
        txtNaam.setStyle("-fx-background-color:#789EBF; -fx-text-fill:white");
        txtInstructeur.setStyle("-fx-background-color:#789EBF; -fx-text-fill:white");
        txtVerval.setStyle("-fx-background-color:#789EBF; -fx-text-fill:white");
        txtType.setStyle("-fx-background-color:#789EBF; -fx-text-fill:white");

        img = new ImageView("resource/man-icon.png");

        btnUpload = new Button("Kies foto");
        btnOpslaan = new Button("Opslaan");
        btnTerug = new Button("Terug");
        
        btnUpload.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");
        btnOpslaan.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");
        btnTerug.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");

        VBox vbox1 = new VBox(15, lblNaam, lblInschrijvingsNr, lblInstructeur, lblVerval, lblType);
        vbox1.setPadding(new Insets(10));

        HBox hboxKnoppen = new HBox(10, btnUpload, btnOpslaan, btnTerug);

        vbox2 = new VBox(15, txtNaam, txtInschrijvingsNr, txtInstructeur, txtVerval, txtType, lblInfo, hboxKnoppen);
        vbox1.setPadding(new Insets(10));

        lblInfo.setVisible(false);

        vbox3 = new VBox(15, img);
        vbox1.setPadding(new Insets(10));
        vbox3.setAlignment(Pos.BASELINE_RIGHT);
        
        vbox1.setTranslateY(70);
        vbox2.setTranslateY(80);
        vbox3.setTranslateY(100);

        HBox holder = new HBox(30, vbox1, vbox2, vbox3);
        holder.setPadding(new Insets(10));
        HBox.setHgrow(holder, Priority.ALWAYS);
        holder.setPadding(new Insets(10));
        holder.setMaxSize(665, 440);
        holder.setAlignment(Pos.CENTER);
        holder.setStyle("-fx-border-color: #282E54; -fx-border-radius: 10 10 10 10;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-color: #282B3A;"
                + "-fx-background-radius: 5;");

        this.getChildren().add(holder);
        this.setStyle("-fx-background-image: url('resource/achtergrondStandaard.png')");
        this.setAlignment(Pos.CENTER);
        this.setMinSize(breedte, hoogte);
        this.setMinSize(breedte, hoogte);

        //events
        btnOpslaan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                opslaan();
            }
        });
        btnTerug.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ((View) schermController.getScherm(MainApp.LOGIN_ID)).update(); // work around om MVC view update te forceren!

                schermController.setScherm(MainApp.LOGIN_ID);
            }
        });

        btnUpload.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                uploadFoto();
                img.setFitHeight(125);
                img.setFitWidth(125);
            }
        });

        for (Node n : vbox2.getChildren()) {
            if (n instanceof TextField) {
                ((TextField) n).textProperty().addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable e) {
                        lblInfo.setVisible(false);
                    }
                });
            }
        }
    }

    private void opslaan() {
        if (checkVelden()) {
            lblInfo.setVisible(false);

            Leerling lln = new Leerling(
                    txtNaam.getText(),
                    txtInschrijvingsNr.getText(),
                    txtInstructeur.getText(),
                    new Date(),
                    txtType.getText(),
                    img.getImage());
            
            lln.setEva1(new EvaluatieMoment());
            lln.setEva2(new EvaluatieMoment());
            lln.setEva3(new EvaluatieMoment());

            AddLeerlingTask task = new AddLeerlingTask(lln);

            task.setOnSucceeded(e -> {
                clear();

                SaveEvaTask t1 = new SaveEvaTask(lln.getInschrijvingsnr(), 1, lln.getEva1());
                SaveEvaTask t2 = new SaveEvaTask(lln.getInschrijvingsnr(), 2, lln.getEva2());
                SaveEvaTask t3 = new SaveEvaTask(lln.getInschrijvingsnr(), 3, lln.getEva3());

                MainApp.service.submit(t1);
                MainApp.service.submit(t2);
                MainApp.service.submit(t3);
                
                lblInfo.setText("Leerling opgeslagen!");
                lblInfo.setTextFill(Color.DARKGREEN);
                lblInfo.setVisible(true);
                vbox3.getChildren().clear();
                vbox3.getChildren().add(new ImageView("resource/man-icon.png"));
            });
            task.setOnFailed(e -> {
                lblInfo.setText("Fout bij het toevoegen van de leerling!");
                lblInfo.setTextFill(Color.DARKRED);
                lblInfo.setVisible(true);
            });

            MainApp.service.submit(task);
        } else {
            lblInfo.setVisible(true);
        }
    }

    private boolean checkVelden() {
        if (txtNaam.getText().isEmpty() || txtInschrijvingsNr.getText().isEmpty() || txtInstructeur.getText().isEmpty() || txtType.getText().isEmpty() || txtVerval.getText().isEmpty()) {
            lblInfo.setText("Niet alle velden ingevuld!");
            lblInfo.setTextFill(Color.DARKRED);
            return false;
        } else {
            return true;
        }
    }

    private void clear() {
        for (Node n : vbox2.getChildren()) {
            if (n instanceof TextField) {
                ((TextField) n).clear();
            }
        }
    }

    private void uploadFoto() {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                img.setImage(image);

                vbox3.getChildren().clear();
                vbox3.getChildren().add(img);
            } catch (IOException ex) {
                Logger.getLogger(NieuweLeerling.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
