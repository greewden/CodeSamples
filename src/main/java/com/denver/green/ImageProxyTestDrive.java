package com.denver.green;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by degreen on 2017-03-01.
 */
public class ImageProxyTestDrive {
    private ImageComponent imageComponent;
    private JFrame frame = new JFrame("CD Cover Viewer");
    private JMenuBar menuBar;
    private JMenu menu;
    private HashMap<String, URL> cds = new HashMap<>();

    public ImageProxyTestDrive() throws Exception {

        cds.put("Ambient: Music for Airports", new URL("http://images.amazon.com/images/P/B000003S2K.01.LZZZZZZZ.jpg"));
        cds.put("Buddha Bar", new URL("http://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg"));
        cds.put("Ima", new URL("http://images.amazon.com/images/P/B000005IRM.01.LZZZZZZZ.jpg"));
        cds.put("Karma", new URL("http://images.amazon.com/images/P/B000005DCB.01.LZZZZZZZ.gif"));
        cds.put("MCMXC A.D.", new URL("http://images.amazon.com/images/P/B000002URV.01.LZZZZZZZ.jpg"));
        cds.put("Northern Exposure", new URL("http://images.amazon.com/images/P/B000003SFN.01.LZZZZZZZ.jpg"));
        cds.put("Selected Ambient Works, Vol. 2", new URL("http://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg"));
        cds.put("Oliver", new URL("http://www.cs.yale.edu/homes/freeman-elizabeth/2004/9/Oliver_sm.jpg"));
        URL initialURL = cds.get("Selected Ambient Works, Vol. 2");
        menuBar = new JMenuBar();
        menu = new JMenu("Favorite CDs");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        for (String name: cds.keySet()) {
            JMenuItem menuItem = new JMenuItem(name);
            menu.add(menuItem);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    imageComponent.setIcon(new ImageProxy(cds.get(event.getActionCommand())));
                    frame.repaint();
                }
            });
        }

        // Set-up frame and menus
        Icon icon = new ImageProxy(initialURL);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public static void main (String[] args) throws Exception {
        ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
    }
}
