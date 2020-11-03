package org.uqbar;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.Conversion;
import org.uqbar.ConversorDomain;

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
@PWA(name = "Vaadin Application", shortName = "Vaadin App", description = "This is an example Vaadin application.", enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
@SuppressWarnings("all")
public class ConversorView extends VerticalLayout {
  private final ConversorDomain conversor = new ConversorDomain();
  
  /**
   * Construct a new Vaadin view.
   * <p>
   * Build the initial UI state for the user accessing the application.
   * 
   * @param service The message service. Automatically injected Spring managed bean.
   */
  public ConversorView() {
    NumberField _numberField = new NumberField("Millas");
    final Procedure1<NumberField> _function = (NumberField it) -> {
      it.addThemeName("bordered");
      it.setWidth("250");
    };
    final NumberField txtMillas = ObjectExtensions.<NumberField>operator_doubleArrow(_numberField, _function);
    Label _label = new Label("Kilómetros");
    final Procedure1<Label> _function_1 = (Label it) -> {
      Style _style = it.getStyle();
      final Procedure1<Style> _function_2 = (Style it_1) -> {
        it_1.set("fontWeight", "bold");
        it_1.set("fontSize", "small");
      };
      ObjectExtensions.<Style>operator_doubleArrow(_style, _function_2);
    };
    final Label lblKilometrosPrefijo = ObjectExtensions.<Label>operator_doubleArrow(_label, _function_1);
    final Label lblKilometros = new Label("<Ingrese millas>");
    Grid<Conversion> _grid = new Grid<Conversion>(Conversion.class);
    final Procedure1<Grid<Conversion>> _function_2 = (Grid<Conversion> it) -> {
      it.setItems(this.conversor.getConversiones());
      it.setColumns();
      Grid.Column<Conversion> _addColumn = it.addColumn("fechaAsString");
      final Procedure1<Grid.Column<Conversion>> _function_3 = (Grid.Column<Conversion> it_1) -> {
        it_1.setSortable(false);
        it_1.setHeader("Fecha");
      };
      ObjectExtensions.<Grid.Column<Conversion>>operator_doubleArrow(_addColumn, _function_3);
      Grid.Column<Conversion> _addColumn_1 = it.addColumn("millasAsString");
      final Procedure1<Grid.Column<Conversion>> _function_4 = (Grid.Column<Conversion> it_1) -> {
        it_1.setSortable(false);
        it_1.setHeader("Millas");
      };
      ObjectExtensions.<Grid.Column<Conversion>>operator_doubleArrow(_addColumn_1, _function_4);
      Grid.Column<Conversion> _addColumn_2 = it.addColumn("kilometrosAsString");
      final Procedure1<Grid.Column<Conversion>> _function_5 = (Grid.Column<Conversion> it_1) -> {
        it_1.setSortable(false);
        it_1.setHeader("Kilometros");
      };
      ObjectExtensions.<Grid.Column<Conversion>>operator_doubleArrow(_addColumn_2, _function_5);
      it.addThemeVariants(
        GridVariant.LUMO_NO_BORDER, 
        GridVariant.LUMO_NO_ROW_BORDERS, 
        GridVariant.LUMO_ROW_STRIPES);
    };
    final Grid<Conversion> grdConversiones = ObjectExtensions.<Grid<Conversion>>operator_doubleArrow(_grid, _function_2);
    Button _button = new Button("Convertir");
    final Procedure1<Button> _function_3 = (Button it) -> {
      final ComponentEventListener<ClickEvent<Button>> _function_4 = (ClickEvent<Button> e) -> {
        this.conversor.setMillas((txtMillas.getValue()).doubleValue());
        this.conversor.convertir();
        lblKilometros.setText(this.conversor.kilometrosAsString());
        grdConversiones.getDataProvider().refreshAll();
      };
      it.addClickListener(_function_4);
      it.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
      it.addClickShortcut(Key.ENTER);
    };
    final Button btnConvertir = ObjectExtensions.<Button>operator_doubleArrow(_button, _function_3);
    this.add(txtMillas, btnConvertir, lblKilometrosPrefijo, lblKilometros, grdConversiones);
  }
}
