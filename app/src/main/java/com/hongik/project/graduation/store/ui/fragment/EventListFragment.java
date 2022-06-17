package com.hongik.project.graduation.store.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hongik.project.graduation.store.R;
import com.hongik.project.graduation.store.ui.network.ProductListFetcher;
import com.hongik.project.graduation.store.ui.network.response.ProductDto;

import java.util.List;

public class EventListFragment extends Fragment {

    public static String TAG = "EventListFragment";
    private LiveData<List<ProductDto>> productList;
    private RecyclerView eventListRecyclerView;
    private EventListAdapter eventListAdapter;


    private class EventListHolder extends RecyclerView.ViewHolder{

        private ProductDto product;
        private TextView productNameTextView;
        private TextView productPriceTextView;
        private TextView productConvenienceStoreTextView;
        private ImageView productImageUrlImageView;
        private TextView productEventType;

        public void bind(ProductDto product){
            this.product = product;
            productNameTextView.setText(this.product.getName());
            productPriceTextView.setText(this.product.getPrice().toString());
            productConvenienceStoreTextView.setText(this.product.getConvenienceStore());
            Glide.with(getContext()).load(product.getProductImgUrl()).into(productImageUrlImageView);
//            productEventType.setText(this.product.getEventType().toString());
        }

        public EventListHolder(@NonNull View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.product_name);
            productPriceTextView = itemView.findViewById(R.id.product_price);
            productConvenienceStoreTextView = itemView.findViewById(R.id.product_convenience_store);
            productImageUrlImageView = itemView.findViewById(R.id.product_image);
//            productEventType =itemView.findViewById(R.id.product_event_type);
        }
    }

    private class EventListAdapter extends RecyclerView.Adapter<EventListHolder>{
        private List<ProductDto> productList;

        public EventListAdapter(List<ProductDto> productList) {
            this.productList = productList;
        }

        @NonNull
        @Override
        public EventListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = getLayoutInflater().inflate(R.layout.list_item_product, parent, false);
            return new EventListHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull EventListHolder holder, int position) {
            ProductDto product = productList.get(position);
            holder.bind(product);
        }

        @Override
        public int getItemCount() {
            return productList.size();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate start");


        productList = new ProductListFetcher().fetchContents();



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView start");
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);

        eventListRecyclerView = view.findViewById(R.id.event_list_recycler_view);
        eventListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productList.observe(getViewLifecycleOwner(), new Observer<List<ProductDto>>() {
            @Override
            public void onChanged(List<ProductDto> productDtos) {
                updateUI(productDtos);
            }
        });
    }

    private void updateUI(List<ProductDto> productList){
        Log.d(TAG, "updateUI -> " + productList);
        eventListAdapter = new EventListAdapter(productList);
        eventListRecyclerView.setAdapter(eventListAdapter);

    }

}
