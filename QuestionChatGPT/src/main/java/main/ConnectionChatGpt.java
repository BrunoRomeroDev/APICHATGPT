package main;



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.ExecutionException;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class ConnectionChatGpt {
	
	
	static final String URL_POST = "https://api.openai.com/v1/completions";
	public static final String FILE_JSON = "C:\\Users\\Romero\\Desktop\\get.json";
	
	public static final String FILE_JSONini = "{\r\n"
			+ "    \"model\": \"text-davinci-003\", \r\n"
			+ "    \"prompt\": \"";
	public static final String FILE_JSONfim = "\", \r\n"
			+ "    \"temperature\": 0,\r\n"
			+ "    \"max_tokens\": 500\r\n"
			+ "}";
			
	
	public static  String QuestionChatGPT(String pergunta) throws IOException, InterruptedException, ExecutionException {
		
		
		String accessToken = "Bearer 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"; 
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Authorization", accessToken);
        headers.add("Content-Type", "application/json");
       
        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest request = HttpRequest.newBuilder()
        		.header("Authorization", accessToken)
        		.header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(FILE_JSONini+pergunta+FILE_JSONfim))
                .timeout(Duration.ofSeconds(30))
                .uri(URI.create(URL_POST))
                .build();
        
       
        String s = (String) client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .get();
        
 
        String[] result = s.split(":");

		return result[6];
		
		
	}

}
