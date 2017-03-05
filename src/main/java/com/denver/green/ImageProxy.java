package com.denver.green;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by degreen on 2017-03-01.
 *
 * The ImageProxy class is an example of the Virtual Proxy and State patterns. This class acts
 * as a proxy by standing in for the ImageIcon class. When the GUI first displays an Icon that
 * represents a CD cover the ImageProxy will initiate the loading of the image for the Icon in
 * a separate thread. While the image is loading the proxy will display the message
 * "Loading CD cover, please wait...". The code that handles the loading of the image and the
 * display of the loading message is contain in a object that represents the IconNotLoaded state
 * of the ImageProxy and all calls to the methods defined by the Icon interface will be directed
 * to the IconNotLoaded object. Once the image is loaded the state of the ImageProxy will be
 * transitioned to the IconLoadedState and all further calls to the methods defined by the Icon
 * interface will be handled by the IconLoadedState object.
 *
 * The use of the IconLoadedState and IconNotLoadedState objects is an example of the state pattern.
 */
public class ImageProxy implements Icon {
    ImageIcon imageIcon;
    URL imageURL;
    Thread retrievalThread;
    boolean iconRetrieved = false;

    ImageState IconLoadedState; // This object will be used after the CD cover image is loaded.
    ImageState IconNotLoadedState; // This object will be used while the CD cover image is being loaded.
    ImageState state;   // Reference to the current state of the image proxy.

    // Constructor creates the objects representing the possible states that ImageProxy can be in as
    // well as setting the current state of the object to not loaded
    public ImageProxy(URL url) {
        imageURL = url;
        IconNotLoadedState = new IconNotLoadedState(this);
        IconLoadedState = new IconLoadedState(this);
        state = IconNotLoadedState;
    }

    // The methods below uses the current state object to complete the work.
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        state.paintIcon(c, g, x, y);
    }

    @Override
    public int getIconWidth() {
        return state.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return state.getIconHeight();
    }
}
