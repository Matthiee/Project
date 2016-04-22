package be.matkensim.project.gui;

import be.matkensim.project.controller.EvaController;
import be.matkensim.project.controller.LeerlingController;
import be.matkensim.project.controller.SchermController;
import be.matkensim.project.domein.Verkeerstechniek;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Veld2VerkeerstechniekKruisen extends Pane implements View{

    private final SchermController schermController;
    private EvaController evaController;
    private LeerlingController llnController;
    private Button aandachtBtn,exit;
    private TableView<String> list = new TableView<String>();
    private ObservableList<String> houdingen = FXCollections.observableArrayList();
    private Label toon = new Label("Geselecteerd:");
    private VBox vBox1 = new VBox();
    private VBox vBox2 = new VBox();
    private HBox hBox1 = new HBox();

    private TableView<Verkeerstechniek> table = new TableView<Verkeerstechniek>();
    private ObservableList<Verkeerstechniek> data
            = FXCollections.observableArrayList();

    public Veld2VerkeerstechniekKruisen(SchermController schermCtrl, EvaController evaCtrl, LeerlingController llnCtrl) {
        evaController = evaCtrl;
        schermController = schermCtrl;
        llnController = llnCtrl;
        this.llnController.getLeerling().addView(this);
        vBox1.getChildren().addAll(toon);
        houdingen.addAll("Kruisen");

        aandachtBtn = new Button("Aandachtspunt");
        aandachtBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) 
            {
                aandacht();
            }
        });
        
        TableColumn commentaarCol = new TableColumn("Commentaar");
        commentaarCol.setMinWidth(400);
        commentaarCol.setCellValueFactory(
                new PropertyValueFactory<Verkeerstechniek, String>("commentaar"));
        commentaarCol.setCellFactory(TextFieldTableCell.forTableColumn());
        commentaarCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Verkeerstechniek, String>>() {
            @Override
            public void handle(CellEditEvent<Verkeerstechniek, String> t) {
                ((Verkeerstechniek) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setCommentaar(t.getNewValue());
            }
        }
        );

        table.setItems(data);
        table.getColumns().addAll(commentaarCol);
        table.setTranslateX(65);

        TextField addCommentaar = new TextField();
        addCommentaar.setMaxWidth(400);
        addCommentaar.setPromptText("Commentaar");
        addCommentaar.setTranslateX(65);

        final Button addButton = new Button("Voeg toe");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(!"".equals(addCommentaar.getText()))
                {
                data.add(new Verkeerstechniek(
                        addCommentaar.getText()
                ));
                addCommentaar.clear();
                }
            }
        });
        addButton.setTranslateX(65);

        table.setItems(data);
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                commentaarGeselecteerd();
            }
        });
        table.setEditable(true);
        table.setMaxHeight(250);

        vBox2.getChildren().addAll(table, addCommentaar, addButton,aandachtBtn);
        exit = new Button("ga terug");
        exit.setTranslateY(12);

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                evaController.saveListDataVerkeerstechniek("Kruisen", data);
                Veld2VerkeerstechniekKruisen.this.schermController.setScherm(MainApp.VERKEERSTECHNIEK_ID);
            }
        });
        hBox1.getChildren().addAll(exit);

        vBox2.setTranslateX(250);
        hBox1.setTranslateY(300);

        this.getChildren().addAll(vBox1, vBox2, hBox1);
        this.setMinWidth(600);
        update();
    }

    private void commentaarGeselecteerd() {
        toon.setText("Geselecteerd: \n" + verkort(table.getSelectionModel().getSelectedItem().getCommentaar()));
    }

    private String verkort(String s) {
        return s.replaceAll("(.{30})", "$1\n");
    }

    @Override
    public void update() {
        data = evaController.loadListDataVerkeerstechniek("Kruisen");
        table.setItems(data);
    }
    
    private void aandacht()
    {
        if(table.getSelectionModel().getSelectedItem()!=null)
            llnController.setAandachtsPunt(table.getSelectionModel().getSelectedItem().getCommentaar()); 
    }
}
