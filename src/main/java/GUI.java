import javax.swing.*;

public class GUI
{
    private double temperature;
    private int humidity;
    private double wind_speed;
    private String wind_direction;
    private JFrame frame;

    public GUI (double temperature, int humidity, double wind_speed, String wind_direction)
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.wind_speed = wind_speed;
        this.wind_direction = wind_direction;

        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(400, 400);
        this.frame.setVisible(true);
        this.frame.setLayout(null);
    }
    label label_1 = new label("one", )
}
