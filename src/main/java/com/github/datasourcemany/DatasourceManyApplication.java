package com.github.datasourcemany;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.github.datasourcemany.mapper")
public class DatasourceManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatasourceManyApplication.class, args);
	}

}
