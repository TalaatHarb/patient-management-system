package net.talaatharb.patientmanagementsystem.uicontrollers;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;
import net.talaatharb.patientmanagementsystem.facades.PatientManagementFacade;

@Component
@RequiredArgsConstructor
public class PatientManagementSystemUiController {
	
	private final PatientManagementFacade patientManagementFacade;
	
	@FXML
	@Setter
	private TextField organizationName;
	
	@FXML
	public void addOrganization() {
		OrganizationDto organizationDto = new OrganizationDto();
		organizationDto.setName(organizationName.getText());
		patientManagementFacade.createOrganization(organizationDto);
	}
}
