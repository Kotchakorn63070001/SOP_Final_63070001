package com.example.sop_final_63070001;

import com.example.sop_final_63070001.ProductService.Product;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;

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
        this.fetchData();


        cost.addValueChangeListener(event -> {
//            Notification show = Notification.show("enter");
            String cost1 = String.valueOf(cost.getValue());
            String profit1 = String.valueOf(profit.getValue());
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("cost", cost1);
            formData.add("profit", profit1);


            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/calculate")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            price.setValue(Double.parseDouble(out));
        });


    }
    private void fetchData(){
        ArrayList<Product> allProduct = WebClient.create()
                .get()
                .uri("http://localhost:8080/getProducts")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ArrayList<Product>>() {})
                .block();
//        for (int i=0; i< allProduct.size(); i++){
//            list.setItems(allProduct.get(i).getProductName());
//        }
        list.setItems(allProduct);

    }
}
