package lk.ijse.LibrarySystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Member {
    private String id;
    private String name;
    private String Address;
    private String Contact;
    private String Email;
    private String Gender;
}
