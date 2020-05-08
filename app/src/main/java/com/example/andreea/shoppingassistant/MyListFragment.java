//package com.example.andreea.shoppingassistant;
//
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//public class MyListFragment extends Fragment {
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.mylist_layout, container, false);
//        return view;
//    }
//
//    ArrayList<Product> products = new ArrayList<>();
//    ListView products_list;
//    String[] categories = {"All", "Fruits & Vegetables", "Diary", "Beauty & Skincare", "Books", "Meat & Seafood", "Cleaning", "Beverages", "Pets", "Other", "Kids", "Bread & Cereal", "Condiments & Spices", "Baking", "Pasta & Rice", "Snacks", "Health", "Household"};
//    ProductAdapter adapter;
//
//    private void initializeViews(View view) {
//        Spinner mySpinner = view.findViewById(R.id.btn_filter);
//        mySpinner.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, categories));
//
//        products_list = view.findViewById(R.id.productsList);
//        adapter = new ProductAdapter(getContext(), products);
//        products_list.setAdapter(adapter);
//
//        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if(position >= 0 && position < categories.length) {
//                    getSelectedCategoryData(categories[position]);
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//    }
//
//    private void getSelectedCategoryData(String category) {
//        ArrayList<Product> pr = new ArrayList<>();
//        if (category == "All") {
//            adapter = new ProductAdapter(getContext(), products);
//        }
//        else {
//            for(Product product : products) {
//                if(product.getCategory().equals(category)) {
//                    pr.add(product);
//                }
//            }
//            adapter = new ProductAdapter(getContext(), pr);
//        }
//        products_list.setAdapter(adapter);
//    }
//
//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        initializeViews(view);
//
//        Button addBtn = view.findViewById(R.id.btn_add_product);
//        addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                View mView = getLayoutInflater().inflate(R.layout.add_product, null);
//                builder.setView(mView);
//                builder.setTitle("Add new product");
//
//                final EditText input_name = mView.findViewById(R.id.input_name);
//                final Spinner input_category = mView.findViewById(R.id.input_type);
//                final EditText input_amount = mView.findViewById(R.id.input_amount);
//
//                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        String name = input_name.getText().toString();
//                        String category = input_category.getSelectedItem().toString();
//                        int amount = Integer.parseInt(input_amount.getText().toString());
//
//                        if(!name.isEmpty()) {
//                            Toast.makeText(getContext(), "You added: " + name + " " + category + " " + amount, Toast.LENGTH_LONG).show();
//                            Product p = new Product(name, category, amount);
//                            products.add(p);
//                            ProductAdapter adapter = new ProductAdapter(getContext(), products);
//                            products_list.setAdapter(adapter);
//                        }
//                    }
//                });
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
//
//                builder.show();
//            }
//        });
//
//        Product p = new Product("ProductName_default", "ProductCategory_default", 10);
//        products.add(p);
//    }
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        ((MyApplication) getActivity().getApplication()).storeData(products);
//    }
//
//}
