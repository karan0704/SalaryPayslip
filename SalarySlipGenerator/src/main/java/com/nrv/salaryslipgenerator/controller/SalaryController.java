package com.nrv.salaryslipgenerator.controller;

import com.nrv.salaryslipgenerator.model.Employee;
import com.nrv.salaryslipgenerator.model.SalarySlip;
import com.nrv.salaryslipgenerator.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping("/import")
    public ResponseEntity<List<Employee>> importEmployeeData(@RequestParam("filePath") String filePath) {
        try {
            List<Employee> employees = salaryService.importEmployeeData(filePath);
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/generate")
    public ResponseEntity<SalarySlip> generateSalarySlip(@RequestParam("employeeName") String employeeName,
                                                         @RequestParam("month") String month) {
        SalarySlip slip = salaryService.generateSalarySlip(employeeName, month);
        return ResponseEntity.ok(slip);
    }
}
