package br.com.scsb.ui.common.component;

import javax.swing.JComboBox;
import java.util.List;

public class DefaultComboBox<T> extends JComboBox<T> {

    public void addElements(List<T> items) {
        items.forEach(this::addItem);
    }
}
