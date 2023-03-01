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
        label_1 = new JLabel("Temperature: " + temperature);
        label_1.setLayout(null);
        label_1.setBounds(0, 0, 100, 100);
        label_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        label_1.setForeground(new Color(200, 200, 0));

        label_2 = new JLabel("Humidity Percentage: " + humidity);
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

        panel = new JPanel();
        panel.add(label_1);
        panel.add(label_2);
        panel.add(label_3);
        panel.add(label_4);
        panel.setBackground(Color.BLUE);
        panel.setOpaque(true);

        ImageIcon imageIcon = new ImageIcon("WeatherForecaster.png");
        frame = new JFrame();
        frame.add(panel);
        frame.setVisible(true);
        frame.setIconImage(imageIcon.getImage());
        frame.setTitle("Weather Forecast Program");
//        frame.setBackground(Color.BLUE);
        frame.setSize(400, 200);
        frame.setResizable(false);
    }
}