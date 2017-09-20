package EnListame.enlistame_back.mapper;

import java.util.Map;

import javax.annotation.PostConstruct;
import ma.glasnost.orika.Converter;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory.Builder;
import ma.glasnost.orika.unenhance.HibernateUnenhanceStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import EnListame.enlistame_back.mapper.classmap.CustomClassMapBuilder;



@Component("appMapper")
public class AppMapper extends ConfigurableMapper {

	@Autowired
	private ApplicationContext applicationContext;

	public AppMapper() {
		super(false);
	}

	@PostConstruct
	private void setUp() {
		super.init();
	}

	@Override
	protected void configureFactoryBuilder(Builder factoryBuilder) {
		super.configureFactoryBuilder(factoryBuilder);

		factoryBuilder.unenhanceStrategy(new HibernateUnenhanceStrategy());
	}

	@Override
	protected void configure(MapperFactory factory) {
		super.configure(factory);

		addSpringMappers(factory);
		addSpringConverters(factory);

		addSpringClassMapBuilders(factory);
	}

	@SuppressWarnings("rawtypes")
	private void addSpringMappers(MapperFactory factory) {
		Map<String, Mapper> mappers = applicationContext.getBeansOfType(Mapper.class);
		for (Mapper<?, ?> mapper : mappers.values()) {
			factory.registerMapper(mapper);
		}
	}

	@SuppressWarnings("rawtypes")
	private void addSpringConverters(MapperFactory factory) {
		Map<String, Converter> converters = applicationContext.getBeansOfType(Converter.class);
		for (Converter<?, ?> converter : converters.values()) {
			factory.getConverterFactory().registerConverter(converter);
		}
	}

	@SuppressWarnings("rawtypes")
	private void addSpringClassMapBuilders(MapperFactory factory) {
		Map<String, CustomClassMapBuilder> classMapBuilders = applicationContext
				.getBeansOfType(CustomClassMapBuilder.class);
		for (CustomClassMapBuilder<?, ?> classMapBuilder : classMapBuilders.values()) {
			classMapBuilder.configure(factory);
		}
	}

}
