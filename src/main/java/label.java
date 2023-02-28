import javax.swing.*;
import java.awt.*;

public class label
{
    private JLabel label;
    private ImageIcon text_icon;

    public label(String text, String icon, int vertical_text_position, int horizental_text_position, int vertical_alignment, int horizental_alignment, int x_bound, int y_bound)
    {
        label = new JLabel();
        text_icon = new ImageIcon(icon);

//        Border border = BorderFactory.createLineBorder(Color.BLUE, 5);

        this.label.setText(text);
        this.label.setIcon(text_icon);
        this.label.setVerticalTextPosition(vertical_text_position);
        this.label.setHorizontalTextPosition(horizental_text_position);
        this.label.setVerticalAlignment(vertical_alignment);
        this.label.setHorizontalAlignment(horizental_alignment);
        this.label.setFont(new Font ("Segoe UI Black", Font.PLAIN, 10));
        this.label.setIconTextGap(3);
        this.label.setOpaque(true);
//        this.label.setBorder(border);
        this.label.setBounds(x_bound, y_bound, 200, 200);
    }
}
