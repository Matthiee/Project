/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import gui.View;

/**
 *
 * @author Matthias
 */
public interface Model {
    void addView(View view);
    void removeView(View v);
    void update();
}
