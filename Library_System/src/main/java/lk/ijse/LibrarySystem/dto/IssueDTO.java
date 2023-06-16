package lk.ijse.LibrarySystem.dto;

import lk.ijse.LibrarySystem.entity.Return;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class IssueDTO extends Return {
    private String issusId;
    private String issusDate;
    private String memberId;
    private String bookId;
    private String dueDate;
    private String issuseQty;
}
