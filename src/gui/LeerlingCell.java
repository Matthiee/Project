package gui;

import domein.Leerling;
import javafx.scene.control.ListCell;

/**
 *
 * @author Matthias
 */
public class LeerlingCell extends ListCell<Leerling>{

    @Override
    protected void updateItem(Leerling item, boolean empty) {
        super.updateItem(item, empty); 
        
        if (empty){
            setText("");
            return;
        }
        
        setText(item.getNaam());
    }
    
    
    
}
