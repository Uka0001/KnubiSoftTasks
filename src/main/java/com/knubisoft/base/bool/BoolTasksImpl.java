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
        if (value.booleanValue()){
            value = true;
        }
        return value;
    }

    @Override
    public Boolean isFalseUnbox(boolean value) {
        if (!Boolean.getBoolean(String.valueOf(value))){
        }
        return value;
    }

    @Override
    public boolean andFunction(int digit, String string) {
        if (string == null) /*&& string.equals(" ") && string.equals(""))*/ {
            return false;
        } else if (string.isEmpty()) {
            return false;
        }else {
            try{
                if(digit == Integer.parseInt(string)){
                    return true;
                } else {
                    return false;
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean orFunction(int digit, String string) {
        if (string == null || string.equals(" ") || string.equals("")) {
            return false;
        } else {
            try{
                if(digit == Integer.parseInt(string)){
                    return true;
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean andComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int range) {
        return false;
    }

    @Override
    public boolean orComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int generatedThirdDigit, int range) {
        return false;
    }

    @Override
    public boolean isSameSizeArray(Object[] firstArray, Object... secondArray) {
        return false;
    }

    @Override
    public boolean isSameCharactersCount(String username, String name, int maxLength) {
        return false;
    }
}
