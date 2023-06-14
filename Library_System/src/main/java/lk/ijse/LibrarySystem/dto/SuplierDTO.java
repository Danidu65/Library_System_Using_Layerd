package lk.ijse.LibrarySystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SuplierDTO {
    private String Id;
    private String Name;
    private String Contact;
    private String Address;
    private String SuplierBooks;
}
