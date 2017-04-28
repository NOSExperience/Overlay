package main;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

import static java.awt.GraphicsDevice.WindowTranslucency.*;
import javax.swing.*;

public class Main extends JFrame {
	
	private static final long serialVersionUID = 1554119310077614846L;

	public Main() {
        super("TranslucentWindow");
        setUndecorated(true);
        setLayout(new GridBagLayout());
        
        getContentPane().setBackground(new Color(1.0f, 0.0f, 0.0f));
 
        addComponentListener(new ComponentAdapter() {
        	@Override
        	public void componentResized(ComponentEvent e) {
        		//setShape(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        		setShape(new RoundRectangle2D.Double(0.0, 0.0, getWidth(), getHeight(), 25, 25));
        	}
        });
        
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setOpacity(0.55f);
        setVisible(true);
 
        //Add a sample button.
        add(new JButton("I am a Button"));
        
        pack();
    }
 
    public static void main(String[] args) {
    	GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); 
    	
        if(!(device.isWindowTranslucencySupported(TRANSLUCENT) &&
        		device.isWindowTranslucencySupported(PERPIXEL_TRANSPARENT))) {
        	
                System.exit(1);
        }
        
        JFrame.setDefaultLookAndFeelDecorated(false);
 
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                @SuppressWarnings("unused")
				Main instance = new Main();
            }
        });
    }

}
