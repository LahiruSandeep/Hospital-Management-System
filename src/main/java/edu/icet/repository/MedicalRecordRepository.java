package edu.icet.repository;

import edu.icet.entity.MedicalReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalReportEntity, Integer> {
    List<MedicalReportEntity> findByPatientId(Integer patientId);
    List<MedicalReportEntity> findByAdminId(Integer adminId);
    List<MedicalReportEntity> findByLabNumber(Integer labNumber);
    List<MedicalReportEntity> findByCategory(String category);
}
