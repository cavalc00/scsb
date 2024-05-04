package br.com.scsb.util.border;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import static br.com.scsb.util.constant.NumericalConstants.BORDER_HEIGHT;
import static br.com.scsb.util.constant.NumericalConstants.BORDER_WIDTH;


public class Borders {

    public static Border createEmptyBorder() {
        return BorderFactory.createEmptyBorder(BORDER_HEIGHT, BORDER_WIDTH, BORDER_HEIGHT, BORDER_WIDTH);
    }
}
