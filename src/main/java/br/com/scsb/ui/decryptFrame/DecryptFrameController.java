package br.com.scsb.ui.decryptFrame;

import br.com.scsb.ui.common.controller.CommonFrameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DecryptFrameController extends CommonFrameController {

    @Autowired
    private DecryptFrame decryptFrame;

    @Override
    public void prepareAndOpenFrame() {
        this.showDecryptFrame();
    }

    private void showDecryptFrame() {
        decryptFrame.setVisible(true);
    }
}
