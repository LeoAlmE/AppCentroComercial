package mx.edu.utng.recyclerviewstore;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

//import mx.edu.utng.recyclerviewstore.dummy.DummyContent.DummyItem;

import com.bumptech.glide.Glide;

import java.util.List;

public class StoreRecyclerViewAdapter extends RecyclerView.Adapter<StoreRecyclerViewAdapter.ViewHolder> {

    private final List<Store> mValues;
    private Context contexto;

    public StoreRecyclerViewAdapter(Context ctx, List<Store> items) {
        contexto = ctx;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_store, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        try {
            holder.mItem = mValues.get(position);
            holder.tvNombre.setText(holder.mItem.getNombre());
            holder.tvDireccion.setText(holder.mItem.getDireccion());
            holder.rbRestaurante.setRating(holder.mItem.getValoracion());

            Glide.with(contexto)
                    .load(holder.mItem.getUrlPhoto())
                    .centerCrop()
                    .placeholder(R.drawable.store)
                    .error(R.drawable.store)
                    .into(holder.ivPhoto);
        }catch (Exception e){
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvNombre;
        public final TextView tvDireccion;
        public final ImageView ivPhoto;
        public final RatingBar rbRestaurante;
        public Store mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvNombre = (TextView) view.findViewById(R.id.tvNombre);
            tvDireccion = (TextView) view.findViewById(R.id.tvDireccion);
            ivPhoto = (ImageView)view.findViewById(R.id.ivPhoto);
            rbRestaurante = (RatingBar)view.findViewById(R.id.rbValoracion);

        }
        @Override
        public String toString() {
            return super.toString() + " '" + tvNombre.getText() + "'";
        }
    }
}