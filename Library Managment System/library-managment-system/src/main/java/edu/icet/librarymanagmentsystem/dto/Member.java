package edu.icet.librarymanagmentsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class Member {
    private String id;
    private String name;
    private String contact;
    private LocalDate date;
}
