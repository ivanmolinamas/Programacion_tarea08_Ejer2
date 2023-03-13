package PROG08_Tarea;

import PROG08_Tarea_util.Validar;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * 
 * @author IVAN Clase principal
 * 
 * Clase principal donde esta el codigo para interactuar con todo.
 * En el se imprime el menu y se pide opciones, depende de las opciones se llama
 * a diferentes metodos y clases para realizar las modificaciones oportunas
 */
public class Principal {

    static Scanner teclado = new Scanner(System.in);

    /**
     * Metodo para lanzar por pantalla el menu y este pide una ocpion. la lista
     * va de 1 a 5, siendo 5 la opcion salida
     *
     * @return Devuelve la opcion seleccionada, siendo el 5 la opcion de salir
     */
    public static int mostrarMenu() {
        // metodo para imprimir la opcion de menu por pantalla
        // este metodo tambien recoge la opcion
        System.out.println("GESTION DE VEHICULOS DEL CONCESIONARIO");

        System.out.println("1 - Nuevo vehiculo");
        System.out.println("2 - Listar vehiculos");
        System.out.println("3 - Buscar vehiculo");
        System.out.println("4 - Modificar kilometros de vehiculo");
        System.out.println("5 - Eliminar un Vehiculo");
        System.out.println("6 - Salir");
        System.out.println("Elige una opcion:");
        // se pide la opcion por teclado, ese valor se devuelve con return 
        int opcion = teclado.nextInt();
        teclado.nextLine();
        return opcion;
    }

