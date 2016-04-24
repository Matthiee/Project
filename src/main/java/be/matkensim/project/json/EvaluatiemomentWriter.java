/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.matkensim.project.json;


import be.matkensim.project.domein.EvaluatieMoment;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
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
@Produces(value = MediaType.APPLICATION_JSON)
public class EvaluatiemomentWriter implements MessageBodyWriter<EvaluatieMoment>{

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return (EvaluatieMoment.class.isAssignableFrom(type));
    } 

    @Override
    public long getSize(EvaluatieMoment t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(EvaluatieMoment eva, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        
            JsonObjectBuilder b = Json.createObjectBuilder();
            //rijtechniek
            b.add("parkeren", eva.getParkeren());
            b.add("garage", eva.getParkeren());
            b.add("stuuroef", eva.getStuuroef());
            b.add("achteruit", eva.getAchteruit());
            b.add("keren", eva.getKeren());
            b.add("houding", eva.getHouding());
            b.add("remmen", eva.getRemmen());
            b.add("koppeling", eva.getKoppeling());
            b.add("schakelen", eva.getSchakelen());
            b.add("sturen", eva.getSturen());
            b.add("kijken", eva.getKijken());
            b.add("helling", eva.getHelling());
            b.add("houdingOpm", getArr(eva.getHoudingOpm()));
            b.add("koppelingOpm", getArr(eva.getKoppelingOpm()));
            b.add("remmenOpm", getArr(eva.getRemmenOpm()));
            b.add("schakelenOpm", getArr(eva.getSchakelenOpm()));
            b.add("sturenOpm", getArr(eva.getSturenOpm()));
            b.add("kijkenOpm", getArr(eva.getKijkenOpm()));
            b.add("hellingOpm", getArr(eva.getHellingOpm()));
                    
            //verkeerstechniek
            b.add("richtingaanwijzers", eva.getRichtingaanwijzers());
            b.add("voorrang", eva.getVoorrang());
            b.add("openbareWeg", eva.getOpenbareWeg());
            b.add("verkeerstekens", eva.getVerkeerstekens());
            b.add("snelheid", eva.getSnelheid());
            b.add("afstand", eva.getAfstand());
            b.add("inhalen", eva.getInhalen());
            b.add("kruisen", eva.getKruisen());
            b.add("linksaf", eva.getLinksaf());
            b.add("rechtsaf", eva.getRechtsaf());
            b.add("richtingaanwijzersOpm", getArr(eva.getRichtingaanwijzersOpm()));
            b.add("voorrangOpm", getArr(eva.getVoorrangOpm()));
            b.add("openbareWegOpm", getArr(eva.getOpenbareWegOpm()));
            b.add("verkeerstekensOpm", getArr(eva.getVerkeerstekensOpm()));
            b.add("snelheidOpm", getArr(eva.getSnelheidOpm()));
            b.add("afstandOpm", getArr(eva.getAfstandOpm()));
            b.add("inhalenOpm", getArr(eva.getInhalenOpm()));
            b.add("kruisenOpm", getArr(eva.getKruisenOpm()));
            b.add("linksafOpm", getArr(eva.getLinksafOpm()));
            b.add("rechtsafOpm", getArr(eva.getRechtsafOpm()));
            
            //attitude
            b.add("attitudeOpm", getArr(eva.getAttitudeOpm()));
            
            //hoofdmenu
            b.add("rotonde", eva.getRotonde());
            b.add("rijstroken", eva.getRijstroken());
            b.add("stad", eva.getStad());
            b.add("autosnelweg", eva.getAutosnelweg());
            b.add("schakelaars", eva.getSchakelaars());
            b.add("vloeistoffen", eva.getVloeistoffen());
            b.add("banden", eva.getBanden());
            b.add("tanken", eva.getTanken());
            b.add("noodstop", eva.getNoodstop());
            b.add("gps", eva.getGps());
            b.add("hoofdmenuOpm", getArr(eva.getHoofdmenuOpm()));
            
        try(JsonWriter out = Json.createWriter(entityStream)){
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
