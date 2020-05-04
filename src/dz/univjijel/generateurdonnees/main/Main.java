/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.univjijel.generateurdonnees.main;

import dz.univjijel.generateurdonnees.core.ChargerDonneesAleatoires;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ChargerDonneesAleatoires.lancerChargement(100000l);
    }
    
}
