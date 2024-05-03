package br.com.scsb;

import br.com.scsb.ui.mainframe.MainFrameController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.SwingUtilities;

@SpringBootApplication
public class SistemaDeCriptografiaSimetricaDeBlocosApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = createApplicationContext(args);
        displayMainFrame(applicationContext);
    }

    private static ConfigurableApplicationContext createApplicationContext(String... args) {
        return new SpringApplicationBuilder(SistemaDeCriptografiaSimetricaDeBlocosApplication.class)
                .headless(false)
                .run(args);
    }

    private static void displayMainFrame(ConfigurableApplicationContext context) {
        SwingUtilities.invokeLater(() -> {
            MainFrameController mainFrameController = context.getBean(MainFrameController.class);
            mainFrameController.prepareAndOpenFrame();
        });
    }
}
