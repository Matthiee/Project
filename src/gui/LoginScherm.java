package gui;

import controller.SchermController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Kenzo
 */
public class LoginScherm extends Pane
{
    private final SchermController schermController;
    
    private ImageView img;
    private TextField txtNaam;
    private Button btnZoek, btnDoorgaan;
    private ListView<String> lvNamen;
    private ObservableList<String> namen;
    private Label lblInfo;
    
    public LoginScherm(SchermController schermCtrl) 
    {
        setPadding(new Insets(10));
        
        schermController = schermCtrl;
        this.maxHeight(800);
        this.maxWidth(1200);
        this.setPrefSize(1200, 800);
        lblInfo = new Label("");
        img = new ImageView("resource/man-icon.png");
        btnDoorgaan=new Button("Doorgaan");
        btnZoek=new Button("Zoek");
        txtNaam=new TextField();
        namen =FXCollections.emptyObservableList();
        lvNamen=new ListView<>(namen);
        
        HBox hbox = new HBox(10, btnZoek, btnDoorgaan);
        
        VBox vbox = new VBox(10, txtNaam, lblInfo, hbox);
        vbox.setPadding(new Insets(10));
        
        
        
        HBox holder = new HBox(10, img, vbox, lvNamen);
        holder.setPadding(new Insets(10));
        
        holder.setStyle("-fx-border-color: black;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-color: lightgray;"
                + "-fx-background-radius: 5;");
        
        holder.setAlignment(Pos.CENTER);
        
        getChildren().addAll(holder);
        
    }    
}
