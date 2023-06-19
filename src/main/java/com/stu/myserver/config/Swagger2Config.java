package com.stu.myserver.config;


import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/******************************
 * 用途说明:
 * 作者姓名: 公众号:程序员小明1024
 * 创建时间: 2023-02-09 22:02
 ******************************/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 分组名
                .groupName("WebApi")
                .apiInfo(apiInfo())
                .select()
//                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("test")
                .description("描述服务端的 api 接口定义")
                .version("1.0")
                .contact(new Contact("test", "http://www.baidu.com", "xxxx.@xxx.com"))
                .build();
    }

}
