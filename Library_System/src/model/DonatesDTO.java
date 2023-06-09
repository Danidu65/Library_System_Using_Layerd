package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class DonatesDTO {
    private String donetionId;
    private String review;
    private double Ammount;
    private String donetionName;
    private String ExibitionId;
}
