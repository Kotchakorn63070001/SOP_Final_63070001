package com.example.sop_final_63070001.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "/index")
public class ProductView extends VerticalLayout {
    private ComboBox list;
    private TextField name;
    private NumberField cost, profit, price;
    private Button add, update, del, clear;
    private HorizontalLayout panel;

    public ProductView() {
        list = new ComboBox("Product List");
        list.setWidth("600px");
        name = new TextField("Product Name:");
        name.setWidth("600px");
        name.setValue("");
        cost = new NumberField("Product Cost:");
        cost.setWidth("600px");
        cost.setValue(0.0);
        profit = new NumberField("Product Profit:");
        profit.setWidth("600px");
        profit.setValue(0.0);
        price = new NumberField("Product Price");
        price.setWidth("600px");
        price.setValue(0.0);
        price.setEnabled(false);
        panel = new HorizontalLayout();
        add = new Button("Add Product");
        update = new Button("Update Product");
        del = new Button("Delete Product");
        clear = new Button("Clear Product");
        panel.add(add, update, del, clear);
        add(list, name, cost, profit, price, panel);

    }
}
