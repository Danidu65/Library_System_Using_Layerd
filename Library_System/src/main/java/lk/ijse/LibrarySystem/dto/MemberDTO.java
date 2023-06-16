package lk.ijse.LibrarySystem.dto;

import lk.ijse.LibrarySystem.entity.Member;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class MemberDTO extends Member {
    private String id;
    private String name;
    private String Address;
    private String Contact;
    private String Email;
    private String Gender;
}
