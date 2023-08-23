package ch.competec;


import java.util.ArrayList;

public class TourManager {

  // Statische Sammlung von Städten
  private static ArrayList<City> destinationCities = new ArrayList<>();

  // Fügt eine Stadt zur Sammlung hinzu
  public static void addCity(City city) {
    destinationCities.add(city);
  }

  // Gibt eine Stadt aus der Sammlung zurück
  public static City getCity(int index) {
    return destinationCities.get(index);
  }

  // Gibt die Anzahl der Städte in der Sammlung zurück
  public static int numberOfCities() {
    return destinationCities.size();
  }
}
