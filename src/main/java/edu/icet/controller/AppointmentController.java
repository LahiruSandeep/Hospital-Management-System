package edu.icet.controller;

import edu.icet.dto.Appointment;
import edu.icet.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    final AppointmentService appointmentService;

    @PostMapping("/add-appointment")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAppointment(@RequestBody Appointment appointment){
        appointmentService.addAppointment(appointment);
    }

    @PutMapping("/update-appointment")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateAppointment(@RequestBody Appointment appointment){
        appointmentService.addAppointment(appointment);
    }

    @DeleteMapping("/delete-appointment/{id}")
    public Boolean deleteAppointment(@PathVariable Integer id){
        return appointmentService.deleteById(id);
    }

    @GetMapping("/view-all-appointment")
    public List<Appointment> findAll(){
        return appointmentService.getAll();
    }

    @GetMapping("/search-appointment-by-id/{id}")
    public Appointment searchById(@PathVariable Integer id){
        return appointmentService.getAppointmentById(id);
    }

    @GetMapping("/search-by-admin-id/{id}")
    public List<Appointment> searchByAdminId(@PathVariable Integer id){
        return appointmentService.searchByAdminId(id);
    }

    @GetMapping("/search-by-patient-id/{id}")
    public List<Appointment> searchByPatientId(@PathVariable Integer id){
        return appointmentService.searchByPatientId(id);
    }

    @GetMapping("/search-by-type/{type}")
    public List<Appointment> searchByType(@PathVariable String type){
        return appointmentService.searchByType(type);
    }

}
