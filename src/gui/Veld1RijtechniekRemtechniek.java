/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.Rijtechniek;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author Kenzo
 */
public class Veld1RijtechniekRemtechniek extends Pane
{
    //private final SchermController schermController;
    private Button exit;
    private TableView<String> list = new TableView<String>();
    private ObservableList<String> houdingen = FXCollections.observableArrayList();
    private Label toon = new Label("Geselecteerd:");
    private VBox vBox1 = new VBox();
    private VBox vBox2 = new VBox();
    private HBox hBox1 = new HBox();
    
    private TableView<Rijtechniek> table = new TableView<Rijtechniek>();
    private  ObservableList<Rijtechniek> data =
            FXCollections.observableArrayList(
            new Rijtechniek("Dosering", ""),
            new Rijtechniek("Volgorde", ""),
            new Rijtechniek("Te laat", "")
            );
    

    public Veld1RijtechniekRemtechniek(/*SchermController schermCtrl*/) {
        //schermController = schermCtrl;
        vBox1.getChildren().addAll(toon);
        houdingen.addAll("Dosering","Volgorde","Te laat");
        
        TableColumn algemeenCol = new TableColumn("Algemeen");
        algemeenCol.setMinWidth(100);
        algemeenCol.setCellValueFactory(
            new PropertyValueFactory<Rijtechniek, String>("algemeen"));
        algemeenCol.setCellFactory(TextFieldTableCell.forTableColumn());
        algemeenCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Rijtechniek, String>>() {
                @Override
                public void handle(CellEditEvent<Rijtechniek, String> t) {
                    ((Rijtechniek) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setAlgemeen(t.getNewValue());
                }
            }
        );
 
        TableColumn commentaarCol = new TableColumn("Commentaar");
        commentaarCol.setMinWidth(200);
        commentaarCol.setCellValueFactory(
            new PropertyValueFactory<Rijtechniek, String>("commentaar"));
        commentaarCol.setCellFactory(TextFieldTableCell.forTableColumn());
        commentaarCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Rijtechniek, String>>() {
                @Override
                public void handle(CellEditEvent<Rijtechniek, String> t) {
                    ((Rijtechniek) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setCommentaar(t.getNewValue());
                }
            }
        );
 
        
        table.setItems(data);
        table.getColumns().addAll(algemeenCol, commentaarCol);
 
        TextField addFirstName = new TextField();
        addFirstName.setPromptText("Algemeen");
        addFirstName.setMaxWidth(150);
        TextField addLastName = new TextField();
        addLastName.setMaxWidth(400);
        addLastName.setPromptText("Commentaar");

        final Button addButton = new Button("Voeg toe");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Rijtechniek(
                        addFirstName.getText(),
                        addLastName.getText()
                        ));
                addFirstName.clear();
                addLastName.clear();
            }
        });
 
        table.setItems(data);
        table.setOnMouseClicked(e -> doorgaanAlsGebruikerGeselecteerd());
        table.setEditable(true); 
        table.setMaxHeight(250);

        vBox2.getChildren().addAll(table,addFirstName, addLastName,addButton);
        exit = new Button("ga terug");
        exit.setTranslateY(12);
        //eventhandeler
        //exit.setOnAction(e -> this.schermController.setScherm(MainApp.HOOFDMENU_ID));
        hBox1.getChildren().addAll(exit);
        
        vBox2.setTranslateX(250);
        hBox1.setTranslateY(300);
        
        this.getChildren().addAll(vBox1,vBox2,hBox1);
        this.setMinWidth(600);
    }
    private void doorgaanAlsGebruikerGeselecteerd() {
        toon.setText("Geselecteerd: " + verkort(table.getSelectionModel().getSelectedItem().getAlgemeen()+"\nCommentaar: ")
                +"\n"+verkort(table.getSelectionModel().getSelectedItem().getCommentaar()));
    }

    //wrap de commentaar elke 30 chars
    private String verkort(String s)
    {
        return s.replaceAll("(.{30})", "$1\n");
    }
}
