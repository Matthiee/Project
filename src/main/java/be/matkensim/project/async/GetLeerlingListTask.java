/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.matkensim.project.async;

import be.matkensim.project.domein.Leerling;
import java.util.List;
import javafx.concurrent.Task;
import javafx.ws.rs.WebTarget;

/**
 *
 * @author Matthias
 */
public class GetLeerlingListTask extends Task<List<Leerling>>{

    private final WebTarget userListResource;

    public GetLeerlingListTask() {
        userListResource = ClientBuilder.newClient()
                .target("https://glassfish-svanimpe.rhcloud.com/reminders/api")
                .path("users")
                .register(UserListReader.class);
    }
    
    @Override
    protected List<Leerling> call() throws Exception {
        
    }
    
}
