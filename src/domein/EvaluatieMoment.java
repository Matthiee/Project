
package domein;

public class EvaluatieMoment {
    
    //voor de kleuren:
        //Neutraal              = 0     Wit
        //Gekend                = 1     Groen
        //Gezien niet Gekend    = 2     Oranje
        //Niet gekend           = 3     Rood
    
    //gegevens rijtechniek
    private int houding, koppeling, remmen, schakelen, sturen,
            kijken, keren, parkeren, garage, helling, stuuroef, achteruit;
    private String houdingOpm, koppelingOpm, remmenOpm, schakelenOpm,
            sturenOpm, kijkenOpm, hellingOpm;
    //gegevens verkeerstechniek
    private int richtingaanwijzers, voorrang, openbareWeg, verkeerstekens, snelheid,
            afstand, inhalen, kruisen, linksaf, rechtsaf;
    private String richtingaanwijzersOpm, voorrangOpm, openbareWegOpm, verkeerstekensOpm, 
            snelheidOpm, afstandOpm, inhalenOpm, kruisenOpm, linksafOpm, rechtsafOpm;
    //gegevens grafiek
    private int grafiek;
    //gegevens attitude
    private String attitudeOpm;
    //gegevens hoofdmenu;
    private int rotonde, rijstroken, stad, autosnelweg, schakelaars, vloeistoffen,
            banden, tanken, noodstop, gps;
    private String hoofdmenuOpm;
    
    //Constructors

    public EvaluatieMoment() {
        this.houding = 0;
        this.koppeling = 0;
        this.remmen = 0;
        this.schakelen = 0;
        this.sturen = 0;
        this.kijken = 0;
        this.keren = 0;
        this.parkeren = 0;
        this.garage = 0;
        this.helling = 0;
        this.stuuroef = 0;
        this.achteruit = 0;
        this.houdingOpm = "";
        this.koppelingOpm = "";
        this.remmenOpm = "";
        this.schakelenOpm = "";
        this.sturenOpm = "";
        this.kijkenOpm = "";
        this.hellingOpm = "";
        this.richtingaanwijzers = 0;
        this.voorrang = 0;
        this.openbareWeg = 0;
        this.verkeerstekens = 0;
        this.snelheid = 0;
        this.afstand = 0;
        this.inhalen = 0;
        this.kruisen = 0;
        this.linksaf = 0;
        this.rechtsaf = 0;
        this.richtingaanwijzersOpm = "";
        this.voorrangOpm = "";
        this.openbareWegOpm = "";
        this.verkeerstekensOpm = "";
        this.snelheidOpm = "";
        this.afstandOpm = "";
        this.inhalenOpm = "";
        this.kruisenOpm = "";
        this.linksafOpm = "";
        this.rechtsafOpm = "";
        this.grafiek = 0;
        this.attitudeOpm = "";
        this.rotonde = 0;
        this.rijstroken = 0;
        this.stad = 0;
        this.autosnelweg = 0;
        this.schakelaars = 0;
        this.vloeistoffen = 0;
        this.banden = 0;
        this.tanken = 0;
        this.noodstop = 0;
        this.gps = 0;
        this.hoofdmenuOpm = "";
    }
    

    public EvaluatieMoment(int houding, int koppeling, int remmen, int schakelen, int sturen, int kijken, 
            int keren, int parkeren, int garage, int helling, int stuuroef, int achteruit, String houdingOpm, 
            String koppelingOpm, String remmenOpm, String schakelenOpm, String sturenOpm, String kijkenOpm, 
            String hellingOpm, int richtingaanwijzers, int voorrang, int openbareWeg, int verkeerstekens, 
            int snelheid, int afstand, int inhalen, int kruisen, int linksaf, int rechtsaf, String richtingaanwijzersOpm, 
            String voorrangOpm, String openbareWegOpm, String verkeerstekensOpm, String snelheidOpm, String afstandOpm, 
            String inhalenOpm, String kruisenOpm, String linksafOpm, String rechtsafOpm, int grafiek, String attitudeOpm, 
            int rotonde, int rijstroken, int stad, int autosnelweg, int schakelaars, int vloeistoffen, int banden, int tanken, 
            int noodstop, int gps, String hoofdmenuOpm) {
        this.houding = houding;
        this.koppeling = koppeling;
        this.remmen = remmen;
        this.schakelen = schakelen;
        this.sturen = sturen;
        this.kijken = kijken;
        this.keren = keren;
        this.parkeren = parkeren;
        this.garage = garage;
        this.helling = helling;
        this.stuuroef = stuuroef;
        this.achteruit = achteruit;
        this.houdingOpm = houdingOpm;
        this.koppelingOpm = koppelingOpm;
        this.remmenOpm = remmenOpm;
        this.schakelenOpm = schakelenOpm;
        this.sturenOpm = sturenOpm;
        this.kijkenOpm = kijkenOpm;
        this.hellingOpm = hellingOpm;
        this.richtingaanwijzers = richtingaanwijzers;
        this.voorrang = voorrang;
        this.openbareWeg = openbareWeg;
        this.verkeerstekens = verkeerstekens;
        this.snelheid = snelheid;
        this.afstand = afstand;
        this.inhalen = inhalen;
        this.kruisen = kruisen;
        this.linksaf = linksaf;
        this.rechtsaf = rechtsaf;
        this.richtingaanwijzersOpm = richtingaanwijzersOpm;
        this.voorrangOpm = voorrangOpm;
        this.openbareWegOpm = openbareWegOpm;
        this.verkeerstekensOpm = verkeerstekensOpm;
        this.snelheidOpm = snelheidOpm;
        this.afstandOpm = afstandOpm;
        this.inhalenOpm = inhalenOpm;
        this.kruisenOpm = kruisenOpm;
        this.linksafOpm = linksafOpm;
        this.rechtsafOpm = rechtsafOpm;
        this.grafiek = grafiek;
        this.attitudeOpm = attitudeOpm;
        this.rotonde = rotonde;
        this.rijstroken = rijstroken;
        this.stad = stad;
        this.autosnelweg = autosnelweg;
        this.schakelaars = schakelaars;
        this.vloeistoffen = vloeistoffen;
        this.banden = banden;
        this.tanken = tanken;
        this.noodstop = noodstop;
        this.gps = gps;
        this.hoofdmenuOpm = hoofdmenuOpm;
    }
    
    
    //Getters en Setters
    public int getHouding() {
        return houding;
    }

