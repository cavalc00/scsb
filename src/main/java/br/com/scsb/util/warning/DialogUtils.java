package br.com.scsb.util.warning;

import br.com.scsb.util.constant.StringConstantsPT;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogUtils {
    public static void showWarningPanel(String errorMessage) {
        JOptionPane.showMessageDialog(new JFrame(), errorMessage, StringConstantsPT.Titles.ALERT_TITLE, JOptionPane.WARNING_MESSAGE);
    }
}
