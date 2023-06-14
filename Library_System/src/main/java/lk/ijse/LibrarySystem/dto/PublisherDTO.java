package lk.ijse.LibrarySystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PublisherDTO {
    private String Id;
    private String Name;
    private String Year;
    private String publishedBook;
}
