package lk.ijse.LibrarySystem.dto;

import lk.ijse.LibrarySystem.entity.Publisher;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class PublisherDTO extends Publisher {
    private String Id;
    private String Name;
    private String Year;
    private String publishedBook;
}
