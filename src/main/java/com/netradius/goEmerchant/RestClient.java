package com.netradius.goEmerchant;

import com.netradius.goEmerchant.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;

/**
 * @author Dilip S Sisodia
 */
@Slf4j
public class RestClient {


	private ObjectMapper objectMapper;
	private HttpPost post;

	public RestClient() {
		objectMapper = new ObjectMapper();
	}

	public ApiResponse httpGet(String transactionData, String apiUrl) {
		try (CloseableHttpClient client = HttpClientBuilder.create().build()){
			HttpGet get = new HttpGet(apiUrl);
			StringEntity data = new StringEntity(transactionData, "UTF-8");
			get.setHeader("Content-type", "application/json; charset-utf-8");
			HttpResponse response = client.execute(get);
			ApiResponse result = objectMapper.readValue (response.getEntity().getContent(), ApiResponse.class);
			log.debug(result.toString());
			return result;
		} catch (IOException ex) {
			log.error("Error processing post request: " + ex.getMessage());
		}
		return null;
	}

	public ApiResponse httpPost(String transactionData, String apiUrl) {
		try(CloseableHttpClient client = HttpClientBuilder.create().build()) {
			HttpPost post = new HttpPost(apiUrl);
			StringEntity data = new StringEntity(transactionData, "UTF-8");
			post.setEntity(data);
			post.setHeader("Content-type", "application/json; charset-utf-8");
			HttpResponse response = client.execute(post);
			ApiResponse result = objectMapper.readValue (response.getEntity().getContent(), ApiResponse.class);
			log.debug(result.toString());
			return result;
		} catch (IOException ex) {
			log.error("Error processing post request: " + ex.getMessage());
		}
		return  null;
	}
}
