package raj.com.securityapps.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raj.com.securityapps.entity.UserEntity;
import raj.com.securityapps.repository.UserRepository;
import raj.com.securityapps.to.UserInfoTo;

import java.util.HashMap;
import java.util.Optional;

@Service
public class UserInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoService.class);

    @Autowired
    private UserRepository userRepository;

    public void saveUserInfo(UserInfoTo userInfo){
        UserEntity user = forUser(userInfo);
        user =  userRepository.save(user);
        LOGGER.error("user id : "+user.getUserId());
    }

    public HashMap<String,Object> getUserInfo(String userName) {
        Optional<UserEntity> userOpt = userRepository.findByUserName(userName);
        HashMap<String,Object> resultMap = new HashMap<>();
        if(!userOpt.isPresent()){
            LOGGER.error("user is not exist");
            return resultMap;
        }

        UserEntity user = userOpt.get();
        resultMap.put("userName",user.getUserName());
        resultMap.put("active",user.getActive());
        resultMap.put("roles",user.getRoles());
        return resultMap;
    }

    private UserEntity forUser(UserInfoTo userInfo) {
        UserEntity users = new UserEntity();
        users.setUserName(userInfo.getUserName());
        users.setPassword(userInfo.getPassword());
        users.setActive(userInfo.isActive());
        users.setRoles(userInfo.getRoles());
        return users;
    }
}
