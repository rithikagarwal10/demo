package ca.cmpt6.demo;

//import java.util.Map;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
// import org.springframework.jdbc.core.JdbcTemplate;

//import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
public class DemoApplication {

	// @Autowired
    // private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}
