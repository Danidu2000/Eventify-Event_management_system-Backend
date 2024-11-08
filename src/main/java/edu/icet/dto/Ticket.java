package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Ticket {
    private Integer id;
    private double price;
    private String status;
    private Integer organizerId;
    private Integer eventId;
}
