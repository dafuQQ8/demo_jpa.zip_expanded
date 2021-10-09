package ua.testing.demo_jpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    @Id
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private RoleType role;

}
