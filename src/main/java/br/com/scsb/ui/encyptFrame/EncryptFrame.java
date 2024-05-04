package br.com.scsb.ui.encyptFrame;

import br.com.scsb.model.enums.CipherEnum;
import br.com.scsb.ui.common.component.CommonFrame;
import br.com.scsb.ui.common.component.DefaultComboBox;
import br.com.scsb.util.border.Borders;
import br.com.scsb.util.constant.StringConstantsPT;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.GridLayout;
import java.util.Arrays;

@Component
public class EncryptFrame extends CommonFrame {

    private JLabel cbAlgorithmLabel;
    private DefaultComboBox<String> algorithmComboBox;

    @Override
    @PostConstruct
    public void setup() {
        this.getRootPane().setBorder(Borders.createEmptyBorder());
        this.setTitle(StringConstantsPT.Labels.ENCRYPT);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new GridLayout(1, 2, 20, 20));

        this.initComponents();
        this.pack();
    }

    private void prepareCbAlgorithmLabel() {
        cbAlgorithmLabel = new JLabel(StringConstantsPT.Labels.CIPHER_BOX_LABEL);
    }

    private void prepareAlgorithmComboBox() {
        algorithmComboBox = new DefaultComboBox<>();
        algorithmComboBox.removeAllItems();
        algorithmComboBox.addElements(Arrays.stream(CipherEnum.values()).map(CipherEnum::getCipher).toList());
    }

    private void attachComponents() {
        this.add(cbAlgorithmLabel);
        this.add(algorithmComboBox);
    }

    private void initComponents() {
        this.prepareCbAlgorithmLabel();
        this.prepareAlgorithmComboBox();

        this.attachComponents();
    }
}
