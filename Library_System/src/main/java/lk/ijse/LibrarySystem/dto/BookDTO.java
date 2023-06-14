package lk.ijse.LibrarySystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookDTO {
    private String id;
    private String name;
    private String Author;
    private int Qty;
    private String Discription;
}
