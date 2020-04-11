
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author Majd Talji <en.majd.talji@gmail.com>
 */
public class Main extends JFrame {

    JScrollBar redScroller;
    JScrollBar greenScroller;
    JScrollBar blueScroller;
    JLabel redLabel;
    JLabel greenLabel;
    JLabel blueLabel;
    JPanel selectedColorSquare;
    JLabel selectedColorValue;

    public Main() {
        createAndShowGuI();
    }

    private void createAndShowGuI() {

        setTitle("Color Picker");
        redLabel = new JLabel("Red");
        greenLabel = new JLabel("Green");
        blueLabel = new JLabel("Blue");
        redScroller = new JScrollBar(JScrollBar.HORIZONTAL, 255, 1, 0, 256);
        greenScroller = new JScrollBar(JScrollBar.HORIZONTAL, 255, 1, 0, 256);
        blueScroller = new JScrollBar(JScrollBar.HORIZONTAL, 255, 1, 0, 256);
        selectedColorSquare = new JPanel();
        selectedColorValue = new JLabel("Color: 255, 255, 255", JLabel.CENTER);

        redLabel.setBounds(40, 40, 40, 25);
        greenLabel.setBounds(40, 80, 40, 25);
        blueLabel.setBounds(40, 120, 40, 25);
        redScroller.setBounds(100, 40, 300, 25);
        greenScroller.setBounds(100, 80, 300, 25);
        blueScroller.setBounds(100, 120, 300, 25);
        selectedColorSquare.setBounds(420, 40, 145, 80);
        selectedColorValue.setBounds(420, 125, 145, 25);

        redScroller.setBackground(Color.red);
        greenScroller.setBackground(Color.green);
        blueScroller.setBackground(Color.blue);
        selectedColorSquare.setBackground(new Color(255, 255, 255));

        AdjustmentListener al = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Color c = new Color(redScroller.getValue(), greenScroller.getValue(), blueScroller.getValue());

                selectedColorSquare.setBackground(c);

                selectedColorValue.setText("Color : " + c.getRed() + ", " + c.getGreen() + ", " + c.getBlue());
            }
        };

        redScroller.addAdjustmentListener(al);
        greenScroller.addAdjustmentListener(al);
        blueScroller.addAdjustmentListener(al);

        redScroller.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                redScroller.setBackground(new Color(redScroller.getValue(), 0, 0));
            }
        });

        greenScroller.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                greenScroller.setBackground(new Color(0, greenScroller.getValue(), 0));
            }
        });

        blueScroller.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                blueScroller.setBackground(new Color(0, 0, blueScroller.getValue()));
            }
        });

        add(redLabel);
        add(greenLabel);
        add(blueLabel);
        add(redScroller);
        add(greenScroller);
        add(blueScroller);
        add(selectedColorSquare);
        add(selectedColorValue);

        getContentPane().setBackground(new Color(200, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 210);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

}
