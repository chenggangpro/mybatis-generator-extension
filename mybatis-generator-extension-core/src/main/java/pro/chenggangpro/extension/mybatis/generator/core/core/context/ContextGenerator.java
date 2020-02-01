package pro.chenggangpro.extension.mybatis.generator.core.core.context;

import org.mybatis.generator.config.Context;
import pro.chenggangpro.extension.mybatis.generator.core.option.GeneratorType;
import pro.chenggangpro.extension.mybatis.generator.core.properties.GeneratorExtensionProperties;

/**
 * @author: chenggang
 * @date 2020-01-21.
 */
public interface ContextGenerator {

    /**
     * generator type
     * @return
     */
    GeneratorType targetGeneratorType();

    /**
     * generateContext
     * @param extensionProperties
     * @return
     */
    Context generateContext(GeneratorExtensionProperties extensionProperties);
}
