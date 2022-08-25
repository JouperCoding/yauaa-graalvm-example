package yauaa.example;

import io.micronaut.core.annotation.Introspected;

import java.util.Map;

@Introspected
public class Response {

	private final Map<String, String> result;

	public Response(Map<String, String> result){
		this.result = result;
	}

	public Map<String, String> getResult() {
		return result;
	}
}
