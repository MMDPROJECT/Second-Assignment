import javax.swing.*;
import java.awt.*;

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
        label_1 = new JLabel("Temperature: " + temperature);                //setting text of the label
        label_1.setLayout(null);                                                //setting layout manager to null because we want to set positions manually
        label_1.setBounds(0, 0, 100, 100);                    //setting bounds of the label
        label_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 20)); //setting style of the text
        label_1.setForeground(new Color(200, 200, 0));                 //setting color of the text

        label_2 = new JLabel("Humidity Percentage: " + humidity);           //same as above
        label_2.setLayout(null);                                                //...
        label_2.setBounds(0, 100, 100, 100);                  //...
        label_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 20)); //...
        label_2.setForeground(new Color(200, 200, 0));                 //...

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

        panel = new JPanel();                                                   //creating a panel
        panel.add(label_1);                                                     //adding labels to the panel one by one
        panel.add(label_2);
        panel.add(label_3);
        panel.add(label_4);
        panel.setBackground(Color.BLUE);                                        //setting background color
        panel.setOpaque(true);                                                  //set this true to display background color

        ImageIcon imageIcon = new ImageIcon("WeatherForecaster.png");   //creating frame icon
        frame = new JFrame();                                                  //creating a frame
        frame.add(panel);                                                      //adding panel and all components to the frame
        frame.setVisible(true);                                                //set this to true to display the frame
        frame.setIconImage(imageIcon.getImage());                              //setting image icon
        frame.setTitle("Weather Forecast Program");                            //setting the title text
        frame.setSize(400, 200);                                  //setting size of frame
        frame.setResizable(false);                                            //prevent the frame to be resized
    }
}