package com.netradius.goemerchant;

import com.netradius.goemerchant.model.ApiResponse;
import com.netradius.goemerchant.model.Authorize;
import com.netradius.goemerchant.model.BatchClose;
import com.netradius.goemerchant.model.Credit;
import com.netradius.goemerchant.model.MerchantInformation;
import com.netradius.goemerchant.model.Query;
import com.netradius.goemerchant.model.ReAuthorize;
import com.netradius.goemerchant.model.ReSale;
import com.netradius.goemerchant.model.RecurringModify;
import com.netradius.goemerchant.model.Sale;
import com.netradius.goemerchant.model.Settle;
import com.netradius.goemerchant.model.TransactionType;
import com.netradius.goemerchant.model.VoidTransaction;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.IOException;

/**
 * GoEmerchant client.
 *
 * @author Dilip S Sisodia
 */
@Slf4j
public class GoEmerchantClient {

  private static final String GO_EMERCHANT_URL
      = "https://secure.1stpaygateway.net/secure/RestGW/Gateway/Transaction/";

  private ObjectMapper objectMapper;
  private RestClient client;
  private HttpResponse response;

  public GoEmerchantClient() {
    objectMapper = new ObjectMapper();
    objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
    client = new RestClient();
  }

  public ApiResponse authorize(Authorize authorize) {
    return getResponseData(authorize, TransactionType.Auth);
  }

  public ApiResponse batchClose(BatchClose batchClose) {
    return getResponseData(batchClose, TransactionType.CloseBatch);
  }

  public ApiResponse credit(Credit credit) {
    return getResponseData(credit, TransactionType.Credit);
  }

  public ApiResponse query(Query query) {
    return getResponseData(query, TransactionType.Query);
  }

  public ApiResponse reAuthorize(ReAuthorize reAuthorize) {
    return getResponseData(reAuthorize, TransactionType.ReAuth);
  }

  public ApiResponse recurringModify(RecurringModify recurringModify) {
    return getResponseData(recurringModify, TransactionType.RecurringModify);
  }

  public ApiResponse reSale(ReSale reSale) {
    return getResponseData(reSale, TransactionType.ReSale);
  }

  public ApiResponse sale(Sale sale) {
    return getResponseData(sale, TransactionType.Sale);
  }

  public ApiResponse settle(Settle settle) {
    return getResponseData(settle, TransactionType.Settle);
  }

  public ApiResponse performVoid(VoidTransaction voidTransaction) {
    return getResponseData(voidTransaction, TransactionType.Void);
  }

  private ApiResponse getResponseData(MerchantInformation transactionData, TransactionType type) {
    try {
      return client.httpPost(
          objectMapper.writeValueAsString(transactionData), GO_EMERCHANT_URL + type.name());
    } catch (IOException ex) {
      log.error("Error processing json data for request: " + ex.getMessage());
    }
    return null;
  }
}
