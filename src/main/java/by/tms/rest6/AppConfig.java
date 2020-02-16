package by.tms.rest6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean("tok")
    public List<Integer> tokens(){
        return new ArrayList<>();
    }

    @Bean("hist")
    public List<String> history(){
        return new ArrayList<>();
    }

}
