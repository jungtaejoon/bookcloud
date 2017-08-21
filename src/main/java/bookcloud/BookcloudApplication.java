package bookcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class BookcloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookcloudApplication.class, args);
	}
}
