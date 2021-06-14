/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alan-
 */
public class NodoHijo {
    NodoGeneral direHijo;
    NodoHijo ant, sig;

    public NodoHijo(NodoGeneral hijoApuntar) {
        this.direHijo = hijoApuntar;
        ant = sig = null;
    }
    
}
