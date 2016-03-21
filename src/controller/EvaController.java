
package controller;

import gui.Onderdeel;

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
    
    public void loadColorData(Onderdeel onderdeel){
        
        String base = onderdeel.getBase();
        int status = 0;
        
        //Hoofdmenu
            //links
        if(base.equals("resource/Hoofdmenu/schakelaars")){
            if(selectedEva == 1){status = leerlingController.getEva1().getSchakelaars();}
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
        if(base.equals("resource/Rijtechniek/openbareWeg")){
            if(selectedEva == 1) status = leerlingController.getEva1().getOpenbareWeg();
            if(selectedEva == 2) status = leerlingController.getEva2().getOpenbareWeg();
            if(selectedEva == 3) status = leerlingController.getEva3().getOpenbareWeg();
        }
        if(base.equals("resource/Rijtechniek/richtingaanwijzers")){
            if(selectedEva == 1) status = leerlingController.getEva1().getRichtingaanwijzers();
            if(selectedEva == 2) status = leerlingController.getEva2().getRichtingaanwijzers();
            if(selectedEva == 3) status = leerlingController.getEva3().getRichtingaanwijzers();
        }
        if(base.equals("resource/Rijtechniek/rechtsaf")){
            if(selectedEva == 1) status = leerlingController.getEva1().getRechtsaf();
            if(selectedEva == 2) status = leerlingController.getEva2().getRechtsaf();
            if(selectedEva == 3) status = leerlingController.getEva3().getRechtsaf();
        }
        if(base.equals("resource/Rijtechniek/linksaf")){
            if(selectedEva == 1) status = leerlingController.getEva1().getLinksaf();
            if(selectedEva == 2) status = leerlingController.getEva2().getLinksaf();
            if(selectedEva == 3) status = leerlingController.getEva3().getLinksaf();
        }
        if(base.equals("resource/Rijtechniek/kruisen")){
            if(selectedEva == 1) status = leerlingController.getEva1().getKruisen();
            if(selectedEva == 2) status = leerlingController.getEva2().getKruisen();
            if(selectedEva == 3) status = leerlingController.getEva3().getKruisen();
        }
        if(base.equals("resource/Rijtechniek/voorrang")){
            if(selectedEva == 1) status = leerlingController.getEva1().getVoorrang();
            if(selectedEva == 2) status = leerlingController.getEva2().getVoorrang();
            if(selectedEva == 3) status = leerlingController.getEva3().getVoorrang();
        }
        if(base.equals("resource/Rijtechniek/verkeerstekens")){
            if(selectedEva == 1) status = leerlingController.getEva1().getVerkeerstekens();
            if(selectedEva == 2) status = leerlingController.getEva2().getVerkeerstekens();
            if(selectedEva == 3) status = leerlingController.getEva3().getVerkeerstekens();
        }
        if(base.equals("resource/Rijtechniek/snelheid")){
            if(selectedEva == 1) status = leerlingController.getEva1().getSnelheid();
            if(selectedEva == 2) status = leerlingController.getEva2().getSnelheid();
            if(selectedEva == 3) status = leerlingController.getEva3().getSnelheid();
        }
        if(base.equals("resource/Rijtechniek/afstand")){
            if(selectedEva == 1) status = leerlingController.getEva1().getAfstand();
            if(selectedEva == 2) status = leerlingController.getEva2().getAfstand();
            if(selectedEva == 3) status = leerlingController.getEva3().getAfstand();
        }
        if(base.equals("resource/Rijtechniek/inhalen")){
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
            
        if(base.equals("resource/Hoofdmenu/schakelaars")){
            if(selectedEva == 1){
                leerlingController.getEva1().setSchakelaars(status);
                if(leerlingController.getEva2().getSchakelaars() == 0)leerlingController.getEva2().setSchakelaars(status);
                if(leerlingController.getEva3().getSchakelaars() == 0)leerlingController.getEva3().setSchakelaars(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setSchakelaars(status);
                if(leerlingController.getEva3().getSchakelaars() == 0)leerlingController.getEva3().setSchakelaars(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setSchakelaars(status);
        }
        
        if(base.equals("resource/Hoofdmenu/vloeistoffen")){
            if(selectedEva == 1){
                leerlingController.getEva1().setVloeistoffen(status);
                if(leerlingController.getEva2().getVloeistoffen() == 0)leerlingController.getEva2().setVloeistoffen(status);
                if(leerlingController.getEva3().getVloeistoffen() == 0)leerlingController.getEva3().setVloeistoffen(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setVloeistoffen(status);
                if(leerlingController.getEva3().getVloeistoffen() == 0)leerlingController.getEva3().setVloeistoffen(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setVloeistoffen(status);
        }
        
        if(base.equals("resource/Hoofdmenu/banden")){
            if(selectedEva == 1){
                leerlingController.getEva1().setBanden(status);
                if(leerlingController.getEva2().getBanden() == 0)leerlingController.getEva2().setBanden(status);
                if(leerlingController.getEva3().getBanden() == 0)leerlingController.getEva3().setBanden(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setBanden(status);
                if(leerlingController.getEva3().getBanden() == 0)leerlingController.getEva3().setBanden(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setBanden(status);
        }
            //rechts
        if(base.equals("resource/Hoofdmenu/tanken")){
            if(selectedEva == 1){
                leerlingController.getEva1().setTanken(status);
                if(leerlingController.getEva2().getTanken() == 0)leerlingController.getEva2().setTanken(status);
                if(leerlingController.getEva3().getTanken() == 0)leerlingController.getEva3().setTanken(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setTanken(status);
                if(leerlingController.getEva3().getTanken() == 0)leerlingController.getEva3().setTanken(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setTanken(status);
        }
        
        if(base.equals("resource/Hoofdmenu/gps")){
            if(selectedEva == 1){
                leerlingController.getEva1().setGps(status);
                if(leerlingController.getEva2().getGps() == 0)leerlingController.getEva2().setGps(status);
                if(leerlingController.getEva3().getGps() == 0)leerlingController.getEva3().setGps(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setGps(status);
                if(leerlingController.getEva3().getGps() == 0)leerlingController.getEva3().setGps(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setGps(status);
        }
        
        if(base.equals("resource/Hoofdmenu/stop")){
            if(selectedEva == 1){
                leerlingController.getEva1().setNoodstop(status);
                if(leerlingController.getEva2().getNoodstop() == 0)leerlingController.getEva2().setNoodstop(status);
                if(leerlingController.getEva3().getNoodstop() == 0)leerlingController.getEva3().setNoodstop(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setNoodstop(status);
                if(leerlingController.getEva3().getNoodstop() == 0)leerlingController.getEva3().setNoodstop(status);
            }    
            if(selectedEva == 3) leerlingController.getEva3().setNoodstop(status);
        }
            //top
        if(base.equals("resource/Hoofdmenu/stad")){
            if(selectedEva == 1){
                leerlingController.getEva1().setStad(status);
                if(leerlingController.getEva2().getStad() == 0)leerlingController.getEva2().setStad(status);
                if(leerlingController.getEva3().getStad() == 0)leerlingController.getEva3().setStad(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setStad(status);
                if(leerlingController.getEva3().getStad() == 0)leerlingController.getEva3().setStad(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setStad(status);
        }
        if(base.equals("resource/Hoofdmenu/snelweg")){
            if(selectedEva == 1){
                leerlingController.getEva1().setAutosnelweg(status);
                if(leerlingController.getEva2().getAutosnelweg() == 0)leerlingController.getEva2().setAutosnelweg(status);
                if(leerlingController.getEva3().getAutosnelweg() == 0)leerlingController.getEva3().setAutosnelweg(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setAutosnelweg(status);
                if(leerlingController.getEva3().getAutosnelweg() == 0)leerlingController.getEva3().setAutosnelweg(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setAutosnelweg(status);
        }
        if(base.equals("resource/Hoofdmenu/rotonde")){
            if(selectedEva == 1){
                leerlingController.getEva1().setRotonde(status);
                if(leerlingController.getEva2().getRotonde() == 0)leerlingController.getEva2().setRotonde(status);
                if(leerlingController.getEva3().getRotonde() == 0)leerlingController.getEva3().setRotonde(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setRotonde(status);
                if(leerlingController.getEva3().getRotonde() == 0)leerlingController.getEva3().setRotonde(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setRotonde(status);
        }
        if(base.equals("resource/Hoofdmenu/rijstroken")){
            if(selectedEva == 1){
                leerlingController.getEva1().setRijstroken(status);
                if(leerlingController.getEva2().getRijstroken() == 0)leerlingController.getEva2().setRijstroken(status);
                if(leerlingController.getEva3().getRijstroken() == 0)leerlingController.getEva3().setRijstroken(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setRijstroken(status);
                if(leerlingController.getEva3().getRijstroken() == 0)leerlingController.getEva3().setRijstroken(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setRijstroken(status);
        }
        //rijtechniek
        if(base.equals("resource/Rijtechniek/stuuroef")){
            if(selectedEva == 1){
                leerlingController.getEva1().setStuuroef(status);
                if(leerlingController.getEva2().getStuuroef() == 0)leerlingController.getEva2().setStuuroef(status);
                if(leerlingController.getEva3().getStuuroef() == 0)leerlingController.getEva3().setStuuroef(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setStuuroef(status);
                if(leerlingController.getEva3().getStuuroef() == 0)leerlingController.getEva3().setStuuroef(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setStuuroef(status);
        }
        if(base.equals("resource/Rijtechniek/keren")){
            if(selectedEva == 1){
                leerlingController.getEva1().setKeren(status);
                if(leerlingController.getEva2().getKeren() == 0)leerlingController.getEva2().setKeren(status);
                if(leerlingController.getEva3().getKeren() == 0)leerlingController.getEva3().setKeren(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setKeren(status);
                if(leerlingController.getEva3().getKeren() == 0)leerlingController.getEva3().setKeren(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setKeren(status);
        }
        if(base.equals("resource/Rijtechniek/garage")){
            if(selectedEva == 1){
                leerlingController.getEva1().setGarage(status);
                if(leerlingController.getEva2().getGarage() == 0)leerlingController.getEva2().setGarage(status);
                if(leerlingController.getEva3().getGarage() == 0)leerlingController.getEva3().setGarage(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setGarage(status);
                if(leerlingController.getEva3().getGarage() == 0)leerlingController.getEva3().setGarage(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setGarage(status);
        }
        if(base.equals("resource/Rijtechniek/parkeren")){
            if(selectedEva == 1){
                leerlingController.getEva1().setParkeren(status);
                if(leerlingController.getEva2().getParkeren() == 0)leerlingController.getEva2().setParkeren(status);
                if(leerlingController.getEva3().getParkeren() == 0)leerlingController.getEva3().setParkeren(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setParkeren(status);
                if(leerlingController.getEva3().getParkeren() == 0)leerlingController.getEva3().setParkeren(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setParkeren(status);
        }
        if(base.equals("resource/Rijtechniek/achteruit")){
            if(selectedEva == 1){
                leerlingController.getEva1().setAchteruit(status);
                if(leerlingController.getEva2().getAchteruit() == 0)leerlingController.getEva2().setAchteruit(status);
                if(leerlingController.getEva3().getAchteruit() == 0)leerlingController.getEva3().setAchteruit(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setAchteruit(status);
                if(leerlingController.getEva3().getAchteruit() == 0)leerlingController.getEva3().setAchteruit(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setAchteruit(status);
        }
        if(base.equals("resource/Rijtechniek/rem")){
            if(selectedEva == 1){
                leerlingController.getEva1().setRemmen(status);
                if(leerlingController.getEva2().getRemmen() == 0)leerlingController.getEva2().setRemmen(status);
                if(leerlingController.getEva3().getRemmen() == 0)leerlingController.getEva3().setRemmen(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setRemmen(status);
                if(leerlingController.getEva3().getRemmen() == 0)leerlingController.getEva3().setRemmen(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setRemmen(status);
        }
        if(base.equals("resource/Rijtechniek/koppeling")){
            if(selectedEva == 1){
                leerlingController.getEva1().setKoppeling(status);
                if(leerlingController.getEva2().getKoppeling() == 0)leerlingController.getEva2().setKoppeling(status);
                if(leerlingController.getEva3().getKoppeling() == 0)leerlingController.getEva3().setKoppeling(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setKoppeling(status);
                if(leerlingController.getEva3().getKoppeling() == 0)leerlingController.getEva3().setKoppeling(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setKoppeling(status);
        }
        if(base.equals("resource/Rijtechniek/helling")){
            if(selectedEva == 1){
                leerlingController.getEva1().setHelling(status);
                if(leerlingController.getEva2().getHelling() == 0)leerlingController.getEva2().setHelling(status);
                if(leerlingController.getEva3().getHelling() == 0)leerlingController.getEva3().setHelling(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setHelling(status);
                if(leerlingController.getEva3().getHelling() == 0)leerlingController.getEva3().setHelling(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setHelling(status);
        }
        if(base.equals("resource/Rijtechniek/kijk")){
            if(selectedEva == 1){
                leerlingController.getEva1().setKijken(status);
                if(leerlingController.getEva2().getKijken() == 0)leerlingController.getEva2().setKijken(status);
                if(leerlingController.getEva3().getKijken() == 0)leerlingController.getEva3().setKijken(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setKijken(status);
                if(leerlingController.getEva3().getKijken() == 0)leerlingController.getEva3().setKijken(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setKijken(status);
        }
        if(base.equals("resource/Rijtechniek/schakel")){
            if(selectedEva == 1){
                leerlingController.getEva1().setSchakelen(status);
                if(leerlingController.getEva2().getSchakelen() == 0)leerlingController.getEva2().setSchakelen(status);
                if(leerlingController.getEva3().getSchakelen() == 0)leerlingController.getEva3().setSchakelen(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setSchakelen(status);
                if(leerlingController.getEva3().getSchakelen() == 0)leerlingController.getEva3().setSchakelen(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setSchakelen(status);
        }
        if(base.equals("resource/Rijtechniek/stuur")){
            if(selectedEva == 1){
                leerlingController.getEva1().setSturen(status);
                if(leerlingController.getEva2().getSturen() == 0)leerlingController.getEva2().setSturen(status);
                if(leerlingController.getEva3().getSturen() == 0)leerlingController.getEva3().setSturen(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setSturen(status);
                if(leerlingController.getEva3().getSturen() == 0)leerlingController.getEva3().setSturen(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setSturen(status);
        }
        if(base.equals("resource/Rijtechniek/houding")){
            if(selectedEva == 1){
                leerlingController.getEva1().setHouding(status);
                if(leerlingController.getEva2().getHouding() == 0)leerlingController.getEva2().setHouding(status);
                if(leerlingController.getEva3().getHouding() == 0)leerlingController.getEva3().setHouding(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setHouding(status);
                if(leerlingController.getEva3().getHouding() == 0)leerlingController.getEva3().setHouding(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setHouding(status);
        }
        
        //verkeerstechniek
        if(base.equals("resource/Rijtechniek/openbareWeg")){
            if(selectedEva == 1){
                leerlingController.getEva1().setOpenbareWeg(status);
                if(leerlingController.getEva2().getOpenbareWeg() == 0)leerlingController.getEva2().setOpenbareWeg(status);
                if(leerlingController.getEva3().getOpenbareWeg() == 0)leerlingController.getEva3().setOpenbareWeg(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setOpenbareWeg(status);
                if(leerlingController.getEva3().getOpenbareWeg() == 0)leerlingController.getEva3().setOpenbareWeg(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setOpenbareWeg(status);
        }
        if(base.equals("resource/Rijtechniek/richtingaanwijzers")){
            if(selectedEva == 1){
                leerlingController.getEva1().setRichtingaanwijzers(status);
                if(leerlingController.getEva2().getRichtingaanwijzers() == 0)leerlingController.getEva2().setRichtingaanwijzers(status);
                if(leerlingController.getEva3().getRichtingaanwijzers() == 0)leerlingController.getEva3().setRichtingaanwijzers(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setRichtingaanwijzers(status);
                if(leerlingController.getEva3().getRichtingaanwijzers() == 0)leerlingController.getEva3().setRichtingaanwijzers(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setRichtingaanwijzers(status);
        }
        if(base.equals("resource/Rijtechniek/rechtsaf")){
            if(selectedEva == 1){
                leerlingController.getEva1().setRechtsaf(status);
                if(leerlingController.getEva2().getRechtsaf() == 0)leerlingController.getEva2().setRechtsaf(status);
                if(leerlingController.getEva3().getRechtsaf() == 0)leerlingController.getEva3().setRechtsaf(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setRechtsaf(status);
                if(leerlingController.getEva3().getRechtsaf() == 0)leerlingController.getEva3().setRechtsaf(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setRechtsaf(status);
        }
        if(base.equals("resource/Rijtechniek/linksaf")){
            if(selectedEva == 1){
                leerlingController.getEva1().setLinksaf(status);
                if(leerlingController.getEva2().getLinksaf() == 0)leerlingController.getEva2().setLinksaf(status);
                if(leerlingController.getEva3().getLinksaf() == 0)leerlingController.getEva3().setLinksaf(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setLinksaf(status);
                if(leerlingController.getEva3().getLinksaf() == 0)leerlingController.getEva3().setLinksaf(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setLinksaf(status);
        }
        if(base.equals("resource/Rijtechniek/kruisen")){
            if(selectedEva == 1){
                leerlingController.getEva1().setKruisen(status);
                if(leerlingController.getEva2().getKruisen() == 0)leerlingController.getEva2().setKruisen(status);
                if(leerlingController.getEva3().getKruisen() == 0)leerlingController.getEva3().setKruisen(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setKruisen(status);
                if(leerlingController.getEva3().getKruisen() == 0)leerlingController.getEva3().setKruisen(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setKruisen(status);
        }
        if(base.equals("resource/Rijtechniek/voorrang")){
            if(selectedEva == 1){
                leerlingController.getEva1().setVoorrang(status);
                if(leerlingController.getEva2().getVoorrang() == 0)leerlingController.getEva2().setVoorrang(status);
                if(leerlingController.getEva3().getVoorrang() == 0)leerlingController.getEva3().setVoorrang(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setVoorrang(status);
                if(leerlingController.getEva3().getVoorrang() == 0)leerlingController.getEva3().setVoorrang(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setVoorrang(status);
        }
        if(base.equals("resource/Rijtechniek/verkeerstekens")){
            if(selectedEva == 1){
                leerlingController.getEva1().setVerkeerstekens(status);
                if(leerlingController.getEva2().getVerkeerstekens() == 0)leerlingController.getEva2().setVerkeerstekens(status);
                if(leerlingController.getEva3().getVerkeerstekens() == 0)leerlingController.getEva3().setVerkeerstekens(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setVerkeerstekens(status);
                if(leerlingController.getEva3().getVerkeerstekens() == 0)leerlingController.getEva3().setVerkeerstekens(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setVerkeerstekens(status);
        }
        if(base.equals("resource/Rijtechniek/snelheid")){
            if(selectedEva == 1){
                leerlingController.getEva1().setSnelheid(status);
                if(leerlingController.getEva2().getSnelheid() == 0)leerlingController.getEva2().setSnelheid(status);
                if(leerlingController.getEva3().getSnelheid() == 0)leerlingController.getEva3().setSnelheid(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setSnelheid(status);
                if(leerlingController.getEva3().getSnelheid() == 0)leerlingController.getEva3().setSnelheid(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setSnelheid(status);
        }
        if(base.equals("resource/Rijtechniek/afstand")){
            if(selectedEva == 1){
                leerlingController.getEva1().setAfstand(status);
                if(leerlingController.getEva2().getAfstand() == 0)leerlingController.getEva2().setAfstand(status);
                if(leerlingController.getEva3().getAfstand() == 0)leerlingController.getEva3().setAfstand(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setAfstand(status);
                if(leerlingController.getEva3().getAfstand() == 0)leerlingController.getEva3().setAfstand(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setAfstand(status);
        }
        if(base.equals("resource/Rijtechniek/inhalen")){
            if(selectedEva == 1){
                leerlingController.getEva1().setInhalen(status);
                if(leerlingController.getEva2().getInhalen() == 0)leerlingController.getEva2().setInhalen(status);
                if(leerlingController.getEva3().getInhalen() == 0)leerlingController.getEva3().setInhalen(status);
            }
            if(selectedEva == 2) {
                leerlingController.getEva2().setInhalen(status);
                if(leerlingController.getEva3().getInhalen() == 0)leerlingController.getEva3().setInhalen(status);
            }
            if(selectedEva == 3) leerlingController.getEva3().setInhalen(status);
        }
    }
}

