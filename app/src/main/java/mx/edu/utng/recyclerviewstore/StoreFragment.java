package mx.edu.utng.recyclerviewstore;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class StoreFragment extends Fragment {

    RecyclerView recyclerView;
    public List<Store> storeList;
    private StoreRecyclerViewAdapter adapterStores;
    private StoreLab mStore;

    public StoreRecyclerViewAdapter getAdapterStores() {
        return adapterStores;
    }

    public void setAdapterStores(StoreRecyclerViewAdapter adapterStores) {
        this.adapterStores = adapterStores;
    }

    public StoreLab getmStore() {
        return mStore;
    }

    public void setmStore(StoreLab mStore) {
        this.mStore = mStore;
    }

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    public StoreFragment() {
    }

    @SuppressWarnings("unused")
    public static StoreFragment newInstance(int columnCount) {
        StoreFragment fragment = new StoreFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store_list, container, false);
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            mStore = StoreLab.get(getContext());

            try {
                /*Store store = new Store();
                store.setNombre("American Eagle");
                store.setUrlPhoto("https://medias.fashionnetwork.com/image/upload/v1/medias/b4b7ed5f444e91b595b3bec102d6bd262980494.jpg");
                store.setValoracion(4f);
                store.setDireccion("Local 24 Planta 1");
                mStore.addStore(store);
                Store store2 = new Store();
                store2.setNombre("Calvin Klein");
                store2.setUrlPhoto("https://www.modaes.com/files/000_2016/calvin%20klein/calvin%20klein%20tienda948.jpg");
                store2.setValoracion(4f);
                store2.setDireccion("Local 10 Planta 3");
                mStore.addStore(store2);*/
            }catch (Exception e){
                Toast.makeText(getContext(), "Error: "+e.getMessage(),Toast.LENGTH_LONG).show();
            }
                List<Store> stores = mStore.getStores();
                adapterStores = new StoreRecyclerViewAdapter(getActivity(), stores);
                recyclerView.setAdapter(adapterStores);
        }
        return view;
    }




}