package com.example.zdorovieappshop.Activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zdorovieappshop.Adapter.BestDealAdapter;
import com.example.zdorovieappshop.Adapter.CategoryAdapter;
import com.example.zdorovieappshop.Domain.CategoryDomain;
import com.example.zdorovieappshop.Domain.ItemsDomain;
import com.example.zdorovieappshop.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter catAdapter,bestDealAdapter;
private RecyclerView recyclerViewCat,recyclerViewBestDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initRecyclerviewCat();
        initLocation();
        initRecyclerViewBestDeal();
    }

    private void initLocation() {
        String[] items = new String[]{"Москва, Россия","Дмитров, Россия"};
        final Spinner locationSpin =findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpin.setAdapter(adapter);
    }

    private void initRecyclerviewCat() {
        ArrayList<CategoryDomain> items = new ArrayList<>();
        items.add(new CategoryDomain("cat1","Овощи"));
        items.add(new CategoryDomain("cat2","Фрукты"));
        items.add(new CategoryDomain("cat3","Молочка"));
        items.add(new CategoryDomain("cat4","Напитки"));
        items.add(new CategoryDomain("cat5","Зерновые"));
        recyclerViewCat=findViewById(R.id.catView);
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        catAdapter=new CategoryAdapter(items);
        recyclerViewCat.setAdapter(catAdapter);


    }
    private void initRecyclerViewBestDeal(){
        recyclerViewBestDeal=findViewById(R.id.bestView);
        recyclerViewBestDeal.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        bestDealAdapter=new BestDealAdapter(getData());
        recyclerViewBestDeal.setAdapter(bestDealAdapter);
    }
    public ArrayList<ItemsDomain> getData(){
        ArrayList<ItemsDomain>items = new ArrayList<>();
        items.add(new ItemsDomain("orange","Свежий Апельсин",42.5,"Сочный апельсин, обладающий ярким оранжевым оттенком и освежающим цитрусовым вкусом, является натуральным источником витамина С, который бодрит ваши чувства и поддерживает иммунную систему. Восхитительная закуска, сочетающая в себе полезные свойства и вкус.",4.2));
        items.add(new ItemsDomain("apple", "Свежее Яблоко", 35.0, "Сочное яблоко с хрустящей текстурой и сладким вкусом. Яблоки - отличный источник клетчатки и антиоксидантов, которые помогают укрепить здоровье и защитить организм от различных заболеваний.", 4.5));
        items.add(new ItemsDomain("watermelon", "Сладкий Арбуз", 25.0, "Сочный арбуз с мякотью нежно-красного цвета и сладким, освежающим вкусом. Арбузы - отличный способ утолить жажду и обеспечить организм витаминами и минералами.", 4.7));
        items.add(new ItemsDomain("berry", "Свежая вишня", 45.0, "Ассорти из спелых ягод, включая клубнику, малину, чернику и землянику. Ягоды - низкокалорийный источник витаминов, минералов и антиоксидантов, необходимых для поддержания здоровья и красоты.", 4.8));
        items.add(new ItemsDomain("pineaplle", "Ароматный Ананас", 30.0, "Ароматный ананас с сочной и сладкой мякотью. Ананасы - богатый источник витаминов С и В6, которые помогают поддерживать здоровье сердца, укрепляют иммунитет и помогают улучшить пищеварение.", 4.6));
        items.add(new ItemsDomain("strawberry", "Сладкая Клубника", 50.0, "Сладкая и ароматная клубника, которая прекрасно сочетается с другими фруктами или добавляется в десерты. Клубника - отличный источник витаминов и антиоксидантов, способствующих здоровью кожи и сердца.", 4.9));
        return items;
    }
}