    public static void main(String[] args) {
        int opcion;

        Vehiculo v = null;

        //variables que se usaran para recoger información del vehiculo.
        String marca, matricula, busca_matricula, descripcion, propietario, dni;
        int kilometros, precio, nuevosKilometros;
        int dia_matri, mes_matri, anyo_matri;
        LocalDate matri_fecha = null;
        int matri_dia, matri_mes, matri_anyo;
        boolean correcto;

        Concesionario concesionario = new Concesionario();

        System.out.println("BIENVENIDO");

        do {
            opcion = mostrarMenu();

            switch (opcion) {
                case 1:
                    // aqui va la creacion de un nuevo vehiculo, se pediran los datos
                    // se añadiran a variables y luego con esas variables se creara
                    //el objeto con argumentos.
                    System.out.println("Nuevo Vehiculo");

                    // inicio de pedir datos al usuario para crear un vehiculo nuevo
                    // los datos se guadaran en las variables, estas si son correctas 
                    // se pasaran todas a la vez al constructor.
                    System.out.println("Introduce la marca del vehiculo");
                    marca = teclado.nextLine();

                    // se pide la descripcion del vehiculo y se añade a la variable descripcion
                    System.out.println("Introduce la descripcion del vehiculo");
                    descripcion = teclado.nextLine();

                    // se pide matricula
                    // con do while creamos bucle hasta que la matricula sea correcta
                    do {
                        System.out.println("Introduce la matricula del vehciulo en formato NNNNLLL");
                        matricula = teclado.nextLine();
                        // con el if lanzamos el mensaje de matricula incorrecta
                        if (!Validar.validarMatricula(matricula)) {
                            System.out.println("Matricula inocrrecta");
                        }
                    } while (!Validar.validarMatricula(matricula));

                    // se piden kiometros
                    // igual que antes, con do while comprobamos que los kilometros son positivos
                    do {
                        System.out.println("Introduzca los kilometros");
                        kilometros = teclado.nextInt();
                        teclado.nextLine();
                        if (0 > kilometros) {
                            System.out.println("Kilometros incorrectos");
                        }
                    } while (0 > kilometros);

                    //se pide el precio
                    System.out.println("Introduce precio del vehiculo");
                    precio = teclado.nextInt();
                    teclado.nextLine();

                    // se pide el nombre del propietario
                    // se valida que tenga dos espacios, a traves de la calse validar
                    // con el metodo validarNombre
                    do {
                        System.out.println("Introduce el nombre y apellidos del propietario");
                        propietario = teclado.nextLine();
                        if (!Validar.validarNombre(propietario)) {
                            System.out.println("Nombre incorrecto, introduzca nombre y apellidos formato:Nombre Apellido1 Apellido2");
                        }
                    } while (!Validar.validarNombre(propietario));

                    //se pide el DNI
                    // Validación del DNI, con un do while se pedira hasta que sea correcto
                    do {
                        System.out.println("Introduce el DNI del propietario");
                        dni = teclado.nextLine();
                        if (!Validar.validarDNI(dni)) {
                            System.out.println("DNI incorrecto.");
                        }
                    } while (!Validar.validarDNI(dni));

                    // se pide la fecha de forma individual dia, mes y año
                    // validar fecha correcta
                    do {
                        correcto = true;

                        try {
                            System.out.println("Introduce el dia de matriculacion");
                            dia_matri = teclado.nextInt();
                            teclado.nextLine();

                            System.out.println("Introduce el mes de matriculacion");
                            mes_matri = teclado.nextInt();
                            teclado.nextLine();

                            System.out.println("Introduce el anyo de matricuiacon");
                            anyo_matri = teclado.nextInt();

                            matri_fecha = LocalDate.of(anyo_matri, mes_matri, dia_matri);

                            // comprobamos que la fecha es anterior a la actual
                            if (Validar.validaFecha(matri_fecha)) {
                                correcto = true;
                            } else {
                                correcto = false;
                                System.out.println("La fecha no es anterior a la fecha actual");
                            }
                        } catch (InputMismatchException e) {
                            correcto = false;
                            teclado.next();
                            System.out.println("Fecha incorrecta");
                        } catch (DateTimeException e) {
                            correcto = false;
                            System.out.println("Fecha incorrecta");
                        }
                        // si todo lo anterio resta correcto se sale del bucle
                    } while (!correcto);

                    // ahora introducimos los datos en un vehiculo y posteriormente al array
                    v = new Vehiculo(marca, matricula, descripcion, propietario, dni, kilometros, precio, matri_fecha);
                    //con el objeto vehiculo compelto, pasamos a añadir lo al array
                    System.out.println("");
                    switch (concesionario.insertarVehiculo(v)) {
                        case -2:
                            System.out.println("El vehiculo existe");
                            break;
                        case 0:
                            System.out.println("Vehiculo insertado correctamente");
                            break;
                    }
                    System.out.println("");
                    break;
                case 2:
                    // con el metodo de concesionario listarVehiculos se imprime por pantalla la información de estos
                    System.out.println("Listar Vehiculos");
                    concesionario.listarVehiculos();

                    break;
                case 3:
                    // buscar un vehiculo
                    //se pide la matricula y este se pasara al metodo buscaVehiculo
                    System.out.println("Buscar Vehiculo");
                    System.out.println("Inserta matricula a buscar");
                    busca_matricula = teclado.next();

                    // con buscaVehiculo buscamos el vehiculo y el string que devuelve lo metemos a la nueva variable
                    Vehiculo veh = concesionario.buscaVehiculo(busca_matricula);
                    String vehString = veh.toString();

                    // ahora, si el string es null, porque no habia ningun coche y devolvio null
                    //significa qu eno hay coche, si devuelve otra cosa, la imprimimos ya que es la info
                    if (veh == null) {
                        System.out.println("No existe Vehiculo con la matricula introducia");
                    } else {
                        System.out.println(vehString);
                    }

                    break;
                case 4:
                    // Se modifican los kilometros, se piden matricula y kilometros y se añaden a una variable
                    // estos se pasaran por el metodo actualizaKms con sus variables para que los actualize, si existe el vehiculo
                    System.out.println("Modificar kilometros");

                    System.out.println("Inserta la matricula del coche");
                    busca_matricula = teclado.nextLine();
                    System.out.println("Inserta el nuevo numero de kilometros");
                    nuevosKilometros = teclado.nextInt();
                    // actualizaKms pide matricula y kilometros nuevos, si existe la matricula los actualiza
                    // en caso contrario devuelve un false y el if-else lanza mensaje.
                    if (concesionario.actualizaKms(busca_matricula, nuevosKilometros)) {
                        System.out.println("Se han actualizado los kilometros correctamente");
                    } else {
                        System.out.println("No existe vehículo con la matrícula introducida");
                    }

                    break;
                case 5:
                    // borrar vehiculo
                    System.out.println("Eliminar vehiculo");
                    System.out.println("Inserta la matricula del coche");
                    busca_matricula = teclado.nextLine();
                    if (concesionario.eliminarVehiculo(busca_matricula)) {
                        System.out.println("Borrado correctamente");
                    }else{
                        System.out.println("No se pudo borrar");
                    }

                    break;
                case 6:
                    // se despide
                    System.out.println("Fin del programa. Adios!");
                    break;
                default:
                    // opcion default
                    System.out.println("Opcion incorrecta.");
            }
            // mientras la opcion devuelta no sea 5, el programa lanza el menu
        } while (opcion != 6);
    }
}
