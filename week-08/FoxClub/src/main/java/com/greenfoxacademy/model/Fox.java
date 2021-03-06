package com.greenfoxacademy.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fox {
  private String name;
  private List<String> tricklist;
  private List<String> unKnownList;
  private String food;
  private String drink;


  public Fox() {
    this.name = "Mr.Fox";
    this.food = "pizze";
    this.drink = "lemonade";
    this.tricklist = new ArrayList<>();
    this.unKnownList = new ArrayList<>();
  }

  public Fox(String name, String food, String drink) {
    this.name = name;
    this.tricklist = new ArrayList<>();
    this.unKnownList = new ArrayList<>();
    this.food = food;
    this.drink = drink;
  }

  public void addTrick(String trick) {
    tricklist.add(trick);
  }

}
