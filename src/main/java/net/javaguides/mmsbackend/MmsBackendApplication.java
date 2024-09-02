package net.javaguides.mmsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class MmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmsBackendApplication.class, args);
	}

}
