package tr.salkan.code.java.genericApi.product.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@RequiredArgsConstructor
@EntityScan(basePackages = "tr.salkan.code.java")
@ComponentScan("tr.salkan.code.java")
public class DBConfig {

//    @Bean
//    public DataSource dataSource() {
//
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setUrl("xxxxx");
//        dataSource.setUsername("yyyyy");
//        dataSource.setPassword("zzzzz");
//
//        Properties properties = new Properties();
//        properties.setProperty("spring.jpa.hibernate.ddl-auto", "create");
//        dataSource.setConnectionProperties(properties);
//        return dataSource;
//    }
}
