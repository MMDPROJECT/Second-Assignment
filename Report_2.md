![image-20230227030757318](C:\Users\Datis\AppData\Roaming\Typora\typora-user-images\image-20230227030757318.png)

​																					**SECOND ASSIGNMENT** **REPORT**									

​										**Mohammad Hossein Basouli** 																	**401222020**



















**Introduction:**

- **A brief description of the this program:**
  - Write a program to prompt the user name of a **city** and output some information about it's weather.
- **Objectives:**
  1. Getting familiar with **JSON**.
  2. Learn how to establish a **HTTP Connection** to a **API**.
  3. Parsing desired data from **JSON**.
- **An overview of the approach has taken to complete assignment:**
  1. Establish a **HTTP Connection** to **API**.
  2. drop the data retrieved from **API** to a Buffered Reader and then append it line by line to a StringBuilder. After that we return it as a String.
  3. Call a function to split desired data into parts by **JSON** and output that.



**Design and Implementation:**

- **Describing code line by line:**

  1. Setting up our **API KEY**.

     ![image-20230227033440026](C:\Users\Datis\AppData\Roaming\Typora\typora-user-images\image-20230227033440026.png)

    2. Input city name from user.

       ![image-20230227033529136](C:\Users\Datis\AppData\Roaming\Typora\typora-user-images\image-20230227034358704.png)

  		3. Call ***getWeatherData()*** to establish a connection to API and return the String containing all data.

       ![image-20230227033829693](C:\Users\Datis\AppData\Roaming\Typora\typora-user-images\image-20230227033829693.png)

       - For that we first set our **URL** to a specified format like the picture above and establish a connection to that.

       - Then  we have set the requestMethod to *"**GET**"*.

       - Insert data that we read from connection stream in a Buffered reader and append it line by line to StringBuilder.

       - Close the connection and our buffer, Then return the String builder as a String.

         

  4. Call the ***showWeatherInfo()*** and pass the String to it:

     - After that we call the methods ***getTemperature(), getHumidity(), getWindSpeed(), getDirection()***,  one after the other to parse trough String by **JSON** Methods and output asked information. we see one of these function bodies in the picture below:

       ![image-20230227041606896](C:\Users\Datis\AppData\Roaming\Typora\typora-user-images\image-20230227041606896.png)





**Testing and Evaluation:**

1. Input the city name:

   ![image-20230227040832729](C:\Users\Datis\AppData\Roaming\Typora\typora-user-images\image-20230227040832729.png)

2. Wait a few seconds and as you can see in the picture below the data comes up:

   ![image-20230227040934413](C:\Users\Datis\AppData\Roaming\Typora\typora-user-images\image-20230227040934413.png)

3. Now let's test a special case that our **city** doesn't exist and see what happens:

   ![image-20230227041212738](C:\Users\Datis\AppData\Roaming\Typora\typora-user-images\image-20230227041212738.png)		

4. As you can see in the picture above nothing has been shown because **"sare ghabram"** does not exist in **API** cities.