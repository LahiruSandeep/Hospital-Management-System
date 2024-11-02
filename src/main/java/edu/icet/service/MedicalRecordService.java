package edu.icet.service;

import edu.icet.dto.MedicalReport;

import java.util.List;

public interface MedicalRecordService {

    MedicalReport getMedicalReportById(Integer id);

    void addMedicalReport(MedicalReport medicalReport);

    List<MedicalReport> getMedicalReports();

    Boolean deleteById(Integer id);

    List<MedicalReport> searchByPatientId(Integer patientId);

    List<MedicalReport> searchByAdminId(Integer adminId);

    List<MedicalReport> searchByLabNumber(Integer labNumber);

    List<MedicalReport> searchByCategory(String category);
}
