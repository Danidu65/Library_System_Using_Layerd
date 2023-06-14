package lk.ijse.LibrarySystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Suplier{
    private String Id;
    private String Name;
    private String Contact;
    private String Address;
    private String SuplierBooks;
}
