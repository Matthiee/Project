
package be.matkensim.project.domein;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EvaluatieMoment {
    
    //voor de kleuren:
        //Neutraal              = 0     Wit
        //Gekend                = 1     Groen
        //Gezien niet Gekend    = 2     Oranje
        //Niet gekend           = 3     Rood
    
    //gegevens rijtechniek
    private int parkeren, garage, stuuroef, achteruit, keren;
    private int houding, remmen, koppeling,schakelen, sturen, kijken, helling;
    private ObservableList<Rijtechniek> houdingOpm, koppelingOpm, remmenOpm, schakelenOpm,
            sturenOpm, kijkenOpm, hellingOpm, kerenOpm, parkerenOpm, achteruitOpm,
            garageOpm, stuuroefOpm;
    //gegevens verkeerstechniek
    private int richtingaanwijzers, voorrang, openbareWeg, verkeerstekens, snelheid,
            afstand, inhalen, kruisen, linksaf, rechtsaf;
    private ObservableList<Verkeerstechniek> richtingaanwijzersOpm, voorrangOpm, openbareWegOpm, verkeerstekensOpm, 
            snelheidOpm, afstandOpm, inhalenOpm, kruisenOpm, linksafOpm, rechtsafOpm;
    //gegevens attitude
    private ObservableList<String> attitudeOpm;
    //gegevens hoofdmenu;
    private int rotonde, rijstroken, stad, autosnelweg, schakelaars, vloeistoffen,
            banden, tanken, noodstop, gps;
    private ObservableList<String> hoofdmenuOpm;
    
    //Constructors

    public EvaluatieMoment() {
        //dummy array om de andere arrays in te vullen
        int[] array = {0, 0, 0};
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
        this.houdingOpm = FXCollections.observableArrayList();
        this.koppelingOpm = FXCollections.observableArrayList();
        this.remmenOpm = FXCollections.observableArrayList();
        this.schakelenOpm = FXCollections.observableArrayList();
        this.sturenOpm = FXCollections.observableArrayList();
        this.kijkenOpm = FXCollections.observableArrayList();
        this.hellingOpm = FXCollections.observableArrayList();
        this.garageOpm = FXCollections.observableArrayList();
        this.stuuroefOpm = FXCollections.observableArrayList();
        this.parkerenOpm = FXCollections.observableArrayList();
        this.kerenOpm = FXCollections.observableArrayList();
        this.achteruitOpm = FXCollections.observableArrayList();
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
        this.richtingaanwijzersOpm = FXCollections.observableArrayList();
        this.voorrangOpm = FXCollections.observableArrayList();
        this.openbareWegOpm = FXCollections.observableArrayList();
        this.verkeerstekensOpm = FXCollections.observableArrayList();
        this.snelheidOpm = FXCollections.observableArrayList();
        this.afstandOpm = FXCollections.observableArrayList();
        this.inhalenOpm = FXCollections.observableArrayList();
        this.kruisenOpm = FXCollections.observableArrayList();
        this.linksafOpm = FXCollections.observableArrayList();
        this.rechtsafOpm = FXCollections.observableArrayList();
        this.attitudeOpm = FXCollections.observableArrayList();
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
        this.hoofdmenuOpm = FXCollections.observableArrayList();
    }

    public EvaluatieMoment(int parkeren, int garage, int stuuroef, int achteruit, int keren, int houding, int remmen, int koppeling, int schakelen, int sturen, int kijken, int helling, ObservableList<Rijtechniek> houdingOpm, ObservableList<Rijtechniek> koppelingOpm, ObservableList<Rijtechniek> remmenOpm, ObservableList<Rijtechniek> schakelenOpm, ObservableList<Rijtechniek> sturenOpm, ObservableList<Rijtechniek> kijkenOpm, ObservableList<Rijtechniek> hellingOpm, ObservableList<Rijtechniek> kerenOpm, ObservableList<Rijtechniek> parkerenOpm, ObservableList<Rijtechniek> achteruitOpm, ObservableList<Rijtechniek> garageOpm, ObservableList<Rijtechniek> stuuroefOpm, int richtingaanwijzers, int voorrang, int openbareWeg, int verkeerstekens, int snelheid, int afstand, int inhalen, int kruisen, int linksaf, int rechtsaf, ObservableList<Verkeerstechniek> richtingaanwijzersOpm, ObservableList<Verkeerstechniek> voorrangOpm, ObservableList<Verkeerstechniek> openbareWegOpm, ObservableList<Verkeerstechniek> verkeerstekensOpm, ObservableList<Verkeerstechniek> snelheidOpm, ObservableList<Verkeerstechniek> afstandOpm, ObservableList<Verkeerstechniek> inhalenOpm, ObservableList<Verkeerstechniek> kruisenOpm, ObservableList<Verkeerstechniek> rechtsafOpm, ObservableList<String> attitudeOpm, int rotonde, int rijstroken, int stad, int autosnelweg, int schakelaars, int vloeistoffen, int banden, int tanken, int noodstop, int gps) {
        this.parkeren = parkeren;
        this.garage = garage;
        this.stuuroef = stuuroef;
        this.achteruit = achteruit;
        this.keren = keren;
        this.houding = houding;
        this.remmen = remmen;
        this.koppeling = koppeling;
        this.schakelen = schakelen;
        this.sturen = sturen;
        this.kijken = kijken;
        this.helling = helling;
        this.houdingOpm = houdingOpm;
        this.koppelingOpm = koppelingOpm;
        this.remmenOpm = remmenOpm;
        this.schakelenOpm = schakelenOpm;
        this.sturenOpm = sturenOpm;
        this.kijkenOpm = kijkenOpm;
        this.hellingOpm = hellingOpm;
        this.kerenOpm = kerenOpm;
        this.parkerenOpm = parkerenOpm;
        this.achteruitOpm = achteruitOpm;
        this.garageOpm = garageOpm;
        this.stuuroefOpm = stuuroefOpm;
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
        this.rechtsafOpm = rechtsafOpm;
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

    public int getKeren() {
        return keren;
    }

    public void setKeren(int keren) {
        this.keren = keren;
    }

    public int getHouding() {
        return houding;
    }

    public void setHouding(int houding) {
        this.houding = houding;
    }

    public int getRemmen() {
        return remmen;
    }

    public void setRemmen(int remmen) {
        this.remmen = remmen;
    }

    public int getKoppeling() {
        return koppeling;
    }

    public void setKoppeling(int koppeling) {
        this.koppeling = koppeling;
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

    public int getHelling() {
        return helling;
    }

    public void setHelling(int helling) {
        this.helling = helling;
    }

    public ObservableList<Rijtechniek> getHoudingOpm() {
        return houdingOpm;
    }

    public void setHoudingOpm(ObservableList<Rijtechniek> houdingOpm) {
        this.houdingOpm = houdingOpm;
    }

    public ObservableList<Rijtechniek> getKoppelingOpm() {
        return koppelingOpm;
    }

    public void setKoppelingOpm(ObservableList<Rijtechniek> koppelingOpm) {
        this.koppelingOpm = koppelingOpm;
    }

    public ObservableList<Rijtechniek> getRemmenOpm() {
        return remmenOpm;
    }

    public void setRemmenOpm(ObservableList<Rijtechniek> remmenOpm) {
        this.remmenOpm = remmenOpm;
    }

    public ObservableList<Rijtechniek> getSchakelenOpm() {
        return schakelenOpm;
    }

    public void setSchakelenOpm(ObservableList<Rijtechniek> schakelenOpm) {
        this.schakelenOpm = schakelenOpm;
    }

    public ObservableList<Rijtechniek> getSturenOpm() {
        return sturenOpm;
    }

    public void setSturenOpm(ObservableList<Rijtechniek> sturenOpm) {
        this.sturenOpm = sturenOpm;
    }

    public ObservableList<Rijtechniek> getKijkenOpm() {
        return kijkenOpm;
    }

    public void setKijkenOpm(ObservableList<Rijtechniek> kijkenOpm) {
        this.kijkenOpm = kijkenOpm;
    }

    public ObservableList<Rijtechniek> getHellingOpm() {
        return hellingOpm;
    }

    public void setHellingOpm(ObservableList<Rijtechniek> hellingOpm) {
        this.hellingOpm = hellingOpm;
    }

    public ObservableList<Rijtechniek> getKerenOpm() {
        return kerenOpm;
    }

    public void setKerenOpm(ObservableList<Rijtechniek> kerenOpm) {
        this.kerenOpm = kerenOpm;
    }

    public ObservableList<Rijtechniek> getParkerenOpm() {
        return parkerenOpm;
    }

    public void setParkerenOpm(ObservableList<Rijtechniek> parkerenOpm) {
        this.parkerenOpm = parkerenOpm;
    }

    public ObservableList<Rijtechniek> getAchteruitOpm() {
        return achteruitOpm;
    }

    public void setAchteruitOpm(ObservableList<Rijtechniek> achteruitOpm) {
        this.achteruitOpm = achteruitOpm;
    }

    public ObservableList<Rijtechniek> getGarageOpm() {
        return garageOpm;
    }

    public void setGarageOpm(ObservableList<Rijtechniek> garageOpm) {
        this.garageOpm = garageOpm;
    }

    public ObservableList<Rijtechniek> getStuuroefOpm() {
        return stuuroefOpm;
    }

    public void setStuuroefOpm(ObservableList<Rijtechniek> stuuroefOpm) {
        this.stuuroefOpm = stuuroefOpm;
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

    public ObservableList<Verkeerstechniek> getRichtingaanwijzersOpm() {
        return richtingaanwijzersOpm;
    }

    public void setRichtingaanwijzersOpm(ObservableList<Verkeerstechniek> richtingaanwijzersOpm) {
        this.richtingaanwijzersOpm = richtingaanwijzersOpm;
    }

    public ObservableList<Verkeerstechniek> getVoorrangOpm() {
        return voorrangOpm;
    }

    public void setVoorrangOpm(ObservableList<Verkeerstechniek> voorrangOpm) {
        this.voorrangOpm = voorrangOpm;
    }

    public ObservableList<Verkeerstechniek> getOpenbareWegOpm() {
        return openbareWegOpm;
    }

    public void setOpenbareWegOpm(ObservableList<Verkeerstechniek> openbareWegOpm) {
        this.openbareWegOpm = openbareWegOpm;
    }

    public ObservableList<Verkeerstechniek> getVerkeerstekensOpm() {
        return verkeerstekensOpm;
    }

    public void setVerkeerstekensOpm(ObservableList<Verkeerstechniek> verkeerstekensOpm) {
        this.verkeerstekensOpm = verkeerstekensOpm;
    }

    public ObservableList<Verkeerstechniek> getSnelheidOpm() {
        return snelheidOpm;
    }

    public void setSnelheidOpm(ObservableList<Verkeerstechniek> snelheidOpm) {
        this.snelheidOpm = snelheidOpm;
    }

    public ObservableList<Verkeerstechniek> getAfstandOpm() {
        return afstandOpm;
    }

    public void setAfstandOpm(ObservableList<Verkeerstechniek> afstandOpm) {
        this.afstandOpm = afstandOpm;
    }

    public ObservableList<Verkeerstechniek> getInhalenOpm() {
        return inhalenOpm;
    }

    public void setInhalenOpm(ObservableList<Verkeerstechniek> inhalenOpm) {
        this.inhalenOpm = inhalenOpm;
    }

    public ObservableList<Verkeerstechniek> getKruisenOpm() {
        return kruisenOpm;
    }

    public void setKruisenOpm(ObservableList<Verkeerstechniek> kruisenOpm) {
        this.kruisenOpm = kruisenOpm;
    }

    public ObservableList<Verkeerstechniek> getLinksafOpm() {
        return linksafOpm;
    }

    public void setLinksafOpm(ObservableList<Verkeerstechniek> linksafOpm) {
        this.linksafOpm = linksafOpm;
    }

    public ObservableList<Verkeerstechniek> getRechtsafOpm() {
        return rechtsafOpm;
    }

    public void setRechtsafOpm(ObservableList<Verkeerstechniek> rechtsafOpm) {
        this.rechtsafOpm = rechtsafOpm;
    }

    public ObservableList<String> getAttitudeOpm() {
        return attitudeOpm;
    }

    public void setAttitudeOpm(ObservableList<String> attitudeOpm) {
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

    public ObservableList<String> getHoofdmenuOpm() {
        return hoofdmenuOpm;
    }

    public void setHoofdmenuOpm(ObservableList<String> hoofdmenuOpm) {
        this.hoofdmenuOpm = hoofdmenuOpm;
    }
    
    
}
