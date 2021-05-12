package mx.appliedsolutions.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class RegUsrMongoApplication {

	@Autowired
	private EntityUserRepository repository;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RegUsrMongoApplication.class, args);
		EntityUserRepository rep= context.getBean(EntityUserRepository.class);
		System.out.println(rep);
	}
	
	
	
}
