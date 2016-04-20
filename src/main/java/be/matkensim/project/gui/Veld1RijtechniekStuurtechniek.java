package be.matkensim.project.gui;

import be.matkensim.project.controller.EvaController;
import be.matkensim.project.controller.LeerlingController;
import be.matkensim.project.controller.SchermController;
import be.matkensim.project.domein.Rijtechniek;
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

public class Veld1RijtechniekStuurtechniek extends Pane implements View{

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

    private TableView<Rijtechniek> table = new TableView<Rijtechniek>();
    private ObservableList<Rijtechniek> data
            = FXCollections.observableArrayList(
                    new Rijtechniek("Dosering"),
                    new Rijtechniek("Houding")
            );

    public Veld1RijtechniekStuurtechniek(SchermController schermCtrl, EvaController evaCtrl, LeerlingController llnCtrl) {
        evaController = evaCtrl;
        schermController = schermCtrl;
        llnController = llnCtrl;
        vBox1.getChildren().addAll(toon);
        houdingen.addAll("Dosering", "Houding");
        this.llnController.getLeerling().addView(this);
     
        TableColumn commentaarCol = new TableColumn("Commentaar");
        commentaarCol.setMinWidth(400);
        commentaarCol.setCellValueFactory(
                new PropertyValueFactory<Rijtechniek, String>("commentaar"));
        commentaarCol.setCellFactory(TextFieldTableCell.forTableColumn());
        commentaarCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Rijtechniek, String>>() {
            @Override
            public void handle(CellEditEvent<Rijtechniek, String> t) {
                ((Rijtechniek) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setCommentaar(t.getNewValue());
            }
        }
        );

        table.setItems(data);
        table.getColumns().addAll(commentaarCol);

        TextField commentaarFld = new TextField();
        commentaarFld.setMaxWidth(400);
        commentaarFld.setPromptText("Commentaar");

        final Button addButton = new Button("Voeg toe");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Rijtechniek(
                        commentaarFld.getText()
                ));
                commentaarFld.clear();
            }
        });

        table.setItems(data);
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                commentaarGeselecteerd();
            }
        });
        table.setEditable(true);
        table.setMaxHeight(250);

        vBox2.getChildren().addAll(table,commentaarFld, addButton);
        exit = new Button("ga terug");
        exit.setTranslateY(12);

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                evaController.saveListDataRijtechniek("Stuurtechniek", data);
                Veld1RijtechniekStuurtechniek.this.schermController.setScherm(MainApp.RIJTECHNIEK_ID);
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

    //wrap de commentaar elke 30 chars
    private String verkort(String s) {
        return s.replaceAll("(.{30})", "$1\n");
    }

    @Override
    public void update() {
        data = evaController.loadListDataRijtechniek("Stuurtechniek");
        table.setItems(data);
    }
}