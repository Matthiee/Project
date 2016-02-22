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

    public Onderdeel(String base) {

        String neutraal = base + "Neutraal.png";
        String gekend = base + "Groen.png";
        String gezien_niet_gekend = base + "Oranje.png";
        String niet_gekend = base + "Rood.png";

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

    public int getStatus() {
        return statusProperty.get();
    }

    public void setStatus(int status) {
        this.statusProperty.setValue(status);
    }

    public IntegerProperty getStatusProperty() {
        return statusProperty;
    }

}
