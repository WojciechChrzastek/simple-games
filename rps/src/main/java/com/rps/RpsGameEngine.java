package com.rps;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class RpsGameEngine {

  private Map<RoundWeapons, Winner> gameEngineMap = new HashMap<>();

  public RpsGameEngine() {
    gameEngineMap.put(new RoundWeapons(Weapon.ROCK, Weapon.ROCK), Winner.TIE);
    gameEngineMap.put(new RoundWeapons(Weapon.ROCK, Weapon.SCISSORS), Winner.USER);
    gameEngineMap.put(new RoundWeapons(Weapon.ROCK, Weapon.LIZARD), Winner.USER);
    gameEngineMap.put(new RoundWeapons(Weapon.ROCK, Weapon.PAPER), Winner.COMPUTER);
    gameEngineMap.put(new RoundWeapons(Weapon.ROCK, Weapon.SPOCK), Winner.COMPUTER);

    gameEngineMap.put(new RoundWeapons(Weapon.PAPER, Weapon.PAPER), Winner.TIE);
    gameEngineMap.put(new RoundWeapons(Weapon.PAPER, Weapon.ROCK), Winner.USER);
    gameEngineMap.put(new RoundWeapons(Weapon.PAPER, Weapon.SPOCK), Winner.USER);
    gameEngineMap.put(new RoundWeapons(Weapon.PAPER, Weapon.SCISSORS), Winner.COMPUTER);
    gameEngineMap.put(new RoundWeapons(Weapon.PAPER, Weapon.LIZARD), Winner.COMPUTER);

    gameEngineMap.put(new RoundWeapons(Weapon.SCISSORS, Weapon.SCISSORS), Winner.TIE);
    gameEngineMap.put(new RoundWeapons(Weapon.SCISSORS, Weapon.PAPER), Winner.USER);
    gameEngineMap.put(new RoundWeapons(Weapon.SCISSORS, Weapon.LIZARD), Winner.USER);
    gameEngineMap.put(new RoundWeapons(Weapon.SCISSORS, Weapon.ROCK), Winner.COMPUTER);
    gameEngineMap.put(new RoundWeapons(Weapon.SCISSORS, Weapon.SPOCK), Winner.COMPUTER);

    gameEngineMap.put(new RoundWeapons(Weapon.LIZARD, Weapon.LIZARD), Winner.TIE);
    gameEngineMap.put(new RoundWeapons(Weapon.LIZARD, Weapon.PAPER), Winner.USER);
    gameEngineMap.put(new RoundWeapons(Weapon.LIZARD, Weapon.SPOCK), Winner.USER);
    gameEngineMap.put(new RoundWeapons(Weapon.LIZARD, Weapon.SCISSORS), Winner.COMPUTER);
    gameEngineMap.put(new RoundWeapons(Weapon.LIZARD, Weapon.ROCK), Winner.COMPUTER);

    gameEngineMap.put(new RoundWeapons(Weapon.SPOCK, Weapon.SPOCK), Winner.TIE);
    gameEngineMap.put(new RoundWeapons(Weapon.SPOCK, Weapon.SCISSORS), Winner.USER);
    gameEngineMap.put(new RoundWeapons(Weapon.SPOCK, Weapon.ROCK), Winner.USER);
    gameEngineMap.put(new RoundWeapons(Weapon.SPOCK, Weapon.PAPER), Winner.COMPUTER);
    gameEngineMap.put(new RoundWeapons(Weapon.SPOCK, Weapon.LIZARD), Winner.COMPUTER);
  }

  @AllArgsConstructor
  private class RoundWeapons {
    private Weapon user;
    private Weapon computer;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      RoundWeapons that = (RoundWeapons) o;

      if (user != that.user) return false;
      return computer == that.computer;
    }

    @Override
    public int hashCode() {
      int result = user.hashCode();
      result = 31 * result + computer.hashCode();
      return result;
    }
  }

  public Winner whoWin(Weapon user, Weapon computer) {
    return gameEngineMap.get(new RoundWeapons(user, computer));
  }
}
