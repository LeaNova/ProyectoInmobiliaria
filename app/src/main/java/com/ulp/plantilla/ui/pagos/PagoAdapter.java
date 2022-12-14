package com.ulp.plantilla.ui.pagos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ulp.plantilla.R;
import com.ulp.plantilla.modelo.Pago;
import com.ulp.plantilla.ui.inquilinos.InquilinoAdapter;

import java.util.List;

public class PagoAdapter extends RecyclerView.Adapter<PagoAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<Pago> lista;

    public PagoAdapter(Context context, LayoutInflater layoutInflater, List<Pago> lista) {
        this.context = context;
        this.layoutInflater = layoutInflater;
        this.lista = lista;
    }

    @NonNull
    @Override
    public PagoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.pago_item, parent, false);

        return new PagoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PagoAdapter.ViewHolder holder, int position) {
        Pago pago = lista.get(position);

        holder.tvPagoCodigo.setText(pago.getNumPago()+"");
        holder.tvPagoFecha.setText(pago.getFechaPago());
        holder.tvPagoImporte.setText("$ " + pago.getImporte());
        holder.tvPagoContrato.setText(pago.getContrato().getIdContrato()+"");
        holder.tvDetalle.setText(pago.getDetalle());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPagoCodigo, tvPagoFecha, tvPagoImporte, tvPagoContrato, tvDetalle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPagoCodigo = itemView.findViewById(R.id.tvPagoCodigo);
            tvPagoFecha = itemView.findViewById(R.id.tvPagoFecha);
            tvPagoImporte = itemView.findViewById(R.id.tvPagoImporte);
            tvPagoContrato = itemView.findViewById(R.id.tvPagoContrato);
            tvDetalle = itemView.findViewById(R.id.tvDetalle);
        }
    }
}
