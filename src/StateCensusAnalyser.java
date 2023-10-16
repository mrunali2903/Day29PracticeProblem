import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StateCensusAnalyser {
    private List<CSVStateCensus> stateCensusList = new ArrayList<>();

    public void loadCensusData(String csvFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            br.readLine(); // Skip the header row

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) { // Assuming 3 columns: State, Population, Area
                    String stateName = data[0];
                    int population = Integer.parseInt(data[1]);
                    double area = Double.parseDouble(data[2]);
                    CSVStateCensus census = new CSVStateCensus(stateName, population, area);
                    stateCensusList.add(census);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Iterator<CSVStateCensus> getCensusDataIterator() {
        return stateCensusList.iterator();
    }

    // Add any additional methods for data analysis
}
