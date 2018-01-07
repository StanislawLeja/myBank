package com.mybank.logic;

import java.util.LinkedList;

/**
 * Created by Stanisław Leja on 07.01.18.
 */
public class TransferPool {
    private LinkedList<Transfer> transferQueue;

    public TransferPool(){
        this.transferQueue = new LinkedList<Transfer>();
    }

    public void transferMoney(long srcAccount, long dstAccount, long amount){
        transferQueue.add(new Transfer(srcAccount,dstAccount,amount));
    }

    public Transfer getHeadTask(){
        return transferQueue.getFirst();
    }
}
