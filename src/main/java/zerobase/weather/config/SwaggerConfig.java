package zerobase.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	//localhost:8080/swagger-ui/index.html
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("zerobase.weather"))
			.paths(PathSelectors.any()) //any는 path에 상관없이 모든 api를 보여줌.
//			.paths(PathSelectors.ant("/read/**")) //특정 api만
			.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title("날씨 일기 프로젝트 :)")
			.description("날씨 일기를 CRUD 할 수 있는 벡엔드 API 입니다.")
			.version("2.0")
			.build();
	}
}
