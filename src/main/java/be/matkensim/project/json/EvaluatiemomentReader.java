package be.matkensim.project.json;

import be.matkensim.project.domein.EvaluatieMoment;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.BadRequestException;
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
public class EvaluatiemomentReader implements MessageBodyReader<EvaluatieMoment> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return EvaluatieMoment.class.isAssignableFrom(type);
    }

    @Override
    public EvaluatieMoment readFrom(Class<EvaluatieMoment> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        try (JsonReader in = Json.createReader(entityStream)) {
            JsonObject j = in.readObject();
            EvaluatieMoment eva = new EvaluatieMoment();
            
            // rijtechniek
            eva.setParkeren(j.getInt("parkeren", 0));
            eva.setGarage(j.getInt("garage", 0));
            eva.setStuuroef(j.getInt("stuuroef", 0));
            eva.setAchteruit(j.getInt("achteruit", 0));
            eva.setKeren(j.getInt("keren", 0));
            eva.setHouding(j.getInt("houding", 0));
            eva.setRemmen(j.getInt("remmen", 0));
            eva.setKoppeling(j.getInt("koppeling", 0));
            eva.setSchakelen(j.getInt("schakelen", 0));
            eva.setSturen(j.getInt("sturen", 0));
            eva.setKijken(j.getInt("kijken", 0));
            eva.setHelling(j.getInt("helling", 0));
            eva.setHoudingOpm(GetOpmerkingen(j.getJsonArray("houdingOpm")));
            eva.setKoppelingOpm(GetOpmerkingen(j.getJsonArray("koppelingOpm")));
            eva.setRemmenOpm(GetOpmerkingen(j.getJsonArray("remmenOpm")));
            eva.setSchakelenOpm(GetOpmerkingen(j.getJsonArray("schakelenOpm")));
            eva.setSturenOpm(GetOpmerkingen(j.getJsonArray("sturenOpm")));
            eva.setKijkenOpm(GetOpmerkingen(j.getJsonArray("kijkenOpm")));
            eva.setHellingOpm(GetOpmerkingen(j.getJsonArray("hellingOpm")));
            
            //verkeerstechniek
            eva.setRichtingaanwijzers(j.getInt("richtingaanwijzers", 0));
            eva.setVoorrang(j.getInt("voorrang", 0));
            eva.setOpenbareWeg(j.getInt("openbareWeg", 0));
            eva.setVerkeerstekens(j.getInt("verkeerstekens", 0));
            eva.setSnelheid(j.getInt("snelheid", 0));
            eva.setAfstand(j.getInt("afstand", 0));
            eva.setInhalen(j.getInt("inhalen", 0));
            eva.setKruisen(j.getInt("kruisen", 0));
            eva.setLinksaf(j.getInt("linksaf", 0));
            eva.setRechtsaf(j.getInt("rechtsaf", 0));
            eva.setRichtingaanwijzersOpm(GetOpmerkingen(j.getJsonArray("richtingaanwijzersOpm")));
            eva.setVoorrangOpm(GetOpmerkingen(j.getJsonArray("voorrangOpm")));
            eva.setOpenbareWegOpm(GetOpmerkingen(j.getJsonArray("openbareWegOpm")));
            eva.setVerkeerstekensOpm(GetOpmerkingen(j.getJsonArray("verkeerstekensOpm")));
            eva.setSnelheidOpm(GetOpmerkingen(j.getJsonArray("snelheidOpm")));
            eva.setAfstandOpm(GetOpmerkingen(j.getJsonArray("afstandOpm")));
            eva.setInhalenOpm(GetOpmerkingen(j.getJsonArray("inhalenOpm")));
            eva.setKruisenOpm(GetOpmerkingen(j.getJsonArray("kruisenOpm")));
            eva.setLinksafOpm(GetOpmerkingen(j.getJsonArray("linksafOpm")));
            eva.setRechtsafOpm(GetOpmerkingen(j.getJsonArray("rechtsafOpm")));
            
            //attitude
            eva.setAttitudeOpm(GetOpmerkingen(j.getJsonArray("attitudeOpm")));
            
            //hoofdmenu
            eva.setRotonde(j.getInt("rotonde", 0));
            eva.setRijstroken(j.getInt("rijstroken", 0));
            eva.setStad(j.getInt("stad", 0));
            eva.setAutosnelweg(j.getInt("autosnelweg", 0));
            eva.setSchakelaars(j.getInt("schakelaars", 0));
            eva.setVloeistoffen(j.getInt("vloeistoffen", 0));
            eva.setBanden(j.getInt("banden", 0));
            eva.setTanken(j.getInt("tanken", 0));
            eva.setNoodstop(j.getInt("noodstop", 0));
            eva.setGps(j.getInt("gps", 0));
            eva.setHoofdmenuOpm(GetOpmerkingen(j.getJsonArray("hoofdmenuOpm")));
            
            return eva;
        } catch (JsonException | ClassCastException e) {
            throw new BadRequestException("invalid json");
        }
    }
    
    private ObservableList<String> GetOpmerkingen(JsonArray arr){
        ObservableList<String> o = FXCollections.observableArrayList();
        for (int i = 0; i < arr.size(); i++) {
            o.add(arr.getString(i));
        }
        
        return o;
    }

}
