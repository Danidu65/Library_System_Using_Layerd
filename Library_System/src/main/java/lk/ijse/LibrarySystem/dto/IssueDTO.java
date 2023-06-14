package lk.ijse.LibrarySystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class IssueDTO {
    private String issusId;
    private String issusDate;
    private String memberId;
    private String bookId;
    private String dueDate;
    private String issuseQty;
}
