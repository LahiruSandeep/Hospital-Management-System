package edu.icet.controller;

import edu.icet.dto.MedicalReport;
import edu.icet.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/medical-report")
public class MedicalReportController {

    final MedicalRecordService service;

    @PostMapping("/add-report")
    public void addMedicalReport(@RequestBody MedicalReport medicalReport){
        service.addMedicalReport(medicalReport);
    }

    @GetMapping("/get-all-reports")
    public List<MedicalReport> getMedicalReports() {
        return service.getMedicalReports();
    }

    @DeleteMapping("delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean deleteById(@PathVariable Integer id){
        service.deleteById(id);
        return true;
    }

    @GetMapping("/search-by-id/{id}")
    public MedicalReport searchById(@PathVariable Integer id){
        return service.getMedicalReportById(id);
    }

    @GetMapping("/search-by-patient-id/{patientId}")
    public List<MedicalReport> searchByPatientId(@PathVariable Integer patientId){
        return service.searchByPatientId(patientId);
    }

    @GetMapping("/search-by-admin-id/{adminId}")
    public List<MedicalReport> searchByAdminId(@PathVariable Integer adminId){
        return service.searchByAdminId(adminId);
    }

    @GetMapping("/search-by-labNumber/{labNumber}")
    public List<MedicalReport> searchByLabNumber(@PathVariable Integer labNumber){
        return service.searchByLabNumber(labNumber);
    }

    @GetMapping("/search-by-category/{category}")
    public List<MedicalReport> serachByCategory(@PathVariable String category){
        return service.searchByCategory(category);
    }

}
