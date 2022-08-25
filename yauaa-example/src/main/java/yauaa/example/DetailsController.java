package yauaa.example;

import io.micronaut.core.version.annotation.Version;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.inject.Inject;
import yauaa.example.useragent.UserAgentService;

import java.util.Map;

@Validated
@Controller("/yauaa/example")
public class DetailsController {

	@Inject
	UserAgentService userAgentService;

	@Version("1")
	@Get("/parse")
	@ExecuteOn(TaskExecutors.IO)
	@Operation(summary = "Parse User-Agent")
	public HttpResponse<Response> v1Ping(
		HttpHeaders headers
	) {
		String userAgentString = headers.get(HttpHeaders.USER_AGENT);
		Map<String, String> result = userAgentService.parseUserAgent(userAgentString);
		Response response = new Response(result);
		return HttpResponse.ok().body(response);
	}

}