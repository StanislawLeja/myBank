package com.mybank.logic;

import java.time.LocalDateTime;
import static com.mybank.logic.Parameters.TransferStatus;

/**
 * Created by Stanisław Leja on 07.01.18.
 */
public class Transfer {
    private long accountIdSrc;
    private long accountIdDst;
    private LocalDateTime timeOfTransferRegister;
    private long transferAmount;
    private TransferStatus transferStatus;

    public Transfer(long accountIdDst, long accountIdSrc, long transferAmount) {
        this.accountIdDst = accountIdDst;
        this.accountIdSrc = accountIdSrc;
        this.timeOfTransferRegister = LocalDateTime.now();
        this.transferAmount = transferAmount;
        this.transferStatus = TransferStatus.WAIT_FOR_PROCESSING;
    }

    public long getAccountIdSrc() {
        return accountIdSrc;
    }

    public long getAccountIdDst() {
        return accountIdDst;
    }

    public LocalDateTime getNow() {
        return timeOfTransferRegister;
    }

    public long getTransferAmount() {
        return transferAmount;
    }


    public TransferStatus getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(TransferStatus transferStatus) {
        this.transferStatus = transferStatus;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "accountIdSrc=" + accountIdSrc +
                ", accountIdDst=" + accountIdDst +
                ", timeOfTransferRegister=" + timeOfTransferRegister +
                ", transferAmount=" + transferAmount +
                ", transferStatus=" + transferStatus +
                '}';
    }
}
