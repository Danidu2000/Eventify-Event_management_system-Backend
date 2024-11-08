package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Payment {
    private Integer id;
    private String method;
    private double amount;
    private LocalDate date;
    private Integer userId;
}
