package gui;

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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Kenzo
 */
public class Veld2VerkeerstechniekInhalen extends Pane {

    private final SchermController schermController;
    private Button exit;
    private TableView<String> list = new TableView<String>();
    private ObservableList<String> houdingen = FXCollections.observableArrayList();
    private Label toon = new Label("Geselecteerd:");
    private VBox vBox1 = new VBox();
    private VBox vBox2 = new VBox();
    private HBox hBox1 = new HBox();

    private TableView<Verkeerstechniek> table = new TableView<Verkeerstechniek>();
    private ObservableList<Verkeerstechniek> data
            = FXCollections.observableArrayList(
                    new Verkeerstechniek("Inhalen", ""),
                    new Verkeerstechniek("Voorbijrijden", "")
            );

    public Veld2VerkeerstechniekInhalen(SchermController schermCtrl) {
        schermController = schermCtrl;
        vBox1.getChildren().addAll(toon);
        houdingen.addAll("Inhalen", "Voorbijrijden");

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
        addAlgemeen.setTranslateX(53);
        addAlgemeen.setMaxWidth(150);
        TextField addCommentaar = new TextField();
        addCommentaar.setMaxWidth(400);
        addCommentaar.setPromptText("Commentaar");
        addCommentaar.setTranslateX(53);

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
        table.setOnMouseClicked(e -> doorgaanAlsGebruikerGeselecteerd());
        table.setEditable(true);
        table.setMaxHeight(250);

        vBox2.getChildren().addAll(table, addAlgemeen, addCommentaar, addButton);
        exit = new Button("ga terug");
        exit.setTranslateY(12);

        exit.setOnAction(e -> this.schermController.setScherm(MainApp.VERKEERSTECHNIEK_ID));
        hBox1.getChildren().addAll(exit);

        vBox2.setTranslateX(250);
        hBox1.setTranslateY(300);

        this.getChildren().addAll(vBox1, vBox2, hBox1);
        this.setMinWidth(600);
    }

    private void doorgaanAlsGebruikerGeselecteerd() {
        toon.setText("Geselecteerd: " + verkort(table.getSelectionModel().getSelectedItem().getAlgemeen() + "\nCommentaar: ")
                + "\n" + verkort(table.getSelectionModel().getSelectedItem().getCommentaar()));
    }

    private String verkort(String s) {
        return s.replaceAll("(.{37})", "$1\n");
    }
}
