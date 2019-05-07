package com.collabera.jump.configuration;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean // used to load third party library, here, Docket...you can't go and mark docket class as @Component
	public Docket todoApi() { //Docket to document,owned by Springfox
		
		 
		Predicate<RequestHandler> selector = RequestHandlerSelectors.basePackage("com.collabera.com");
		
		Predicate<String> pathselector = PathSelectors.ant("/employee/**");
		
	//	Docket docket = new Docket(DocumentationType.SWAGGER_2).select().build();//swagger2 documentation
	//	Docket docket = new Docket(DocumentationType.SWAGGER_2).select().apis(selector).paths(pathselector).build();//swagger2 documentation, to specify specific path
	
		Docket dock =  new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).select().apis(RequestHandlerSelectors.basePackage("com.collabera.jump")).build();
		Collection<VendorExtension> extensions = new ArrayList<>();
		
		Contact contact = new Contact("Contact Name"," url", "email");
		 
		ApiInfo apiInfo = new ApiInfo("Employee API","Employee Description","0.0.1", "http://google.com", contact, "license", "licenseUrl", extensions);
		
		dock.apiInfo(apiInfo);
		
		return dock;
	}
}
