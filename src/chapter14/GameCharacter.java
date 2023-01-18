package chapter14;

import java.io.Serializable;

public class GameCharacter implements Serializable {
  int power;
  String type;
  String[] weapons;
  
  public GameCharacter(int p, String t, String[] w) {
    power = p;
    type = t;
    weapons = w;
  }
  
  public int getPower() {
    return power;
  }
  
  public void setPower(int power) {
    this.power = power;
  }
  
  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public String getWeapons() {
    String weaponsList = "";
    
    for (int i = 0; i < weapons.length; i++) {
      weaponsList += weapons[i] + " ";
    }
    return weaponsList;
  }
  
  public void setWeapons(String[] weapons) {
    this.weapons = weapons;
  }
}
