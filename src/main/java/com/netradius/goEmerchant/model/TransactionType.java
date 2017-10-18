package com.netradius.goemerchant.model;

/**
 * Transaction type values.
 *
 * @author Dilip S Sisodia
 */
public enum TransactionType {
  All,
  Auth,
  CloseBatch,
  Credit,
  Query,
  ReAuth,
  RecurringModify,
  ReSale,
  Sale,
  Settle,
  Void
}
