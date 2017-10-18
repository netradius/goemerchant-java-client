package com.netradius.goemerchant;

import com.netradius.goemerchant.model.ApiResponse;
import com.netradius.goemerchant.model.Authorize;
import com.netradius.goemerchant.model.BatchClose;
import com.netradius.goemerchant.model.Credit;
import com.netradius.goemerchant.model.Query;
import com.netradius.goemerchant.model.ReAuthorize;
import com.netradius.goemerchant.model.ReSale;
import com.netradius.goemerchant.model.Recurring;
import com.netradius.goemerchant.model.RecurringModify;
import com.netradius.goemerchant.model.Sale;
import com.netradius.goemerchant.model.Settle;
import com.netradius.goemerchant.model.VoidTransaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test for GoeMerchant rest client.
 *
 * @author Dilip S Sisodia
 */
@Slf4j
public class RestClientTest {

  private String referenceNumber;
  private String orderId;
  private String merchantKey = "MerchantKey Here";
  private String processorId = "ProcessorId Here";

  //  @Test
  //  public void testClient() {
  //    authorize();
  //    settle();
  //    credit();
  //    query();
  //    reAuthorize();
  //    recurringModify();
  //    reSale();
  //    sale();
  //    performVoid();
  //        batchClose();
  //  }

  @Test
  public void authorize() {
    Authorize authorize = new Authorize();
    authorize.setTransactionAmount("1.00");
    authorize.setMerchantKey(merchantKey);
    authorize.setProcessorId(processorId);
    authorize.setCardNumber("5499990123456781");
    authorize.setCardExpMonth("08");
    authorize.setCardExpYear("17");
    authorize.setCvv("123");
    authorize.setRecurring(Recurring.bimonthly);
    authorize.setOwnerName("Auth Demo");
    authorize.setOwnerStreet("1 Test St");
    authorize.setOwnerCity("Philadelphia");
    authorize.setOwnerState("PA");
    authorize.setOwnerZip("19101");

    GoEmerchantClient client = new GoEmerchantClient();
    ApiResponse result = client.authorize(authorize);
    if (result != null) {
      if (!result.getIsError().equals("true")) {
        referenceNumber = result.getData().getReferenceNumber();
        orderId = result.getData().getOrderId();
        log.debug(result.toString());
        assertEquals(result.getIsSuccess(), "true");
      } else {
        for (String message : result.getErrorMessages()) {
          log.debug(message);
        }
      }
    }
  }

  @Test
  public void batchClose() {
    BatchClose batchClose = new BatchClose();
    batchClose.setMerchantKey(merchantKey);
    batchClose.setProcessorId(processorId);

    GoEmerchantClient client = new GoEmerchantClient();
    ApiResponse result = client.batchClose(batchClose);
    log.debug(result.toString());
    assertEquals(result.getIsSuccess(), "true");
  }

  @Test
  public void credit() {
    //635177
    Credit credit = new Credit();
    credit.setMerchantKey(merchantKey);
    credit.setProcessorId(processorId);
    credit.setRefNumber(referenceNumber);
    credit.setTransactionAmount("1.00");
    //    credit.setRecurring("none");
    GoEmerchantClient client = new GoEmerchantClient();
    ApiResponse result = client.credit(credit);
    assertNotNull(result);
  }

  @Test
  public void query() {
    Query query = new Query();
    query.setMerchantKey(merchantKey);
    query.setProcessorId(processorId);
    GoEmerchantClient client = new GoEmerchantClient();
    ApiResponse result = client.query(query);
    log.debug(result.toString());
    assertEquals(result.getIsSuccess(), "true");
  }

  @Test
  public void reAuthorize() {
    ReAuthorize reAuthorize = new ReAuthorize();
    reAuthorize.setMerchantKey(merchantKey);
    reAuthorize.setProcessorId(processorId);
    reAuthorize.setRefNumber("635177");
    reAuthorize.setTransactionAmount("1.00");
    reAuthorize.setOrderId(orderId);
    GoEmerchantClient client = new GoEmerchantClient();
    ApiResponse result = client.reAuthorize(reAuthorize);
    log.debug(result.toString());
    assertEquals(result.getIsSuccess(), "true");
  }

  @Test
  public void recurringModify() {
    RecurringModify recurringModify = new RecurringModify();
    recurringModify.setMerchantKey(merchantKey);
    recurringModify.setProcessorId(processorId);
    recurringModify.setReferenceNumber(referenceNumber);
    recurringModify.setRecurring("1");
    recurringModify.setRecurringType(Recurring.monthly);
    recurringModify.setRecurringStartDate("01/01/2017");
    recurringModify.setRecurringEndDate("01/02/2028");
    recurringModify.setRecurringAmount("20.00");
    recurringModify.setOwnerZip("01001");
    recurringModify.setOwnerEmail("test@test.com");
    recurringModify.setOwnerPhone("5555555555");
    recurringModify.setSendInvoice("1");
    GoEmerchantClient client = new GoEmerchantClient();
    ApiResponse result = client.recurringModify(recurringModify);
    log.debug(result.toString());
    assertEquals(result.getIsSuccess(), "true");
  }

  @Test
  public void reSale() {
    ReSale reSale = new ReSale();
    reSale.setMerchantKey(merchantKey);
    reSale.setProcessorId(processorId);
    reSale.setRefNumber("635177");
    reSale.setTransactionAmount("1.00");
    reSale.setOrderId(orderId);
    GoEmerchantClient client = new GoEmerchantClient();
    ApiResponse result = client.reSale(reSale);
    log.debug(result.toString());
    assertEquals(result.getIsSuccess(), "true");
  }

  @Test
  public void sale() {
    Sale sale = new Sale();
    sale.setTransactionAmount("1.00");
    sale.setMerchantKey(merchantKey);
    sale.setProcessorId(processorId);
    sale.setCardNumber("5499990123456781");
    sale.setCardExpMonth("08");
    sale.setCardExpYear("17");
    sale.setCvv("123");
    sale.setOwnerName("Auth Demo");
    sale.setOwnerStreet("1 Test St");
    sale.setOwnerCity("Philadelphia");
    sale.setOwnerState("PA");
    sale.setOwnerZip("19101");

    GoEmerchantClient client = new GoEmerchantClient();
    ApiResponse result = client.sale(sale);
    log.debug(result.toString());
    assertEquals(result.getIsSuccess(), "true");
  }

  @Test
  public void settle() {
    Settle settle = new Settle();
    settle.setMerchantKey(merchantKey);
    settle.setProcessorId(processorId);
    settle.setRefNumber(referenceNumber);
    settle.setTransactionAmount("1.00");
    GoEmerchantClient client = new GoEmerchantClient();
    ApiResponse result = client.settle(settle);
    assertEquals(result.getIsSuccess(), "true");
  }

  @Test
  public void performVoid() {
    VoidTransaction voidTransaction = new VoidTransaction();
    voidTransaction.setMerchantKey(merchantKey);
    voidTransaction.setProcessorId(processorId);
    voidTransaction.setRefNumber("635177");
    //    voidTransaction.setTransactionAmount("1.00");
    GoEmerchantClient client = new GoEmerchantClient();
    ApiResponse result = client.performVoid(voidTransaction);
    assertNotNull(result);
  }
}
