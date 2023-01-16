import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Logger;

public class Colecciones {

    private static Logger log = Logger.getLogger(Principal.class.getName());

    public static void main(String[] args) {

        var numeros = new HashSet<Integer>();
        int cantidadNumeros = 10;

        for (int i = 0; i < cantidadNumeros; i++) {
            numeros.add(i + 1);
        }

        /*
        * El Iterator es una manera de recorrer colecciones Iterables, es como el
        * Buffer Reader por ejemplo, .next() te devuelve el siguiente, .hashNext()
        * pregunta si hay siguiente
        * */

        //HASHMAP
        var tablaPrimos = new HashMap<Integer, Boolean>();
        var tablaPrimos2 = new HashMap<String, String>();

        Iterator<Integer> iterator = numeros.iterator();
        while (iterator.hasNext()) {
            Integer valor = iterator.next();
            tablaPrimos.put(valor, esPrimo(valor));
            tablaPrimos2.put(valor + "n", esPrimo(valor) ? "primo" : "-");
        }

        /*
         * HASHMAP .getOrDefault(Object key, V defaultValue)
         * Sirve para pasar varios parámetros a un método en el que todos
         * los parámetros tienen el mismo tipo. En el caso de que sean de distinto
         * tipo habrá que hacer un objeto.
         */





    }

    public static Boolean esPrimo(Integer numero) {
        Integer divisor = 2;
        while(divisor < numero) {
            if (numero % divisor == 0) {
                return false;
            }
            divisor++;
        }
        return true;
    }
}
