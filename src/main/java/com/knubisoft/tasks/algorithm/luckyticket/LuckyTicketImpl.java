package com.knubisoft.tasks.algorithm.luckyticket;

public class LuckyTicketImpl implements LuckyTicket {
    @Override
    public boolean checkIsLuckyTicket(String ticket) {
        if (ticket == null || ticket.length() < 6 || ticket.length() > 8) {
            return false;
        }
        int count1 = 0;
        int count2 = 0;
        try {
            char[] array = ticket.toCharArray();
            for (int i = 0, j = array.length - 1; i < array.length / 2; i++, j--) {
                count1 += Integer.parseInt(String.valueOf(array[i]));
                count2 += Integer.parseInt(String.valueOf(array[j]));
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return count1 == count2;
    }
}
