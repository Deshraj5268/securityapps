package raj.com.securityapps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import raj.com.securityapps.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer>{

    Optional<UserEntity> findByUserName(String userName);
}
