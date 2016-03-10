package gui;

import controller.SchermController;
import domein.Leerling;
import java.util.Date;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import persistentie.LeerlingMapper;

/**
 *
 * @author Kenzo
 * @author Matthias
 */
public class NieuweLeerling extends StackPane {

    private final SchermController schermController;

    private Label lblNaam, lblInschrijvingsNr, lblInstructeur, lblVerval, lblType, lblInfo;
    private ImageView img;

    private TextField txtNaam, txtInschrijvingsNr, txtInstructeur, txtVerval, txtType;

    private Button btnOpslaan, btnTerug;

    private VBox vbox2;

    public NieuweLeerling(SchermController schermController1) {
        setPadding(new Insets(10));

        
        
        this.setMaxSize(665, 440); 
 
        schermController = schermController1;

        lblNaam = new Label("Naam: ");
        lblInschrijvingsNr = new Label("Inschrijvingsnr: ");
        lblInstructeur = new Label("Instructeur: ");
        lblVerval = new Label("Verval: ");
        lblType = new Label("Type: ");
        lblInfo = new Label();

        txtInschrijvingsNr = new TextField();
        txtNaam = new TextField();
        txtInstructeur = new TextField();
        txtVerval = new TextField();
        txtType = new TextField();

        img = new ImageView("resource/man-icon.png");

        btnOpslaan = new Button("Opslaan");
        btnTerug = new Button("Terug");

        VBox vbox1 = new VBox(15, lblNaam, lblInschrijvingsNr, lblInstructeur, lblVerval, lblType);
        vbox1.setPadding(new Insets(10));

        HBox hboxKnoppen = new HBox(10, btnOpslaan, btnTerug);

        vbox2 = new VBox(10, txtNaam, txtInschrijvingsNr, txtInstructeur, txtVerval, txtType, lblInfo, hboxKnoppen);
        vbox1.setPadding(new Insets(10));

        lblInfo.setVisible(false);

        VBox vbox3 = new VBox(10, img);
        vbox1.setPadding(new Insets(10));
        vbox3.setAlignment(Pos.BASELINE_RIGHT);

        HBox holder = new HBox(10, vbox1, vbox2, vbox3);
        holder.setPadding(new Insets(10));
        HBox.setHgrow(holder, Priority.ALWAYS);
        holder.setStyle("-fx-border-color: black;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-color: lightgray;"
                + "-fx-background-radius: 5;");

        this.getChildren().add(holder);

        //events
        btnOpslaan.setOnAction(e -> opslaan());
        btnTerug.setOnAction(e -> {
            
            ((View)schermController.getScherm(MainApp.LOGIN_ID)).update(); // work around om MVC view update te forceren!
            
            schermController.setScherm(MainApp.LOGIN_ID);
        });

        for (Node n : vbox2.getChildren()) {
            if (n instanceof TextField) {
                ((TextField) n).textProperty().addListener((e) -> lblInfo.setVisible(false));
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

            if (LeerlingMapper.voegLeerlingToe(lln)) {
                clear();

                lblInfo.setText("Leerling opgeslagen!");
                lblInfo.setTextFill(Color.DARKGREEN);
                lblInfo.setVisible(true);

            } else {
                lblInfo.setText("Fout bij het toevoegen van de leerling!");
                lblInfo.setTextFill(Color.DARKRED);
                lblInfo.setVisible(true);
            }
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
    
    public void update(){
        
    }

}
