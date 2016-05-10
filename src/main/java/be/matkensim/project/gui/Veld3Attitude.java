package be.matkensim.project.gui;

import be.matkensim.project.controller.EvaController;
import be.matkensim.project.controller.LeerlingController;
import be.matkensim.project.controller.SchermController;
import be.matkensim.project.domein.Attitude;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class Veld3Attitude extends VBox implements View {

    //toonTable is de table die moet getoond worden
    private final SchermController schermController;
    private EvaController evaController;
    private LeerlingController llnController;
    private Button aandachtBtn,exit;
    private TableView<String> list = new TableView<String>();
    private ObservableList<String> attitudes = FXCollections.observableArrayList();
    private ObservableList<String> toonAttitudes = FXCollections.observableArrayList();
    
    private ImageView img = new ImageView("resource/Hoofdmenu/attitude.png");
    private Label titel = new Label("Attitude");
    private Label geselecteerd = new Label("  Geselecteerd:");

    private VBox vBox1 = new VBox();
    private VBox vBox2 = new VBox();
    private HBox hBox1 = new HBox();
    private GridPane gp = new GridPane();
    private Button addButton;
    private TextField addAttitude;

    private TableView<Attitude> table = new TableView<Attitude>();
    private ObservableList<Attitude> data
            = FXCollections.observableArrayList(
                    new Attitude("Zenuwachtig"),
                    new Attitude("Concentratie"),
                    new Attitude("Schrik"),
                    new Attitude("Asociaal"),
                    new Attitude("Verkeersgevaarlijk"),
                    new Attitude("Ongeduldig"),
                    new Attitude("Agressief rijgedrag"),
                    new Attitude("Goede inzet"),
                    new Attitude("Verstrooid"),
                    new Attitude("Eigenwijs")
            );
    private ListView<String> toonTable = new ListView<String>();
    private ObservableList<String> toonData
            = FXCollections.observableArrayList();

    public Veld3Attitude(LeerlingController llnCtrl, SchermController schermCtrl, EvaController evaCtrl) {
        schermController = schermCtrl;
        evaController = evaCtrl;
        llnController = llnCtrl;
        this.llnController.getLeerling().addView(this);

        attitudes.addAll("Zenuwachtig", "Concentratie", "Schrik", "Asociaal", "Verkeersgevaarlijk",
                "Ongeduldig", "Agressief rijgedrag", "Goede inzet", "Verstrooid", "Eigenwijs");

        TableColumn algemeenCol = new TableColumn("Attitudes");
        algemeenCol.setMinWidth(250);
        algemeenCol.setCellValueFactory(
                new PropertyValueFactory<Attitude, String>("attitude"));
        algemeenCol.setCellFactory(TextFieldTableCell.forTableColumn());
        algemeenCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Attitude, String>>() {
            @Override
            public void handle(CellEditEvent<Attitude, String> t) {
                ((Attitude) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setAttitude(t.getNewValue());
            }
        }
        );
        TableColumn<String, String> toonCol = new TableColumn<>("Gekozen");
        toonCol.setCellFactory(new Callback<TableColumn<String, String>, TableCell<String, String>>() {
            @Override
            public TableCell<String, String> call(TableColumn<String, String> param) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        

        table.setItems(data);
        table.getColumns().addAll(algemeenCol);

        toonTable.setItems(toonData);

        addAttitude = new TextField();
        addAttitude.setPromptText("Attitude");

        addButton = new Button("Voeg toe aan attitudes");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                llnController.setAandachtsPunt(addAttitude.getText());
                toonData.add(addAttitude.getText());
                
                addAttitude.clear();
            }
        });

        table.setItems(data);
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                doorgaanAlsGeselecteerd();
            }
        });

        
        exit = new Button("Ga terug");
        

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                evaController.saveAttitude(data, toonData);
                Veld3Attitude.this.schermController.setScherm(MainApp.HOOFDMENU_ID);
            }
        });
        

        toonTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                verwijder();
            }
        });

        addButton.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");
        exit.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");
                
        table.getStylesheets().add("resource/tableView.css");
        toonTable.getStylesheets().add("resource/tableView.css");
        addAttitude.setStyle("-fx-background-color:#789EBF; -fx-text-fill:white");
        
        img.setFitHeight(50);
        img.setFitWidth(50);
        titel.setStyle("-fx-font: 40px Tahoma; -fx-text-fill: white;");
        hBox1.getChildren().addAll(img, titel);
        hBox1.setMinHeight(50);
        hBox1.setMaxHeight(50);
        hBox1.setMinWidth(600);
        hBox1.setMaxWidth(600);
        hBox1.setSpacing(15);
        hBox1.setAlignment(Pos.CENTER);
        
        algemeenCol.setMinWidth(296);
        algemeenCol.setMaxWidth(296);
        toonCol.setMinWidth(296);
        toonCol.setMaxWidth(296);
        
        geselecteerd.setMaxSize(300, 30);
        geselecteerd.setMinSize(300, 30);
        geselecteerd.setStyle("-fx-text-fill:white");
        geselecteerd.setAlignment(Pos.CENTER_LEFT);
        toonTable.setMinSize(300, 360);
        toonTable.setMaxSize(300, 360);
        vBox1.getChildren().addAll(geselecteerd, toonTable);
        vBox1.setMinHeight(400);
        vBox1.setMaxHeight(400);
        vBox1.setMinWidth(300);
        vBox1.setMaxWidth(300);
        vBox1.setSpacing(10);
        vBox1.setAlignment(Pos.CENTER);
        
        table.setMaxSize(300, 400);
        table.setMinSize(300, 400);
        
        exit.setMinHeight(30);
        exit.setMaxHeight(30);
        exit.setMinWidth(150);
        exit.setMaxWidth(150);
        exit.setAlignment(Pos.CENTER);
        
        addButton.setMinHeight(30);
        addButton.setMaxHeight(30);
        addButton.setMinWidth(200);
        addButton.setMaxWidth(200);
        addButton.setAlignment(Pos.CENTER);
        
        addAttitude.setMinHeight(30);
        addAttitude.setMaxHeight(30);
        addAttitude.setMinWidth(300);
        addAttitude.setMaxWidth(300);
        addAttitude.setAlignment(Pos.CENTER);
        
        
        gp.add(hBox1, 0, 0, 2, 1);
        
        gp.add(table, 0, 1);
        gp.add(vBox1, 1, 1);
        
        gp.add(addAttitude, 0, 2);
        gp.add(addButton, 1, 2);
        
        gp.add(exit, 1, 3);
        
        gp.setStyle("-fx-border-color: #282E54;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-color: #282B3A;"
                + "-fx-background-radius: 5;");
        gp.setMaxWidth(900);
        gp.setMinWidth(900);
        gp.setMinHeight(600);
        gp.setMaxHeight(600);
        gp.setHgap(50);
        gp.setVgap(20);
        gp.setAlignment(Pos.CENTER);
        
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(gp);
        this.setStyle("-fx-background-image: url('resource/achtergrondStandaard.png')");
        
        update();
    }

    private void doorgaanAlsGeselecteerd() {
        llnController.setAandachtsPunt(table.getSelectionModel().getSelectedItem().getAttitude());
        toonData.addAll(table.getSelectionModel().getSelectedItem().getAttitude());
        data.remove(table.getSelectionModel().getSelectedItem());
    }

    private void verwijder() {
        data.add(new Attitude(
                        toonTable.getSelectionModel().getSelectedItem()
                ));
        
        toonData.remove(toonTable.getSelectionModel().getSelectedItem());
    }
    
    @Override
    public void update() {
        data = evaController.loadAttitudeWoorden();
        toonData = evaController.loadAttitudeOpm();

        if (data.isEmpty()) {
            data = FXCollections.observableArrayList(
                    new Attitude("Zenuwachtig"),
                    new Attitude("Concentratie"),
                    new Attitude("Schrik"),
                    new Attitude("Asociaal"),
                    new Attitude("Verkeersgevaarlijk"),
                    new Attitude("Ongeduldig"),
                    new Attitude("Agressief rijgedrag"),
                    new Attitude("Goede inzet"),
                    new Attitude("Verstrooid"),
                    new Attitude("Eigenwijs")
            );
        }
        toonTable.setItems(toonData);
        table.setItems(data);

    }
}
