package controller;

import domein.Leerling;

/**
 *
 * @author Matthias
 */
public class LeerlingController {
    private Leerling leerling;
    
    public LeerlingController(Leerling l){
        this.leerling=l;
    }

    public Leerling getLeerling() {
        return leerling;
    }

    public void setLeerling(Leerling leerling) {
        this.leerling = leerling;
    }
    
    
    
    
    
}
