package lk.ijse.LibrarySystem.dto;

import lk.ijse.LibrarySystem.entity.Suplier;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class SuplierDTO extends Suplier {
    private String Id;
    private String Name;
    private String Contact;
    private String Address;
    private String SuplierBooks;
}
