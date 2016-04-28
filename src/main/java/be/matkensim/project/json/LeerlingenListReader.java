package be.matkensim.project.json;

import be.matkensim.project.domein.Leerling;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Matthias
 */
@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class LeerlingenListReader implements MessageBodyReader<List<Leerling>> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if (!List.class.isAssignableFrom(type)) {
            return false;
        }

        if (genericType instanceof ParameterizedType) {
            Type[] args = ((ParameterizedType) genericType).getActualTypeArguments();
            return args.length == 1 && args[0].equals(Leerling.class);
        } else {
            return false;
        }
    }

    @Override
    public List<Leerling> readFrom(Class<List<Leerling>> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        try (JsonReader in = Json.createReader(entityStream)) {
            JsonArray jsonLlnen = in.readArray();
            List<Leerling> leerlingen = new ArrayList<>();

            for (JsonObject j : jsonLlnen.getValuesAs(JsonObject.class)) {
                Leerling lln = new Leerling();
                Image i = new Image("resource/man-icon.png");
                lln.setNaam(j.getString("naam", null));
                lln.setGrafiek(j.getInt("grafiek", -1));
                lln.setInschrijvingsnr(j.getString("inschrijvingsnr", null));
                lln.setLastSelectedEva(j.getInt("lastSelectedEva", -1));
                lln.setType(j.getString("type", null));
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                lln.setVerval(fmt.parse(j.getString("verval", "2000-01-01")));
                lln.setInstructeur(j.getString("instructeur", null));
                lln.setImage(i);
                
                leerlingen.add(lln);
            }
            
            return leerlingen;            
        } catch (ParseException ex) {
            Logger.getLogger(LeerlingenListReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

}
