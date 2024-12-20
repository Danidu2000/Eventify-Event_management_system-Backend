package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Event {
    private Integer id;
    private String title;
    private String description;
    private String location;
    private LocalDate date;
    private LocalTime time;
    private Integer organizerId;
    private String imagePath;
}
