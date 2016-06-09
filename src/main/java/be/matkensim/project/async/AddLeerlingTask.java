/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.matkensim.project.async;

import be.matkensim.project.domein.Leerling;
import be.matkensim.project.json.LeerlingWriter;
import javafx.concurrent.Task;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Matthias
 */
public class AddLeerlingTask extends Task<Void>{

    private final WebTarget userListResource;
    private final Leerling lln;
    
    public AddLeerlingTask(Leerling lln){
    this.lln = lln;
        userListResource = ClientBuilder.newClient()
                .target("http://evaapi-matthiee.rhcloud.com/api/")
                .path("leerlingen")
                .register(LeerlingWriter.class);
    }
    
    @Override
    protected Void call() throws Exception {
        Response response = userListResource.request().post(Entity.entity(lln, MediaType.APPLICATION_JSON));
        switch (response.getStatus()) {
            case 201:
                return null;
            case 400:
                //throw new BadRequestException();
            default:
                throw new Exception();
        }
    }
    
}
