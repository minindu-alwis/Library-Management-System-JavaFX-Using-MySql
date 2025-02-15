package edu.icet.librarymanagmentsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class MemberEntity {
    private String id;
    private String name;
    private String contact;
    private LocalDate date;
}
