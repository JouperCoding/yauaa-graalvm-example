package yauaa.example;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
	info = @Info(
		title = "Yauaa Example",
		version = "${api.version}",
		description = "${openapi.description}",
		license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html")
	)
)
public class Application {

	public static void main(String[] args){
		ApplicationContext applicationContext = Micronaut.build(args)
			.eagerInitSingletons(true)
			.eagerInitConfiguration(true)
			.deduceEnvironment(false)
			.banner(false)
			.mainClass(Application.class)
			.start();
	}

}
