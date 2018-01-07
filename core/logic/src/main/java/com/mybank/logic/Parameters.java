package com.mybank.logic;

/**
 * Created by Stanisław Leja on 07.01.18.
 */
public class Parameters {
    public enum TransferStatus{
        WAIT_FOR_PROCESSING,
        PROCESSING,
        SUCCESSFUL_PROCESSED,
        REJECTED,
    }
    public enum StatementType{
        DEPOSIT,
        WITHDRAWAL,
    }
}
