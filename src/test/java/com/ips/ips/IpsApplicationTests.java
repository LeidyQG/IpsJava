package com.ips.ips;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ips.ips.entity.PacienteModel;
import com.ips.ips.repository.PacienteRepository;
import com.ips.ips.service.PacienteService;

import com.ips.ips.entity.MedicoModel;
import com.ips.ips.repository.MedicoRepository;
import com.ips.ips.service.MedicoService;

class IpsApplicationTests {

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteService pacienteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerPacientes() {
        // Crear una lista de pacientes de prueba
        List<PacienteModel> pacientes = new ArrayList<>();
        pacientes.add(new PacienteModel(1, "Juan", "Pérez", LocalDate.now(), 123456789L, null));
        pacientes.add(new PacienteModel(2, "María", "López", LocalDate.now(), 987654321L, null));

        // Simular el comportamiento del repositorio
        when(pacienteRepository.findAll()).thenReturn(pacientes);

        // Llamar al método del servicio que se va a probar
        ArrayList<PacienteModel> result = pacienteService.obtenerPacientes();

        // Verificar que el resultado sea el esperado
        assertEquals(pacientes, result);
    }

    @Test
    public void testGuardarPaciente() {
        // Crear un paciente de prueba
        PacienteModel paciente = new PacienteModel(1, "Juan", "Pérez", LocalDate.now(), 123456789L, null);

        // Simular el comportamiento del repositorio
        when(pacienteRepository.save(paciente)).thenReturn(paciente);

        // Llamar al método del servicio que se va a probar
        PacienteModel result = pacienteService.guardarPaciente(paciente);

        // Verificar que el resultado sea el esperado
        assertEquals(paciente, result);
    }

    @Test
    public void testObtenerPacientePorId() {
        // Crear un paciente de prueba
        PacienteModel paciente = new PacienteModel(1, "Juan", "Pérez", LocalDate.now(), 123456789L, null);

        // Simular el comportamiento del repositorio
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));

        // Llamar al método del servicio que se va a probar
        Optional<PacienteModel> result = pacienteService.obtenerPacientePorId(1L);

        // Verificar que el resultado sea el esperado
        assertEquals(Optional.of(paciente), result);
    }

    @Test
    public void testEliminarPaciente() {
        // Simular el comportamiento del repositorio
        doNothing().when(pacienteRepository).deleteById(1L);

        // Llamar al método del servicio que se va a probar
        boolean result = pacienteService.eliminarPaciente(1L);

        // Verificar que el resultado sea el esperado
        assertTrue(result);
    }

    @Mock
    private MedicoRepository medicoRepository;

    @InjectMocks
    private MedicoService medicoService;

    @Test
    public void testObtenerMedicos() {
        // Crear una lista de pacientes de prueba
        List<MedicoModel> medicos = new ArrayList<>();
        medicos.add(new MedicoModel(1234,"Pedro","Mar","Pe@Salud.com","304",null,null));
        medicos.add(new MedicoModel(2345, "María", "López","Lopez@ips.co","301",null, null));

        // Simular el comportamiento del repositorio
        when(medicoRepository.findAll()).thenReturn(medicos);

        // Llamar al método del servicio que se va a probar
        ArrayList<MedicoModel> result = medicoService.obtenerMedicos();

        // Verificar que el resultado sea el esperado
        assertEquals(medicos, result);
    }

    @Test
    public void testGuardarMedicos() {
        // Crear un paciente de prueba
        MedicoModel medico = new MedicoModel(19485, "Lina", "Valles", "Valles@ips.edu.co","401", null, null);

        // Simular el comportamiento del repositorio
        when(medicoRepository.save(medico)).thenReturn(medico);

        // Llamar al método del servicio que se va a probar
        MedicoModel result = medicoService.guardarMedico(medico);

        // Verificar que el resultado sea el esperado
        assertEquals(medico, result);
    }

    @Test
    public void testObtenerMedicoPorId() {
        // Crear un paciente de prueba
        MedicoModel medico = new MedicoModel(19485, "Lina", "Valles", "Valles@ips.edu.co","401", null, null);

        // Simular el comportamiento del repositorio
        when(medicoRepository.findById(1L)).thenReturn(Optional.of(medico));

        // Llamar al método del servicio que se va a probar
        Optional<MedicoModel> result = medicoService.obtenerMedicoPorId(1L);

        // Verificar que el resultado sea el esperado
        assertEquals(Optional.of(medico), result);
    }

    @Test
    public void testEliminarMedico() {
        // Simular el comportamiento del repositorio
        doNothing().when(medicoRepository).deleteById(1L);

        // Llamar al método del servicio que se va a probar
        boolean result = medicoService.eliminarMedico(1L);

        // Verificar que el resultado sea el esperado
        assertTrue(result);
    }
}
