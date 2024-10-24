package edu.icet.service;

import edu.icet.dto.Appointment;
import java.util.List;

public interface AppointmentService {
    void addAppointment(Appointment appointment);

    Boolean deleteById(Integer id);

    List<Appointment> getAll();

    Appointment getAppointmentById(Integer id);

    List<Appointment> searchByAdminId(Integer id);

    List<Appointment> searchByPatientId(Integer id);

    List<Appointment> searchByType(String type);
}
