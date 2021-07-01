package pro.chenggang.extension.mybatis.generator;

import org.junit.Assert;
import org.junit.Test;
import pro.chenggang.extension.mybatis.generator.core.MybatisDynamicCodeGenerator;
import pro.chenggang.extension.mybatis.generator.core.PropertiesHolder;
import pro.chenggang.extension.mybatis.generator.properties.GeneratorExtensionProperties;

/**
 * @author: chenggang
 * @date 2020-02-01.
 */
public class MybatisGeneratorExtensionTests {

    @Test
    public void testReadProperties(){
        GeneratorExtensionProperties properties = PropertiesHolder.getInstance().getProperties();
        Assert.assertNotNull(properties);
        properties.setBasePackage(this.getClass().getPackage().getName());
        properties.validateByDefault();
        System.out.println(properties);
    }

    @Test(expected = Test.None.class)
    public void testGenerateWithClass(){
        MybatisDynamicCodeGenerator.getInstance().generate(MybatisGeneratorExtensionTests.class);
    }

    @Test(expected = Test.None.class)
    public void testGenerateWithBasePackage(){
        MybatisDynamicCodeGenerator.getInstance().generate("pro.chenggang.extension.mybatis.generator");
    }


}
