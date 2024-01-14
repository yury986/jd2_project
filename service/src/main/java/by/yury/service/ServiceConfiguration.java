package by.yury.service;

import by.yury.data.DataConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "by.yury.service")
@Import(DataConfiguration.class)
public class ServiceConfiguration {
}
