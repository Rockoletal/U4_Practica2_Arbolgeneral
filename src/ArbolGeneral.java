/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alan-
 */
public class ArbolGeneral {

    NodoGeneral raiz; //INICO PUNTERO DEL ARBOL

    public ArbolGeneral() {
        raiz = null;
    }

    public boolean insertar(char dato, String path) {
        /*
        PASOS
        1- RAIZ ES NULL
        2-Paht Vacio
        3-Buscar Padre
        4-Crear Hijo
        5-Enlazar
         */
        if (raiz == null) {
            raiz = new NodoGeneral(dato);
            return true;
        }

        if (path.isEmpty()) {
            return false;
        }

        NodoGeneral padre = buscarNodoRecursivo(path);
        if (padre == null) {
            return false;
        }
        NodoGeneral hijoYaExiste = buscarNodoRecursivo(path + "/" + dato);
        if (hijoYaExiste != null) {
            return false;
        }
        NodoGeneral nuevo = new NodoGeneral(dato);
        return padre.enlazar(nuevo);
    }

    /*private NodoGeneral buscarNodo(String path) {
        path = path.substring(1);
        String vector[] = path.split("/");

        if (vector[0].charAt(0) == raiz.dato) {
            if (vector.length == 1) {
                return raiz;
            }

            NodoGeneral padre = raiz;

            for (int i = 1; i < vector.length; i++) {
                padre = padre.obtenerHijo(vector[i].charAt(0));
                if (padre == null) {
                    return null;
                }
            }
            return padre;
        }
        return null; // No Concidio celdilla 0 con raiz
    }*/

    public boolean eliminar(String path) {
        if(raiz==null)return false;
        NodoGeneral hijo=buscarNodoRecursivo(path);
        if(hijo==null)return false;
        if(!hijo.esHoja())return false;
        if(hijo==raiz){raiz=null;return true;}

        String pathPadre=obtenerPadthPadre(path);
        NodoGeneral padre=buscarNodoRecursivo(pathPadre);
        return padre.desenlazar(hijo);
    }

    private String obtenerPadthPadre(String path) {
        int pos = path.lastIndexOf("/")-1;
        return path.substring(0, pos);
    }
    
    private NodoGeneral buscarNodo(NodoGeneral padre,int cont,String[]arreglo){
        if(cont<arreglo.length){      
            padre = padre.obtenerHijo(arreglo[cont].charAt(0));
            if(padre == null) return null;
            cont=cont+1;
            padre = buscarNodo(padre,cont,arreglo);
        }
        return padre;
    }
    
    private NodoGeneral buscarNodoRecursivo(String path){
        path = path.substring(1);
        String arreglo[]= path.split("/");
        int cont = 1;
        if(arreglo[0].charAt(0)==raiz.dato){
            if(arreglo.length==1)return raiz;
            NodoGeneral padre =raiz;
            return buscarNodo(padre,cont,arreglo);
        }
        return null;
    }

    public boolean verificar(String path){
        NodoGeneral Nodo = buscarNodoRecursivo(path);
        if(Nodo == null) return false;
        else{ return true;}
    }
}
