/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.matkensim.project.comparators;

import be.matkensim.project.domein.Leerling;
import java.util.Comparator;

/**
 *
 * @author Matthias
 */
public class LeerlingComparator implements Comparator<Leerling>{

    @Override
    public int compare(Leerling o1, Leerling o2) {
        if (o1==null ||o2 == null)
            return 0;
        
        return o1.getNaam().compareTo(o2.getNaam());
    }
    
}
