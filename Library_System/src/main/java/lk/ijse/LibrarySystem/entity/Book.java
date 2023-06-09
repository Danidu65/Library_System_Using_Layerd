package lk.ijse.LibrarySystem.entity;

import lk.ijse.LibrarySystem.dto.BookDTO;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Book extends BookDTO {
    private String id;
    private String name;
    private String Author;
    private int Qty;
    private String Discription;

    public Book(String id, String name, String author, String discription, int qty) {
    }
}
