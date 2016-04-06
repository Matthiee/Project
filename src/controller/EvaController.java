
package controller;

import domein.Rijtechniek;
import domein.Verkeerstechniek;
import gui.Onderdeel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EvaController {
    
    private LeerlingController leerlingController;
    private int selectedEva;
     //eva1=1  eva2=2  eva3=3
    
    public EvaController(LeerlingController llnCtrl){
        leerlingController = llnCtrl;
        selectedEva = getSelectedEva();
    }

    public int getSelectedEva() {
        return leerlingController.getLastSelectedEva();
    }

    public void setSelectedEva(int selectedEva) {
        this.selectedEva = selectedEva;
        leerlingController.setLastSelectedEva(selectedEva);
    }
    
    public int[] loadPijlen(){
        int [] pijl = {0, 0, 0};
        int value1 = 0;
        int value2 = 0; 
        int value3 = 0; 
        int value4 = 0; 
        int value5 = 0; 
        int value6 = 0; 
        int value7 = 0; 
        int value8 = 0; 
        int value9 = 0; 
        int value10 = 0;
        
        //inlezen van waarden
        if(selectedEva == 1){
            value1 = leerlingController.getEva1().getRechtsaf();
            value2 = leerlingController.getEva1().getRichtingaanwijzers();
            value3 = leerlingController.getEva1().getOpenbareWeg();
            value4 = leerlingController.getEva1().getVoorrang();
            value5 = leerlingController.getEva1().getVerkeerstekens();
            value6 = leerlingController.getEva1().getSnelheid();
            value7 = leerlingController.getEva1().getAfstand();
            value8 = leerlingController.getEva1().getInhalen();
            value9 = leerlingController.getEva1().getKruisen();
            value10 = leerlingController.getEva1().getLinksaf();
        }
        if(selectedEva == 2){
            value1 = leerlingController.getEva2().getRechtsaf();
            value2 = leerlingController.getEva2().getRichtingaanwijzers();
            value3 = leerlingController.getEva2().getOpenbareWeg();
            value4 = leerlingController.getEva2().getVoorrang();
            value5 = leerlingController.getEva2().getVerkeerstekens();
            value6 = leerlingController.getEva2().getSnelheid();
            value7 = leerlingController.getEva2().getAfstand();
            value8 = leerlingController.getEva2().getInhalen();
            value9 = leerlingController.getEva2().getKruisen();
            value10 = leerlingController.getEva2().getLinksaf();
        }
        if(selectedEva == 3){
            value1 = leerlingController.getEva3().getRechtsaf();
            value2 = leerlingController.getEva3().getRichtingaanwijzers();
            value3 = leerlingController.getEva3().getOpenbareWeg();
            value4 = leerlingController.getEva3().getVoorrang();
            value5 = leerlingController.getEva3().getVerkeerstekens();
            value6 = leerlingController.getEva3().getSnelheid();
            value7 = leerlingController.getEva3().getAfstand();
            value8 = leerlingController.getEva3().getInhalen();
            value9 = leerlingController.getEva3().getKruisen();
            value10 = leerlingController.getEva3().getLinksaf();
        }
        
        //pijl 1 value 1-3
            //neutraal check 1
        if(value1 == 0 || value2 == 0 || value3 == 0) pijl[0] = 0;
            //oranje
        if(value1 == 2 || value2 == 2 || value3 == 2) pijl[0] = 2;
            //rood
        if(value1 == 3 || value2 == 3 || value3 == 3) pijl[0] = 3;
            //neutraal check 2
        if(value1 == 0 && value2 == 0 && value3 == 0) pijl[0] = 0;
            //Groen
        if(value1 == 1 && value2 == 1 && value3 == 1) pijl[0] = 1;
        
        //pijl 2 value 4-6
            //neutraal check 1
        if(value4 == 0 || value5 == 0 || value6 == 0) pijl[1] = 0;
            //oranje
        if(value4 == 2 || value5 == 2 || value6 == 2) pijl[1] = 2;
            //rood
        if(value4 == 3 || value5 == 3 || value6 == 3) pijl[1] = 3;
            //neutraal
        if(value4 == 0 && value5 == 0 && value6 == 0) pijl[1] = 0;
            //groen
        if(value4 == 1 && value5 == 1 && value6 == 1) pijl[1] = 1;
        
        //pijl 3 value 7-10
            //neutraal check 1
        if(value7 == 0 || value8 == 0 || value9 == 0 || value10 == 0) pijl[2] = 0;
            //oranje
        if(value7 == 2 || value8 == 2 || value9 == 2 || value10 == 2) pijl[2] = 2;
            //rood
        if(value7 == 3 || value8 == 3 || value9 == 3 || value10 == 3) pijl[2] = 3;
            //neutraal
        if(value7 == 0 && value8 == 0 && value9 == 0 && value10 == 0) pijl[2] = 0;
            //groen
        if(value7 == 1 && value8 == 1 && value9 == 1 && value10 == 1) pijl[2] = 1;
        
        return pijl;
    }

    public int[] loadStuur(){
        int [] stuur = {0, 0, 0};
        int value1 = 0;
        int value2 = 0; 
        int value3 = 0; 
        int value4 = 0; 
        int value5 = 0; 
        int value6 = 0; 
        int value7 = 0; 
        int value8 = 0; 
        int value9 = 0; 
        int value10 = 0; 
        int value11 = 0; 
        int value12 = 0;
        //inlezen van waarden
        if(selectedEva == 1){
            value1 = leerlingController.getEva1().getHouding();
            value2 = leerlingController.getEva1().getRemmen();
            value3 = leerlingController.getEva1().getKoppeling();
            value4 = leerlingController.getEva1().getSturen();
            value5 = leerlingController.getEva1().getSchakelen();
            value6 = leerlingController.getEva1().getKijken();
            value7 = leerlingController.getEva1().getParkeren();
            value8 = leerlingController.getEva1().getKeren();
            value9 = leerlingController.getEva1().getGarage();
            value10 = leerlingController.getEva1().getAchteruit();
            value11 = leerlingController.getEva1().getStuuroef();
            value12 = leerlingController.getEva1().getHelling();
        }
        if(selectedEva == 2){
            value1 = leerlingController.getEva2().getHouding();
            value2 = leerlingController.getEva2().getRemmen();
            value3 = leerlingController.getEva2().getKoppeling();
            value4 = leerlingController.getEva2().getSturen();
            value5 = leerlingController.getEva2().getSchakelen();
            value6 = leerlingController.getEva2().getKijken();
            value7 = leerlingController.getEva2().getParkeren();
            value8 = leerlingController.getEva2().getKeren();
            value9 = leerlingController.getEva2().getGarage();
            value10 = leerlingController.getEva2().getAchteruit();
            value11 = leerlingController.getEva2().getStuuroef();
            value12 = leerlingController.getEva2().getHelling();
        }
        if(selectedEva == 3){
            value1 = leerlingController.getEva3().getHouding();
            value2 = leerlingController.getEva3().getRemmen();
            value3 = leerlingController.getEva3().getKoppeling();
            value4 = leerlingController.getEva3().getSturen();
            value5 = leerlingController.getEva3().getSchakelen();
            value6 = leerlingController.getEva3().getKijken();
            value7 = leerlingController.getEva3().getParkeren();
            value8 = leerlingController.getEva3().getKeren();
            value9 = leerlingController.getEva3().getGarage();
            value10 = leerlingController.getEva3().getAchteruit();
            value11 = leerlingController.getEva3().getStuuroef();
            value12 = leerlingController.getEva3().getHelling();
        }
        //stuur 1 value 1-6
            //neutraal check 1
        if(value1 == 0 || value2 == 0 || value3 == 0 || value4 == 0 || value5 == 0 || value6 == 0) stuur[0] = 0;
            //oranje
        if(value1 == 2 || value2 == 2 || value3 == 2 || value4 == 2 || value5 == 2 || value6 == 2) stuur[0] = 2;
            //rood
        if(value1 == 3 || value2 == 3 || value3 == 3 || value4 == 3 || value5 == 3 || value6 == 3) stuur[0] = 3;
            //neutraal check 2
        if(value1 == 0 && value2 == 0 && value3 == 0 && value4 == 0 && value5 == 0 && value6 == 0) stuur[0] = 0;
            //Groen
        if(value1 == 1 && value2 == 1 && value3 == 1 && value4 == 1 && value5 == 1 && value6 == 1) stuur[0] = 1;
        
        //stuur 2 value 10-12
            //neutraal check 1
        if(value10 == 0 || value11 == 0 || value12 == 0) stuur[1] = 0;
            //oranje
        if(value10 == 2 || value11 == 2 || value12 == 2) stuur[1] = 2;
            //rood
        if(value10 == 3 || value11 == 3 || value12 == 3) stuur[1] = 3;
            //neutraal check 2
        if(value10 == 0 && value11 == 0 && value12 == 0) stuur[1] = 0;
            //groen
        if(value10 == 1 && value11 == 1 && value12 == 1) stuur[1] = 1;
        
        //stuur 3 value 7-9
            //neutraal check 1
        if(value7 == 0 || value8 == 0 || value9 == 0) stuur[2] = 0;
            //oranje
        if(value7 == 2 || value8 == 2 || value9 == 2) stuur[2] = 2;
            //rood
        if(value7 == 3 || value8 == 3 || value9 == 3) stuur[2] = 3;
            //neutraal check 2
        if(value7 == 0 && value8 == 0 && value9 == 0) stuur[2] = 0;
            //groen
        if(value7 == 1 && value8 == 1 && value9 == 1) stuur[2] = 1;
            
        return stuur;
    }
    
    public ObservableList<Rijtechniek> loadListDataRijtechniek(String attribuut){
        ObservableList<Rijtechniek> list = FXCollections.observableArrayList();
        
        if(selectedEva == 1){
            if(attribuut.equals("Houding")) list = leerlingController.getEva1().getHoudingOpm();
            if(attribuut.equals("Kijktechniek")) list = leerlingController.getEva1().getKijkenOpm();
            if(attribuut.equals("Koppeling")) list = leerlingController.getEva1().getHoudingOpm();
            if(attribuut.equals("Remtechniek")) list = leerlingController.getEva1().getHoudingOpm();
            if(attribuut.equals("Schakeltechniek")) list = leerlingController.getEva1().getHoudingOpm();
            if(attribuut.equals("Stuurtechniek")) list = leerlingController.getEva1().getHoudingOpm();
        }
        if(selectedEva == 2){
            if(attribuut.equals("Houding")) list = leerlingController.getEva2().getHoudingOpm();
            if(attribuut.equals("Kijktechniek")) list = leerlingController.getEva2().getKijkenOpm();
            if(attribuut.equals("Koppeling")) list = leerlingController.getEva2().getHoudingOpm();
            if(attribuut.equals("Remtechniek")) list = leerlingController.getEva2().getHoudingOpm();
            if(attribuut.equals("Schakeltechniek")) list = leerlingController.getEva2().getHoudingOpm();
            if(attribuut.equals("Stuurtechniek")) list = leerlingController.getEva2().getHoudingOpm();
        }
        if(selectedEva == 3){
            if(attribuut.equals("Houding")) list = leerlingController.getEva3().getHoudingOpm();
            if(attribuut.equals("Kijktechniek")) list = leerlingController.getEva3().getKijkenOpm();
            if(attribuut.equals("Koppeling")) list = leerlingController.getEva3().getHoudingOpm();
            if(attribuut.equals("Remtechniek")) list = leerlingController.getEva3().getHoudingOpm();
            if(attribuut.equals("Schakeltechniek")) list = leerlingController.getEva3().getHoudingOpm();
            if(attribuut.equals("Stuurtechniek")) list = leerlingController.getEva3().getHoudingOpm();
        }
        
        return list;
    }
    
    public void saveListDataRijtechniek(String attribuut, ObservableList<Rijtechniek> list){
        
        if(selectedEva == 1){
            if(attribuut.equals("Houding"))leerlingController.getEva1().setHoudingOpm(list);
            if(attribuut.equals("Kijktechniek"))leerlingController.getEva1().setKijkenOpm(list);
            if(attribuut.equals("Koppeling"))leerlingController.getEva1().setKoppelingOpm(list);
            if(attribuut.equals("Remtechniek"))leerlingController.getEva1().setRemmenOpm(list);
            if(attribuut.equals("Schakeltechniek"))leerlingController.getEva1().setSchakelenOpm(list);
            if(attribuut.equals("Stuurtechniek"))leerlingController.getEva1().setSturenOpm(list);
        }
        if(selectedEva == 2){
            if(attribuut.equals("Houding"))leerlingController.getEva2().setHoudingOpm(list);
            if(attribuut.equals("Kijktechniek"))leerlingController.getEva2().setKijkenOpm(list);
            if(attribuut.equals("Koppeling"))leerlingController.getEva2().setKoppelingOpm(list);
            if(attribuut.equals("Remtechniek"))leerlingController.getEva2().setRemmenOpm(list);
            if(attribuut.equals("Schakeltechniek"))leerlingController.getEva2().setSchakelenOpm(list);
            if(attribuut.equals("Stuurtechniek"))leerlingController.getEva2().setSturenOpm(list);
        }
        if(selectedEva == 3){
            if(attribuut.equals("Houding"))leerlingController.getEva3().setHoudingOpm(list);
            if(attribuut.equals("Kijktechniek"))leerlingController.getEva3().setKijkenOpm(list);
            if(attribuut.equals("Koppeling"))leerlingController.getEva3().setKoppelingOpm(list);
            if(attribuut.equals("Remtechniek"))leerlingController.getEva3().setRemmenOpm(list);
            if(attribuut.equals("Schakeltechniek"))leerlingController.getEva3().setSchakelenOpm(list);
            if(attribuut.equals("Stuurtechniek"))leerlingController.getEva3().setSturenOpm(list);
        }
        
    }
    
    public ObservableList<Verkeerstechniek> loadListDataVerkeerstechniek (String attribuut){
        
        ObservableList<Verkeerstechniek> list = FXCollections.observableArrayList();
        
        if(selectedEva == 1){
            if(attribuut.equals("Afstand")) list = leerlingController.getEva1().getAfstandOpm();
            if(attribuut.equals("Inhalen")) list = leerlingController.getEva1().getInhalenOpm();
            if(attribuut.equals("Kruisen")) list = leerlingController.getEva1().getKruisenOpm();
            if(attribuut.equals("Linksaf")) list = leerlingController.getEva1().getLinksafOpm();
            if(attribuut.equals("Plaats")) list = leerlingController.getEva1().getOpenbareWegOpm();
            if(attribuut.equals("Rechtsaf")) list = leerlingController.getEva1().getRechtsafOpm();
            if(attribuut.equals("Richtingaanwijzers")) list = leerlingController.getEva1().getRichtingaanwijzersOpm();
            if(attribuut.equals("Snelheid")) list = leerlingController.getEva1().getSnelheidOpm();
            if(attribuut.equals("Verkeerstekens")) list = leerlingController.getEva1().getVerkeerstekensOpm();
            if(attribuut.equals("Voorrang")) list = leerlingController.getEva1().getVoorrangOpm();
        }
        
        if(selectedEva == 2){
            if(attribuut.equals("Afstand")) list = leerlingController.getEva2().getAfstandOpm();
            if(attribuut.equals("Inhalen")) list = leerlingController.getEva2().getInhalenOpm();
            if(attribuut.equals("Kruisen")) list = leerlingController.getEva2().getKruisenOpm();
            if(attribuut.equals("Linksaf")) list = leerlingController.getEva2().getLinksafOpm();
            if(attribuut.equals("Plaats")) list = leerlingController.getEva2().getOpenbareWegOpm();
            if(attribuut.equals("Rechtsaf")) list = leerlingController.getEva2().getRechtsafOpm();
            if(attribuut.equals("Richtingaanwijzers")) list = leerlingController.getEva2().getRichtingaanwijzersOpm();
            if(attribuut.equals("Snelheid")) list = leerlingController.getEva2().getSnelheidOpm();
            if(attribuut.equals("Verkeerstekens")) list = leerlingController.getEva2().getVerkeerstekensOpm();
            if(attribuut.equals("Voorrang")) list = leerlingController.getEva2().getVoorrangOpm();
            
        }
        
        if(selectedEva == 3){
            if(attribuut.equals("Afstand")) list = leerlingController.getEva3().getAfstandOpm();
            if(attribuut.equals("Inhalen")) list = leerlingController.getEva3().getInhalenOpm();
            if(attribuut.equals("Kruisen")) list = leerlingController.getEva3().getKruisenOpm();
            if(attribuut.equals("Linksaf")) list = leerlingController.getEva3().getLinksafOpm();
            if(attribuut.equals("Plaats")) list = leerlingController.getEva3().getOpenbareWegOpm();
            if(attribuut.equals("Rechtsaf")) list = leerlingController.getEva3().getRechtsafOpm();
            if(attribuut.equals("Richtingaanwijzers")) list = leerlingController.getEva3().getRichtingaanwijzersOpm();
            if(attribuut.equals("Snelheid")) list = leerlingController.getEva3().getSnelheidOpm();
            if(attribuut.equals("Verkeerstekens")) list = leerlingController.getEva3().getVerkeerstekensOpm();
            if(attribuut.equals("Voorrang")) list = leerlingController.getEva3().getVoorrangOpm();
        }
        
        return list;
    }
    
    public void saveListDataVerkeerstechniek (String attribuut, ObservableList<Verkeerstechniek> list){
                
        if(selectedEva == 1){
            if(attribuut.equals("Afstand"))   leerlingController.getEva1().setAfstandOpm(list);
            if(attribuut.equals("Inhalen"))   leerlingController.getEva1().setInhalenOpm(list);
            if(attribuut.equals("Kruisen"))   leerlingController.getEva1().setKruisenOpm(list);
            if(attribuut.equals("Linksaf"))   leerlingController.getEva1().setLinksafOpm(list);
            if(attribuut.equals("Plaats"))   leerlingController.getEva1().setOpenbareWegOpm(list);
            if(attribuut.equals("Rechtsaf"))   leerlingController.getEva1().setRechtsafOpm(list);
            if(attribuut.equals("Richtingaanwijzers"))   leerlingController.getEva1().setRichtingaanwijzersOpm(list);
            if(attribuut.equals("Snelheid"))   leerlingController.getEva1().setSnelheidOpm(list);
            if(attribuut.equals("Verkeerstekens"))   leerlingController.getEva1().setVerkeerstekensOpm(list);
            if(attribuut.equals("Voorrang"))   leerlingController.getEva1().setVoorrangOpm(list);
        }
        
        if(selectedEva == 2){
            if(attribuut.equals("Afstand"))leerlingController.getEva2().setAfstandOpm(list);
            if(attribuut.equals("Inhalen"))leerlingController.getEva2().setInhalenOpm(list);
            if(attribuut.equals("Kruisen"))leerlingController.getEva2().setKruisenOpm(list);
            if(attribuut.equals("Linksaf"))leerlingController.getEva2().setLinksafOpm(list);
            if(attribuut.equals("Plaats"))leerlingController.getEva2().setOpenbareWegOpm(list);
            if(attribuut.equals("Rechtsaf"))leerlingController.getEva2().setRechtsafOpm(list);
            if(attribuut.equals("Richtingaanwijzers"))leerlingController.getEva2().setRichtingaanwijzersOpm(list);
            if(attribuut.equals("Snelheid"))leerlingController.getEva2().setSnelheidOpm(list);
            if(attribuut.equals("Verkeerstekens"))leerlingController.getEva2().setVerkeerstekensOpm(list);
            if(attribuut.equals("Voorrang"))leerlingController.getEva2().setVoorrangOpm(list);
            
        }
        
        if(selectedEva == 3){
            if(attribuut.equals("Afstand"))leerlingController.getEva3().setAfstandOpm(list);
            if(attribuut.equals("Inhalen"))leerlingController.getEva3().setInhalenOpm(list);
            if(attribuut.equals("Kruisen"))leerlingController.getEva3().setKruisenOpm(list);
            if(attribuut.equals("Linksaf"))leerlingController.getEva3().setLinksafOpm(list);
            if(attribuut.equals("Plaats"))leerlingController.getEva3().setOpenbareWegOpm(list);
            if(attribuut.equals("Rechtsaf"))leerlingController.getEva3().setRechtsafOpm(list);
            if(attribuut.equals("Richtingaanwijzers"))leerlingController.getEva3().setRichtingaanwijzersOpm(list);
            if(attribuut.equals("Snelheid"))leerlingController.getEva3().setSnelheidOpm(list);
            if(attribuut.equals("Verkeerstekens"))leerlingController.getEva3().setVerkeerstekensOpm(list);
            if(attribuut.equals("Voorrang"))leerlingController.getEva3().setVoorrangOpm(list);
        }
    }
    
    public void loadColorData(Onderdeel onderdeel){
        
        String base = onderdeel.getBase();
        int status = 0;
        
        //Hoofdmenu
            //links
        if(base.equals("resource/Hoofdmenu/schakelaars")){
            if(selectedEva == 1) status = leerlingController.getEva1().getSchakelaars();
            if(selectedEva == 2) status = leerlingController.getEva2().getSchakelaars();
            if(selectedEva == 3) status = leerlingController.getEva3().getSchakelaars();
        }     
        if(base.equals("resource/Hoofdmenu/vloeistoffen")){
            if(selectedEva == 1) status = leerlingController.getEva1().getVloeistoffen();
            if(selectedEva == 2) status = leerlingController.getEva2().getVloeistoffen();
            if(selectedEva == 3) status = leerlingController.getEva3().getVloeistoffen();
        }
        if(base.equals("resource/Hoofdmenu/banden")){
            if(selectedEva == 1) status = leerlingController.getEva1().getBanden();
            if(selectedEva == 2) status = leerlingController.getEva2().getBanden();
            if(selectedEva == 3) status = leerlingController.getEva3().getBanden();
        }
        
            //rechts
        if(base.equals("resource/Hoofdmenu/tanken")){
            if(selectedEva == 1) status = leerlingController.getEva1().getTanken();
            if(selectedEva == 2) status = leerlingController.getEva2().getTanken();
            if(selectedEva == 3) status = leerlingController.getEva3().getTanken();
        }     
        if(base.equals("resource/Hoofdmenu/gps")){
            if(selectedEva == 1) status = leerlingController.getEva1().getGps();
            if(selectedEva == 2) status = leerlingController.getEva2().getGps();
            if(selectedEva == 3) status = leerlingController.getEva3().getGps();
        }
        
        if(base.equals("resource/Hoofdmenu/stop")){
            if(selectedEva == 1) status = leerlingController.getEva1().getNoodstop();
            if(selectedEva == 2) status = leerlingController.getEva2().getNoodstop();
            if(selectedEva == 3) status = leerlingController.getEva3().getNoodstop();
        }
        
            //top
        if(base.equals("resource/Hoofdmenu/stad")){
            if(selectedEva == 1) status = leerlingController.getEva1().getStad();
            if(selectedEva == 2) status = leerlingController.getEva2().getStad();
            if(selectedEva == 3) status = leerlingController.getEva3().getStad();
        }
        if(base.equals("resource/Hoofdmenu/snelweg")){
            if(selectedEva == 1) status = leerlingController.getEva1().getAutosnelweg();
            if(selectedEva == 2) status = leerlingController.getEva2().getAutosnelweg();
            if(selectedEva == 3) status = leerlingController.getEva3().getAutosnelweg();
        }
        if(base.equals("resource/Hoofdmenu/rotonde")){
            if(selectedEva == 1) status = leerlingController.getEva1().getRotonde();
            if(selectedEva == 2) status = leerlingController.getEva2().getRotonde();
            if(selectedEva == 3) status = leerlingController.getEva3().getRotonde();
        }
        if(base.equals("resource/Hoofdmenu/rijstroken")){
            if(selectedEva == 1) status = leerlingController.getEva1().getRijstroken();
            if(selectedEva == 2) status = leerlingController.getEva2().getRijstroken();
            if(selectedEva == 3) status = leerlingController.getEva3().getRijstroken();
        }
        
        //rijtechniek
        if(base.equals("resource/Rijtechniek/stuuroef")){
            if(selectedEva == 1) status = leerlingController.getEva1().getStuuroef();
            if(selectedEva == 2) status = leerlingController.getEva2().getStuuroef();
            if(selectedEva == 3) status = leerlingController.getEva3().getStuuroef();
        }
        if(base.equals("resource/Rijtechniek/keren")){
            if(selectedEva == 1) status = leerlingController.getEva1().getKeren();
            if(selectedEva == 2) status = leerlingController.getEva2().getKeren();
            if(selectedEva == 3) status = leerlingController.getEva3().getKeren();
        }
        if(base.equals("resource/Rijtechniek/garage")){
            if(selectedEva == 1) status = leerlingController.getEva1().getGarage();
            if(selectedEva == 2) status = leerlingController.getEva2().getGarage();
            if(selectedEva == 3) status = leerlingController.getEva3().getGarage();
        }
        if(base.equals("resource/Rijtechniek/parkeren")){
            if(selectedEva == 1) status = leerlingController.getEva1().getParkeren();
            if(selectedEva == 2) status = leerlingController.getEva2().getParkeren();
            if(selectedEva == 3) status = leerlingController.getEva3().getParkeren();
        }
        if(base.equals("resource/Rijtechniek/achteruit")){
            if(selectedEva == 1) status = leerlingController.getEva1().getAchteruit();
            if(selectedEva == 2) status = leerlingController.getEva2().getAchteruit();
            if(selectedEva == 3) status = leerlingController.getEva3().getAchteruit();
        }
        if(base.equals("resource/Rijtechniek/rem")){
            if(selectedEva == 1) status = leerlingController.getEva1().getRemmen();
            if(selectedEva == 2) status = leerlingController.getEva2().getRemmen();
            if(selectedEva == 3) status = leerlingController.getEva3().getRemmen();
        }
        if(base.equals("resource/Rijtechniek/koppeling")){
            if(selectedEva == 1) status = leerlingController.getEva1().getKoppeling();
            if(selectedEva == 2) status = leerlingController.getEva2().getKoppeling();
            if(selectedEva == 3) status = leerlingController.getEva3().getKoppeling();
        }
        if(base.equals("resource/Rijtechniek/helling")){
            if(selectedEva == 1) status = leerlingController.getEva1().getHelling();
            if(selectedEva == 2) status = leerlingController.getEva2().getHelling();
            if(selectedEva == 3) status = leerlingController.getEva3().getHelling();
        }
        if(base.equals("resource/Rijtechniek/kijk")){
            if(selectedEva == 1) status = leerlingController.getEva1().getKijken();
            if(selectedEva == 2) status = leerlingController.getEva2().getKijken();
            if(selectedEva == 3) status = leerlingController.getEva3().getKijken();
        }
        if(base.equals("resource/Rijtechniek/schakel")){
            if(selectedEva == 1) status = leerlingController.getEva1().getSchakelen();
            if(selectedEva == 2) status = leerlingController.getEva2().getSchakelen();
            if(selectedEva == 3) status = leerlingController.getEva3().getSchakelen();
        }
        if(base.equals("resource/Rijtechniek/stuur")){
            if(selectedEva == 1) status = leerlingController.getEva1().getSturen();
            if(selectedEva == 2) status = leerlingController.getEva2().getSturen();
            if(selectedEva == 3) status = leerlingController.getEva3().getSturen();
        }
        if(base.equals("resource/Rijtechniek/houding")){
            if(selectedEva == 1) status = leerlingController.getEva1().getHouding();
            if(selectedEva == 2) status = leerlingController.getEva2().getHouding();
            if(selectedEva == 3) status = leerlingController.getEva3().getHouding();
        }
        
        //verkeerstechniek
        if(base.equals("resource/Verkeerstechniek/openbareWeg")){
            if(selectedEva == 1) status = leerlingController.getEva1().getOpenbareWeg();
            if(selectedEva == 2) status = leerlingController.getEva2().getOpenbareWeg();
            if(selectedEva == 3) status = leerlingController.getEva3().getOpenbareWeg();
        }
        if(base.equals("resource/Verkeerstechniek/richtingaanwijzers")){
            if(selectedEva == 1) status = leerlingController.getEva1().getRichtingaanwijzers();
            if(selectedEva == 2) status = leerlingController.getEva2().getRichtingaanwijzers();
            if(selectedEva == 3) status = leerlingController.getEva3().getRichtingaanwijzers();
        }
        if(base.equals("resource/Verkeerstechniek/rechtsaf")){
            if(selectedEva == 1) status = leerlingController.getEva1().getRechtsaf();
            if(selectedEva == 2) status = leerlingController.getEva2().getRechtsaf();
            if(selectedEva == 3) status = leerlingController.getEva3().getRechtsaf();
        }
        if(base.equals("resource/Verkeerstechniek/linksaf")){
            if(selectedEva == 1) status = leerlingController.getEva1().getLinksaf();
            if(selectedEva == 2) status = leerlingController.getEva2().getLinksaf();
            if(selectedEva == 3) status = leerlingController.getEva3().getLinksaf();
        }
        if(base.equals("resource/Verkeerstechniek/kruisen")){
            if(selectedEva == 1) status = leerlingController.getEva1().getKruisen();
            if(selectedEva == 2) status = leerlingController.getEva2().getKruisen();
            if(selectedEva == 3) status = leerlingController.getEva3().getKruisen();
        }
        if(base.equals("resource/Verkeerstechniek/voorrang")){
            if(selectedEva == 1) status = leerlingController.getEva1().getVoorrang();
            if(selectedEva == 2) status = leerlingController.getEva2().getVoorrang();
            if(selectedEva == 3) status = leerlingController.getEva3().getVoorrang();
        }
        if(base.equals("resource/Verkeerstechniek/verkeerstekens")){
            if(selectedEva == 1) status = leerlingController.getEva1().getVerkeerstekens();
            if(selectedEva == 2) status = leerlingController.getEva2().getVerkeerstekens();
            if(selectedEva == 3) status = leerlingController.getEva3().getVerkeerstekens();
        }
        if(base.equals("resource/Verkeerstechniek/snelheid")){
            if(selectedEva == 1) status = leerlingController.getEva1().getSnelheid();
            if(selectedEva == 2) status = leerlingController.getEva2().getSnelheid();
            if(selectedEva == 3) status = leerlingController.getEva3().getSnelheid();
        }
        if(base.equals("resource/Verkeerstechniek/afstand")){
            if(selectedEva == 1) status = leerlingController.getEva1().getAfstand();
            if(selectedEva == 2) status = leerlingController.getEva2().getAfstand();
            if(selectedEva == 3) status = leerlingController.getEva3().getAfstand();
        }
        if(base.equals("resource/Verkeerstechniek/inhalen")){
            if(selectedEva == 1) status = leerlingController.getEva1().getInhalen();
            if(selectedEva == 2) status = leerlingController.getEva2().getInhalen();
            if(selectedEva == 3) status = leerlingController.getEva3().getInhalen();
        }
        
        
        onderdeel.setStatus(status);
    }
    
    
    public void saveColorData(String base, int status){
        //hoofdmenu
            //links
            int selectedEva = getSelectedEva();
            int code; //bepaald rangorde van de kleuren
            
        if(base.equals("resource/Hoofdmenu/schakelaars")){
            if(selectedEva == 1){
                leerlingController.getEva1().setSchakelaars(status);
                if(leerlingController.getEva2().getSchakelaars() == 0){
                    leerlingController.getEva2().setSchakelaars(status);
                }
                else{
                    if(status < leerlingController.getEva2().getSchakelaars()){
                        leerlingController.getEva2().setSchakelaars(status);
                    }
                }
                if(leerlingController.getEva3().getSchakelaars() == 0){
                    leerlingController.getEva3().setSchakelaars(status);
                }
                else{
                    if(status < leerlingController.getEva3().getSchakelaars()){
                        leerlingController.getEva3().setSchakelaars(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setSchakelaars(status);
                if(leerlingController.getEva3().getSchakelaars() == 0)leerlingController.getEva3().setSchakelaars(status);
                else{
                    if(status < leerlingController.getEva3().getSchakelaars()){
                        leerlingController.getEva3().setSchakelaars(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setSchakelaars(status);
        }
        
        if(base.equals("resource/Hoofdmenu/vloeistoffen")){
            if(selectedEva == 1){
                leerlingController.getEva1().setVloeistoffen(status);
                if(leerlingController.getEva2().getVloeistoffen() == 0){
                    leerlingController.getEva2().setVloeistoffen(status);
                }
                else{
                    if(status < leerlingController.getEva3().getVloeistoffen()){
                        leerlingController.getEva2().setVloeistoffen(status);
                    }
                }
                if(leerlingController.getEva3().getVloeistoffen() == 0){
                    leerlingController.getEva3().setVloeistoffen(status);
                }
                else{
                    if(status < leerlingController.getEva2().getVloeistoffen()){
                        leerlingController.getEva3().setVloeistoffen(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setVloeistoffen(status);
                if(leerlingController.getEva3().getVloeistoffen() == 0)leerlingController.getEva3().setVloeistoffen(status);
                else{
                    if(status < leerlingController.getEva2().getVloeistoffen()){
                        leerlingController.getEva3().setVloeistoffen(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setVloeistoffen(status);
        }
        
        if(base.equals("resource/Hoofdmenu/banden")){
            if(selectedEva == 1){
                leerlingController.getEva1().setBanden(status);
                if(leerlingController.getEva2().getBanden() == 0){
                    leerlingController.getEva2().setBanden(status);
                }
                else{
                    if(status < leerlingController.getEva2().getBanden()){
                        leerlingController.getEva2().setBanden(status);
                    }
                }
                if(leerlingController.getEva3().getBanden() == 0){
                    leerlingController.getEva3().setBanden(status);
                }
                else{
                    if(status < leerlingController.getEva3().getBanden()){
                        leerlingController.getEva3().setBanden(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setBanden(status);
                if(leerlingController.getEva3().getBanden() == 0)leerlingController.getEva3().setBanden(status);
                else{
                    if(status < leerlingController.getEva3().getBanden()){
                        leerlingController.getEva3().setBanden(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setBanden(status);
        }
            //rechts
        if(base.equals("resource/Hoofdmenu/tanken")){
            if(selectedEva == 1){
                leerlingController.getEva1().setTanken(status);
                if(leerlingController.getEva2().getTanken() == 0){
                    leerlingController.getEva2().setTanken(status);
                }
                else{
                    if(status < leerlingController.getEva2().getTanken()){
                        leerlingController.getEva2().setTanken(status);
                    }
                }
                if(leerlingController.getEva3().getTanken() == 0){
                    leerlingController.getEva3().setTanken(status);
                }
                else{
                    if(status < leerlingController.getEva3().getTanken()){
                        leerlingController.getEva3().setTanken(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setTanken(status);
                if(leerlingController.getEva3().getTanken() == 0)leerlingController.getEva3().setTanken(status);
                else{
                    if(status < leerlingController.getEva3().getTanken()){
                        leerlingController.getEva3().setTanken(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setTanken(status);
        }
        
        if(base.equals("resource/Hoofdmenu/gps")){
            if(selectedEva == 1){
                leerlingController.getEva1().setGps(status);
                if(leerlingController.getEva2().getGps() == 0){
                    leerlingController.getEva2().setGps(status);
                }
                else{
                    if(status < leerlingController.getEva2().getGps()){
                        leerlingController.getEva2().setGps(status);
                    }
                }
                if(leerlingController.getEva3().getGps() == 0){
                    leerlingController.getEva3().setGps(status);
                }
                else{
                    if(status < leerlingController.getEva3().getGps()){
                        leerlingController.getEva3().setGps(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setGps(status);
                if(leerlingController.getEva3().getGps() == 0)leerlingController.getEva3().setGps(status);
                else{
                    if(status < leerlingController.getEva3().getGps()){
                        leerlingController.getEva3().setGps(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setGps(status);
        }
        
        if(base.equals("resource/Hoofdmenu/stop")){
            if(selectedEva == 1){
                leerlingController.getEva1().setNoodstop(status);
                if(leerlingController.getEva2().getNoodstop() == 0){
                    leerlingController.getEva2().setNoodstop(status);
                }
                else{
                    if(status < leerlingController.getEva2().getNoodstop()){
                        leerlingController.getEva2().setNoodstop(status);
                    }
                }
                if(leerlingController.getEva3().getNoodstop() == 0){
                    leerlingController.getEva3().setNoodstop(status);
                }
                else{
                    if(status < leerlingController.getEva3().getNoodstop()){
                        leerlingController.getEva3().setNoodstop(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setNoodstop(status);
                if(leerlingController.getEva3().getNoodstop() == 0)leerlingController.getEva3().setNoodstop(status);
                else{
                    if(status < leerlingController.getEva3().getNoodstop()){
                        leerlingController.getEva3().setNoodstop(status);
                    }
                }
            }    
            if(selectedEva == 3) leerlingController.getEva3().setNoodstop(status);
        }
            //top
        if(base.equals("resource/Hoofdmenu/stad")){
            if(selectedEva == 1){
                leerlingController.getEva1().setStad(status);
                if(leerlingController.getEva2().getStad() == 0){
                    leerlingController.getEva2().setStad(status);
                }
                else{
                    if(status < leerlingController.getEva2().getStad()){
                        leerlingController.getEva2().setStad(status);
                    }
                }
                if(leerlingController.getEva3().getStad() == 0){
                    leerlingController.getEva3().setStad(status);
                }
                else{
                    if(status < leerlingController.getEva3().getStad()){
                        leerlingController.getEva3().setStad(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setStad(status);
                if(leerlingController.getEva3().getStad() == 0)leerlingController.getEva3().setStad(status);
                else{
                    if(status < leerlingController.getEva3().getStad()){
                        leerlingController.getEva3().setStad(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setStad(status);
        }
        if(base.equals("resource/Hoofdmenu/snelweg")){
            if(selectedEva == 1){
                leerlingController.getEva1().setAutosnelweg(status);
                if(leerlingController.getEva2().getAutosnelweg() == 0){
                    leerlingController.getEva2().setAutosnelweg(status);
                }
                else{
                    if(status < leerlingController.getEva2().getAutosnelweg()){
                        leerlingController.getEva2().setAutosnelweg(status);
                    }
                }
                if(leerlingController.getEva3().getAutosnelweg() == 0){
                    leerlingController.getEva3().setAutosnelweg(status);
                }
                else{
                    if(status < leerlingController.getEva3().getAutosnelweg()){
                        leerlingController.getEva3().setAutosnelweg(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setAutosnelweg(status);
                if(leerlingController.getEva3().getAutosnelweg() == 0)leerlingController.getEva3().setAutosnelweg(status);
                else{
                    if(status < leerlingController.getEva3().getAutosnelweg()){
                        leerlingController.getEva3().setAutosnelweg(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setAutosnelweg(status);
        }
        if(base.equals("resource/Hoofdmenu/rotonde")){
            if(selectedEva == 1){
                leerlingController.getEva1().setRotonde(status);
                if(leerlingController.getEva2().getRotonde() == 0){
                    leerlingController.getEva2().setRotonde(status);
                }
                else{
                    if(status < leerlingController.getEva2().getRotonde()){
                        leerlingController.getEva2().setRotonde(status);
                    }
                }
                if(leerlingController.getEva3().getRotonde() == 0){
                    leerlingController.getEva3().setRotonde(status);
                }
                else{
                    if(status < leerlingController.getEva3().getRotonde()){
                        leerlingController.getEva3().setRotonde(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setRotonde(status);
                if(leerlingController.getEva3().getRotonde() == 0)leerlingController.getEva3().setRotonde(status);
                else{
                    if(status < leerlingController.getEva3().getRotonde()){
                        leerlingController.getEva3().setRotonde(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setRotonde(status);
        }
        if(base.equals("resource/Hoofdmenu/rijstroken")){
            if(selectedEva == 1){
                leerlingController.getEva1().setRijstroken(status);
                if(leerlingController.getEva2().getRijstroken() == 0){
                    leerlingController.getEva2().setRijstroken(status);
                }
                else{
                    if(status < leerlingController.getEva2().getRijstroken()){
                        leerlingController.getEva2().setRijstroken(status);
                    }
                }
                if(leerlingController.getEva3().getRijstroken() == 0){
                    leerlingController.getEva3().setRijstroken(status);
                }
                else{
                    if(status < leerlingController.getEva3().getRijstroken()){
                        leerlingController.getEva3().setRijstroken(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setRijstroken(status);
                if(leerlingController.getEva3().getRijstroken() == 0)leerlingController.getEva3().setRijstroken(status);
                else{
                    if(status < leerlingController.getEva3().getRijstroken()){
                        leerlingController.getEva3().setRijstroken(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setRijstroken(status);
        }
        //rijtechniek
        if(base.equals("resource/Rijtechniek/stuuroef")){
            if(selectedEva == 1){
                leerlingController.getEva1().setStuuroef(status);
                if(leerlingController.getEva2().getStuuroef() == 0){
                    leerlingController.getEva2().setStuuroef(status);
                }
                else{
                    if(status < leerlingController.getEva2().getStuuroef()){
                        leerlingController.getEva2().setStuuroef(status);
                    }
                }
                if(leerlingController.getEva3().getStuuroef() == 0){
                    leerlingController.getEva3().setStuuroef(status);
                }
                else{
                    if(status < leerlingController.getEva3().getStuuroef()){
                        leerlingController.getEva3().setStuuroef(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setStuuroef(status);
                if(leerlingController.getEva3().getStuuroef() == 0)leerlingController.getEva3().setStuuroef(status);
                else{
                    if(status < leerlingController.getEva3().getStuuroef()){
                        leerlingController.getEva3().setStuuroef(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setStuuroef(status);
        }
        if(base.equals("resource/Rijtechniek/keren")){
            if(selectedEva == 1){
                leerlingController.getEva1().setKeren(status);
                if(leerlingController.getEva2().getKeren() == 0){
                    leerlingController.getEva2().setKeren(status);
                }
                else{
                    if(status < leerlingController.getEva2().getKeren()){
                        leerlingController.getEva2().setKeren(status);
                    }
                }
                if(leerlingController.getEva3().getKeren() == 0){
                    leerlingController.getEva3().setKeren(status);
                }
                else{
                    if(status < leerlingController.getEva3().getKeren()){
                        leerlingController.getEva3().setKeren(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setKeren(status);
                if(leerlingController.getEva3().getKeren() == 0)leerlingController.getEva3().setKeren(status);
                else{
                    if(status < leerlingController.getEva3().getKeren()){
                        leerlingController.getEva3().setKeren(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setKeren(status);
        }
        if(base.equals("resource/Rijtechniek/garage")){
            if(selectedEva == 1){
                leerlingController.getEva1().setGarage(status);
                if(leerlingController.getEva2().getGarage() == 0){
                    leerlingController.getEva2().setGarage(status);
                }
                else{
                    if(status < leerlingController.getEva2().getGarage()){
                        leerlingController.getEva2().setGarage(status);
                    }
                }
                if(leerlingController.getEva3().getGarage() == 0){
                    leerlingController.getEva3().setGarage(status);
                }
                else{
                    if(status < leerlingController.getEva3().getGarage()){
                        leerlingController.getEva3().setGarage(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setGarage(status);
                if(leerlingController.getEva3().getGarage() == 0)leerlingController.getEva3().setGarage(status);
                else{
                    if(status < leerlingController.getEva3().getGarage()){
                        leerlingController.getEva3().setGarage(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setGarage(status);
        }
        if(base.equals("resource/Rijtechniek/parkeren")){
            if(selectedEva == 1){
                leerlingController.getEva1().setParkeren(status);
                if(leerlingController.getEva2().getParkeren() == 0){
                    leerlingController.getEva2().setParkeren(status);
                }
                else{
                    if(status < leerlingController.getEva2().getParkeren()){
                        leerlingController.getEva2().setParkeren(status);
                    }
                }
                if(leerlingController.getEva3().getParkeren() == 0){
                    leerlingController.getEva3().setParkeren(status);
                }
                else{
                    if(status < leerlingController.getEva3().getParkeren()){
                        leerlingController.getEva3().setParkeren(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setParkeren(status);
                if(leerlingController.getEva3().getParkeren() == 0)leerlingController.getEva3().setParkeren(status);
                else{
                    if(status < leerlingController.getEva3().getParkeren()){
                        leerlingController.getEva3().setParkeren(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setParkeren(status);
        }
        if(base.equals("resource/Rijtechniek/achteruit")){
            if(selectedEva == 1){
                leerlingController.getEva1().setAchteruit(status);
                if(leerlingController.getEva2().getAchteruit() == 0){
                    leerlingController.getEva2().setAchteruit(status);
                }
                else{
                    if(status < leerlingController.getEva2().getAchteruit()){
                        leerlingController.getEva2().setAchteruit(status);
                    }
                }
                if(leerlingController.getEva3().getAchteruit() == 0){
                    leerlingController.getEva3().setAchteruit(status);
                }
                else{
                    if(status < leerlingController.getEva3().getAchteruit()){
                        leerlingController.getEva3().setAchteruit(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setAchteruit(status);
                if(leerlingController.getEva3().getAchteruit() == 0)leerlingController.getEva3().setAchteruit(status);
                else{
                    if(status < leerlingController.getEva3().getAchteruit()){
                        leerlingController.getEva3().setAchteruit(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setAchteruit(status);
        }
        if(base.equals("resource/Rijtechniek/rem")){
            if(selectedEva == 1){
                leerlingController.getEva1().setRemmen(status);
                if(leerlingController.getEva2().getRemmen() == 0){
                    leerlingController.getEva2().setRemmen(status);
                }
                else{
                    if(status < leerlingController.getEva2().getRemmen()){
                        leerlingController.getEva2().setRemmen(status);
                    }
                }
                if(leerlingController.getEva3().getRemmen() == 0){
                    leerlingController.getEva3().setRemmen(status);
                }
                else{
                    if(status < leerlingController.getEva3().getRemmen()){
                        leerlingController.getEva3().setRemmen(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setRemmen(status);
                if(leerlingController.getEva3().getRemmen() == 0)leerlingController.getEva3().setRemmen(status);
                else{
                    if(status < leerlingController.getEva3().getRemmen()){
                        leerlingController.getEva3().setRemmen(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setRemmen(status);
        }
        if(base.equals("resource/Rijtechniek/koppeling")){
            if(selectedEva == 1){
                leerlingController.getEva1().setKoppeling(status);
                if(leerlingController.getEva2().getKoppeling() == 0){
                    leerlingController.getEva2().setKoppeling(status);
                }
                else{
                    if(status < leerlingController.getEva2().getKoppeling()){
                        leerlingController.getEva2().setKoppeling(status);
                    }
                }
                if(leerlingController.getEva3().getKoppeling() == 0){
                    leerlingController.getEva3().setKoppeling(status);
                }
                else{
                    if(status < leerlingController.getEva3().getKoppeling()){
                        leerlingController.getEva3().setKoppeling(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setKoppeling(status);
                if(leerlingController.getEva3().getKoppeling() == 0)leerlingController.getEva3().setKoppeling(status);
                else{
                    if(status < leerlingController.getEva3().getKoppeling()){
                        leerlingController.getEva3().setKoppeling(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setKoppeling(status);
        }
        if(base.equals("resource/Rijtechniek/helling")){
            if(selectedEva == 1){
                leerlingController.getEva1().setHelling(status);
                if(leerlingController.getEva2().getHelling() == 0){
                    leerlingController.getEva2().setHelling(status);
                }
                else{
                    if(status < leerlingController.getEva2().getHelling()){
                        leerlingController.getEva2().setHelling(status);
                    }
                }
                if(leerlingController.getEva3().getHelling() == 0){
                    leerlingController.getEva3().setHelling(status);
                }
                else{
                    if(status < leerlingController.getEva3().getHelling()){
                        leerlingController.getEva3().setHelling(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setHelling(status);
                if(leerlingController.getEva3().getHelling() == 0)leerlingController.getEva3().setHelling(status);
                else{
                    if(status < leerlingController.getEva3().getHelling()){
                        leerlingController.getEva3().setHelling(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setHelling(status);
        }
        if(base.equals("resource/Rijtechniek/kijk")){
            if(selectedEva == 1){
                leerlingController.getEva1().setKijken(status);
                if(leerlingController.getEva2().getKijken() == 0){
                    leerlingController.getEva2().setKijken(status);
                }
                else{
                    if(status < leerlingController.getEva2().getKijken()){
                        leerlingController.getEva2().setKijken(status);
                    }
                }
                if(leerlingController.getEva3().getKijken() == 0){
                    leerlingController.getEva3().setKijken(status);
                }
                else{
                    if(status < leerlingController.getEva3().getKijken()){
                        leerlingController.getEva3().setKijken(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setKijken(status);
                if(leerlingController.getEva3().getKijken() == 0)leerlingController.getEva3().setKijken(status);
                else{
                    if(status < leerlingController.getEva3().getKijken()){
                        leerlingController.getEva3().setKijken(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setKijken(status);
        }
        if(base.equals("resource/Rijtechniek/schakel")){
            if(selectedEva == 1){
                leerlingController.getEva1().setSchakelen(status);
                if(leerlingController.getEva2().getSchakelen() == 0){
                    leerlingController.getEva2().setSchakelen(status);
                }
                else{
                    if(status < leerlingController.getEva2().getSchakelen()){
                        leerlingController.getEva2().setSchakelen(status);
                    }
                }
                if(leerlingController.getEva3().getSchakelen() == 0){
                    leerlingController.getEva3().setSchakelen(status);
                }
                else{
                    if(status < leerlingController.getEva3().getSchakelen()){
                        leerlingController.getEva3().setSchakelen(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setSchakelen(status);
                if(leerlingController.getEva3().getSchakelen() == 0)leerlingController.getEva3().setSchakelen(status);
                else{
                    if(status < leerlingController.getEva3().getSchakelen()){
                        leerlingController.getEva3().setSchakelen(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setSchakelen(status);
        }
        if(base.equals("resource/Rijtechniek/stuur")){
            if(selectedEva == 1){
                leerlingController.getEva1().setSturen(status);
                if(leerlingController.getEva2().getSturen() == 0){
                    leerlingController.getEva2().setSturen(status);
                }
                else{
                    if(status < leerlingController.getEva2().getSturen()){
                        leerlingController.getEva2().setSturen(status);
                    }
                }
                if(leerlingController.getEva3().getSturen() == 0){
                    leerlingController.getEva3().setSturen(status);
                }
                else{
                    if(status < leerlingController.getEva3().getSturen()){
                        leerlingController.getEva3().setSturen(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setSturen(status);
                if(leerlingController.getEva3().getSturen() == 0)leerlingController.getEva3().setSturen(status);
                else{
                    if(status < leerlingController.getEva3().getSturen()){
                        leerlingController.getEva3().setSturen(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setSturen(status);
        }
        if(base.equals("resource/Rijtechniek/houding")){
            if(selectedEva == 1){
                leerlingController.getEva1().setHouding(status);
                if(leerlingController.getEva2().getHouding() == 0){
                    leerlingController.getEva2().setHouding(status);
                }
                else{
                    if(status < leerlingController.getEva2().getHouding()){
                        leerlingController.getEva2().setHouding(status);
                    }
                }
                if(leerlingController.getEva3().getHouding() == 0){
                    leerlingController.getEva3().setHouding(status);
                }
                else{
                    if(status < leerlingController.getEva3().getHouding()){
                        leerlingController.getEva3().setHouding(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setHouding(status);
                if(leerlingController.getEva3().getHouding() == 0)leerlingController.getEva3().setHouding(status);
                else{
                    if(status < leerlingController.getEva3().getHouding()){
                        leerlingController.getEva3().setHouding(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setHouding(status);
        }
        
        //verkeerstechniek
        if(base.equals("resource/Verkeerstechniek/openbareWeg")){
            if(selectedEva == 1){
                leerlingController.getEva1().setOpenbareWeg(status);
                if(leerlingController.getEva2().getOpenbareWeg() == 0){
                    leerlingController.getEva2().setOpenbareWeg(status);
                }
                else{
                    if(status < leerlingController.getEva2().getOpenbareWeg()){
                        leerlingController.getEva2().setOpenbareWeg(status);
                    }
                }
                if(leerlingController.getEva3().getOpenbareWeg() == 0){
                    leerlingController.getEva3().setOpenbareWeg(status);
                }
                else{
                    if(status < leerlingController.getEva3().getOpenbareWeg()){
                        leerlingController.getEva3().setOpenbareWeg(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setOpenbareWeg(status);
                if(leerlingController.getEva3().getOpenbareWeg() == 0)leerlingController.getEva3().setOpenbareWeg(status);
                else{
                    if(status < leerlingController.getEva3().getOpenbareWeg()){
                        leerlingController.getEva3().setOpenbareWeg(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setOpenbareWeg(status);
        }
        if(base.equals("resource/Verkeerstechniek/richtingaanwijzers")){
            if(selectedEva == 1){
                leerlingController.getEva1().setRichtingaanwijzers(status);
                if(leerlingController.getEva2().getRichtingaanwijzers() == 0){
                    leerlingController.getEva2().setRichtingaanwijzers(status);
                }
                else{
                    if(status < leerlingController.getEva2().getRichtingaanwijzers()){
                        leerlingController.getEva2().setRichtingaanwijzers(status);
                    }
                }
                if(leerlingController.getEva3().getRichtingaanwijzers() == 0){
                    leerlingController.getEva3().setRichtingaanwijzers(status);
                }
                else{
                    if(status < leerlingController.getEva3().getRichtingaanwijzers()){
                        leerlingController.getEva3().setRichtingaanwijzers(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setRichtingaanwijzers(status);
                if(leerlingController.getEva3().getRichtingaanwijzers() == 0)leerlingController.getEva3().setRichtingaanwijzers(status);
                else{
                    if(status < leerlingController.getEva3().getRichtingaanwijzers()){
                        leerlingController.getEva3().setRichtingaanwijzers(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setRichtingaanwijzers(status);
        }
        if(base.equals("resource/Verkeerstechniek/rechtsaf")){
            if(selectedEva == 1){
                leerlingController.getEva1().setRechtsaf(status);
                if(leerlingController.getEva2().getRechtsaf() == 0){
                    leerlingController.getEva2().setRechtsaf(status);
                }
                else{
                    if(status < leerlingController.getEva2().getRechtsaf()){
                        leerlingController.getEva2().setRechtsaf(status);
                    }
                }
                if(leerlingController.getEva3().getRechtsaf() == 0){
                    leerlingController.getEva3().setRechtsaf(status);
                }
                else{
                    if(status < leerlingController.getEva3().getRechtsaf()){
                        leerlingController.getEva3().setRechtsaf(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setRechtsaf(status);
                if(leerlingController.getEva3().getRechtsaf() == 0)leerlingController.getEva3().setRechtsaf(status);
                else{
                    if(status < leerlingController.getEva3().getRechtsaf()){
                        leerlingController.getEva3().setRechtsaf(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setRechtsaf(status);
        }
        if(base.equals("resource/Verkeerstechniek/linksaf")){
            if(selectedEva == 1){
                leerlingController.getEva1().setLinksaf(status);
                if(leerlingController.getEva2().getLinksaf() == 0){
                    leerlingController.getEva2().setLinksaf(status);
                }
                else{
                    if(status < leerlingController.getEva2().getLinksaf()){
                        leerlingController.getEva2().setLinksaf(status);
                    }
                }
                if(leerlingController.getEva3().getLinksaf() == 0){
                    leerlingController.getEva3().setLinksaf(status);
                }
                else{
                    if(status < leerlingController.getEva3().getLinksaf()){
                        leerlingController.getEva3().setLinksaf(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setLinksaf(status);
                if(leerlingController.getEva3().getLinksaf() == 0)leerlingController.getEva3().setLinksaf(status);
                else{
                    if(status < leerlingController.getEva3().getLinksaf()){
                        leerlingController.getEva3().setLinksaf(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setLinksaf(status);
        }
        if(base.equals("resource/Verkeerstechniek/kruisen")){
            if(selectedEva == 1){
                leerlingController.getEva1().setKruisen(status);
                if(leerlingController.getEva2().getKruisen() == 0){
                    leerlingController.getEva2().setKruisen(status);
                }
                else{
                    if(status < leerlingController.getEva2().getKruisen()){
                        leerlingController.getEva2().setKruisen(status);
                    }
                }
                if(leerlingController.getEva3().getKruisen() == 0){
                    leerlingController.getEva3().setKruisen(status);
                }
                else{
                    if(status < leerlingController.getEva3().getKruisen()){
                        leerlingController.getEva3().setKruisen(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setKruisen(status);
                if(leerlingController.getEva3().getKruisen() == 0)leerlingController.getEva3().setKruisen(status);
                else{
                    if(status < leerlingController.getEva3().getKruisen()){
                        leerlingController.getEva3().setKruisen(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setKruisen(status);
        }
        if(base.equals("resource/Verkeerstechniek/voorrang")){
            if(selectedEva == 1){
                leerlingController.getEva1().setVoorrang(status);
                if(leerlingController.getEva2().getVoorrang() == 0){
                    leerlingController.getEva2().setVoorrang(status);
                }
                else{
                    if(status < leerlingController.getEva2().getVoorrang()){
                        leerlingController.getEva2().setVoorrang(status);
                    }
                }
                if(leerlingController.getEva3().getVoorrang() == 0){
                    leerlingController.getEva3().setVoorrang(status);
                }
                else{
                    if(status < leerlingController.getEva3().getVoorrang()){
                        leerlingController.getEva3().setVoorrang(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setVoorrang(status);
                if(leerlingController.getEva3().getVoorrang() == 0)leerlingController.getEva3().setVoorrang(status);
                else{
                    if(status < leerlingController.getEva3().getVoorrang()){
                        leerlingController.getEva3().setVoorrang(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setVoorrang(status);
        }
        if(base.equals("resource/Verkeerstechniek/verkeerstekens")){
            if(selectedEva == 1){
                leerlingController.getEva1().setVerkeerstekens(status);
                if(leerlingController.getEva2().getVerkeerstekens() == 0){
                    leerlingController.getEva2().setVerkeerstekens(status);
                }
                else{
                    if(status < leerlingController.getEva2().getVerkeerstekens()){
                        leerlingController.getEva2().setVerkeerstekens(status);
                    }
                }
                if(leerlingController.getEva3().getVerkeerstekens() == 0){
                    leerlingController.getEva3().setVerkeerstekens(status);
                }
                else{
                    if(status < leerlingController.getEva3().getVerkeerstekens()){
                        leerlingController.getEva3().setVerkeerstekens(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setVerkeerstekens(status);
                if(leerlingController.getEva3().getVerkeerstekens() == 0)leerlingController.getEva3().setVerkeerstekens(status);
                else{
                    if(status < leerlingController.getEva3().getVerkeerstekens()){
                        leerlingController.getEva3().setVerkeerstekens(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setVerkeerstekens(status);
        }
        if(base.equals("resource/Verkeerstechniek/snelheid")){
            if(selectedEva == 1){
                leerlingController.getEva1().setSnelheid(status);
                if(leerlingController.getEva2().getSnelheid() == 0){
                    leerlingController.getEva2().setSnelheid(status);
                }
                else{
                    if(status < leerlingController.getEva2().getSnelheid()){
                        leerlingController.getEva2().setSnelheid(status);
                    }
                }
                if(leerlingController.getEva3().getSnelheid() == 0){
                    leerlingController.getEva3().setSnelheid(status);
                }
                else{
                    if(status < leerlingController.getEva3().getSnelheid()){
                        leerlingController.getEva3().setSnelheid(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setSnelheid(status);
                if(leerlingController.getEva3().getSnelheid() == 0)leerlingController.getEva3().setSnelheid(status);
                else{
                    if(status < leerlingController.getEva3().getSnelheid()){
                        leerlingController.getEva3().setSnelheid(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setSnelheid(status);
        }
        if(base.equals("resource/Verkeerstechniek/afstand")){
            if(selectedEva == 1){
                leerlingController.getEva1().setAfstand(status);
                if(leerlingController.getEva2().getAfstand() == 0){
                    leerlingController.getEva2().setAfstand(status);
                }
                else{
                    if(status < leerlingController.getEva2().getAfstand()){
                        leerlingController.getEva2().setAfstand(status);
                    }
                }
                if(leerlingController.getEva3().getAfstand() == 0){
                    leerlingController.getEva3().setAfstand(status);
                }
                else{
                    if(status < leerlingController.getEva3().getAfstand()){
                        leerlingController.getEva3().setAfstand(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setAfstand(status);
                if(leerlingController.getEva3().getAfstand() == 0)leerlingController.getEva3().setAfstand(status);
                else{
                    if(status < leerlingController.getEva3().getAfstand()){
                        leerlingController.getEva3().setAfstand(status);
                    }
                }
            }
            
            if(selectedEva == 3) leerlingController.getEva3().setAfstand(status);
        }
        if(base.equals("resource/Verkeerstechniek/inhalen")){
            if(selectedEva == 1){
                leerlingController.getEva1().setInhalen(status);
                if(leerlingController.getEva2().getInhalen() == 0){
                    leerlingController.getEva2().setInhalen(status);
                }
                else{
                    if(status < leerlingController.getEva2().getInhalen()){
                        leerlingController.getEva2().setInhalen(status);
                    }
                }
                if(leerlingController.getEva3().getInhalen() == 0){
                    leerlingController.getEva3().setInhalen(status);
                }
                else{
                    if(status < leerlingController.getEva3().getInhalen()){
                        leerlingController.getEva3().setInhalen(status);
                    }
                }
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setInhalen(status);
                if(leerlingController.getEva3().getInhalen() == 0)leerlingController.getEva3().setInhalen(status);
                else{
                    if(status < leerlingController.getEva3().getInhalen()){
                        leerlingController.getEva3().setInhalen(status);
                    }
                }
            }
            if(selectedEva == 3) leerlingController.getEva3().setInhalen(status);
        }
    }
}

