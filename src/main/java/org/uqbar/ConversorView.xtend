package org.uqbar

import com.vaadin.flow.component.Key
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.button.ButtonVariant
import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.grid.GridVariant
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
@Route("")
@PWA(name="Conversor Vaadin", shortName="Conversor", description="El viejo y confiable conversor", enableInstallPrompt=false)
@CssImport("./styles/shared-styles.css")
@CssImport(value="./styles/vaadin-text-field-styles.css", themeFor="vaadin-text-field")
class ConversorView extends VerticalLayout {

	val conversor = new ConversorDomain
	
	new() {
		val txtMillas = new NumberField("Millas") => [
			addThemeName("bordered")
			width = "250"
			id = "txtMillas"
		]

		val lblKilometrosPrefijo = new Label("Kilómetros") => [
			style => [
				set("fontWeight","bold")
				set("fontSize", "small")
			]
		] 
		
		val lblKilometros = new Label("<Ingrese millas>") => [
			id = "lblKilometros"
		]

		val grdConversiones = new Grid(Conversion) => [
			setItems(conversor.conversiones)
			setColumns()
			addColumn("fechaAsString") => [
				sortable = false
				header = "Fecha"
			]
			addColumn("millasAsString") => [
				sortable = false
				header = "Millas"
			]
			addColumn("kilometrosAsString") => [
				sortable = false
				header = "Kilometros"
			]
			addThemeVariants(
				GridVariant.LUMO_NO_BORDER,
        		GridVariant.LUMO_NO_ROW_BORDERS, 
        		GridVariant.LUMO_ROW_STRIPES
        	)
		]

		val btnConvertir = new Button("Convertir") => [
			id = "btnConvertir"
			addClickListener([ e | 
				conversor.millas = txtMillas.value
				conversor.convertir
				lblKilometros.text = conversor.kilometrosAsString
				grdConversiones.getDataProvider().refreshAll
			])
			addThemeVariants(ButtonVariant.LUMO_PRIMARY)
			addClickShortcut(Key.ENTER)
		]
		
		add(txtMillas, btnConvertir, lblKilometrosPrefijo, lblKilometros, grdConversiones)
		
	}

}
