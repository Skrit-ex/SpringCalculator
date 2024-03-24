package by.pack.dto;


import by.pack.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class OperationDto {


    @Pattern(regexp = "^\\d+\\.?\\d*", message = "The Num1 isn't number, try again")
    private String num1;

    @Pattern(regexp = "^\\d+\\.?\\d*", message = "The Num2 isn't number, try again")
    private String num2;

    private String type;

    private long userId;

}
