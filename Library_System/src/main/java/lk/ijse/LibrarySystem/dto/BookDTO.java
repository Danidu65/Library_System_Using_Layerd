package lk.ijse.LibrarySystem.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class BookDTO {
    private String id;
    private String name;
    private String Author;
    private int Qty;
    private String Discription;
}
