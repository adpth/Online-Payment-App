package com.vairagi.codes.paymentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.vairagi.codes.paymentapp.Adapter.BurgerAdapter;
import com.vairagi.codes.paymentapp.Adapter.CooldrinkAdapter;
import com.vairagi.codes.paymentapp.Adapter.PizzaAdapter;
import com.vairagi.codes.paymentapp.viewmodel.BurgerModel;
import com.vairagi.codes.paymentapp.viewmodel.DrinkModel;
import com.vairagi.codes.paymentapp.viewmodel.PizzaModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rv_pizza,rv_burger,rv_cooldrinks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loadPizza();
        loadBurger();
        loadCoolDrink();

    }

    private void loadCoolDrink() {

        ArrayList<DrinkModel> model = new ArrayList<>();
        model.add(new DrinkModel("CocaCola","20",R.drawable.drink1));
        model.add(new DrinkModel("Sprite","20",R.drawable.drink2));
        model.add(new DrinkModel("Fanta","20",R.drawable.drink3));
        model.add(new DrinkModel("Monster","20",R.drawable.drink4));
        model.add(new DrinkModel("ThumbsUp","30",R.drawable.drink5));

        rv_cooldrinks=(RecyclerView)findViewById(R.id.rv_cool_drink);
        CooldrinkAdapter adapter = new CooldrinkAdapter(model,this);
        rv_cooldrinks.setItemAnimator(new DefaultItemAnimator());


        rv_cooldrinks.setAdapter(adapter);
    }

    private void loadBurger() {

        ArrayList<BurgerModel> model = new ArrayList<>();
        model.add(new BurgerModel("Burger","124",R.drawable.burger1));
        model.add(new BurgerModel("Burger","124",R.drawable.burger2));
        model.add(new BurgerModel("Burger","142",R.drawable.burger3));
        model.add(new BurgerModel("Burger","172",R.drawable.burger4));
        model.add(new BurgerModel("Burger","98",R.drawable.burger5));

        rv_burger=(RecyclerView)findViewById(R.id.rv_burger);
        BurgerAdapter adapter = new BurgerAdapter(model,this);
        rv_burger.setItemAnimator(new DefaultItemAnimator());


        rv_burger.setAdapter(adapter);
    }

    private void loadPizza() {

        ArrayList<PizzaModel> model = new ArrayList<>();
        model.add(new PizzaModel("Pizza","199",R.drawable.pizza1));
        model.add(new PizzaModel("Pizza","235",R.drawable.pizza2));
        model.add(new PizzaModel("Pizza","323",R.drawable.pizza3));
        model.add(new PizzaModel("Pizza","215",R.drawable.pizza4));
        model.add(new PizzaModel("Pizza","305",R.drawable.pizza5));

        rv_pizza =(RecyclerView)findViewById(R.id.rv_pizza);
        PizzaAdapter adapter = new PizzaAdapter(model,this);
        rv_pizza.setItemAnimator(new DefaultItemAnimator());

        rv_pizza.setAdapter(adapter);
    }
}