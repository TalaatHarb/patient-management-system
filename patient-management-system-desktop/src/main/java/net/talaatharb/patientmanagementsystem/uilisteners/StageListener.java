package net.talaatharb.patientmanagementsystem.uilisteners;

import java.io.IOException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import net.talaatharb.patientmanagementsystem.uievents.StageReadyEvent;

@Slf4j
@Component
public class StageListener implements ApplicationListener<StageReadyEvent> {

	private final ApplicationContext applicationContext;
	private final String applicationTitle;
	private final Resource fxml;

	public StageListener(@Value("classpath:/ui.fxml") Resource fxml, ApplicationContext applicationContext) {
		this.applicationTitle = "Patient Management System";
		this.fxml = fxml;
		this.applicationContext = applicationContext;
	}

	@Override
	public void onApplicationEvent(StageReadyEvent stageReadyEvent) {
		try {
			Stage stage = stageReadyEvent.getStage();
			URL url = fxml.getURL();
			FXMLLoader fxmlLoader = new FXMLLoader(url);
			fxmlLoader.setControllerFactory(applicationContext::getBean);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root, 800, 600);
			stage.setScene(scene);
			stage.setTitle(this.applicationTitle);
			stage.show();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
}
