# mybatis-generator-extension
Based On MyBatis Generator And MyBatis Dynamic Sql

> The `MyBatis Dynamic Sql` is an extra tool provided by mybatis office ,See [MyBatis Dynamic Sql](https://github.com/mybatis/mybatis-dynamic-sql)

Features:

* [x] Change MySQL `tinyint` type generated to `Integer` type
* [x] Add `Lombok` extension to generated entity
* [x] Add  db-name and property-name constant to generated entity 
* [x] Add `updateSelective(record,dsl-> dsl.where(...)` to `dynamicMapper`(`mybatis-dynamic-sql`)
* [x] Add all `dynamicMapper` extend `CommonSelectMapper` (`mybatis-dynamic-sql`)
* [x] Add trim table's common prefix name 
* [x] Add `ResultMap` with table name in `mapper.xml` 

### Use Cases

* Include Required Dependencies

```xml
<dependency>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-core</artifactId>
</dependency>
<dependency>
    <groupId>org.mybatis.dynamic-sql</groupId>
    <artifactId>mybatis-dynamic-sql</artifactId>
</dependency>
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```

* Setup `mybatis-generator.yml` file

Copy `META-INF/mybatis-generator.yml` to your project's `test/resources` directory. 
And change your personalized database settings eg..


* Generate

*  In Your Project's `test/main` Directory,Write Your own package 
*  Write a `Class` with junit test or a simple main class,like below

```java
public class MybatisGeneratorExtensionTests {

    @Test(expected = Test.None.class)
    public void testGenerateWithClass(){
        MybatisDynamicCodeGenerator.getInstance().generate(MybatisGeneratorExtensionTests.class);
    }

}
```

> OR
 
 ```java
public class MybatisGeneratorExtensionTests {

    public static void main(String[] args) {
        MybatisDynamicCodeGenerator.getInstance().generate(MybatisGeneratorExtensionTests.class);
    }
}
 ```
 
* Then run the test method or the main method.
 

### Note

* All `mybatis-generator.yml` settings,see `pro.chenggang.extension.mybatis.generator.properties.GeneratorExtensionProperties` class.
* All details please see the source code.