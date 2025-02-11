package edu.icet.librarymanagmentsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString

public class User {

    private String id;
    private String username;
    private String email;
    private String password;

}
