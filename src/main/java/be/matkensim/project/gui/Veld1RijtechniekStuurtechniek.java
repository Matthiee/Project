package be.matkensim.project.gui;

import be.matkensim.project.controller.EvaController;
import be.matkensim.project.controller.LeerlingController;
import be.matkensim.project.controller.SchermController;
import be.matkensim.project.domein.Rijtechniek;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

public class Veld1RijtechniekStuurtechniek extends VBox implements View{

    private final SchermController schermController;
    private EvaController evaController;
    private LeerlingController llnController;
    private Button aandachtBtn, exit, addButton;
    private TableView<String> list = new TableView<String>();
    private ObservableList<String> houdingen = FXCollections.observableArrayList();
    private Label toon = new Label("Geselecteerd:");
    private VBox vBox1 = new VBox();
    private VBox vBox2 = new VBox();
    private HBox hBox1 = new HBox();
    private HBox hBox2 = new HBox();
    private GridPane gp = new GridPane();
    private Label titel = new Label("Stuurtechniek");
    private ImageView titelAfb = new ImageView("resource/Rijtechniek/stuurNeutraal.png");
    private TextField commentaarFld;
    private TableColumn commentaarCol;

    private TableView<Rijtechniek> table = new TableView<Rijtechniek>();
    private ObservableList<Rijtechniek> data = FXCollections.observableArrayList();

    public Veld1RijtechniekStuurtechniek(SchermController schermCtrl, EvaController evaCtrl, LeerlingController llnCtrl) {
        evaController = evaCtrl;
        schermController = schermCtrl;
        llnController = llnCtrl;
        vBox1.getChildren().addAll(toon);
        houdingen.addAll("Zithouding", "Gordel", "Spiegel", "Handrem");
        this.llnController.getLeerling().addView(this);
        
        aandachtBtn = new Button("Aandachtspunt");
        aandachtBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) 
            {
                aandacht();
            }
        });

        commentaarCol = new TableColumn("Commentaar");
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

        
        commentaarFld = new TextField();
        commentaarFld.setPromptText("Commentaar");

        addButton = new Button("Voeg toe");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(!"".equals(commentaarFld.getText()))
                {
                    data.add(new Rijtechniek(
                        commentaarFld.getText()
                ));
                commentaarFld.clear();
                }
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

        vBox2.getChildren().addAll(table, commentaarFld);
        exit = new Button("ga terug");

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                evaController.saveListDataRijtechniek("Stuurtechniek", data);
                Veld1RijtechniekStuurtechniek.this.schermController.setScherm(MainApp.RIJTECHNIEK_ID);
            }
        });
        
        hBox1.getChildren().addAll(titelAfb, titel);
        hBox1.setMinHeight(50);
        hBox1.setMaxHeight(50);
        hBox1.setMinWidth(600);
        hBox1.setMaxWidth(600);
        hBox1.setSpacing(15);
        hBox1.setAlignment(Pos.CENTER);
        titelAfb.setFitHeight(50);
        titelAfb.setFitWidth(50);
        titel.setStyle("-fx-font: 40px Tahoma");
        toon.setMinHeight(400);
        toon.setMaxHeight(400);
        toon.setMinWidth(300);
        toon.setMaxWidth(300);
        toon.setAlignment(Pos.TOP_LEFT);
        table.setMinWidth(300);
        table.setMaxWidth(300);
        table.setMinHeight(400);
        table.setMaxHeight(400);
        addButton.setMinHeight(30);
        addButton.setMaxHeight(30);
        addButton.setMinWidth(150);
        addButton.setMaxWidth(150);
        addButton.setAlignment(Pos.CENTER);
        aandachtBtn.setMinHeight(30);
        aandachtBtn.setMaxHeight(30);
        aandachtBtn.setMinWidth(150);
        aandachtBtn.setMaxWidth(150);
        aandachtBtn.setAlignment(Pos.CENTER);
        exit.setMinHeight(30);
        exit.setMaxHeight(30);
        exit.setMinWidth(150);
        exit.setMaxWidth(150);
        exit.setAlignment(Pos.CENTER);
        commentaarFld.setMinHeight(30);
        commentaarFld.setMaxHeight(30);
        commentaarFld.setMinWidth(250);
        commentaarFld.setMaxWidth(250);
        commentaarFld.setAlignment(Pos.CENTER);
        
        gp.setStyle("-fx-border-color: black;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-color: lightgray;"
                + "-fx-background-radius: 5;");
        gp.setMaxWidth(900);
        gp.setMinWidth(900);
        gp.setMinHeight(600);
        gp.setMaxHeight(600);
        gp.setHgap(50);
        gp.setVgap(20);
        gp.setAlignment(Pos.CENTER);
        gp.add(hBox1, 0, 0, 2, 1);
        gp.add(toon, 0, 1);
        gp.add(table, 1, 1);
        gp.add(commentaarFld, 0, 2);
        gp.add(addButton, 1, 2);
        gp.add(aandachtBtn, 0, 3);
        gp.add(exit, 1, 3);
        
        
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(gp);
        this.setStyle("-fx-background-image: url('resource/achtergrondStandaard.png')");
        
        
        update();
    }

    private void commentaarGeselecteerd() {
        toon.setText("Geselecteerd: \n" +verkort(table.getSelectionModel().getSelectedItem().getCommentaar()));
    }

    //wrap de commentaar elke 30 chars
    private String verkort(String s) {
        return s.replaceAll("(.{30})", "$1\n");
    }
    
    
    @Override
    public void update(){
        data = evaController.loadListDataRijtechniek("Stuurtechniek");
        table.setItems(data);
    }
    
    private void aandacht()
    {
        if(table.getSelectionModel().getSelectedItem()!=null)
            llnController.setAandachtsPunt(table.getSelectionModel().getSelectedItem().getCommentaar()); 
    }
}

