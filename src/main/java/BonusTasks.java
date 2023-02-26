import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.util.Scanner;

public class BonusTasks
{
    public final static String apiKey = "4559ae7bd83f44d5ba911803232502";
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the city: ");
        String city = input.nextLine();

        String weatherJson = getWeatherData(city);
        showWeatherInfo(weatherJson);
    }

    public static String getWeatherData(String city)
    {
        try
        {
            URL url = new URL("http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
            {
                stringBuilder.append(line);
            }
            reader.close();
            return stringBuilder.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static double getTemperature(String weatherJson)
    {
        JSONObject jsonObject = new JSONObject(weatherJson);
        double answer = jsonObject.getJSONObject("current").getDouble("temp_c");
        return answer;
    }
    public static int getHumidity(String weatherJson)
    {
        JSONObject jsonObject = new JSONObject(weatherJson);
        int answer = jsonObject.getJSONObject("current").getInt("humidity");
        return answer;
    }
    public static double getWindSpeed (String weatherJson)
    {
        JSONObject jsonObject = new JSONObject(weatherJson);
        double answer = jsonObject.getJSONObject("current").getDouble("wind_kph");
        return answer;
    }
    public static String getDirection (String weatherJson)
    {
        JSONObject jsonObject = new JSONObject(weatherJson);
        String answer = jsonObject.getJSONObject("current").getString("wind_dir");
        return answer;
    }
    public static void showWeatherInfo (String weatherJson)
    {
        double temperature = getTemperature(weatherJson);

        int humidity = getHumidity(weatherJson);

        double wind_speed = getWindSpeed(weatherJson);

        String wind_direction = getDirection(weatherJson);

        System.out.print("temperature: " + temperature + "\n" + "humidity percentage: " + humidity + "\n" + "wind speed: " + wind_speed + "\n" + "wind direction: " + wind_direction);
    }
}
