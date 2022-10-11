package com.knubisoft.base.bool;

public class BoolTasksImpl implements BoolTasks {

    @Override
    public Boolean isTrueAutobox(boolean value) {
        if (value)
            return true;
        return false;
    }

    @Override
    public Boolean isFalseAutobox(boolean value) {
        if (!value)
            return false;
        return true;
    }

    @Override
    public boolean isTrueUnbox(Boolean value) {
        if (value.booleanValue()) {
            value = true;
        }
        return value;
    }

    @Override
    public Boolean isFalseUnbox(boolean value) {
        if (!Boolean.getBoolean(String.valueOf(value))) {
        }
        return value;
    }

    @Override
    public boolean andFunction(int digit, String string) {
        if (string == null) {
            return false;
        } else if (string.isEmpty()) {
            return false;
        } else {
            try {
                if (digit == Integer.parseInt(string)) {
                    return true;
                } else {
                    return false;
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean orFunction(int digit, String string) {
        if (string == null || string.isEmpty() /*string.equals(" ") || string.equals("")*/) {
            return false;
        } else {
            try {
                if (digit == Integer.parseInt(string)) {
                    return true;
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean andComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int range) {
        return generatedFirstDigit == generatedSecondDigit;
    }

    @Override
    public boolean orComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int generatedThirdDigit, int range) {
        return generatedFirstDigit == generatedSecondDigit || generatedFirstDigit == generatedThirdDigit || generatedThirdDigit == generatedSecondDigit;
    }

    @Override
    public boolean isSameSizeArray(Object[] firstArray, Object... secondArray) {
        if (firstArray == null || secondArray == null) {
            return false;
        } else if (firstArray.length == secondArray.length) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean isSameCharactersCount(String username, String name, int maxLength) {
        if (username == null || name == null || username.isEmpty() || name.isEmpty() || maxLength == 0) {
            return false;
        } else {
            int count = 0;
            for (int i = 0; i < username.length(); i++) {
                if (username.charAt(i) != ' ')
                    count++;
            }
            int count1 = 0;
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) != ' ')
                    count1++;
            }
            return count == count1;
        }
    }
}
