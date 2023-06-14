package lk.ijse.LibrarySystem.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class SuplierDTO {
    private String Id;
    private String Name;
    private String Contact;
    private String Address;
    private String SuplierBooks;
}
