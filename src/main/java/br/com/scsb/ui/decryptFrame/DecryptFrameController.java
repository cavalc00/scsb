package br.com.scsb.ui.decryptFrame;

import br.com.scsb.ui.common.controller.CommonFrameController;
import br.com.scsb.util.constant.StringConstantsPT;
import br.com.scsb.util.rule.EncryptDecryptAESUtil;
import br.com.scsb.util.warning.DialogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.security.GeneralSecurityException;
import java.util.Objects;

@Controller
public class DecryptFrameController extends CommonFrameController {

    @Autowired
    private DecryptFrame decryptFrame;

    @Override
    public void prepareAndOpenFrame() {
        this.registerAction(decryptFrame.getBtnDecrypt(), (e) -> {
            try {
                this.encryptData();
            } catch (GeneralSecurityException ex) {
                throw new RuntimeException(ex);
            }
        });

        this.clearFields();
        this.showDecryptFrame();
    }

    private void showDecryptFrame() {
        decryptFrame.setVisible(true);
    }

    private void encryptData() throws GeneralSecurityException {
        Boolean isValid = this.validateRequiredFields();

        if (isValid) {
            String decrypted = EncryptDecryptAESUtil.decrypt(decryptFrame.getSecretKeyField().getText(),
                    decryptFrame.getDataField().getText(),
                    decryptFrame.getAlgorithmComboBox().getItemAt(decryptFrame.getAlgorithmComboBox().getSelectedIndex()));

            decryptFrame.getTaDecrypt().setText(decrypted);
        }
    }

    private void clearFields() {
        decryptFrame.getDataField().setText(null);
        decryptFrame.getSecretKeyField().setText(null);
        decryptFrame.getTaDecrypt().setText(null);
    }

    private Boolean validateRequiredFields() {
        if (Objects.isNull(decryptFrame.getSecretKeyField().getText()) || decryptFrame.getSecretKeyField().getText().isEmpty()) {
            DialogUtils.showWarningPanel(StringConstantsPT.Labels.EMPTY_SECRET_MESSAGE);
            return false;
        }

        if (Objects.isNull(decryptFrame.getDataField().getText()) || decryptFrame.getDataField().getText().isEmpty()) {
            DialogUtils.showWarningPanel(StringConstantsPT.Labels.EMPTY_DATA_MESSAGE);
            return false;
        }

        return true;
    }
}
