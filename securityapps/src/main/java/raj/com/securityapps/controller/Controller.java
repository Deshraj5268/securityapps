package raj.com.securityapps.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/"/*,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE*/)
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @GetMapping(path="/")
    public ResponseEntity<?> securityTest(){
        return new ResponseEntity("Successfully logged in",HttpStatus.OK);
    }

    @GetMapping(path="/user")
    public ResponseEntity<?> userSecurityTest(){
        return new ResponseEntity("user Successfully logged in",HttpStatus.OK);
    }

    @GetMapping(path="/admin")
    public ResponseEntity<?> adminSecurityTest(){
        return new ResponseEntity("admin Successfully logged in",HttpStatus.OK);
    }
}
