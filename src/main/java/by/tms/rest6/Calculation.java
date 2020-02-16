package by.tms.rest6;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculation {
    private int num1;
    private String op;
    private int num2;
    @JsonIgnore
    private int rest;


}
