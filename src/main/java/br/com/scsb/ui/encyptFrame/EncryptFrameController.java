package br.com.scsb.ui.encyptFrame;

import br.com.scsb.ui.common.controller.CommonFrameController;
import br.com.scsb.util.constant.StringConstantsPT;
import br.com.scsb.util.rule.EncryptDecryptAESUtil;
import br.com.scsb.util.warning.DialogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.security.GeneralSecurityException;
import java.util.Objects;

@Controller
public class EncryptFrameController extends CommonFrameController {

    @Autowired
    private EncryptFrame encryptFrame;

    @Override
    public void prepareAndOpenFrame() {
        this.registerAction(encryptFrame.getBtnGenerateSecretKey(), (e) -> this.generateSecretKey());
        this.registerAction(encryptFrame.getBtnCrypt(), (e) -> {
            try {
                this.encryptData();
            } catch (GeneralSecurityException ex) {
                throw new RuntimeException(ex);
            }
        });

        this.clearFields();
        this.showEncryptFrame();
    }

    private void clearFields() {
        encryptFrame.getDataField().setText(null);
        encryptFrame.getSecretKeyField().setText(null);
        encryptFrame.getTaCrypt().setText(null);
    }

    private void encryptData() throws GeneralSecurityException {
        Boolean isValid = this.validateRequiredFields();

        if (isValid) {
            String encrypted = EncryptDecryptAESUtil.encrypt(encryptFrame.getSecretKeyField().getText(),
                    encryptFrame.getDataField().getText(),
                    encryptFrame.getAlgorithmComboBox().getItemAt(encryptFrame.getAlgorithmComboBox().getSelectedIndex()));

            encryptFrame.getTaCrypt().setText(encrypted);
        }
    }

    private Boolean validateRequiredFields() {
        if (Objects.isNull(encryptFrame.getSecretKeyField().getText()) || encryptFrame.getSecretKeyField().getText().isEmpty()) {
            DialogUtils.showWarningPanel(StringConstantsPT.Labels.EMPTY_SECRET_MESSAGE);
            return false;
        }

        if (Objects.isNull(encryptFrame.getDataField().getText()) || encryptFrame.getDataField().getText().isEmpty()) {
            DialogUtils.showWarningPanel(StringConstantsPT.Labels.EMPTY_DATA_MESSAGE);
            return false;
        }

        return true;
    }

    private void showEncryptFrame() {
        encryptFrame.setVisible(true);
    }

    private void generateSecretKey() {
        String secretKey = EncryptDecryptAESUtil.generateSecretKey();
        encryptFrame.getSecretKeyField().setText(secretKey);
    }
}