    public void setHouding(int houding) {
        this.houding = houding;
    }

    public int getKoppeling() {
        return koppeling;
    }

    public void setKoppeling(int koppeling) {
        this.koppeling = koppeling;
    }

    public int getRemmen() {
        return remmen;
    }

    public void setRemmen(int remmen) {
        this.remmen = remmen;
    }

    public int getSchakelen() {
        return schakelen;
    }

    public void setSchakelen(int schakelen) {
        this.schakelen = schakelen;
    }

    public int getSturen() {
        return sturen;
    }

    public void setSturen(int sturen) {
        this.sturen = sturen;
    }

    public int getKijken() {
        return kijken;
    }

    public void setKijken(int kijken) {
        this.kijken = kijken;
    }

    public int getKeren() {
        return keren;
    }

    public void setKeren(int keren) {
        this.keren = keren;
    }

    public int getParkeren() {
        return parkeren;
    }

    public void setParkeren(int parkeren) {
        this.parkeren = parkeren;
    }

    public int getGarage() {
        return garage;
    }

    public void setGarage(int garage) {
        this.garage = garage;
    }

    public int getHelling() {
        return helling;
    }

    public void setHelling(int helling) {
        this.helling = helling;
    }

    public int getStuuroef() {
        return stuuroef;
    }

    public void setStuuroef(int stuuroef) {
        this.stuuroef = stuuroef;
    }

    public int getAchteruit() {
        return achteruit;
    }

    public void setAchteruit(int achteruit) {
        this.achteruit = achteruit;
    }

    public String getHoudingOpm() {
        return houdingOpm;
    }

    public void setHoudingOpm(String houdingOpm) {
        this.houdingOpm = houdingOpm;
    }

    public String getKoppelingOpm() {
        return koppelingOpm;
    }

    public void setKoppelingOpm(String koppelingOpm) {
        this.koppelingOpm = koppelingOpm;
    }

    public String getRemmenOpm() {
        return remmenOpm;
    }

    public void setRemmenOpm(String remmenOpm) {
        this.remmenOpm = remmenOpm;
    }

    public String getSchakelenOpm() {
        return schakelenOpm;
    }

    public void setSchakelenOpm(String schakelenOpm) {
        this.schakelenOpm = schakelenOpm;
    }

    public String getSturenOpm() {
        return sturenOpm;
    }

    public void setSturenOpm(String sturenOpm) {
        this.sturenOpm = sturenOpm;
    }

    public String getKijkenOpm() {
        return kijkenOpm;
    }

    public void setKijkenOpm(String kijkenOpm) {
        this.kijkenOpm = kijkenOpm;
    }

    public String getHellingOpm() {
        return hellingOpm;
    }

    public void setHellingOpm(String hellingOpm) {
        this.hellingOpm = hellingOpm;
    }

    public int getRichtingaanwijzers() {
        return richtingaanwijzers;
    }

    public void setRichtingaanwijzers(int richtingaanwijzers) {
        this.richtingaanwijzers = richtingaanwijzers;
    }

    public int getVoorrang() {
        return voorrang;
    }

    public void setVoorrang(int voorrang) {
        this.voorrang = voorrang;
    }

    public int getOpenbareWeg() {
        return openbareWeg;
    }

    public void setOpenbareWeg(int openbareWeg) {
        this.openbareWeg = openbareWeg;
    }

    public int getVerkeerstekens() {
        return verkeerstekens;
    }

