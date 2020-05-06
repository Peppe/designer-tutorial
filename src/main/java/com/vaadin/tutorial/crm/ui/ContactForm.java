package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.tutorial.crm.backend.entity.Company;
import com.vaadin.tutorial.crm.backend.entity.Contact;
import com.vaadin.tutorial.crm.backend.service.CompanyService;

import java.util.List;

/**
 * A Designer generated component for the contact-form template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("contact-form")
@JsModule("./src/views/contact-form.js")
public class ContactForm extends PolymerTemplate<ContactForm.ContactFormModel> {

    Binder<Contact> binder = new BeanValidationBinder<>(Contact.class);
    @Id("firstName")
    private TextField firstName;
    @Id("lastName")
    private TextField lastName;
    @Id("emailField")
    private EmailField email;
    @Id("companyField")
    private ComboBox<Company> company;
    @Id("statusField")
    private ComboBox<Contact.Status> status;
    @Id("saveButton")
    private Button saveButton;
    @Id("deleteButton")
    private Button deleteButton;
    @Id("closeButton")
    private Button closeButton;

    /**
     * Creates a new ContactForm.
     */
    public ContactForm(CompanyService companyService) {
        // You can initialise any data required for the connected UI components here.
        binder.bindInstanceFields(this);

        company.setItems(companyService.findAll());
        company.setItemLabelGenerator(Company::getName);
        status.setItems(Contact.Status.values());

    }

    /**
     * This model binds properties between ContactForm and contact-form
     */
    public interface ContactFormModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
