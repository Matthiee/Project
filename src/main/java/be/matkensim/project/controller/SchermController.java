package be.matkensim.project.controller;

import java.util.HashMap;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Matthias
 */
public class SchermController extends StackPane {

    private final HashMap<String, Node> schermen;
    private int hoogte = 768;
    private int breedte = 1024;
    
    public SchermController() {
        super();
        
        schermen =new HashMap<>();
        this.setMaxHeight(hoogte);
        this.setMaxWidth(breedte);
        this.setMinHeight(hoogte);
        this.setMinWidth(breedte);
        this.setPrefSize(breedte, hoogte);
    }

    public int getHoogte() {
        return hoogte;
    }

    public void setHoogte(int hoogte) {
        this.hoogte = hoogte;
    }

    public int getBreedte() {
        return breedte;
    }

    public void setBreedte(int breedte) {
        this.breedte = breedte;
    }
    
    
    public void addScherm(String id, Node scherm){
        if (!schermen.containsKey(id))
            schermen.put(id, scherm); 
    }
    
    public Node getScherm(String id){
       return schermen.get(id);
    }
    
    public void setScherm(String id){
        Node scherm = getScherm(id);
        if (scherm==null)
        {
            System.out.println("Scherm is niet geladen!");
        } else {
            if (getChildren().isEmpty()){
                getChildren().add(scherm);
            } else {
                getChildren().remove(0);
                getChildren().add(0, scherm);
            }
        }
    }

}
