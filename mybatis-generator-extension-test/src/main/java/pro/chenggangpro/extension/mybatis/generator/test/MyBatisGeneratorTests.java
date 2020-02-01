package pro.chenggangpro.extension.mybatis.generator.test;

import pro.chenggangpro.extension.mybatis.generator.core.core.MybatisGeneratorExtension;

/**
 * @author: chenggang
 * @date 2020-02-01.
 */
public class MyBatisGeneratorTests {

    public static void main(String[] args) {
        MybatisGeneratorExtension.getInstance().generate(MyBatisGeneratorTests.class);

    }
}
