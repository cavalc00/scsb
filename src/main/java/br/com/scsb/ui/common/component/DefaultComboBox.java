package br.com.scsb.ui.common.component;

import br.com.scsb.ui.common.component.interfaces.IComponent;
import org.springframework.stereotype.Component;

import javax.swing.JComboBox;
import java.util.List;

@Component
public class DefaultComboBox<T> extends JComboBox<T> implements IComponent {

    public void addElements(List<T> items) {
        items.forEach(this::addItem);
    }

    @Override
    public void setup() {
        this.setEditable(false);
    }
}
