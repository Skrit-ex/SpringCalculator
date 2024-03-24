package by.pack.entity;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter
@Setter
public class SessionOperation {


    @Pattern(regexp = "^\\d+\\.?\\d*", message = "The Num1 isn't number, try again")
    private String num1;

    @Pattern(regexp = "^\\d+\\.?\\d*", message = "The Num2 isn't number, try again")
    private String num2;

    private String type;
    private long userId;

    private String result;

    private LocalDateTime time;
}
