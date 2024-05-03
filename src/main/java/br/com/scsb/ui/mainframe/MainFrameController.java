package br.com.scsb.ui.mainframe;

import br.com.scsb.ui.common.controller.CommonFrameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainFrameController extends CommonFrameController {

    @Autowired
    private MainFrame mainFrame;

    @Override
    public void prepareAndOpenFrame() {
        mainFrame.setVisible(true);
    }
}
