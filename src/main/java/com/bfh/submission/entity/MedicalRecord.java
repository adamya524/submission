package com.bfh.submission.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecord {
    private int id;
    private String patientName;
    private String diagnosis;
    private int billAmount;
    private int patientAge;
}