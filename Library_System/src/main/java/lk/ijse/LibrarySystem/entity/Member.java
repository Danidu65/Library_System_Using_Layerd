package lk.ijse.LibrarySystem.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Member {
    private String id;
    private String name;
    private String Address;
    private String Contact;
    private String Email;
    private String Gender;
}
