package org.uqbar

import com.vaadin.flow.component.button.testbench.ButtonElement
import com.vaadin.flow.component.html.testbench.LabelElement
import com.vaadin.flow.component.textfield.testbench.NumberFieldElement
import org.junit.Assert
import org.junit.Test
import com.vaadin.flow.component.grid.testbench.GridElement

class ConversorViewIT extends AbstractViewTest {
	@Test
	def void conversionHappyPath() {
		// Pre-condiciones
		Assert.assertEquals(0, $(GridElement).waitForFirst.rowCount)

		// Arrange - Act
		val txtMillas = $(NumberFieldElement).id("txtMillas")
		txtMillas.value = "1000"
		val btnConvertir = $(ButtonElement).id("btnConvertir")
		btnConvertir.click()
		
		// Assert
		val lblKilometros = $(LabelElement).id("lblKilometros")		
		Assert.assertEquals("1.609,34", lblKilometros.text)
		Assert.assertEquals(1, $(GridElement).waitForFirst.rowCount)
	}
}
