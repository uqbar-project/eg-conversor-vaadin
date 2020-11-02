package org.uqbar;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
@Route
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
@SuppressWarnings("all")
public class ConversorViewBinding extends VerticalLayout {
  private ConversorDomain conversor = new ConversorDomain();
  
  /**
   * Construct a new Vaadin view.
   * <p>
   * Build the initial UI state for the user accessing the application.
   * 
   * @param service The message service. Automatically injected Spring managed bean.
   */
  public ConversorViewBinding() {
    final Binder<ConversorDomain> binder = new Binder<ConversorDomain>(ConversorDomain.class);
    NumberField _numberField = new NumberField("Millas");
    final Procedure1<NumberField> _function = (NumberField it) -> {
      it.addThemeName("bordered");
    };
    final NumberField txtMillas = ObjectExtensions.<NumberField>operator_doubleArrow(_numberField, _function);
    binder.<Double>forField(txtMillas).bind("millas");
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
    Button _button = new Button("Convertir");
    final Procedure1<Button> _function_2 = (Button it) -> {
      final ComponentEventListener<ClickEvent<Button>> _function_3 = (ClickEvent<Button> e) -> {
        try {
          binder.writeBean(this.conversor);
          this.conversor.convertir();
          lblKilometros.setText(this.conversor.kilometrosAsString());
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      it.addClickListener(_function_3);
      it.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
      it.addClickShortcut(Key.ENTER);
    };
    final Button btnConvertir = ObjectExtensions.<Button>operator_doubleArrow(_button, _function_2);
    this.addClassName("centered-content");
    this.add(txtMillas, btnConvertir, lblKilometrosPrefijo, lblKilometros);
  }
}