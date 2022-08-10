package com.knubisoft.ORM.model;

import java.util.ArrayList;
import java.util.List;

public class Root {
    private String foodGeneral;
    private List<Food> food = new ArrayList<>();

    public List<Food> getFood() {
        return food;
    }

    public String getFoodGeneral() {
        return foodGeneral;
    }

    public void setFoodGeneral(String foodGeneral) {
        this.foodGeneral = foodGeneral;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Root{" +
                "foodGeneral='" + foodGeneral + '\'' +
                ", food=" + food +
                '}';
    }
}
