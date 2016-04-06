package gui;

import controller.EvaController;
import controller.LeerlingController;
import controller.SchermController;
import domein.Verkeerstechniek;
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

public class Veld2VerkeerstechniekVoorrang extends Pane implements View{

    private final SchermController schermController;
    private EvaController evaController;
    private LeerlingController llnController;
    private Button exit;
    private TableView<String> list = new TableView<String>();
    private ObservableList<String> houdingen = FXCollections.observableArrayList();
    private Label toon = new Label("Geselecteerd:");
    private VBox vBox1 = new VBox();
    private VBox vBox2 = new VBox();
    private HBox hBox1 = new HBox();

    private TableView<Verkeerstechniek> table = new TableView<Verkeerstechniek>();
    private ObservableList<Verkeerstechniek> data
            = FXCollections.observableArrayList();

    public Veld2VerkeerstechniekVoorrang(SchermController schermCtrl, EvaController evaCtrl, LeerlingController llnCtrl) {
        evaController = evaCtrl;
        schermController = schermCtrl;
        llnController = llnCtrl;
        this.llnController.getLeerling().addView(this);
        vBox1.getChildren().addAll(toon);
        houdingen.addAll("Voorrang");
        

        TableColumn algemeenCol = new TableColumn("Algemeen");
        algemeenCol.setMinWidth(100);
        algemeenCol.setCellValueFactory(
                new PropertyValueFactory<Verkeerstechniek, String>("algemeen"));
        algemeenCol.setCellFactory(TextFieldTableCell.forTableColumn());
        algemeenCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Verkeerstechniek, String>>() {
            @Override
            public void handle(CellEditEvent<Verkeerstechniek, String> t) {
                ((Verkeerstechniek) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setAlgemeen(t.getNewValue());
            }
        }
        );

        TableColumn commentaarCol = new TableColumn("Commentaar");
        commentaarCol.setMinWidth(200);
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
        table.getColumns().addAll(algemeenCol, commentaarCol);
        table.setTranslateX(65);

        TextField addAlgemeen = new TextField();
        addAlgemeen.setPromptText("Algemeen");
        addAlgemeen.setTranslateX(65);
        addAlgemeen.setMaxWidth(150);
        TextField addCommentaar = new TextField();
        addCommentaar.setMaxWidth(400);
        addCommentaar.setPromptText("Commentaar");
        addCommentaar.setTranslateX(65);

        final Button addButton = new Button("Voeg toe");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Verkeerstechniek(
                        addAlgemeen.getText(),
                        addCommentaar.getText()
                ));
                addAlgemeen.clear();
                addCommentaar.clear();
            }
        });
        addButton.setTranslateX(65);

        table.setItems(data);
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                doorgaanAlsGebruikerGeselecteerd();
            }
        });
        table.setEditable(true);
        table.setMaxHeight(250);

        vBox2.getChildren().addAll(table, addAlgemeen, addCommentaar, addButton);
        exit = new Button("ga terug");
        exit.setTranslateY(12);

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                evaController.saveListDataVerkeerstechniek("Voorrang", data);
                Veld2VerkeerstechniekVoorrang.this.schermController.setScherm(MainApp.VERKEERSTECHNIEK_ID);
            }
        });
        hBox1.getChildren().addAll(exit);

        vBox2.setTranslateX(250);
        hBox1.setTranslateY(300);

        this.getChildren().addAll(vBox1, vBox2, hBox1);
        this.setMinWidth(600);
        update();
    }

    private void doorgaanAlsGebruikerGeselecteerd() {
        toon.setText("Geselecteerd: " + verkort(table.getSelectionModel().getSelectedItem().getAlgemeen() + "\nCommentaar: ")
                + "\n" + verkort(table.getSelectionModel().getSelectedItem().getCommentaar()));
    }

    private String verkort(String s) {
        return s.replaceAll("(.{37})", "$1\n");
    }

    @Override
    public void update() {
        data = evaController.loadListDataVerkeerstechniek("Voorrang");
        table.setItems(data);
    }
}
