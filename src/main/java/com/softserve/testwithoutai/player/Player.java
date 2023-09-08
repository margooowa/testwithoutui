package com.softserve.testwithoutai.player;

import java.util.List;

public class Player {

  public String name;

  public int age;

  public int experience;

  public List<Integer> skills;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getExperience() {
    return experience;
  }

  public void setExperience(int experience) {
    this.experience = experience;
  }

  public List<Integer> getSkills() {
    return skills;
  }

  public void setSkills(List<Integer> skills) {
    this.skills = skills;
  }
}
