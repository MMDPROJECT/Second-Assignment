import javax.swing.*;

public class GUI
{
    private double temperature;
    private int humidity;
    private double wind_speed;
    private String wind_direction;
    public JFrame frame;

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
    label label_1 = new label("one.png", "one.png", JLabel.CENTER, JLabel.RIGHT, JLabel.TOP, JLabel.LEFT, 0, 0);
    label label_2 = new label("two", "two.png", JLabel.CENTER, JLabel.RIGHT, JLabel.TOP, JLabel.RIGHT, 200, 0);
    label label_3 = new label("three", "three.png", JLabel.CENTER, JLabel.RIGHT, JLabel.BOTTOM, JLabel.LEFT, 0, 200);
    label label_4 = new label("four", "four.png", JLabel.CENTER, JLabel.RIGHT, JLabel.BOTTOM, JLabel.RIGHT, 200, 200);

    public void setFrame(JFrame frame)
    {
        frame.add(label_1);
        frame.add(label_2);
        frame.add(label_3);
        frame.add(label_4);
    }
}
