package br.com.scsb.ui.encyptFrame;

import br.com.scsb.model.enums.CipherEnum;
import br.com.scsb.ui.common.component.CommonFrame;
import br.com.scsb.ui.common.component.DefaultComboBox;
import br.com.scsb.util.border.Borders;
import br.com.scsb.util.constant.StringConstantsPT;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.GridLayout;
import java.util.Arrays;

@Component
public class EncryptFrame extends CommonFrame {

    private JPanel panelData;
    private JLabel tfDataLabel;
    private JTextField dataField;

    private JPanel panelAlgorithm;
    private JLabel cbAlgorithmLabel;
    private DefaultComboBox<String> algorithmComboBox;

    private JPanel panelSecretKey;
    private JLabel tfSecretKeyLabel;
    private JTextField secretKeyField;
    private JButton btnGenerateSecretKey;

    private JButton btnCrypt;
    private JTextArea taCrypt;
    private JScrollPane taScroll;

    @Override
    @PostConstruct
    public void setup() {
        this.getRootPane().setBorder(Borders.createEmptyBorder());
        this.setTitle(StringConstantsPT.Labels.ENCRYPT);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new GridLayout(5, 1, 20, 20));

        this.initComponents();
        this.pack();
    }

    public JTextField getDataField() {
        return dataField;
    }

    public DefaultComboBox<String> getAlgorithmComboBox() {
        return algorithmComboBox;
    }

    public JTextField getSecretKeyField() {
        return secretKeyField;
    }

    public JButton getBtnGenerateSecretKey() {
        return btnGenerateSecretKey;
    }

    public JButton getBtnCrypt() {
        return btnCrypt;
    }

    public JTextArea getTaCrypt() {
        return taCrypt;
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
        panelData = new JPanel(new GridLayout(1, 2, 20, 20));
        panelData.add(tfDataLabel);
        panelData.add(dataField);

        panelAlgorithm = new JPanel(new GridLayout(1, 2, 10, 20));
        panelAlgorithm.add(cbAlgorithmLabel);
        panelAlgorithm.add(algorithmComboBox);

        panelSecretKey = new JPanel(new GridLayout(1, 3, 10, 20));
        panelSecretKey.add(tfSecretKeyLabel);
        panelSecretKey.add(secretKeyField);
        panelSecretKey.add(btnGenerateSecretKey);

        this.add(panelData);
        this.add(panelAlgorithm);
        this.add(panelSecretKey);
        this.add(btnCrypt);
        this.add(taScroll);
    }

    private void initComponents() {
        this.prepareTfDataLabel();
        this.prepareDataField();
        this.prepareCbAlgorithmLabel();
        this.prepareAlgorithmComboBox();
        this.prepareTfSecretKeyLabel();
        this.prepareSecretKeyField();
        this.prepareBtnGenerateSecretKey();
        this.prepareBtnCrypt();
        this.prepareTaCrypt();

        this.attachComponents();
    }

    private void prepareDataField() {
        dataField = new JTextField();
        dataField.setEditable(true);
    }

    private void prepareTfDataLabel() {
        tfDataLabel = new JLabel(StringConstantsPT.Labels.DATA_USER);
    }

    private void prepareTaCrypt() {
        taCrypt = new JTextArea();
        taScroll = new JScrollPane(taCrypt);
        taCrypt.setLineWrap(true);
        taCrypt.setEditable(false);
    }

    private void prepareBtnCrypt() {
        btnCrypt = new JButton(StringConstantsPT.Labels.ENCRYPT);
    }

    private void prepareBtnGenerateSecretKey() {
        btnGenerateSecretKey = new JButton(StringConstantsPT.Labels.GENERATE_KEY);
    }

    private void prepareSecretKeyField() {
        secretKeyField = new JTextField();
        secretKeyField.setEditable(false);
    }

    private void prepareTfSecretKeyLabel() {
        tfSecretKeyLabel = new JLabel(StringConstantsPT.Labels.SECRET_KEY);
    }
}
