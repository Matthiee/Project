/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.matkensim.project.async;

import be.matkensim.project.domein.Leerling;
import be.matkensim.project.json.LeerlingenListReader;
import java.util.List;
import javafx.concurrent.Task;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author Matthias
 */
public class GetLeerlingListTask extends Task<List<Leerling>>{

    private final WebTarget userListResource;

    public GetLeerlingListTask() {
        userListResource = ClientBuilder.newClient()
                .target("http://localhost:8080/api/api/")
                .path("leerlingen")
                .register(LeerlingenListReader.class);
    }
    
    @Override
    protected List<Leerling> call() throws Exception {
        return null;
    }
    
}
