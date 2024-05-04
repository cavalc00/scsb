package br.com.scsb.ui.encyptFrame;

import br.com.scsb.ui.common.controller.CommonFrameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EncryptFrameController extends CommonFrameController {

    @Autowired
    private EncryptFrame encryptFrame;

    @Override
    public void prepareAndOpenFrame() {
        encryptFrame.pack();
        encryptFrame.setVisible(true);
    }
}
