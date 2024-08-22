package com.nrv.salaryslipgenerator.service;

import com.nrv.salaryslipgenerator.model.Employee;
import com.nrv.salaryslipgenerator.model.SalarySlip;
import com.nrv.salaryslipgenerator.repository.EmployeeRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalarySlipService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> importEmployeeData(String filePath) throws Exception {
        FileInputStream file = new FileInputStream(new File(filePath));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        List<Employee> employees = new ArrayList<>();

        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // Skip header row

            Employee employee = new Employee();
            employee.setName(row.getCell(0).getStringCellValue());
            employee.setDesignation(row.getCell(1).getStringCellValue());
            employee.setDepartment(row.getCell(2).getStringCellValue());
            employee.setSalary(row.getCell(3).getNumericCellValue());

            employees.add(employee);
        }

        workbook.close();
        employeeRepository.saveAll(employees);
        return employees;
    }

    public SalarySlip generateSalarySlip(String employeeName, String month) {
        Employee employee = employeeRepository.findByName(employeeName);
        if (employee == null) throw new RuntimeException("Employee not found");

        SalarySlip slip = new SalarySlip();
        slip.setEmployeeName(employee.getName());
        slip.setMonth(month);
        slip.setSalary(employee.getSalary());

        // Implement PDF generation logic (using iText or another library)
        // Set the PDF path in the slip object.

        return slip;
    }
}
