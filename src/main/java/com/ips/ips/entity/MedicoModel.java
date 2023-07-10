package com.ips.ips.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "Medico")
public class MedicoModel {

    @Id
    @Column(unique = true)
    private int tarjeta_profesional;
    private String nombre;
    private String apellido;
    private String correo;
    private String consultorio;
    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    private EspecialidadModel especialidad;
    @JsonIgnore
    @OneToMany(mappedBy = "medico")
    private List<CitaModel> citas;


    public MedicoModel() {

    }

     public MedicoModel(int tarjeta_profesional, String nombre, String apellido, String correo, String consultorio,
            EspecialidadModel especialidad,List<CitaModel> citas) {
        this.tarjeta_profesional = tarjeta_profesional;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.consultorio = consultorio;
        this.especialidad = especialidad;
        this.citas = citas;      
    
    }

    public int getTarjeta_profesional() {
        return tarjeta_profesional;
    }

    public void setTarjeta_profesional(int tarjeta_profesional) {
        this.tarjeta_profesional = tarjeta_profesional;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public EspecialidadModel getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadModel especialidad) {
        this.especialidad = especialidad;
    } 

    public List<CitaModel> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaModel> citas) {
        this.citas = citas;
    }

}
