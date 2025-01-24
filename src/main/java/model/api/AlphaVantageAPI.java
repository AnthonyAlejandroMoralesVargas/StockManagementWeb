package model.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AlphaVantageAPI {

    private static final String API_URL = "https://www.alphavantage.co/query";
    private String apiKey;

    public AlphaVantageAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    public AlphaVantageAPI() {
        this.apiKey = "70QX4UDI1NSM2LKD";
    }

    public double getCurrentPrice(String symbol) {
        String urlString = API_URL + "?function=TIME_SERIES_INTRADAY&symbol=" + symbol + "&interval=1min&apikey=" + apiKey;

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parsear el JSON con Jackson
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response.toString());

            JsonNode timeSeries = rootNode.get("Time Series (1min)");
            if (timeSeries != null) {
                String lastKey = timeSeries.fieldNames().next(); // Obtener el último timestamp
                double price = timeSeries.get(lastKey).get("4. close").asDouble();
                return price;
            }
            return -1;
        } catch (Exception e) {
            throw new RuntimeException("Error al consumir la API: " + e.getMessage(), e);
        }
    }
}