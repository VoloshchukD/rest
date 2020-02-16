package by.tms.rest6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/hist")
public class HistController {

    @Autowired
    @Qualifier("hist")
    List<String> history;

    @PostMapping(path = "/show")
    public ResponseEntity<String> show(){
        return new ResponseEntity(history, HttpStatus.OK);
    }

}
