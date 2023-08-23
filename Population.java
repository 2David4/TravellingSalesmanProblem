package ch.competec;

import java.util.ArrayList;
import java.util.Collections;

public class Population {
  private ArrayList<Tour> tours;
  private double fittestDistance = 0;

  // Konstruktor
  public Population(int populationSize) {
    tours = new ArrayList<>(populationSize);
    for (int i = 0; i < populationSize; i++) {
      Tour newTour = new Tour();
      for (int j = 0; j < TourManager.numberOfCities(); j++) {
        newTour.addCity(TourManager.getCity(j));
      }
      Collections.shuffle(newTour.getTourList()); // Sie müssen eine Getter-Methode in der Tour-Klasse für die ArrayList von Städten erstellen
      tours.add(newTour);
    }
  }

  // Fügt eine Tour an einer bestimmten Position in der Population hinzu
  public void setTour(int index, Tour tour) {
    tours.set(index, tour);
    fittestDistance = 0; // Zurücksetzen der besten Distanz, da sie neu berechnet werden muss
  }

  // Holt eine Tour von einer bestimmten Position in der Population
  public Tour getTour(int index) {
    return tours.get(index);
  }

  // Holt die beste Tour in der Population
  public Tour getFittest() {
    Tour fittest = tours.get(0);
    for (int i = 1; i < tours.size(); i++) {
      if (getTour(i).getDistance() < fittest.getDistance()) {
        fittest = getTour(i);
      }
    }
    return fittest;
  }

  // Gibt die Größe der Population zurück
  public int size() {
    return tours.size();
  }

  @Override
  public String toString() {
    String result = "";
    for (int i = 0; i < tours.size(); i++) {
      result += "Tour " + i + ": " + getTour(i) + "\n";
    }
    return result;
  }
}
