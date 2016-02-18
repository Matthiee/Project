/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.LeerlingController;
import domein.Leerling;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author simon
 */
public class HoofdMenu extends BorderPane{
    
    private Leerling lln;
    private LeerlingController llnController;
    private LeerlingInfoHouder lih;
    
    private TextField opmerkingen;
    
    public HoofdMenu(Leerling lln, LeerlingController llnController){
        //Top of the borderpane
        GridPane top = new GridPane();
            //De leerlingen en controller toewijzen           
        this.llnController = llnController;
        this.lln = lln;
            //de nodes
        opmerkingen = new TextField("Test text voor de opmerkingen");
        lih = new LeerlingInfoHouder(lln, llnController);
            //nodes toevoegen
        top.add(opmerkingen, 0, 0);
        top.add(lih, 1, 0);
        
        //Bottom of the borderpane
        
        
        //alle onderdelen toevoegen aan de borderpane
        this.setTop(top);
    }
    
}
