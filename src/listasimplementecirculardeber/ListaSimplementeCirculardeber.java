package ListaSimplementeCirculardeber;

class CNodo {
	int dato;
	CNodo siguiente;
        
	public CNodo()	{
            siguiente = null;
	}
}

class CLista {
    CNodo cabeza;
    public CLista()	{
            cabeza = null;
    }

    public void InsertarDato(int dat) {
        CNodo NuevoNodo;
        CNodo antes, luego;
        NuevoNodo = new CNodo();
        NuevoNodo.dato=dat;
        int ban=0;
        if (cabeza == null){
            NuevoNodo.siguiente=cabeza;
            
            cabeza = NuevoNodo;
        }
        else {  if (dat<cabeza.dato) {
                    NuevoNodo.siguiente=cabeza;
             antes=cabeza;
            luego=cabeza;
            do {       
                luego=luego.siguiente;

                while(ban==0){
                    if(luego.siguiente==cabeza){
                        ban=1;
                    }{
                        luego=luego.siguiente ;
                    }
                    }
            }while (luego!=cabeza);
            luego.siguiente=NuevoNodo;
                    cabeza = NuevoNodo;
                    
        }
                else {  antes=cabeza;
                        luego=cabeza;
                        while (ban==0){
                            if (dat>=luego.dato) {
                                antes=luego;
                                luego=luego.siguiente;
                            }
                            if (luego==null){
                                ban=1;
                            }
                            else {
                                    if (dat<luego.dato){
                                        ban=1;
                                    }
                            }
                        }
                        antes.siguiente=NuevoNodo;
                        NuevoNodo.siguiente=luego;
                }
        }
    }

    public void EliminarDato(int dat) {
        CNodo antes,luego;
        int ban=0;
        if (Vacia()) {   
            System.out.print("Lista vacía ");
        }
        else {  if (dat<cabeza.dato) {
                    System.out.print("dato no existe en la lista ");
                }
                else {
                        if (dat==cabeza.dato) {
                            luego=cabeza;
                            antes=cabeza;
                                while(ban==0){
                                    if(luego.siguiente==cabeza){
                                        ban=1;
                                    }
                                  antes=luego;
                                  luego=luego.siguiente;
                                }
                                    if(luego.siguiente==cabeza){
                                      cabeza=null;  
                                    }
                                    else{
                                        cabeza=cabeza.siguiente;
                                         antes.siguiente=cabeza;
                                    }
                                   
                        }
                        else {  antes=cabeza;
                                luego=cabeza;
                                while (ban==0) {
                                    if (dat>luego.dato) {
                                        antes=luego;
                                        luego=luego.siguiente;
                                    }
                                    else ban=1;
                                    if (luego==cabeza) {
                                        ban=1;
                                    }
                                    else {
                                            if (luego.dato==dat) 
                                                ban=1;
                                    }
                                }
                                if (luego==cabeza) {
                                    System.out.print("dato no existe en la Lista ");
                                }
                                else {
                                        if (dat==luego.dato) {
                                            antes.siguiente=luego.siguiente;
                                        }
                                        else 
                                            System.out.print("dato no existe en la Lista ");
                                }
                        }
                }
        }
    }
    public boolean Vacia() {
        return(cabeza==null);
    }

    public void VisualizarDatos() {
        CNodo Temporal;
        Temporal=cabeza;
        if (!Vacia()) {
            while (Temporal!=null) {
                System.out.print(" " + Temporal.dato +" ");
                Temporal = Temporal.siguiente;
            }
            System.out.println("");
        }
        else
            System.out.print("Lista vacía");
    }
}

public class ListaSimplementeCirculardeber {
    public static void main(String args[]) {
        CLista objLista= new CLista();
        System.out.println("Lista Original:");
        objLista.InsertarDato(5);
        objLista.InsertarDato(9);
        objLista.InsertarDato(10);
        objLista.InsertarDato(15);
        objLista.VisualizarDatos();
        System.out.println("\nLista Sin el 9: ");
        objLista.EliminarDato(9);
        objLista.VisualizarDatos();
    }

    
}
