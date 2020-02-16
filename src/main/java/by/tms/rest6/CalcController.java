package by.tms.rest6;

import org.apache.tomcat.util.json.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/calc")
public class CalcController {

    @Autowired
    @Qualifier("tok")
    List<Integer> tokens;

    @Autowired
    @Qualifier("hist")
    List<String> history;

    public static RequestDTO getRD(RequestDTO requestDTO){
        return requestDTO;
    }

    @PostMapping(path = "/run")
    public ResponseEntity<Calculation> calc(@RequestBody Calculation calculation, @RequestParam Integer token){
        RequestDTO requestDTO = new RequestDTO(token);
        if (!tokens.contains(requestDTO.getToken())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        int num1 = calculation.getNum1();
        String op = calculation.getOp();
        int num2 = calculation.getNum2();
        int rest = 0;
        if (op.equals("-")) {
            rest = (num1 - num2);
        } else if (op.equals("+")) {
            rest = (num1 + num2);
        } else if (op.equals("*")) {
            rest = (num1 * num2);
        } else if (op.equals("/")) {
            rest = (num1 / num2);
        }
        String hs =( num1 + " " + op + " " + num2 + " = " + rest );
        history.add(hs);
        return new ResponseEntity(rest, HttpStatus.OK);
    }
}
