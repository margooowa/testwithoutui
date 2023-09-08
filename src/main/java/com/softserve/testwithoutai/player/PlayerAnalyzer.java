package com.softserve.testwithoutai.player;

import java.util.List;

public class PlayerAnalyzer {

  public double calculateScore(List<Player> players) {
    double score = 0;

    for (Player player : players) {
      double skillsAverage = player.getSkills().stream().mapToInt(Integer::intValue).sum() / (double) player.getSkills().size();
      double contribution = player.getAge() * player.getExperience() * skillsAverage;

      if (player.getAge() < 18) {
        contribution *= 0.5;
      }

      if (player.getExperience() > 10) {
        contribution *= 1.2;
      }

      score += contribution;
    }

    return score;
  }

}
