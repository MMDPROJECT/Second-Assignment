![](J:\JavaHomework\WeatherAPI\Resources\image-20230225235244334.png)

										# 					   SECOND ASSIGNMENT REPORT

​						

## 						Mohammad Hossein Basouli          401222020



​									



















## **Introduction:**

- #### **A brief description of the this program:**
  
  - Write a program to prompt the user name of a **city** and output some information about it's weather.
- #### **Objectives:**
  
  1. Getting familiar with **JSON**.
  2. Learn how to establish a **HTTP Connection** to a **API**.
  3. Parsing desired data from **JSON**.
- #### **An overview of the approach has taken to complete assignment:**
  
  1. Establish a **HTTP Connection** to **API**.
  2. drop the data retrieved from **API** to a Buffered Reader and then append it line by line to a StringBuilder. After that we return it as a String.
  3. Call a function to split desired data into parts by **JSON** and output that.



## **Design and Implementation:**

- #### **Describing code line by line:**

  1. Set up **API KEY**.

     ```java
     public class BonusTasks
     {
         public final static String apiKey = "4559ae7bd83f44d5ba911803232502";
         ......
     }
     ```

     

    2. Input city name from user.

       

       ```java
       public static void main(String[] args)
           {
               Scanner input = new Scanner(System.in);
               System.out.println("Enter the city: ");
               String city = input.nextLine();
               .......
           }
          
       ```
  
  
  
  
  
  3. Call **getWeatherData()** to establish a connection to API and return the String containing all data.
  
  
  
  ```java
  public static void main(String[] args)
  {
  	......
  	......
  	if (getWeatherData(city) != null)
          {
              String weatherJson = getWeatherData(city);
              showWeatherInfo(weatherJson);
          }
          else
          {
              System.out.print("No information found!");
          }
  }
  
  public static String getWeatherData(String city)
      {
          try
          {
              URL url = new URL("http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city);
              HttpURLConnection connection = (HttpURLConnection) url.openConnection();
              connection.setRequestMethod("GET");
              BufferedReader reader = new BufferedReader(new 					InputStreamReader(connection.getInputStream()));
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
              return null;
          }
      }
  ```
  
  
  
  
  
  - For that we first set our **URL** to a specified format like the picture above and establish a connection to that.
  
  - Then  we have set the requestMethod to *"**GET**"*.
  
  - Insert data that we read from connection stream in a Buffered reader and append it line by line to StringBuilder.
  
  - Close the connection and our buffer, Then return the String builder as a String.
  
    

4. Call the ***showWeatherInfo()*** and pass the String to it:

   

   ```java
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
   ```





5. After that we call the methods ***getTemperature(), getHumidity(), getWindSpeed(), getDirection()***,  one after the other to parse trough String by **JSON** Methods and return asked information. 



```java
public static void showWeatherInfo (String weatherJson)
    {
        double temperature = getTemperature(weatherJson);

        int humidity = getHumidity(weatherJson);

        double wind_speed = getWindSpeed(weatherJson);

        String wind_direction = getDirection(weatherJson);
        .....
    }
```



6. Pass the information to be arranged in a **GUI frame**:

```java
public static void showWeatherInfo (String weatherJson)
    {
        ....
        ....
        ...
                GUI gui = new GUI(String.valueOf(temperature), String.valueOf(humidity), String.valueOf(wind_speed), wind_direction);

    }
.....
.....
//in the GUI.java file we implented Graphic User Interface of the application
public class GUI
{
    JFrame frame;
    JPanel panel;
    JLabel label_1;
    JLabel label_2;
    JLabel label_3;
    JLabel label_4;
    public GUI(String temperature, String humidity, String wind_speed, String wind_direction)
    {
        label_1 = new JLabel("Temperature: " + temperature); //setting text of the label
        label_1.setLayout(null); //setting layout manager to null because we want to set positions manually
        label_1.setBounds(0, 0, 100, 100); //setting bounds of the label
        label_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 20)); //setting style of the text
        label_1.setForeground(new Color(200, 200, 0)); //setting color of the text

        label_2 = new JLabel("Humidity Percentage: " + humidity); //same as above
        label_2.setLayout(null);                                                
        label_2.setBounds(0, 100, 100, 100);                  
        label_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 20)); 
        label_2.setForeground(new Color(200, 200, 0));                 

        label_3 = new JLabel("Winds Speed: " + wind_speed);
        label_3.setLayout(null);
        label_3.setBounds(0, 200, 100, 100);
        label_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        label_3.setForeground(new Color(200, 200, 0));

        label_4 = new JLabel("Winds Direction: " + wind_direction);
        label_4.setLayout(null);
        label_4.setBounds(0,300, 100, 100);
        label_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        label_4.setForeground(new Color(200, 200, 0));

        panel = new JPanel();  //creating a panel
        panel.add(label_1);    //adding labels to the panel one by one
        panel.add(label_2);
        panel.add(label_3);
        panel.add(label_4);
        panel.setBackground(Color.BLUE);  //setting background color
        panel.setOpaque(true);    //set this true to display background color

        ImageIcon imageIcon = new ImageIcon("WeatherForecaster.png");   //creating frame icon
        frame = new JFrame();  //creating a frame
        frame.add(panel); //adding panel and all components to the frame
        frame.setVisible(true);  //set this to true to display the frame
        frame.setIconImage(imageIcon.getImage()); //setting image icon
        frame.setTitle("Weather Forecast Program");  //setting the title text
        frame.setSize(400, 200);  //setting size of frame
        frame.setResizable(false);  //prevent the frame to be resized
    }
```

## **Testing and Evaluation:**

1. Input the city name:

   

   ![](J:\JavaHomework\WeatherAPI\Resources\image-20230227040832729.png)

2. Wait a few seconds and as you can see that a window comes up and information showed in:

   ![](J:\JavaHomework\WeatherAPI\Resources\image-20230301214457442.png)

3. Now let's test a special case that our **city** doesn't exist and see what happens:

   ![](J:\JavaHomework\WeatherAPI\Resources\image-20230227041212738.png)		

4. As you can see in the picture above nothing has been shown because **"sare ghabram"** does not exist in **API** cities.