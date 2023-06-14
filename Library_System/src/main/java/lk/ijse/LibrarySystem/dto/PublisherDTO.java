package lk.ijse.LibrarySystem.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class PublisherDTO {
    private String Id;
    private String Name;
    private String Year;
    private String publishedBook;
}
