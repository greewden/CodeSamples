package com.denver.green;

import javax.swing.*;
import java.awt.*;

/**
 * Created by degreen on 2017-03-01.
 */
public class IconNotLoadedState implements ImageState {
    ImageProxy proxy;

    public IconNotLoadedState(ImageProxy imageProxy) {
        proxy = imageProxy;
    }

    @Override
    // Displays the message "Loading CD cover, please wait..." while loading the image in a separate thread.
    // Once the image is loaded the state of the ImageProxy is transitioned to IconLoaded.
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.drawString("Loading CD cover, please wait...", x + 300, y + 190);
        if (!proxy.iconRetrieved) {
            proxy.iconRetrieved = true;
            proxy.retrievalThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        proxy.imageIcon = new ImageIcon(proxy.imageURL, "CD Cover");
                        proxy.state = proxy.IconLoadedState;
                        c.repaint();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            proxy.retrievalThread.start();
        }
    }

    @Override
    public int getIconWidth() {
        return 800;
    }

    @Override
    public int getIconHeight() {
        return 600;
    }
}
