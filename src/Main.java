import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        StateCensusAnalyser analyser = new StateCensusAnalyser();
        analyser.loadCensusData("IndianStatesCensus.csv");

        Iterator<CSVStateCensus> iterator = analyser.getCensusDataIterator();
        while (iterator.hasNext()) {
            CSVStateCensus census = iterator.next();
            // Perform data analysis or print the information
            System.out.println(census.getStateName() + " - Population: " + census.getPopulation() + ", Area: " + census.getArea());
        }
    }
}
