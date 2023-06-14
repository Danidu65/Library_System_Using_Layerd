package lk.ijse.LibrarySystem.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Suplier{
    private String Id;
    private String Name;
    private String Contact;
    private String Address;
    private String SuplierBooks;
}
