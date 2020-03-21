package raj.com.securityapps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import raj.com.securityapps.service.MyUserDetailsService;

@SpringBootApplication
public class SecurityappsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityappsApplication.class, args);
	}

}
