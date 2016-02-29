package gui;

import controller.SchermController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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

    public NieuweLeerling(SchermController schermController1) {
        setPadding(new Insets(10));

        this.setMaxSize(645, 440);
        
        schermController = schermController1;

        lblNaam = new Label("Naam: ");
        lblInschrijvingsNr = new Label("Inschrijvingsnr: ");
        lblInstructeur = new Label("Instructeur: ");
        lblVerval = new Label("Verval: ");
        lblType = new Label("Type: ");
        lblInfo = new Label();
        lblInfo.setTextFill(Color.RED);

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
        
        VBox vbox2 = new VBox(10, txtNaam, txtInschrijvingsNr, txtInstructeur, txtVerval, txtType, lblInfo, hboxKnoppen);
        vbox1.setPadding(new Insets(10));
        
        
        VBox vbox3 = new VBox(10, img);
        vbox1.setPadding(new Insets(10));
        vbox3.setAlignment(Pos.BASELINE_RIGHT);
        
        HBox holder = new HBox(10, vbox1,vbox2, vbox3);
        holder.setPadding(new Insets(10));
        HBox.setHgrow(holder, Priority.ALWAYS);
        holder.setStyle("-fx-border-color: black;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-color: lightgray;"
                + "-fx-background-radius: 5;");
        
        this.getChildren().add(holder);
    }

}
