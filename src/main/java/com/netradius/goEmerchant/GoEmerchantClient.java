package com.netradius.goEmerchant;

import com.netradius.goEmerchant.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.IOException;

/**
 * @author Dilip S Sisodia
 */
@Slf4j
public class GoEmerchantClient {

	private static final String GO_EMERCHANT_URL = "https://secure.1stpaygateway.net/secure/RestGW/Gateway/Transaction/";

	private ObjectMapper objectMapper;
	private RestClient client;
	private HttpResponse response;

	public GoEmerchantClient() {
		objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		client = new RestClient();
	}

	public ApiResponse authorize(Authorize authorize) {
		try {
			return client.httpPost(objectMapper.writeValueAsString(authorize), GO_EMERCHANT_URL + "Auth");
//			return getResponseData(response);
		}
		catch (Exception ex) {
			log.error("Error processing json data for request: " + ex.getMessage());
		}
		return null;
	}

	public ApiResponse batchClose(BatchClose batchClose) {
		try {
			return client.httpPost(objectMapper.writeValueAsString(batchClose), GO_EMERCHANT_URL + "CloseBatch");
//			return getResponseData(response);
		} catch (Exception ex) {
			log.error("Error processing json data for request: " + ex.getMessage());
		}
		return null;
	}

	public ApiResponse credit(Credit credit) {
		try {
			return client.httpPost(objectMapper.writeValueAsString(credit), GO_EMERCHANT_URL + "Credit");
//			return getResponseData(response);
		} catch (IOException ex) {
			log.error("Error processing json data for request: " + ex.getMessage());
		}
		return null;

	}

	public ApiResponse query(Query query) {
		try {
			return client.httpPost(objectMapper.writeValueAsString(query), GO_EMERCHANT_URL + "Query");
//			return getResponseData(response);
		} catch (IOException ex) {
			log.error("Error processing json data for request: " + ex.getMessage());
		}
		return null;

	}

	public ApiResponse reAuthorize(ReAuthorize reAuthorize) {
		try {
			return client.httpPost(objectMapper.writeValueAsString(reAuthorize), GO_EMERCHANT_URL + "ReAuth");
//			return getResponseData(response);
		} catch (IOException ex) {
			log.error("Error processing json data for request: " + ex.getMessage());
		}
		return null;

	}

	public ApiResponse recurringModify(RecurringModify recurringModify) {
		try {
			return client.httpPost(objectMapper.writeValueAsString(recurringModify), GO_EMERCHANT_URL + "RecurringModify");
//			return getResponseData(response);
		} catch (IOException ex) {
			log.error("Error processing json data for request: " + ex.getMessage());
		}
		return null;

	}

	public ApiResponse reSale(ReSale reSale) {
		try {
			return client.httpPost(objectMapper.writeValueAsString(reSale), GO_EMERCHANT_URL + "ReSale");
//			return getResponseData(response);
		} catch (IOException ex) {
			log.error("Error processing json data for request: " + ex.getMessage());
		}
		return null;
	}

	public ApiResponse sale(Sale sale) {
		try {
			return client.httpPost(objectMapper.writeValueAsString(sale), GO_EMERCHANT_URL + "Sale");
//			return getResponseData(response);
		} catch (IOException ex) {
			log.error("Error processing json data for request: " + ex.getMessage());
		}
		return null;
	}

	public ApiResponse settle(Settle settle) {
		try {
			return client.httpPost(objectMapper.writeValueAsString(settle), GO_EMERCHANT_URL + "Settle");
//			return getResponseData(response);
		} catch (IOException ex) {
			log.error("Error processing json data for request: " + ex.getMessage());
		}
		return null;
	}

	public ApiResponse performVoid(VoidTransaction voidTransaction) {
		try {
			return client.httpPost(objectMapper.writeValueAsString(voidTransaction), GO_EMERCHANT_URL + "Void");
//			return getResponseData(response);
		} catch (IOException ex) {
			log.error("Error processing json data for request: " + ex.getMessage());
		}
		return null;
	}
	
	private ApiResponse getResponseData(HttpResponse response) {
		try {
			ApiResponse result = objectMapper.readValue (response.getEntity().getContent(), ApiResponse.class);
			return result;
		} catch (IOException ex) {
			log.error("Error converting response data from json: " + ex.getMessage());
		}
		return null;
	}
}
