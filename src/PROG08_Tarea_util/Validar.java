package PROG08_Tarea_util;

import java.time.LocalDate;

/**
 * Esta clase contiene los metodos para validar en la clase principal
 * contiene metodo para: validarMatricula, validarDNI, 
 * validarNombre, validarFecha
 * @author ivanm
 */
public class Validar {

    
    /**
     * Este metodo valida si el formato es correcto para las matriculas
     * siendo NNNNLLL es decir 4 numeros y 3 letras mayuscula
     * @param matricula un String que sera la matricula para el objeto Vehiculo
     * @return un booleano, TRUE si tiene el formato NNNNLLL, o FALSE si no lo cumple
     */
    public static boolean validarMatricula(String matricula) {
        // este metodo valida si el formato es NNNNLLL
        // cuatro numeros y 3 letras mayusculas
        return matricula.matches("^[0-9]{4}[A-Z]{3}$");
    }

    
    /**
     * Comprueba si el formato es correcto, entre 7 u 8 numeros
     * y despues una letra de DNI: (T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K)
     * @param DNI el String tipo DNI de la persona que se quiera comprobar
     * @return un booleano, TRUE si es correcto, FALSE si no es correcto
     */
    public static boolean validarDNI(String DNI) {
        return DNI.matches("^[0-9]{7,8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K]$");
    }

    /**
     * Comprueba que tiene menos de 40 caracteres y ademas exista 2 espacios, sirve que el formato sea NOMBRE APELLIDO1 APELLIDO2
     * cuenta cuantos espacios existen entre los nombres y si es 2 lo da como TRUE si no es asi lo da FALSE
     * @param nombre String que se quiera validar, tiene que ser nombre y apellidos
     * @return booleano TRUE si cumple tener dos espacios y menos de 40 caracteres, FALSE si no lo cumple
     */
    public static boolean validarNombre(String nombre) {
        // este if primero cuenta que no tenga mas de 40 caracteres
        if (nombre.length() > 40) {
            return false;
        }
        // ademas se van a contar los espacios, para eso se crae un bucle for
        // que contara los espacios existentes para que haya 2 o mas.
        char caracter;
        int numEspacios = 0;
        for (int i = 0; i < nombre.length(); i++) {
            caracter = nombre.charAt(i);
            if (caracter == ' ') {
                numEspacios++;
            }
            if (Character.isDigit(caracter)) {
                return false;
            }
        }
        // si tiene 2 o mas espacios es true, si no false
        if(numEspacios >= 2) {
            return true;
        }
        return false;
    }
    
    /**
     * Comprueba una fechada dada por parametro para saber si la fecha es pasada o futura
     * @param matri_fecha una fecha a comprobar
     * @return booleano TRUE si la fecha es antes de la actual
     * FALSE si la fecha es futura a la actual
     */
     public static boolean validaFecha(LocalDate matri_fecha)
	{
        return matri_fecha.isBefore(LocalDate.now());
    }

}
