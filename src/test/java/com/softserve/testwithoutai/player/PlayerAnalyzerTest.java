package com.softserve.testwithoutai.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerAnalyzerTest {

  private PlayerAnalyzer analyzer;

  @BeforeEach
  void setup() {
    this.analyzer = new PlayerAnalyzer();
  }

  @Test
  void should_calculateScore_normalPlayer() {
    // given
    List<Player> playerList = List.of(getNormalPlayer());

    //when
    double result = analyzer.calculateScore(playerList);

    //then
    assertEquals(250, result);
  }

  @Test
  void should_calculateScore_juniorPlayer() {
    // given
    List<Player> playerList = List.of(getJuniorPlayer());

    //when
    double result = analyzer.calculateScore(playerList);

    //then
    assertEquals(67.5, result);
  }

  @Test
  void should_calculateScore_seniorPlayer() {
    // given
    List<Player> playerList = List.of(getSeniorPlayer());
    //when
    double result = analyzer.calculateScore(playerList);

    //then
    assertEquals(2520, result);
  }

  @Test
  void should_calculateScore_multiplePlayer() {
    // given
    List<Player> playerList = List.of(getNormalPlayer(), getJuniorPlayer(), getSeniorPlayer());

    //when
    double result = analyzer.calculateScore(playerList);

    //then
    assertEquals(250 + 67.5 + 2520, result);
  }

  @Test
  void should_throwException_calculateScore_emptySkills() {
    // given
    List<Player> playerList = List.of(getNormalPlayer(), getJuniorPlayer(), getSeniorPlayer());
    for (Player player : playerList) {
      player.setSkills(null);
    }

    //when
    NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
      analyzer.calculateScore(playerList);
    });

    //then
    assertThat(thrown.getMessage()).contains("return value of \"com.softserve.testwithoutai.player.Player.getSkills()\" is null");


  }

  private static Player getNormalPlayer() {
    Player player = new Player();
    player.setAge(25);
    player.setExperience(5);
    player.setSkills(List.of(2, 2, 2));
    return player;
  }

  private static Player getJuniorPlayer() {
    Player player = new Player();
    player.setAge(15);
    player.setExperience(3);
    player.setSkills(List.of(3, 3, 3));
    return player;
  }

  private static Player getSeniorPlayer() {
    Player player = new Player();
    player.setAge(35);
    player.setExperience(15);
    player.setSkills(List.of(4, 4, 4));
    return player;
  }
}
