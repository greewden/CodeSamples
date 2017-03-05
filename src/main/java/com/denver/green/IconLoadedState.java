package com.denver.green;

import java.awt.*;

/**
 * Created by degreen on 2017-03-01.
 */
public class IconLoadedState implements ImageState {
    ImageProxy proxy;

    public IconLoadedState(ImageProxy imageProxy) {
        proxy = imageProxy;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        proxy.imageIcon.paintIcon(c, g, x, y);
    }

    @Override
    public int getIconWidth() {
        return proxy.imageIcon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return proxy.imageIcon.getIconHeight();
    }

}
