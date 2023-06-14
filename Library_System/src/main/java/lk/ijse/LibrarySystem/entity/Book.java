package lk.ijse.LibrarySystem.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Book {
    private String id;
    private String name;
    private String Author;
    private int Qty;
    private String Discription;
}
