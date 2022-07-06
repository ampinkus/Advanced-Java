package arreglo;
/////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Arreglo {
    //atributos privados
    private long[] arr;	    // referencia a arreglo con elementos tipo long
    private int numElems;	// numero actual de elementos en arreglo
    //---------------------------------------------------------------------------------------------------
    // constructor
    public Arreglo(int tam) {   //tam es el tamaño del arreglo
        arr = new long[tam];				// crea arreglo
        numElems = 0;						// arreglo inicia con 0 elementos
    }
    //---------------------------------------------------------------------------------------------------
    // metodo que busca un valor especifico en arreglo
    // el argumento dato especifica el valor del elemento a borrar (metodo retorna true si se encontro el dato buscado)
    public boolean buscar(long dato) {
        int j;
        for(j=0;j<numElems;j++) {
            if(arr[j]==dato) {				// se encontro item
                break;
            }
        }

        if(j==numElems) {					// llego al final del arreglo
            return false;					// no se encontro elemento, retona false
        } else {
            return true;					// se encontro elemento retorna true
        }
    }
    //---------------------------------------------------------------------------------------------------
    // inserta un nuevo elemento en el arreglo
    public void insertar(long dato) {
        arr[numElems] = dato;				// inserta dato en arreglo
        numElems++;							// incrementa en uno numero de elementos de arreglo
    }
    //---------------------------------------------------------------------------------------------------
    // borra elemento del arreglo que sea igual al valor del argumento dato desplazando los valores del
    // arreglo una celda hacia abajo
    public boolean eliminar(long dato) {
        int j;

        for(j=0;j<numElems;j++) {			// busca elemento en arreglo
            if(arr[j]==dato) {				// se encontro el valor buscado
                break;
            }
        }

        if(j==numElems) {					// no se encontro el valor buscado
            return false;
        } else {							// valor encontrado en arreglo
            for(int k=j;k<numElems-1;k++) {	// desplaza elementos superiores al indice j
                arr[k]=arr[k+1];
            }
            numElems--;
            return true;
        }
    }
    //---------------------------------------------------------------------------------------------------
    public void mostrarElementos() {
        for(int j=0;j<numElems;j++) {		// recorre todos los elementos del arreglo
            System.out.print(arr[j] + " ");	// imprime cada elemento del arreglo en consola
        }

        System.out.println("");				// imprime linea en blanco
    }
    //----------------------------------------------------------------------------------------------------
    // muestra el valor del elemento en la posicion i del arreglo
    public long valorElemento(int i) {
        return arr[i];						// retorna el valor del elemento en la posicion i del arreglo
    }
    //----------------------------------------------------------------------------------------------------
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
