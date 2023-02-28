import javax.swing.*;
import java.awt.*;

public class label extends JFrame
{
    private JLabel labelIns;
    private ImageIcon text_icon;

    public label(String text, String icon, int vertical_text_position, int horizental_text_position, int vertical_alignment, int horizental_alignment, int x_bound, int y_bound)
    {
        labelIns = new JLabel();
        text_icon = new ImageIcon(icon);

//        Border border = BorderFactory.createLineBorder(Color.BLUE, 5);

        this.labelIns.setText(text);
        this.labelIns.setIcon(text_icon);
        this.labelIns.setVerticalTextPosition(vertical_text_position);
        this.labelIns.setHorizontalTextPosition(horizental_text_position);
        this.labelIns.setVerticalAlignment(vertical_alignment);
        this.labelIns.setHorizontalAlignment(horizental_alignment);
        this.labelIns.setFont(new Font ("Segoe UI Black", Font.PLAIN, 10));
        this.labelIns.setIconTextGap(3);
        this.labelIns.setOpaque(true);
//        this.labelIns.setBorder(border);
        this.labelIns.setBounds(x_bound, y_bound, 200, 200);
    }
}
