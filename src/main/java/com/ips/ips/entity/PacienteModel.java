package com.ips.ips.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "Paciente")
public class PacienteModel {
    @Id
    @Column(unique = true)
    private int cedula;
    private String nombre;
    private String apellido;
    private LocalDate fechadenacimiento;
    private Long telefono;
    @JsonIgnore
    @OneToMany(mappedBy = "paciente")
    private List<CitaModel> citas;

    public PacienteModel(){
        
    }

    public PacienteModel(int cedula, String nombre, String apellido, LocalDate fechadenacimiento, Long telefono,
            List<CitaModel> citas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechadenacimiento = fechadenacimiento;
        this.telefono = telefono;
        this.citas = citas;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(LocalDate fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }


    public List<CitaModel> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaModel> citas) {
        this.citas = citas;
    }

}
