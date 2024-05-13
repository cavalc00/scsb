package br.com.scsb.ui.mainframe;

import br.com.scsb.ui.common.component.CommonFrame;
import br.com.scsb.util.border.Borders;
import br.com.scsb.util.constant.StringConstantsPT;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import javax.swing.JButton;
import javax.swing.WindowConstants;
import java.awt.GridLayout;

@Component
public class MainFrame extends CommonFrame {

    private JButton encryptButton;
    private JButton decryptButton;

    @Override
    @PostConstruct
    public void setup() {
        this.setTitle(StringConstantsPT.Titles.PROJECT_TITLE);
        this.setResizable(true);
        this.getRootPane().setBorder(Borders.createEmptyBorder());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setIconImage(null);
        this.setLayout(new GridLayout(1, 2, 20, 20));

        this.initComponents();
        this.pack();
    }

    public JButton getEncryptButton() {
        return encryptButton;
    }

    public JButton getDecryptButton() {
        return decryptButton;
    }

    private void prepareEncryptButton() {
        encryptButton = new JButton(StringConstantsPT.Labels.ENCRYPT);
    }

    private void prepareDecryptButton() {
        decryptButton = new JButton(StringConstantsPT.Labels.DECRYPT);
    }

    private void attachComponents() {
        this.add(encryptButton);
        this.add(decryptButton);
    }

    private void initComponents() {
        this.prepareEncryptButton();
        this.prepareDecryptButton();

        this.attachComponents();
    }
}
