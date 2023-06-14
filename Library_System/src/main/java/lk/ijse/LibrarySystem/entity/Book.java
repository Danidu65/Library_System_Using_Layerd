package lk.ijse.LibrarySystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    private String id;
    private String name;
    private String Author;
    private int Qty;
    private String Discription;
}
