package lk.ijse.LibrarySystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Return {
    private String ReturnId;
    private String IssuseId;
    private String RreturnQty;
    private String ReturnDate;
    private String BookId;
    private String IssuseDate;
}
