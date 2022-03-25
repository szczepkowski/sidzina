package pl.goreit.sidzina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
@EnableAsync
@EnableSwagger2
//@EnableDiscoveryClient
public class Sidzina extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Sidzina.class, args);
	}

}
