package br.com.scsb.ui.mainframe;

import br.com.scsb.model.enums.CipherEnum;
import br.com.scsb.ui.common.component.DefaultComboBox;
import br.com.scsb.ui.common.component.DefaultLabel;
import br.com.scsb.ui.common.component.DefaultRadioButton;
import br.com.scsb.ui.common.controller.CommonFrameController;
import br.com.scsb.util.constant.StringConstantsPT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

@Controller
public class MainFrameController extends CommonFrameController {

    @Autowired
    private MainFrame mainFrame;

    @Autowired
    private DefaultComboBox<String> algorithmComboBox;

    @Autowired
    private DefaultLabel algorithmCBLabel;

    @Autowired
    private DefaultRadioButton modeCrypt;

    @Override
    public void prepareAndOpenFrame() {
        this.prepareAlgorithmCBLabel();
        this.prepareAlgorithmComboBox();
        this.prepareRadioButtonCrypt();

        this.showMainFrame();
    }

    private void prepareRadioButtonCrypt() {
        modeCrypt.setText(StringConstantsPT.Labels.CRYPT);
        modeCrypt.setBounds(400, 10, 100, 30);

        mainFrame.add(modeCrypt);
    }

    private void prepareAlgorithmCBLabel() {
        algorithmCBLabel.setup();
        algorithmCBLabel.setLabelFor(algorithmCBLabel);
        algorithmCBLabel.setText(StringConstantsPT.Labels.CIPHER_BOX_LABEL);
        algorithmCBLabel.setBounds(10, 10, 130, 20);

        mainFrame.add(algorithmCBLabel);
    }

    private void prepareAlgorithmComboBox() {
        algorithmComboBox.setup();
        algorithmComboBox.addElements(Arrays.stream(CipherEnum.values()).toList().stream().map(CipherEnum::getCipher).toList());
        algorithmComboBox.setBounds(130, 10, 220, 20);

        mainFrame.add(algorithmComboBox);
    }

    private void showMainFrame() {
        mainFrame.setVisible(true);
    }
}
