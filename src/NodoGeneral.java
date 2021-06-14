/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alan-
 */

// CONTIENE UNA LISTA QUE HACE REFERENCIA A LOS NODOS HIJOS
/*
        INSERTAR    [ENLAZAR]
        ELIMINAR    [DESENLAZAR]
        BuscarHijo  [ObtenerHijo]
*/
public class NodoGeneral {
        char dato;
        NodoHijo ini, fin;
        
        public NodoGeneral(char dato){
            this.dato = dato;
            ini = fin = null;
        }
        // CODIGO EN DUDA
        public boolean esHoja(){
        return ini == null && fin == null;
        }
        
        public boolean enlazar(NodoGeneral hijo){
            //CODIGO CLASICO DE LISTA DOBLE
            NodoHijo temp = new NodoHijo(hijo);
            if(temp==null) return false;
            
            if(ini==null && fin==null){
                ini = fin = temp;
                return true;
            }
            
            fin.sig = temp;
            temp.ant = fin;
            fin = temp;
            return true;
        
        }
        
        public NodoGeneral obtenerHijo(char datoHijoBuscado){
            if(ini == null && fin == null) return null;
            
            for(NodoHijo buscar = ini; buscar != null; buscar = buscar.sig){
                if(buscar.direHijo.dato == datoHijoBuscado){
                    return buscar.direHijo;
                }
            }
            return null;
        }

    public boolean desenlazar(NodoGeneral hijo) {
        if (ini == fin) {
            if (fin.direHijo == hijo) {
                ini = fin = null;
                return true;

            }
            return false;
        }
        NodoHijo temp = ini;
        if (ini.direHijo == hijo) {
            ini = temp.sig;
            ini.ant = temp.sig = temp = null;
            return true;
        }
        if (fin.direHijo == hijo) {
            temp = fin;
            fin = temp.ant;
            fin.sig = temp.ant = temp = null;
            return true;
        }
        temp = temp.sig;
        while (temp.direHijo != hijo && temp != null) {
            temp = temp.sig;
        }
        if (temp == null) {
            return false;
        }
        temp.sig.ant = temp.ant;
        temp.ant.sig = temp.sig;
        temp.sig = temp.ant = temp = null;
        return true;  
    }            
}
