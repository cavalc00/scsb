package br.com.scsb.ui.mainframe;

import br.com.scsb.ui.common.component.interfaces.IComponent;
import br.com.scsb.util.constant.NumericalConstants;
import br.com.scsb.util.constant.StringConstantsPT;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@Component
public class MainFrame extends JFrame implements IComponent {

    @Override
    @PostConstruct
    public void setup() {
        this.setTitle(StringConstantsPT.Titles.PROJECT_TITLE);
        this.setSize(NumericalConstants.WIDTH, NumericalConstants.HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setIconImage(null);
        this.setLayout(null);
    }
}
