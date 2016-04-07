package be.matkensim.project.gui;

import be.matkensim.project.controller.SchermController;
import be.matkensim.project.domein.Attitude;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class Veld3Attitude extends Pane {

    //toonTable is de table die moet getoond worden
    private final SchermController schermController;
    private Button exit;
    private TableView<String> list = new TableView<String>();
    private ObservableList<String> attitudes = FXCollections.observableArrayList();
    private ObservableList<String> toonAttitudes = FXCollections.observableArrayList();

    private VBox vBox1 = new VBox();
    private VBox vBox2 = new VBox();
    private HBox hBox1 = new HBox();

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

    public Veld3Attitude(SchermController schermCtrl) {
        schermController = schermCtrl;

        attitudes.addAll("Zenuwachtig", "Concentratie", "Schrik", "Asociaal", "Verkeersgevaarlijk",
                "Ongeduldig", "Agressief rijgedrag", "Goede inzet", "Verstrooid", "Eigenwijs");

        TableColumn algemeenCol = new TableColumn("Attitude");
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
        toonCol.setMinWidth(250);

        table.setItems(data);
        table.getColumns().addAll(algemeenCol);

        toonTable.setItems(toonData);

        TextField addAttitude = new TextField();
        addAttitude.setPromptText("Attitude");
        addAttitude.setMaxWidth(250);

        final Button addButton = new Button("Voeg toe");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Attitude(
                        addAttitude.getText()
                ));
                addAttitude.clear();
            }
        });
        addButton.setTranslateY(17);

        table.setItems(data);
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                doorgaanAlsGeselecteerd();
            }
        });
        table.setEditable(true);
        table.setMaxHeight(250);
        toonTable.setMaxHeight(250);

        vBox2.getChildren().addAll(table, addAttitude, addButton);
        exit = new Button("ga terug");
        exit.setTranslateY(0);

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Veld3Attitude.this.schermController.setScherm(MainApp.HOOFDMENU_ID);
            }
        });
        hBox1.getChildren().addAll(exit);

        toonTable.setMinWidth(150);
        vBox2.setTranslateX(300);
        hBox1.setTranslateY(300);
        vBox1.getChildren().addAll(toonTable);
        vBox1.setTranslateX(10);

        toonTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                verwijder();
            }
        });
        this.getChildren().addAll(vBox1, vBox2, hBox1);
        this.setMinWidth(600);
    }

    private void doorgaanAlsGeselecteerd() {
        toonData.addAll(table.getSelectionModel().getSelectedItem().getAttitude());
        toonTable.setItems(toonData);
    }

    private void verwijder() {
        toonData.remove(toonTable.getSelectionModel().getSelectedItem());
    }
}
