package raj.com.securityapps.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raj.com.securityapps.service.UserInfoService;
import raj.com.securityapps.to.UserInfoTo;

@RestController
@RequestMapping(name="/ums",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(path="/user/{userName}")
    public ResponseEntity<?> getUserInfo(String userName){
        LOGGER.error("user name : "+userName);
        return new ResponseEntity(userInfoService.getUserInfo(userName), HttpStatus.OK);
    }

    @PostMapping(path="/users")
    public ResponseEntity<?> saveUserInfo(@RequestBody UserInfoTo userInfoTo){
        LOGGER.error("userInfoTo  : "+userInfoTo);
        userInfoService.saveUserInfo(userInfoTo);
        return new ResponseEntity("user saved successfully", HttpStatus.OK);
    }

    @GetMapping(path = "/test",produces = MediaType.ALL_VALUE,consumes = MediaType.ALL_VALUE)
    public ResponseEntity<?> testUrl(){
        String result = "Hello world";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
