/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.matkensim.project.json;

import be.matkensim.project.domein.Leerling;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.collections.ObservableList;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Matthias
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class LeerlingWriter implements MessageBodyWriter<Leerling>{

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Leerling.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(Leerling t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;    
    }

    @Override
    public void writeTo(Leerling lln, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        try(JsonWriter out = Json.createWriter(entityStream)){
            JsonObjectBuilder b = Json.createObjectBuilder();
            b.add("naam", lln.getNaam());
            b.add("grafiek", lln.getGrafiek());
            b.add("inschrijvingsnr", lln.getInschrijvingsnr());
            b.add("lastSelectedEva", lln.getLastSelectedEva());
            b.add("type", lln.getType());
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            b.add("verval", fmt.format(lln.getVerval()));
            b.add("instructeur", lln.getInstructeur());
            b.add("aandachtspunten", getArr(lln.getAandachtsPuntenLijst()));
            
            out.writeObject(b.build());
        }
    }
    
     private JsonArrayBuilder getArr(ObservableList<String> o){
         JsonArrayBuilder b = Json.createArrayBuilder();
       
        for(String s : o){
             b.add(s);
         }
         
         return  b;
     }
}
