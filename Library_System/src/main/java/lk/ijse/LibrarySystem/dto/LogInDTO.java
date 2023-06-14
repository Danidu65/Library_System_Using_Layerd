package lk.ijse.LibrarySystem.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class LogInDTO {
    private String username;
    private String password;

}