    public void setVerkeerstekens(int verkeerstekens) {
        this.verkeerstekens = verkeerstekens;
    }

    public int getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(int snelheid) {
        this.snelheid = snelheid;
    }

    public int getAfstand() {
        return afstand;
    }

    public void setAfstand(int afstand) {
        this.afstand = afstand;
    }

    public int getInhalen() {
        return inhalen;
    }

    public void setInhalen(int inhalen) {
        this.inhalen = inhalen;
    }

    public int getKruisen() {
        return kruisen;
    }

    public void setKruisen(int kruisen) {
        this.kruisen = kruisen;
    }

    public int getLinksaf() {
        return linksaf;
    }

    public void setLinksaf(int linksaf) {
        this.linksaf = linksaf;
    }

    public int getRechtsaf() {
        return rechtsaf;
    }

    public void setRechtsaf(int rechtsaf) {
        this.rechtsaf = rechtsaf;
    }

    public String getRichtingaanwijzersOpm() {
        return richtingaanwijzersOpm;
    }

    public void setRichtingaanwijzersOpm(String richtingaanwijzersOpm) {
        this.richtingaanwijzersOpm = richtingaanwijzersOpm;
    }

    public String getVoorrangOpm() {
        return voorrangOpm;
    }

    public void setVoorrangOpm(String voorrangOpm) {
        this.voorrangOpm = voorrangOpm;
    }

    public String getOpenbareWegOpm() {
        return openbareWegOpm;
    }

    public void setOpenbareWegOpm(String openbareWegOpm) {
        this.openbareWegOpm = openbareWegOpm;
    }

    public String getVerkeerstekensOpm() {
        return verkeerstekensOpm;
    }

    public void setVerkeerstekensOpm(String verkeerstekensOpm) {
        this.verkeerstekensOpm = verkeerstekensOpm;
    }

    public String getSnelheidOpm() {
        return snelheidOpm;
    }

    public void setSnelheidOpm(String snelheidOpm) {
        this.snelheidOpm = snelheidOpm;
    }

    public String getAfstandOpm() {
        return afstandOpm;
    }

    public void setAfstandOpm(String afstandOpm) {
        this.afstandOpm = afstandOpm;
    }

    public String getInhalenOpm() {
        return inhalenOpm;
    }

    public void setInhalenOpm(String inhalenOpm) {
        this.inhalenOpm = inhalenOpm;
    }

    public String getKruisenOpm() {
        return kruisenOpm;
    }

    public void setKruisenOpm(String kruisenOpm) {
        this.kruisenOpm = kruisenOpm;
    }

    public String getLinksafOpm() {
        return linksafOpm;
    }

    public void setLinksafOpm(String linksafOpm) {
        this.linksafOpm = linksafOpm;
    }

    public String getRechtsafOpm() {
        return rechtsafOpm;
    }

    public void setRechtsafOpm(String rechtsafOpm) {
        this.rechtsafOpm = rechtsafOpm;
    }

    public int getGrafiek() {
        return grafiek;
    }

    public void setGrafiek(int grafiek) {
        this.grafiek = grafiek;
    }

    public String getAttitudeOpm() {
        return attitudeOpm;
    }

    public void setAttitudeOpm(String attitudeOpm) {
        this.attitudeOpm = attitudeOpm;
    }

    public int getRotonde() {
        return rotonde;
    }

    public void setRotonde(int rotonde) {
        this.rotonde = rotonde;
    }

    public int getRijstroken() {
        return rijstroken;
    }

    public void setRijstroken(int rijstroken) {
        this.rijstroken = rijstroken;
    }

    public int getStad() {
        return stad;
    }

    public void setStad(int stad) {
        this.stad = stad;
    }

    public int getAutosnelweg() {
        return autosnelweg;
    }

    public void setAutosnelweg(int autosnelweg) {
        this.autosnelweg = autosnelweg;
    }

    public int getSchakelaars() {
        return schakelaars;
    }

    public void setSchakelaars(int schakelaars) {
        this.schakelaars = schakelaars;
    }

    public int getVloeistoffen() {
        return vloeistoffen;
    }

    public void setVloeistoffen(int vloeistoffen) {
        this.vloeistoffen = vloeistoffen;
    }

    public int getBanden() {
        return banden;
    }

    public void setBanden(int banden) {
        this.banden = banden;
    }

    public int getTanken() {
        return tanken;
    }

    public void setTanken(int tanken) {
        this.tanken = tanken;
    }

    public int getNoodstop() {
        return noodstop;
    }

    public void setNoodstop(int noodstop) {
        this.noodstop = noodstop;
    }

    public int getGps() {
        return gps;
    }

    public void setGps(int gps) {
        this.gps = gps;
    }

    public String getHoofdmenuOpm() {
        return hoofdmenuOpm;
    }

    public void setHoofdmenuOpm(String hoofdmenuOpm) {
        this.hoofdmenuOpm = hoofdmenuOpm;
    }
    
    
}
