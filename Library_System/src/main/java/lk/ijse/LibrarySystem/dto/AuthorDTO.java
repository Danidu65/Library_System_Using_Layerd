package lk.ijse.LibrarySystem.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class AuthorDTO {
    private String id;
    private String Name;
    private String BookName;

}
