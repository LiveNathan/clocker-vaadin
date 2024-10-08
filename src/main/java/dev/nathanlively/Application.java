package dev.nathanlively;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import software.xdev.spring.data.eclipse.store.repository.config.EnableEclipseStoreRepositories;

@PWA(name = "Clocker-Vaadin", shortName = "Clocker")
@SpringBootApplication
@EnableEclipseStoreRepositories
@NpmPackage(value = "@fontsource/anton", version = "4.5.0")
@Theme(value = "clocker-vaadin", variant = Lumo.DARK)
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
