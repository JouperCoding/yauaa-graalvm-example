package yauaa.example.useragent;

import io.micronaut.context.annotation.Context;
import jakarta.inject.Singleton;
import nl.basjes.parse.useragent.UserAgentAnalyzer;

import java.util.Map;

@Context
@Singleton
public class UserAgentService {

	private static final UserAgentAnalyzer userAgentAnalyzer = UserAgentAnalyzer
		.newBuilder()
		.hideMatcherLoadStats()
		.withoutCache()
		.withAllFields()
		.build();

	public UserAgentService(){

	}

	public Map<String, String> parseUserAgent(String userAgentString){
		Map<String, String>  userAgentDetails = userAgentAnalyzer.parse(userAgentString).toMap();

		userAgentDetails.replaceAll((key, value) -> {
			value = value.replace("?", "").replace("Unknown", "").trim();
			return value.isEmpty() ? "-" : value;
		});

		return userAgentDetails;
	}
}
