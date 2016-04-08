package be.matkensim.project.domein;

import be.matkensim.project.gui.View;

/**
 *
 * @author Matthias
 */
public interface Model {
    void addView(View view);
    void removeView(View v);
    void update();
}
