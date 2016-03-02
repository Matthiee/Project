
package controller;

import gui.Onderdeel;

public class EvaController {
    
    private LeerlingController leerlingController;
    private int selectedEva; //eva1=1  eva2=2  eva3=3
    
    public EvaController(LeerlingController llnCtrl){
        leerlingController = llnCtrl;
        selectedEva = leerlingController.getLastSelectedEva();
    }

    public int getSelectedEva() {
        return selectedEva;
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
        if(base.equals("resource/Hoofdmenu/stuuroef")){
            if(selectedEva == 1) status = leerlingController.getEva1().getStuuroef();
            if(selectedEva == 2) status = leerlingController.getEva2().getStuuroef();
            if(selectedEva == 3) status = leerlingController.getEva3().getStuuroef();
        }
        if(base.equals("resource/Hoofdmenu/keren")){
            if(selectedEva == 1) status = leerlingController.getEva1().getKeren();
            if(selectedEva == 2) status = leerlingController.getEva2().getKeren();
            if(selectedEva == 3) status = leerlingController.getEva3().getKeren();
        }
        if(base.equals("resource/Hoofdmenu/garage")){
            if(selectedEva == 1) status = leerlingController.getEva1().getGarage();
            if(selectedEva == 2) status = leerlingController.getEva2().getGarage();
            if(selectedEva == 3) status = leerlingController.getEva3().getGarage();
        }
        if(base.equals("resource/Hoofdmenu/parkeren")){
            if(selectedEva == 1) status = leerlingController.getEva1().getParkeren();
            if(selectedEva == 2) status = leerlingController.getEva2().getParkeren();
            if(selectedEva == 3) status = leerlingController.getEva3().getParkeren();
        }
        if(base.equals("resource/Hoofdmenu/achteruit")){
            if(selectedEva == 1) status = leerlingController.getEva1().getAchteruit();
            if(selectedEva == 2) status = leerlingController.getEva2().getAchteruit();
            if(selectedEva == 3) status = leerlingController.getEva3().getAchteruit();
        }
        
        onderdeel.setStatus(status);
    }
    
    
    public void saveColorData(String base, int status){
        //hoofdmenu
            //links
        if(base.equals("resource/Hoofdmenu/schakelaars")){
            if(selectedEva == 1) leerlingController.getEva1().setSchakelaars(status);
            if(selectedEva == 2) leerlingController.getEva2().setSchakelaars(status);
            if(selectedEva == 3) leerlingController.getEva3().setSchakelaars(status);
        }
        
        if(base.equals("resource/Hoofdmenu/vloeistoffen")){
            if(selectedEva == 1) leerlingController.getEva1().setVloeistoffen(status);
            if(selectedEva == 2) leerlingController.getEva2().setVloeistoffen(status);
            if(selectedEva == 3) leerlingController.getEva3().setVloeistoffen(status);
        }
        
        if(base.equals("resource/Hoofdmenu/banden")){
            if(selectedEva == 1) leerlingController.getEva1().setBanden(status);
            if(selectedEva == 2) leerlingController.getEva2().setBanden(status);
            if(selectedEva == 3) leerlingController.getEva3().setBanden(status);
        }
            //rechts
        if(base.equals("resource/Hoofdmenu/tanken")){
            if(selectedEva == 1) leerlingController.getEva1().setTanken(status);
            if(selectedEva == 2) leerlingController.getEva2().setTanken(status);
            if(selectedEva == 3) leerlingController.getEva3().setTanken(status);
        }
        
        if(base.equals("resource/Hoofdmenu/gps")){
            if(selectedEva == 1) leerlingController.getEva1().setGps(status);
            if(selectedEva == 2) leerlingController.getEva2().setGps(status);
            if(selectedEva == 3) leerlingController.getEva3().setGps(status);
        }
        
        if(base.equals("resource/Hoofdmenu/stop")){
            if(selectedEva == 1) leerlingController.getEva1().setNoodstop(status);
            if(selectedEva == 2) leerlingController.getEva2().setNoodstop(status);
            if(selectedEva == 3) leerlingController.getEva3().setNoodstop(status);
        }
            //top
        if(base.equals("resource/Hoofdmenu/stad")){
            if(selectedEva == 1) leerlingController.getEva1().setStad(status);
            if(selectedEva == 2) leerlingController.getEva2().setStad(status);
            if(selectedEva == 3) leerlingController.getEva3().setStad(status);
        }
        if(base.equals("resource/Hoofdmenu/snelweg")){
            if(selectedEva == 1) leerlingController.getEva1().setAutosnelweg(status);
            if(selectedEva == 2) leerlingController.getEva2().setAutosnelweg(status);
            if(selectedEva == 3) leerlingController.getEva3().setAutosnelweg(status);
        }
        if(base.equals("resource/Hoofdmenu/rotonde")){
            if(selectedEva == 1) leerlingController.getEva1().setRotonde(status);
            if(selectedEva == 2) leerlingController.getEva2().setRotonde(status);
            if(selectedEva == 3) leerlingController.getEva3().setRotonde(status);
        }
        if(base.equals("resource/Hoofdmenu/rijstroken")){
            if(selectedEva == 1) leerlingController.getEva1().setRijstroken(status);
            if(selectedEva == 2) leerlingController.getEva2().setRijstroken(status);
            if(selectedEva == 3) leerlingController.getEva3().setRijstroken(status);
        }
        //rijtechniek
        if(base.equals("resource/Hoofdmenu/stuuroef")){
            if(selectedEva == 1) leerlingController.getEva1().setStuuroef(status);
            if(selectedEva == 2) leerlingController.getEva2().setStuuroef(status);
            if(selectedEva == 3) leerlingController.getEva3().setStuuroef(status);
        }
        if(base.equals("resource/Hoofdmenu/keren")){
            if(selectedEva == 1) leerlingController.getEva1().setKeren(status);
            if(selectedEva == 2) leerlingController.getEva2().setKeren(status);
            if(selectedEva == 3) leerlingController.getEva3().setKeren(status);
        }
        if(base.equals("resource/Hoofdmenu/garage")){
            if(selectedEva == 1) leerlingController.getEva1().setGarage(status);
            if(selectedEva == 2) leerlingController.getEva2().setGarage(status);
            if(selectedEva == 3) leerlingController.getEva3().setGarage(status);
        }
        if(base.equals("resource/Hoofdmenu/parkeren")){
            if(selectedEva == 1) leerlingController.getEva1().setParkeren(status);
            if(selectedEva == 2) leerlingController.getEva2().setParkeren(status);
            if(selectedEva == 3) leerlingController.getEva3().setParkeren(status);
        }
        if(base.equals("resource/Hoofdmenu/achteruit")){
            if(selectedEva == 1) leerlingController.getEva1().setAchteruit(status);
            if(selectedEva == 2) leerlingController.getEva2().setAchteruit(status);
            if(selectedEva == 3) leerlingController.getEva3().setAchteruit(status);
        }
    }
    
}
