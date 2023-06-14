package lk.ijse.LibrarySystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Publisher {
    private String Id;
    private String Name;
    private String Year;
    private String publishedBook;
}
