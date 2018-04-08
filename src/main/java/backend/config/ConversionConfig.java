package backend.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import backend.converters.ContactEntityToContactResponseConverter;
import backend.converters.ContactRequestToContactEntityConverter;
import backend.converters.UserEntityToUserResponseConverter;
import backend.converters.UserRequestToUserEntityConverter;

@Configuration
public class ConversionConfig {

	private Set<Converter> getConverters() {
		Set<Converter> converters = new HashSet<Converter>();
		converters.add(new ContactRequestToContactEntityConverter());  
		converters.add(new ContactEntityToContactResponseConverter());
		converters.add(new UserEntityToUserResponseConverter()) ; 
		converters.add(new UserRequestToUserEntityConverter()); 

		return converters;
	}

	@Bean
	public ConversionService conversionService() {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
		bean.setConverters(getConverters());
		bean.afterPropertiesSet();

		return bean.getObject();
	}
}