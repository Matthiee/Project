package controller;

import domein.Leerling;
import gui.View;
import java.util.List;

/**
 *
 * @author Matthias
 */
public class LeerlingController {
    private Leerling leerling;
    
    
    public LeerlingController(Leerling lln){
        this.leerling=lln;
    }

    public Leerling getLeerling() {
        return leerling;
    }

    public void setLeerling(Leerling leerling) {
        
        if (this.leerling!=null){
            List<View> views = this.leerling.getViews();
            
            leerling.getViews().addAll(views);
            this.leerling.getViews().clear();
        }
        
        this.leerling = leerling;
        
        this.leerling.update();
    }
    
    
    
    
    
}
