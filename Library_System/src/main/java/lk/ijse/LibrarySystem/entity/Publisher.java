package lk.ijse.LibrarySystem.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Publisher {
    private String Id;
    private String Name;
    private String Year;
    private String publishedBook;
}
