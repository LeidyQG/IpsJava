package com.ips.ips.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "Cita")
public class CitaModel {

    @Id
    @Column(unique = true)
    private int id_cita;
    private LocalDate fecha;
    @ManyToOne
    @JoinColumn(name = "tarjeta_profesional")
    private MedicoModel medico;
    @ManyToOne
    @JoinColumn(name = "cedula")
    private PacienteModel paciente;

    //TO DO:Falta arreglar que aparexaca cc y tp en vez de paciente y médico
    public CitaModel(){

    }

    public CitaModel(int id_cita,LocalDate fecha,PacienteModel paciente, MedicoModel medico) {
        this.id_cita = id_cita;
        this.fecha = fecha;
        this.medico = medico;
        this.paciente = paciente;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public MedicoModel getMedico() {
        return medico;
    }

    public void setMedico(MedicoModel medico) {
        this.medico = medico;
    }

    public PacienteModel getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteModel paciente) {
        this.paciente = paciente;
    }

    
    
}
