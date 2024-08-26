package employee.management;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        // Scaling the iimage to fit in the window
        Image i2=i1.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
        // Converting the i2 again to image icon
        ImageIcon i3=new ImageIcon(i2);

        // Now Using the JLabel to add  our image to window
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1170,650);
        add(image); // adding the image to the window

        // window Setting
        setSize(1170,650);
        setLocation(100,50);
        setLayout(null);
        setVisible(true);

        // the gif is iterating, so, we are stoping after playing 1 loop
        try{
            Thread.sleep(4700);
            new Login();
            setVisible(false);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new Splash();
    }
}
