package lk.ijse.LibrarySystem.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Author {
    private String id;
    private String Name;
    private String BookName;

    public Author(String authorId) {
    }

    public Author(String string, String string1, String string2, String string3) {
    }
}
