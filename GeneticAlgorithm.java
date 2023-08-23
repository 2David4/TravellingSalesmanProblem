package ch.competec;

public class GeneticAlgorithm {

  private static final double MUTATION_RATE = 0.015;
  private static final int TOURNAMENT_SIZE = 5;
  private static final boolean ELITISM = true;

  // Crossover Population
  public static Population crossoverPopulation(Population pop) {
    Population newPopulation = new Population(pop.size());

    // Elitismus behält die beste Tour
    int elitismOffset = 0;
    if (ELITISM) {
      newPopulation.setTour(0, pop.getFittest());
      elitismOffset = 1;
    }

    // Crossover
    for (int i = elitismOffset; i < pop.size(); i++) {
      Tour parent1 = tournamentSelection(pop);
      Tour parent2 = tournamentSelection(pop);
      Tour child = crossover(parent1, parent2);
      newPopulation.setTour(i, child);
    }

    return newPopulation;
  }

  // Crossover für zwei Elternteile
  private static Tour crossover(Tour parent1, Tour parent2) {
    Tour child = new Tour();

    // Start- und Endpositionen für den Teilweg des ersten Elternteils
    int startPos = (int) (Math.random() * parent1.tourSize());
    int endPos = (int) (Math.random() * parent1.tourSize());

    // Füge den Teilweg des ersten Elternteils hinzu
    for (int i = 0; i < child.tourSize(); i++) {
      if (startPos < endPos && i > startPos && i < endPos) {
        child.setCity(i, parent1.getCity(i));
      } else if (startPos > endPos) {
        if (!(i < startPos && i > endPos)) {
          child.setCity(i, parent1.getCity(i));
        }
      }
    }

    // Füge die fehlenden Städte aus dem zweiten Elternteil hinzu
    for (int i = 0; i < parent2.tourSize(); i++) {
      if (!child.containsCity(parent2.getCity(i))) {
        for (int j = 0; j < child.tourSize(); j++) {
          if (child.getCity(j) == null) {
            child.setCity(j, parent2.getCity(i));
            break;
          }
        }
      }
    }

    return child;
  }

  // Mutiere eine Population
  public static void mutatePopulation(Population pop) {
    for (int i = 0; i < pop.size(); i++) {
      mutate(pop.getTour(i));
    }
  }

  // Mutation
  private static void mutate(Tour tour) {
    for (int tourPos1 = 0; tourPos1 < tour.tourSize(); tourPos1++) {
      if (Math.random() < MUTATION_RATE) {
        int tourPos2 = (int) (tour.tourSize() * Math.random());

        City city1 = tour.getCity(tourPos1);
        City city2 = tour.getCity(tourPos2);

        tour.setCity(tourPos2, city1);
        tour.setCity(tourPos1, city2);
      }
    }
  }

  // Turnierselektion
  private static Tour tournamentSelection(Population pop) {
    Population tournament = new Population(TOURNAMENT_SIZE);
    for (int i = 0; i < TOURNAMENT_SIZE; i++) {
      int randomId = (int) (Math.random() * pop.size());
      tournament.setTour(i, pop.getTour(randomId));
    }
    return tournament.getFittest();
  }
}
