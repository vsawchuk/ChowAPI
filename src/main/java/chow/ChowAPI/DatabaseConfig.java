package chow.ChowAPI;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        if (System.getenv("SPRING_DATASOURCE_URL") != null) {
            dataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));
            dataSource.setUsername(System.getenv("SPRING_DATASOURCE_USERNAME"));
            dataSource.setPassword(System.getenv("SPRING_DATASOURCE_PASSWORD"));
        } else {
            Dotenv dotenv = Dotenv.configure().directory("../").load();
            dataSource.setUrl(dotenv.get("AWS_DB_URL"));
            dataSource.setUsername(dotenv.get("AWS_DB_USERNAME"));
            dataSource.setPassword(dotenv.get("AWS_DB_PASSWORD"));
        }
        return dataSource;
    }
}
