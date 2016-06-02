package com.netradius.goEmerchant;

import com.netradius.goEmerchant.*;
import com.netradius.goEmerchant.model.*;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Dilip S Sisodia
 */
@Slf4j
public class RestClientTest {

	private String referenceNumber;
	private String orderId;

	@Test
	public void testClient() {
		authorize();
		settle();
		credit();
		query();
		reAuthorize();
		recurringModify();
		reSale();
		sale();
		performVoid();
//		batchClose();
	}

	@Test
	public void authorize() {
		Authorize authorize = new Authorize();
		authorize.setTransactionAmount("1.00");
		authorize.setMerchantKey("a91c38c3-7d7f-4d29-acc7-927b4dca0dbe");
		authorize.setProcessorId("15417");
		authorize.setCardNumber("5499990123456781");
		authorize.setCardExpMonth("08");
		authorize.setCardExpYear("17");
		authorize.setCVV("123");
		authorize.setRecurring(Recurring.bimonthly);
		authorize.setOwnerName("Auth Demo");
		authorize.setOwnerStreet("1 Test St");
		authorize.setOwnerCity("Philadelphia");
		authorize.setOwnerState("PA");
		authorize.setOwnerZip("19101");

		GoEmerchantClient client = new GoEmerchantClient();
		ApiResponse result = client.authorize(authorize);
		if(result != null) {
			referenceNumber = result.getData().getReferenceNumber();
			orderId = result.getData().getOrderId();
			log.debug(result.toString());
			assertEquals(result.getIsSuccess(), "true");
		}
	}

	@Test
	public void batchClose() {
		BatchClose batchClose = new BatchClose();
		batchClose.setMerchantKey("a91c38c3-7d7f-4d29-acc7-927b4dca0dbe");
		batchClose.setProcessorId("15417");

		GoEmerchantClient client = new GoEmerchantClient();
		ApiResponse result = client.batchClose(batchClose);
		log.debug(result.toString());
		assertEquals(result.getIsSuccess(), "true");
	}

	@Test
	public void credit() {
//635177
		Credit credit = new Credit();
		credit.setMerchantKey("a91c38c3-7d7f-4d29-acc7-927b4dca0dbe");
		credit.setProcessorId("15417");
		credit.setRefNumber(referenceNumber);
		credit.setTransactionAmount("1.00");
//		credit.setRecurring("none");
		GoEmerchantClient client = new GoEmerchantClient();
		ApiResponse result = client.credit(credit);
		assertNotNull(result);
	}

	@Test
	public void query() {
		Query query = new Query();
		query.setMerchantKey("a91c38c3-7d7f-4d29-acc7-927b4dca0dbe");
		query.setProcessorId("15417");
		GoEmerchantClient client = new GoEmerchantClient();
		ApiResponse result = client.query(query);
		log.debug(result.toString());
		assertEquals(result.getIsSuccess(), "true");
	}

	@Test
	public void reAuthorize() {
		ReAuthorize reAuthorize = new ReAuthorize();
		reAuthorize.setMerchantKey("a91c38c3-7d7f-4d29-acc7-927b4dca0dbe");
		reAuthorize.setProcessorId("15417");
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
		recurringModify.setMerchantKey("a91c38c3-7d7f-4d29-acc7-927b4dca0dbe");
		recurringModify.setProcessorId("15417");
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
		reSale.setMerchantKey("a91c38c3-7d7f-4d29-acc7-927b4dca0dbe");
		reSale.setProcessorId("15417");
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
		sale.setMerchantKey("a91c38c3-7d7f-4d29-acc7-927b4dca0dbe");
		sale.setProcessorId("15417");
		sale.setCardNumber("5499990123456781");
		sale.setCardExpMonth("08");
		sale.setCardExpYear("17");
		sale.setCVV("123");
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
		settle.setMerchantKey("a91c38c3-7d7f-4d29-acc7-927b4dca0dbe");
		settle.setProcessorId("15417");
		settle.setRefNumber(referenceNumber);
		settle.setTransactionAmount("1.00");
		GoEmerchantClient client = new GoEmerchantClient();
		ApiResponse result = client.settle(settle);
		assertEquals(result.getIsSuccess(), "true");
	}

	@Test
	public void performVoid() {
		VoidTransaction voidTransaction = new VoidTransaction();
		voidTransaction.setMerchantKey("a91c38c3-7d7f-4d29-acc7-927b4dca0dbe");
		voidTransaction.setProcessorId("15417");
		voidTransaction.setRefNumber("635177");
//		voidTransaction.setTransactionAmount("1.00");
		GoEmerchantClient client = new GoEmerchantClient();
		ApiResponse result = client.performVoid(voidTransaction);
		assertNotNull(result);
	}
}
