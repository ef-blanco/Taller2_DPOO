package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
    	ArrayList<String> respuesta = new ArrayList<String>();
    	Set llaves = mapaCadenas.keySet();
    	for (Object llave:llaves)
    	{
    		String elemento = mapaCadenas.get(llave).toString();
    		respuesta.add(elemento);
    	}
    	
        return respuesta;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	ArrayList<String> respuesta = new ArrayList<String>();
    	Set llaves = mapaCadenas.keySet();
    	for (Object llave:llaves)
    	{
    		respuesta.add(llave.toString());
    	}
    	Collections.sort(respuesta,Collections.reverseOrder());
        return respuesta;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
    	ArrayList<String> listaLlaves = (ArrayList<String>) getLlavesComoListaInvertida();
    	
    	if (listaLlaves.size()==0)
    	{
    		return null;
    	}
    	else
    	{
    		return listaLlaves.get(listaLlaves.size()-1);
    	}
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	ArrayList<String> listaLlaves = (ArrayList<String>) getLlavesComoListaInvertida();
    	
    	if (listaLlaves.size()==0)
    	{
    		return null;
    	}
    	else
    	{
    		return listaLlaves.get(0);
    	}
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	ArrayList<String> respuesta = new ArrayList<String>();
    	Set llaves = mapaCadenas.keySet();
    	for (Object llave:llaves)
    	{
    		respuesta.add(llave.toString().toUpperCase());
    	}
        return respuesta;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	ArrayList<String> listaValores = (ArrayList<String>) getValoresComoLista();
    	ArrayList<String> valoresNoRepetidos = new ArrayList<String>();
    	for (String valor:listaValores)
    	{
    		if (!(valoresNoRepetidos.contains(valor)))
    		{
    			valoresNoRepetidos.add(valor);
    		}
    	}
        return valoresNoRepetidos.size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	char [] cadenaArray = cadena.toCharArray();
    	char [] llaveCadenaArray = new char [cadena.length()];
    	int j = 0;
    	for (int i = (cadena.length())-1;i>-1;i--)
    	{
    		llaveCadenaArray[j] = cadenaArray[i];
    		j++;
    	}
    	String llaveCadena = llaveCadenaArray.toString();
    	mapaCadenas.put(llaveCadena, cadena);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	if (mapaCadenas.containsValue(valor))
    	{
    		Set<Map.Entry<String,String>> conjuntoEntradas = mapaCadenas.entrySet();
        	String llave = "";
        	for(Map.Entry<String,String> entry:conjuntoEntradas)
        	{
        		String valorEntry = entry.getValue();
        		if (valorEntry.equals(valor))
        		{
        			llave = entry.getKey();
        		}
        	}
        	mapaCadenas.remove(llave, valor);
    	}
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	mapaCadenas.clear();
    	for (Object elemento:objetos)
    	{
    		String valor = elemento.toString();
    		agregarCadena(valor);
    	}
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	HashMap<String,String> nuevoMapa = new HashMap<String,String>();
    	Set<Map.Entry<String,String>> conjuntoEntradas = mapaCadenas.entrySet();
    	for(Map.Entry<String,String> entry:conjuntoEntradas)
    	{
    		String nuevaLlave = entry.getKey().toUpperCase();
    		nuevoMapa.put(nuevaLlave, entry.getValue());
    	}
    	mapaCadenas = nuevoMapa;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
    	boolean respuesta = false;
    	boolean elementoNoEsta = false;
    	for (int i=0;(i<otroArreglo.length)&&(!elementoNoEsta);i++)
    	{
    		if (!(mapaCadenas.containsValue(otroArreglo[i])))
    		{
    			elementoNoEsta = true;
    		}
    	}
    	if (elementoNoEsta==false)
    	{
    		respuesta = true;
    	}
        return respuesta;
    }

}
