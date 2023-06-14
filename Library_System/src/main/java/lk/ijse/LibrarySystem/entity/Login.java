package lk.ijse.LibrarySystem.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Login {
    private String username;
    private String password;
}
