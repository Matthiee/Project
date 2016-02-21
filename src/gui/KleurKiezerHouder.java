package gui;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Matthias
 */
public class KleurKiezerHouder extends Pane {
    
    private Pane pane;
    private ImageView ctrl;
    
    private double SIZE = 25;
    
    public KleurKiezerHouder(Pane p, ImageView v){
    
        pane=p;
        ctrl=v;
        
        
        setPadding(new Insets(10));
        
        Rectangle rectWit, rectGroen, rectOrangje, rectRood;
        
        rectWit = new Rectangle(SIZE,SIZE, Color.WHITE);
        rectGroen = new Rectangle(SIZE,SIZE, Color.GREEN);
        rectOrangje = new Rectangle(SIZE,SIZE, Color.ORANGE);
        rectRood = new Rectangle(SIZE,SIZE, Color.RED);
        
        HBox hbox = new HBox(rectWit, rectGroen, rectOrangje, rectRood);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10));
        getChildren().add(hbox);
        
        hbox.getChildren().forEach((Node n) -> n.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"));
        
        hbox.setStyle("-fx-border-color: black;");
    }

    public Pane getPane() {
        return pane;
    }

    public ImageView getCtrl() {
        return ctrl;
    }
    
    public static void show(Pane pane, ImageView ctrl){
        KleurKiezerHouder houder = new KleurKiezerHouder(pane, ctrl);
        
        houder.setLayoutX(ctrl.getLayoutX()+ctrl.getBoundsInParent().getWidth());
        houder.setLayoutY(ctrl.getLayoutY());
        
        pane.getChildren().add(houder);
    }
    
    
    
}
