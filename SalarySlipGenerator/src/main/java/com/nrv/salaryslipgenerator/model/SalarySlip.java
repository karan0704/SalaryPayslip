package com.nrv.salaryslipgenerator.model;

import lombok.Data;

@Data
public class SalarySlip {
    private String employeeName;
    private String month;
    private Double salary;
    private String pdfPath;
}
