package org.uqbar

import com.vaadin.flow.component.Key
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.button.ButtonVariant
import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.NumberField
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.PWA

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name="Vaadin Application", shortName="Vaadin App", description="This is an example Vaadin application.", enableInstallPrompt=false)
@CssImport("./styles/shared-styles.css")
@CssImport(value="./styles/vaadin-text-field-styles.css", themeFor="vaadin-text-field")
class ConversorView extends VerticalLayout {

	val conversor = new ConversorDomain
	
	/**
	 * Construct a new Vaadin view.
	 * <p>
	 * Build the initial UI state for the user accessing the application.
	 * 
	 * @param service The message service. Automatically injected Spring managed bean.
	 */
	new() {
		val txtMillas = new NumberField("Millas") => [
			addThemeName("bordered")
		]

		val lblKilometrosPrefijo = new Label("Kilómetros") => [
			style => [
				set("fontWeight","bold")
				set("fontSize", "small")
			]
		]
		
		val lblKilometros = new Label("<Ingrese millas>")

		val btnConvertir = new Button("Convertir") => [
			addClickListener([ e | 
				conversor.millas = txtMillas.value
				conversor.convertir
				lblKilometros.text = conversor.kilometrosAsString
			])
			addThemeVariants(ButtonVariant.LUMO_PRIMARY)
			addClickShortcut(Key.ENTER)
		]
		
		addClassName("centered-content")
		add(txtMillas, btnConvertir, lblKilometrosPrefijo, lblKilometros)
	}

}