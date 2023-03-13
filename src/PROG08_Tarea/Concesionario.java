package PROG08_Tarea;

import java.util.*;

/**
 *
 * @author IVAN
 *
 * Esta clase Concesionario tiene los metodos para poder interactuar con la
 * principal y modificar y crear objetos en el array Concesionario.
 */
public class Concesionario {
    // atributos del array
//    private Vehiculo[] Vehiculos;
//    private int numVehiculos;

    // se modifica el array y se va a añadir un tipo ArrayList para ser lista dinamica y ordenada
    private ArrayList<Vehiculo> Vehiculos;

    // 
    /**
     * Ahora es un ArrayList y se inicializa con el constructor vacio
     */
    public Concesionario() {
        this.Vehiculos = new ArrayList<>();
    }

    /**
     * Metodo para buscar vehiculos
     *
     * @param matricula Del vehiculo que se quiere buscar
     * @return Devuelve un toString con los datos del vehiculo en caso de
     * existir, en caso contrairo devuelve un null.
     */
    public Vehiculo buscaVehiculo(String matricula) {
        /**
         * este metodo busca el vehiculo dando una matricula por argumento si
         * existe ese vehiculo con matricula, devuelve un objeto Vehiculo en caso
         * contrario devuelve null
         */

        for (int i = 0; i < Vehiculos.size(); i++) {
            Vehiculo v = this.Vehiculos.get(i);
            if (v.getMatricula().equals(matricula)) {
                return v;
            }
        }
        return null;
    }

    /**
     * metodo para insertar vehiculos
     *
     * @param v es el objeto vehiculo cual se va a añadir al array
     * @return si el array esta completo devuelve -1 si el vehiculo ya existe,
     * porque lo comprueba, devuelve -2 si lo introduce, devuelve 0, ademas suma
     * al int numVehiculos
     */
    public int insertarVehiculo(Vehiculo v) {

        // se borra la opcion de comprobar si hay espacio, ya que esa opcion ya no existe
        //puesto que el MAP ya no es finito
        if (this.buscaVehiculo(v.getMatricula()) != null) {
            return -2;//vehiculo ya existe
        } else {
            // se modifica para añadir vehiculos a nuevo ArrayList
            this.Vehiculos.add(v);
            // con conllections sort ordenamos por vehiculos
            Collections.sort(Vehiculos);
            return 0;// creado
        }
    }

    /**
     * Metodo para listar vehiculos Devuelve un toString de todos los objetos
     * del array que existan.
     *
     */

    public void listarVehiculos() {
        // con un bucle for hacmeos que vaya pasando por todo el array
        for (int i = 0; i < Vehiculos.size(); i++) {
            System.out.println(Vehiculos.get(i).toString());
        }
    }

    /**
     * metodo para actualizar los kilometros
     *
     * @param matricula matricula cual se quiere buscar
     * @param kms Kilometros nuevos que se quieren añadir
     * @return true si lo ha realizado con extito, False si no lo ha realizado.
     */
    public boolean actualizaKms(String matricula, int kms) {

//con un if se comprueban los kilometros del objeto por su matricula
//sean menores a los que se quieren introducir
// si es correcto, se actualizan los km y el booleano se pone en true      
        Vehiculo v;
        if ((v = buscaVehiculo(matricula)) != null) {
            if (kms > v.getNum_kms()) {
                v.setNum_kms(kms);
            }
            return true;
        }
        return false;
    }
    
    //Opcion del metodo eliminarVehiculo
    // se usa el metodo buscaVehiculo para buscar matriculas

//    public boolean eliminarVehiculo(String matricula) {
//        Vehiculo v;
//        if ((v = buscaVehiculo(matricula)) != null) {
//            this.Vehiculos.remove(v);
//            return true;
//        }
//        return false;
//    }
    
    // se Añade eliminarVehiculo, este tiene un bucle donde usa el metodo equals
    
        public boolean eliminarVehiculo(String matricula) {
            for (Vehiculo v: this.Vehiculos) {
                if (v.getMatricula().equals(matricula)) {
                    this.Vehiculos.remove(v);
                    return true;
                }
            }
        return false;
    }

}
