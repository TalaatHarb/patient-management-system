package net.talaatharb.patientmanagementsystem.uievents;

import org.springframework.context.ApplicationEvent;

import javafx.stage.Stage;

public class StageReadyEvent extends ApplicationEvent {

	private static final long serialVersionUID = -283135446429186291L;

	public Stage getStage() {
		return Stage.class.cast(getSource());
	}

	public StageReadyEvent(Object source) {
		super(source);
	}
}