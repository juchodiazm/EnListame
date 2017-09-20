package EnListame.enlistame_back.mapper.classmap;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeFactory;



/**
 * CustomClassMapBuilder provides a utility base for creating customized ClassMapBuilder, which determines type
 * parameters automatically. <br>
 * <br>
 * 
 * It is recommend to extend this class to create your own custom ClassMapBuilder.
 */
public abstract class CustomClassMapBuilder<A, B> {

	private Type<A> aType;
	private Type<B> bType;

	public CustomClassMapBuilder() {
		java.lang.reflect.Type[] actualTypeArguments = ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments();
		aType = TypeFactory.valueOf(actualTypeArguments[0]);
		bType = TypeFactory.valueOf(actualTypeArguments[1]);
	}

	public void configure(MapperFactory factory) {
		ClassMapBuilder<A, B> cmb = factory.classMap(aType, bType);

		// Configure Field mapping
		for (Map.Entry<String, String> entry : getFieldMappings().entrySet()) {
			cmb.field(entry.getKey(), entry.getValue());
		}

		cmb.byDefault().register();
	}

	protected abstract Map<String, String> getFieldMappings();

}
