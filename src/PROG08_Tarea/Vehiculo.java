package PROG08_Tarea;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author IVAN 
 * clase Vehiculo, aqui estara la clase y el constructor de
 * vehiculo con sus setters and getters
 * tambien tiene toString con todos los variables del Vehiculo
 */

// se añade el implements Comparable y tipo Vehiculo
public class Vehiculo implements Comparable<Vehiculo> {

    String marca, matricula, descripcion, propietario, dni_propietario;
    int num_kms, precio;
    LocalDate fecha_matri;

    
    public Vehiculo(String marca, String matricula, String descripcion, String propietario, String dni_propietario, int num_kms, int precio, LocalDate fecha_matri) {
        this.marca = marca;
        this.matricula = matricula;
        this.descripcion = descripcion;
        this.propietario = propietario;
        this.dni_propietario = dni_propietario;
        this.num_kms = num_kms;
        this.precio = precio;
        this.fecha_matri = fecha_matri;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDni_propietario() {
        return dni_propietario;
    }

    public void setDni_propietario(String dni_propietario) {
        this.dni_propietario = dni_propietario;
    }

    public int getNum_kms() {
        return num_kms;
    }

    public void setNum_kms(int num_kms) {
        this.num_kms = num_kms;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public LocalDate getFecha_matri() {
        return fecha_matri;
    }

    public void setFecha_matri(LocalDate fecha_matri) {
        this.fecha_matri = fecha_matri;
    }

    public int get_Anios() {
        LocalDate hoy = LocalDate.now();
        return (Period.between(this.fecha_matri, hoy).getYears());
    }

    public void act_kms(int nuevos_kms) {
        this.num_kms = this.num_kms + nuevos_kms;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "Matricula: "+ matricula+ ", marca:"  + marca + ", descripcion: " + descripcion +  ", propietario: " + propietario + ", DNI propietario: " + dni_propietario + ", Kilometros: " + num_kms + ", precio: " + precio + ", fecha matriculacion: " + fecha_matri + '}';
    }

    
    // se implementa el compareTo
    @Override
    public int compareTo(Vehiculo v) {
        return this.matricula.compareTo(v.getMatricula());
        
    }

 
}
