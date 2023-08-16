import javax.swing.*;
import java.awt.*;

public class JFunctions {
    public JFunctions(){

    }
    public JButton button(String text, int w, int h){
        JButton newButton = new JButton(text);
        newButton.setPreferredSize(new Dimension(w,h));
        return newButton;
    }

    public JLabel text(String t){
        JLabel temp_title = new JLabel(t);
        temp_title.setFont(new Font("Times New Roman", Font.BOLD, 20));
        int stringW = temp_title.getFontMetrics(temp_title.getFont()).stringWidth(temp_title.getText());
        temp_title.setPreferredSize(new Dimension(stringW, 50));
        return temp_title;
    }

    public JFrame window(String title, int w, int h, String iconName){
        JFrame frame = new JFrame(title);

        Image icon = Toolkit.getDefaultToolkit().getImage(iconName);
        frame.setIconImage(icon);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(w, h));
        frame.setLocationRelativeTo(null);

        return frame;
    }

    public void setCenter(Component obj, JFrame window, SpringLayout layout, int height){
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,obj,0,SpringLayout.HORIZONTAL_CENTER, window);
        layout.putConstraint(SpringLayout.NORTH, obj, height, SpringLayout.NORTH, window);
    }
    public void setCenter(Component obj, JFrame window, SpringLayout layout){
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,obj,0,SpringLayout.HORIZONTAL_CENTER, window);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, obj, 0, SpringLayout.VERTICAL_CENTER, window);
    }

    public void setLocation(String hor, Component obj1, int hPad, Component obj2, String vert, int vPad, Component obj3, SpringLayout layout) throws Exception {
        switch (hor) {
            case ("EE") -> layout.putConstraint(SpringLayout.EAST, obj1, hPad, SpringLayout.EAST, obj2);
            case ("EW") -> layout.putConstraint(SpringLayout.EAST, obj1, hPad, SpringLayout.WEST, obj2);
            case ("WW") -> layout.putConstraint(SpringLayout.WEST, obj1, hPad, SpringLayout.WEST, obj2);
            case ("WE") -> layout.putConstraint(SpringLayout.WEST, obj1, hPad, SpringLayout.EAST, obj2);
            case("HH") -> layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, obj1, hPad, SpringLayout.HORIZONTAL_CENTER, obj2);
            default -> throw new Exception("Missing or incorrect horizontal parameter");
        }

        switch (vert) {
            case ("NN") -> layout.putConstraint(SpringLayout.NORTH, obj1, vPad, SpringLayout.NORTH, obj3);
            case ("NS") -> layout.putConstraint(SpringLayout.NORTH, obj1, vPad, SpringLayout.SOUTH, obj3);
            case ("SS") -> layout.putConstraint(SpringLayout.SOUTH, obj1, vPad, SpringLayout.SOUTH, obj3);
            case ("SN") -> layout.putConstraint(SpringLayout.SOUTH, obj1, vPad, SpringLayout.NORTH, obj3);
            default -> throw new Exception("Missing or incorrect vertical parameter");
        }

    }

}
