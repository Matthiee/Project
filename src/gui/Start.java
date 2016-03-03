/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Kenzo
 */
public class Start extends Application{

    @Override
    public void start(Stage primaryStage) 
    {
    Veld1RijtechniekKoppeling veld1RijtechniekKoppeling = new Veld1RijtechniekKoppeling();
    Scene scene = new Scene(veld1RijtechniekKoppeling);
        
        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
