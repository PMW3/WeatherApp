import com.example.weather.WeatherFetch;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class WeatherFetchTest {

    @Test
    public void testFetchWeather() {
        try {

            double latitude = 40.7128;
            double longitude = -74.0060;

            JSONObject weatherData = WeatherFetch.fetchWeather(latitude, longitude);

            System.out.println(weatherData.toString());

            Assertions.assertNotEquals(weatherData, "Weather Data should not be null");
            Assertions.assertEquals(weatherData.getDouble("lat"), latitude, 0.1);
            Assertions.assertEquals(weatherData.getDouble("lon"), longitude, 0.1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConvertToLatLon() {
        try {

            String city = "Boston";
            String state = "Massachusetts";

            JSONObject weatherData = WeatherFetch.convertCityStateToLatLon(city, state);

            System.out.println(weatherData.toString());

            Assertions.assertNotNull(weatherData);
            Assertions.assertEquals(weatherData.getString("name"), city);
            Assertions.assertEquals(weatherData.getString("state"), state);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConvertToLatLon2() {
        try {

            String city = "New York County";
            String state = "New York";

            JSONObject weatherData = WeatherFetch.convertCityStateToLatLon(city, state);

            System.out.println(weatherData.toString());

            Assertions.assertNotNull(weatherData);
            Assertions.assertEquals(weatherData.getString("name"), city);
            Assertions.assertEquals(weatherData.getString("state"), state);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFetchWeatherbyCityState(){
        String city = "Boston";
        String state = "Massachusetts";

        double latitude = 42.361145;
        double longitude = -71.057083;

        JSONObject weatherData = WeatherFetch.fetchWeatherByCityState(city, state);

        System.out.println(weatherData.toString());
        Assertions.assertNotEquals(weatherData, "Weather Data should not be null");
        Assertions.assertEquals(weatherData.getDouble("lat"), latitude, 0.1);
        Assertions.assertEquals(weatherData.getDouble("lon"), longitude, 0.1);
    }

    @Test
    public void testFetchWeatherbyCityState2(){
        String city = "New York";
        String state = "NY";

        double latitude =  40.730610;
        double longitude = -73.935242;

        JSONObject weatherData = WeatherFetch.fetchWeatherByCityState(city, state);

        System.out.println(weatherData.toString());
        Assertions.assertNotEquals(weatherData, "Weather Data should not be null");
        Assertions.assertEquals(weatherData.getDouble("lat"), latitude, 0.1);
        Assertions.assertEquals(weatherData.getDouble("lon"), longitude, 0.1);
    }

}
