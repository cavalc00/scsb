package br.com.scsb.ui.mainframe;

import br.com.scsb.ui.common.controller.CommonFrameController;
import br.com.scsb.ui.decryptFrame.DecryptFrameController;
import br.com.scsb.ui.encyptFrame.EncryptFrameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainFrameController extends CommonFrameController {

    @Autowired
    private MainFrame mainFrame;

    @Autowired
    private EncryptFrameController encryptFrameController;

    @Autowired
    private DecryptFrameController decryptFrameController;

    @Override
    public void prepareAndOpenFrame() {
        this.registerAction(mainFrame.getEncryptButton(), (e) -> this.openEncryptFrame());
        this.registerAction(mainFrame.getDecryptButton(), (e) -> this.openDecryptFrame());

        this.showMainFrame();
    }

    private void openDecryptFrame() {
        decryptFrameController.prepareAndOpenFrame();
    }

    private void openEncryptFrame() {
        encryptFrameController.prepareAndOpenFrame();
    }

    private void showMainFrame() {
        mainFrame.setVisible(true);
    }
}
