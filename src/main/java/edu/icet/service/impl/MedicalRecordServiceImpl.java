package edu.icet.service.impl;

import edu.icet.dto.MedicalReport;
import edu.icet.entity.MedicalReportEntity;
import edu.icet.repository.MedicalRecordRepository;
import edu.icet.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    final MedicalRecordRepository repository;
    final ModelMapper mapper;

    @Override
    public MedicalReport getMedicalReportById(Integer id) {
        return mapper.map(repository.findById(id), MedicalReport.class);
    }

    @Override
    public void addMedicalReport(MedicalReport medicalReport) {
        repository.save(mapper.map(medicalReport, MedicalReportEntity.class));
    }

    @Override
    public List<MedicalReport> getMedicalReports() {
        List<MedicalReport> medicalReports = new ArrayList<>();
        repository.findAll().forEach(medicalReport -> medicalReports.add(mapper.map(medicalReport, MedicalReport.class)));
        return medicalReports;
    }

    @Override
    public Boolean deleteById(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<MedicalReport> searchByPatientId(Integer patientId) {
        List<MedicalReport> medicalReports = new ArrayList<>();
        repository.findByPatientId(patientId).forEach(entity -> {
            medicalReports.add(mapper.map(entity, MedicalReport.class));
        });
        return medicalReports;
    }

    @Override
    public List<MedicalReport> searchByAdminId(Integer adminId) {
        List<MedicalReport> medicalReports = new ArrayList<>();
        repository.findByAdminId(adminId).forEach(entity -> {
            medicalReports.add(mapper.map(entity, MedicalReport.class));
        });
        return medicalReports;
    }

    @Override
    public List<MedicalReport> searchByLabNumber(Integer labNumber) {
        List<MedicalReport> medicalReports = new ArrayList<>();
        repository.findByLabNumber(labNumber).forEach(entity -> {
            medicalReports.add(mapper.map(entity, MedicalReport.class));
        });
        return medicalReports;
    }

    @Override
    public List<MedicalReport> searchByCategory(String category) {
        List<MedicalReport> medicalReports = new ArrayList<>();
        repository.findByCategory(category).forEach(entity -> {
            medicalReports.add(mapper.map(entity, MedicalReport.class));
        });
        return medicalReports;
    }
}
