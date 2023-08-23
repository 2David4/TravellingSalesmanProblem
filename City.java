package ch.competec;

public class City {
  private double x;
  private double y;

  // Konstruktor
  public City(double x, double y) {
    this.x = x;
    this.y = y;
  }

  // Methode zur Berechnung der Entfernung zu einer anderen Stadt
  public double distanceTo(City otherCity) {
    double xDifference = Math.abs(this.x - otherCity.getX());
    double yDifference = Math.abs(this.y - otherCity.getY());
    return Math.sqrt((xDifference * xDifference) + (yDifference * yDifference));
  }

  // Getter für X
  public double getX() {
    return x;
  }

  // Setter für X
  public void setX(double x) {
    this.x = x;
  }

  // Getter für Y
  public double getY() {
    return y;
  }

  // Setter für Y
  public void setY(double y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}
