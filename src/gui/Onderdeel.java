package gui;

import java.util.HashMap;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Matthias
 */
public class Onderdeel extends ImageView {

    public static final int NEUTRAAL = 0;
    public static final int GEKEND = 1;
    public static final int GEZIEN_NIET_GEKEND = 2;
    public static final int NIET_GEKEND = 3;

    private final IntegerProperty statusProperty = new SimpleIntegerProperty(NEUTRAAL);

    private final HashMap<String, Image> imageCache = new HashMap<>(4);
    
    private int transX, transY;
    
    private String base;

    public Onderdeel(String base) {
        
        this.base = base;

        String neutraal = this.base + "Neutraal.png";
        String gekend = this.base + "Groen.png";
        String gezien_niet_gekend = this.base + "Oranje.png";
        String niet_gekend = this.base + "Rood.png";
        
        transX = 0;
        transY = 0;

        statusProperty.addListener((Observable o) -> {
            final int x = getStatus();
            switch (x) {
                case NEUTRAAL:
                    setImage(neutraal);
                    break;
                case GEKEND:
                    setImage(gekend);
                    break;
                case GEZIEN_NIET_GEKEND:
                    setImage(gezien_niet_gekend);
                    break;
                case NIET_GEKEND:
                    setImage(niet_gekend);
                    break;
            }
        });
        
        setImage(neutraal);
    }
    
    public Onderdeel(String base, int tx, int ty) {
        
        this.base = base;

        String neutraal = this.base + "Neutraal.png";
        String gekend = this.base + "Groen.png";
        String gezien_niet_gekend = this.base + "Oranje.png";
        String niet_gekend = this.base + "Rood.png";
        
        transX = tx;
        transY = ty;

        statusProperty.addListener((Observable o) -> {
            final int x = getStatus();
            switch (x) {
                case NEUTRAAL:
                    setImage(neutraal);
                    break;
                case GEKEND:
                    setImage(gekend);
                    break;
                case GEZIEN_NIET_GEKEND:
                    setImage(gezien_niet_gekend);
                    break;
                case NIET_GEKEND:
                    setImage(niet_gekend);
                    break;
            }
        });
        
        setImage(neutraal);
    }

    /**
     * Zet de afbeelding in de ImageView. De afbeeldingen worden gecached om
     * laadtijden te verlagen en voor optimalisatie.
     *
     * @param imageStr Het pad naar de image
     */
    public void setImage(String imageStr) {
        Image img;

        if (imageCache.containsKey(imageStr)) {
            img = imageCache.get(imageStr);
        } else {
            img = new Image(imageStr);
            imageCache.put(imageStr, img);
        }

        setImage(img);
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getStatus() {
        return statusProperty.get();
    }

    public void setStatus(int status) {
        this.statusProperty.setValue(status);
    }

    public IntegerProperty getStatusProperty() {
        return statusProperty;
    }

    public int getTransX() {
        return transX;
    }

    public void setTransX(int transX) {
        this.transX = transX;
    }

    public int getTransY() {
        return transY;
    }

    public void setTransY(int transY) {
        this.transY = transY;
    }
    
    

}
