package com.knubisoft.tasks.algorithm.luckyticket;

public interface LuckyTicket {

    /**
     * @return Check if ticket is lucky.
     * Lucky ticket pattern:
     * <p>
     * 1) not blank or null
     * 2) from 6 to 8 symbols
     * 3) only digits are allowed
     * 4) Incorrect pattern or format -- not lucky
     * <p>
     * Sample of lucky ticket:
     * 123321
     * 1234321
     * 5556555
     * 000000
     * <p>
     * Incorrect:
     * abc
     * null
     * abaaba
     */
    boolean checkIsLuckyTicket(String ticket);

}
