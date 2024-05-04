package br.com.scsb.ui.common.component;

import br.com.scsb.ui.common.component.interfaces.IComponent;
import org.springframework.stereotype.Component;

import javax.swing.JLabel;

@Component
public class DefaultLabel extends JLabel implements IComponent {

    @Override
    public void setup() {
        this.setVisible(true);
    }
}
