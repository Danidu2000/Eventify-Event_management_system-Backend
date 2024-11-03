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

public class Notification {
    private Integer id;
    private String title;
    private String massage;
    private LocalDate date;
    private Integer event_id;
    private Integer user_id;
}
