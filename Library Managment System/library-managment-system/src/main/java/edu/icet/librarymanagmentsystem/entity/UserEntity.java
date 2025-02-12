package edu.icet.librarymanagmentsystem.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="users")
public class UserEntity {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;

}
