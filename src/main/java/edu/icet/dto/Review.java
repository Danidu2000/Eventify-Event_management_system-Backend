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

public class Review {
    private Integer id;
    private String comment;
    private Integer rating;
    private LocalDate date;
    private Integer userId;
    private Integer eventId;
}
