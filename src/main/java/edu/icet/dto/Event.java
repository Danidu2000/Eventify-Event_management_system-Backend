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

public class Event {
    private Integer id;
    private String title;
    private String description;
    private String location;
    private LocalDate date;
    private Integer capacity;
    private Integer organizer_id;
}
