package ch.competec;

public class Main {

  public static void main(String[] args) {

    // Erstelle Städte und füge sie zur TourManager Klasse hinzu
    for (int i = 0; i < 10; i++) {
      double xCoordinate = Math.random() * 100; // Beispiel für zufällige X-Koordinate im Bereich von 0 bis 100
      double yCoordinate = Math.random() * 100; // Beispiel für zufällige Y-Koordinate im Bereich von 0 bis 100
      City city = new City(xCoordinate, yCoordinate);
      TourManager.addCity(city);
    }

    // Initialisiere Population
    Population pop = new Population(50);
    System.out.println("Startdistanz: " + pop.getFittest().getDistance());

    // Ausführen des genetischen Algorithmus für 100 Generationen
    pop = GeneticAlgorithm.crossoverPopulation(pop);
    GeneticAlgorithm.mutatePopulation(pop);

    for (int i = 0; i < 100; i++) {
      pop = GeneticAlgorithm.crossoverPopulation(pop);
      GeneticAlgorithm.mutatePopulation(pop);
    }

    System.out.println("Fertig");
    System.out.println("Enddistanz: " + pop.getFittest().getDistance());
    System.out.println("Lösung:");
    System.out.println(pop.getFittest());
  }
}