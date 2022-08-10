package com.knubisoft.tasks.test;

import java.util.StringJoiner;

class Decompose {

    public String decompose(long n) {
        StringJoiner result = new StringJoiner(" ");

        for (long nextN = n - 1; nextN > 1; nextN--) {
            long out = find(result, n * n - nextN * nextN, nextN);

            if (n * n == out + nextN * nextN) {
                result.add(Long.toString(nextN));
                return result.toString();
            }
        }
        return null;
    }

    private long find(StringJoiner result, long bal, long prevN) {
        long nextN = (long) Math.sqrt(bal);

        if (nextN >= prevN)
            return 0;

        if (nextN * nextN == bal) {
            result.add(Long.toString(nextN));
            return nextN * nextN;
        }

        while (bal > 3 & nextN > 1) {
            long out = find(result, bal - nextN * nextN, nextN);

            if (out == bal - nextN * nextN) {
                result.add(Long.toString(nextN));
                return out + nextN * nextN;
            }
            nextN--;
        }
        return 0;
    }
}
