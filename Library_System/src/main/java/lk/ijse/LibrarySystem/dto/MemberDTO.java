package lk.ijse.LibrarySystem.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class MemberDTO {
    private String id;
    private String name;
    private String Address;
    private String Contact;
    private String Email;
    private String Gender;
}
