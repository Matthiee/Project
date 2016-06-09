/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.matkensim.project.async;

import be.matkensim.project.domein.EvaluatieMoment;
import be.matkensim.project.domein.Leerling;
import be.matkensim.project.json.EvaluatiemomentReader;
import be.matkensim.project.json.LeerlingenListReader;
import java.util.List;
import javafx.concurrent.Task;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Matthias
 */
public class GetEvaTask extends Task<EvaluatieMoment>{

    private final WebTarget userListResource;

    public GetEvaTask(String nr, int id) {
        userListResource = ClientBuilder.newClient()
                .target("http://evaapi-matthiee.rhcloud.com/api/")
                .path("leerling/" + nr +"/eva" + id)
                .register(EvaluatiemomentReader.class);
    }
    
    @Override
    protected EvaluatieMoment call() throws Exception {
        Response response = userListResource.request(MediaType.APPLICATION_JSON).get();
        if (response.getStatus() == 200) {
            EvaluatieMoment eva = response.readEntity(EvaluatieMoment.class);
            return eva;
        } else {
            throw new Exception();
        }
    }
    
}
