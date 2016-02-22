package controller;

import java.util.HashMap;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Matthias
 */
public class SchermController extends StackPane {

    private final HashMap<String, Node> schermen;
    
    public SchermController() {
        super();
        
        schermen =new HashMap<>();
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
