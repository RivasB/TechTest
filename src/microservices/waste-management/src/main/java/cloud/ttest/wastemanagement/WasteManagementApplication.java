package cloud.ttest.wastemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class WasteManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(WasteManagementApplication.class, args);
	}

}
