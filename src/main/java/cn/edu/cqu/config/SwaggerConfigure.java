package cn.edu.cqu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigure {
    /**
    swagger生成接口规范文档
    1.配置生成文档信息
    2.配置生成规则
    3.
     */
    @Bean
    public Docket getDocket(){
        ApiInfoBuilder apiInfoBuilder=new ApiInfoBuilder();
        apiInfoBuilder.title("《校园二手商城接口说明文档》").
                description("此文档说明项目项目规范").
                version("2.0.0").
                contact(new Contact("飞虎队","www.feihudui.com","feihudui@qq.com"));
        ApiInfo apiInfo=apiInfoBuilder.build();
                /**
                 * 如何获取接口对象
                 * 1.new接口，需要在构造器实现接口的所有方法
                 * 2.new接口的子类或者实现类
                 * 3.builder工厂模式，通过工厂
                 */
        //docket支持链式调用
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.edu.cqu.controller")) //对哪个包的类生成文档
                .paths(PathSelectors.any())
                .build();


        return docket;
    }

}
