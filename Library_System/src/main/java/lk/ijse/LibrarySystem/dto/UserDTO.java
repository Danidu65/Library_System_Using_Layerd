package lk.ijse.LibrarySystem.dto;

import lk.ijse.LibrarySystem.entity.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class UserDTO extends User {
    private String Name;
    private String userName;
    private String passWord;

}
