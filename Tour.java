package ch.competec;

import java.util.ArrayList;
import java.util.Collections;

public class Tour {

  private ArrayList<City> tour = new ArrayList<>();
  private double distance = 0;

  // Konstruktor
  public Tour() {
    for (int i = 0; i < TourManager.numberOfCities(); i++) {
      tour.add(null);
    }

    // Erstelle eine zufällige Tour
    for (int i = 0; i < TourManager.numberOfCities(); i++) {
      setCity(i, TourManager.getCity(i));
    }
    // Mischen der Städte, um eine zufällige Tour zu erstellen
    Collections.shuffle(tour);
  }
  public boolean containsCity(City city) {
    return tour.contains(city);
  }
  // Fügt eine Stadt zur Tour hinzu
  public void addCity(City city) {
    tour.add(city);
    distance = 0; // Zurücksetzen der Distanz, da sie neu berechnet werden muss
  }

  // Setzt eine Stadt an einem bestimmten Index in der Tour
  public void setCity(int index, City city) {
    tour.set(index, city);
    distance = 0; // Zurücksetzen der Distanz, da sie neu berechnet werden muss
  }

  // Holt eine Stadt aus der Tour
  public City getCity(int index) {
    return tour.get(index);
  }

  // Berechnet die Gesamtdistanz der Tour
  public double getDistance() {
    if (distance == 0) {
      double tourDistance = 0;
      for (int i = 0; i < tour.size(); i++) {
        City fromCity = getCity(i);
        City destinationCity;
        if (i + 1 < tour.size()) {
          destinationCity = getCity(i + 1);
        } else {
          destinationCity = getCity(0); // Rückkehr zum Start, wenn es die letzte Stadt ist
        }
        tourDistance += fromCity.distanceTo(destinationCity);
      }
      distance = tourDistance;
    }
    return distance;
  }

  // Gibt die Anzahl der Städte in der Tour zurück
  public int tourSize() {
    return tour.size();
  }

  public ArrayList<City> getTourList() {
    return tour;
  }
  @Override
  public String toString() {
    if (tour.isEmpty()) {
      return "Keine Städte in der Tour";
    }
    String result = "";
    for (City city : tour) {
      result += city.toString() + " -> ";
    }
    result += tour.get(0).toString(); // Zurück zur ersten Stadt
    return result;
  }
}
