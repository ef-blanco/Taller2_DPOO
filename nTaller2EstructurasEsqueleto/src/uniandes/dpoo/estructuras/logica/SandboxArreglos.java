package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
import java.util.Set;
import java.util.Arrays;
import java.util.Collection;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros()
    {
    	int tamanoArreglo = arregloEnteros.length;
    	int [] nuevoArreglo = new int [tamanoArreglo];
    	
    	for (int i=0; i<tamanoArreglo;i++)
    	{
    		int valor = arregloEnteros[i];
    		nuevoArreglo[i]=valor;
    	}
        return nuevoArreglo;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas()
    {
        String [] nuevoArreglo = new String[arregloCadenas.length];
        
        for (int i=0; i<arregloCadenas.length; i++)
        {
        	String valor = arregloCadenas[i];
        	nuevoArreglo[i] = valor;
        }
    	return nuevoArreglo;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros()
    {
        return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas()
    {
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero(int entero)
    {
    	int [] nuevoArreglo = new int [arregloEnteros.length+1];
    	for (int i=0; i<arregloEnteros.length; i++)
    	{
    		int valor = arregloEnteros[i];
    		nuevoArreglo[i] = valor;
    	}
    	nuevoArreglo[nuevoArreglo.length-1] = entero;
    	arregloEnteros = nuevoArreglo;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	String [] nuevoArreglo = new String[arregloCadenas.length+1];
    	for (int i=0; i<arregloCadenas.length; i++)
    	{
    		String valor = arregloCadenas[i];
    		nuevoArreglo[i] = valor;
    	}
    	nuevoArreglo[nuevoArreglo.length-1] = cadena;
    	arregloCadenas = nuevoArreglo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int apariciones = contarApariciones(valor);
    	while (apariciones>0)
    	{
    		int [] nuevoArreglo = new int [arregloEnteros.length-1];
    		int pos = 0;
    		boolean encontro = false;
    		for (int i=0;(i<arregloEnteros.length)&&(!encontro);i++)
    		{
    			if (arregloEnteros[i]==valor)
    			{
    				pos = i;
    				encontro = true;
    			}
    		}
    		for (int j=0;j<pos;j++)
    		{
    			nuevoArreglo[j] = arregloEnteros[j];
    		}
    		for (int k=pos+1;k<arregloEnteros.length;k++)
    		{
    			nuevoArreglo[k-1] = arregloEnteros[k];
    		}
    		arregloEnteros = nuevoArreglo;
    		apariciones--;
    	}
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int apariciones = contarApariciones(cadena);
    	while (apariciones>0)
    	{
    		String [] nuevoArreglo = new String [arregloCadenas.length-1];
    		int pos = 0;
    		boolean encontro = false;
    		for (int i=0;(i<arregloCadenas.length)&&(!encontro);i++)
    		{
    			if ((arregloCadenas[i].toLowerCase()).equals(cadena.toLowerCase()))
    			{
    				pos = i;
    				encontro = true;
    			}
    		}
    		for (int j=0;j<pos;j++)
    		{
    			nuevoArreglo[j] = arregloCadenas[j];
    		}
    		for (int k=pos+1;k<arregloCadenas.length;k++)
    		{
    			nuevoArreglo[k-1] = arregloCadenas[k];
    		}
    		arregloCadenas = nuevoArreglo;
    		apariciones--;
    	}
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int [] nuevoArreglo = new int[arregloEnteros.length+1];
    	if ((0<posicion)&&(posicion<arregloEnteros.length))
    	{
    		for (int i=0;i<posicion;i++)
    		{
    			nuevoArreglo[i] = arregloEnteros[i];
    		}
    		nuevoArreglo[posicion] = entero;
    		for (int i=posicion+1;i<arregloEnteros.length;i++)
    		{
    			nuevoArreglo[i] = arregloEnteros[i-1];
    		}
    	}
    	
    	else if (posicion<=0)
    	{
    		nuevoArreglo[0] = entero;
    		for (int i=0;i<arregloEnteros.length;i++)
    		{
    			nuevoArreglo[i+1] = arregloEnteros[i];
    		}
    		
    	}
    	
    	else if (posicion>arregloEnteros.length)
    	{
    		agregarEntero(entero);
    	}
    	arregloEnteros = nuevoArreglo;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	if ((0<=posicion)&&(posicion<arregloEnteros.length))
    	{
    		int[] nuevoArreglo = new int [arregloEnteros.length-1];
    		for (int i=0;i<posicion;i++)
    		{
    			nuevoArreglo[i] = arregloEnteros[i];
       		}
    		for (int j=posicion+1;j<arregloEnteros.length;j++)
    		{
    			nuevoArreglo[j-1] = arregloEnteros[j];
    		}
    		arregloEnteros = nuevoArreglo;
    	}
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int[] nuevoArreglo = new int[valores.length];
    	for (int i=0;i<valores.length;i++)
    	{
    		nuevoArreglo[i] = i;	
    	}
    	arregloEnteros = nuevoArreglo;	
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String[] nuevoArreglo = new String[objetos.length];
    	for (int i=0;i<objetos.length;i++)
    	{
    		Object objeto = objetos[i];
    		nuevoArreglo[i] = objeto.toString();
    	}
    	arregloCadenas = nuevoArreglo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	for(int i=0; i<arregloEnteros.length;i++)
    	{
    		if(arregloEnteros[i]<0)
    		{
    			arregloEnteros[i] = arregloEnteros[i]*(-1);	
    		}
    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	Arrays.sort(arregloEnteros);
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Arrays.sort(arregloCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int conteo = 0;
    	for (int i=0;i<arregloEnteros.length;i++)
    	{
    		if (arregloEnteros[i]==valor)
    		{
    			conteo++;
    		}
    	}
        return conteo;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int conteo = 0;
    	for (int i=0;i<arregloCadenas.length;i++)
    	{
    		if ((cadena.toLowerCase()).equals(arregloCadenas[i].toLowerCase()))
    		{
    			conteo++;
    		}
    	}
        return conteo;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int numPosiciones = contarApariciones(valor);
    	int [] posiciones = new int [0];
    	if (numPosiciones>0)
    	{
    		int [] pos = new int[numPosiciones];
    		int j = 0;
    		for (int i=0;i<arregloEnteros.length;i++)
    		{
    			if (arregloEnteros[i]==valor)
    			{
    				pos[j] = i;
    				j++;
    			}
    		}
    		posiciones = pos;
    	}

        return posiciones;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	int [] rango = new int [0];
    	if (arregloEnteros.length != 0)
    	{
    		organizarEnteros();
    		int [] rta = new int [2];
    		rta[0] = arregloEnteros[0];
    		rta[1] = arregloEnteros[arregloEnteros.length-1];
    		rango = rta;	
    	}
        return rango;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer,Integer> histograma = new HashMap<Integer,Integer>();
    	
    	for (int i=0;i<arregloEnteros.length;i++)
    	{
    		Integer llave = arregloEnteros[i];
    		if (!(histograma.containsKey(llave)))
    		{
    			histograma.put(llave, contarApariciones(arregloEnteros[i]));
    		}
    	}
        return histograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	int respuesta = 0;
    	HashMap<Integer,Integer> mapaRepeticiones = calcularHistograma();
    	Collection<Integer> numerosRepetidos = mapaRepeticiones.values();
    	for (int repeticiones:numerosRepetidos)
    	{
    		if (repeticiones>1)
    		{
    			respuesta++;
    		}
    	}
    	
        return respuesta;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	boolean diferente = false;
    	boolean respuesta = false;
    	for (int i=0;(i<arregloEnteros.length)&&(!diferente);i++)
    	{
    		if (arregloEnteros[i]!=otroArreglo[i])
    		{
    			diferente = true;
    		}
    	}
    	if (diferente == false)
    	{
    		respuesta = true;
    	}
        return respuesta;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	organizarEnteros();
    	Arrays.sort(otroArreglo);
    	
        return compararArregloEnteros(otroArreglo);
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	int[] nuevoArreglo = new int[cantidad];
    	
    	for (int i=0; i<nuevoArreglo.length;i++)
    	{
    		nuevoArreglo[i] = (int)(Math.random()*(((maximo-minimo)+1)+minimo));
    	}
    	arregloEnteros = nuevoArreglo;
    }

}
