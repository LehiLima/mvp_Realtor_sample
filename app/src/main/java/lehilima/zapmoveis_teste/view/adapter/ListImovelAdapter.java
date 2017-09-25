package lehilima.zapmoveis_teste.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.text.NumberFormat;

import lehilima.zapmoveis_teste.R;
import lehilima.zapmoveis_teste.data.model.Imoveis;
import lehilima.zapmoveis_teste.view.DetailImovelActivity;
import lehilima.zapmoveis_teste.view.MainActivity;
import lehilima.zapmoveis_teste.view.SplashActivity;


public class ListImovelAdapter extends RecyclerView.Adapter<ListImovelAdapter.MyViewHolder>  {

    private Imoveis list_imoveis;

    public Context mcontext;
    public  Activity mactivity;
    public static Bitmap b;


    private NumberFormat nf = NumberFormat.getCurrencyInstance();

    public ListImovelAdapter(Imoveis imoveis, Context context, Activity activity) {
        list_imoveis = imoveis;
        mcontext = context;
        mactivity = activity;
    }

    // Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
    @Override
    public ListImovelAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a layout
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.custom_list_imoveis_item, null);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    // Called by RecyclerView to display the data at the specified position.
    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int position ) {

        try {
            String valor = nf.format(Double.parseDouble(list_imoveis.getImoveis().get(position).getPrecoVenda().toString()));
            valor = valor.replace(",00","");
            viewHolder.subtipo.setText(list_imoveis.getImoveis().get(position).getSubtipoImovel().toString());
            viewHolder.valor.setText(valor);
            viewHolder.endereco.setText(list_imoveis.getImoveis().get(position).getEndereco().getLogradouro().toString());
            viewHolder.informacoes.setText(list_imoveis.getImoveis().get(position).getInfo().toString());

            if (list_imoveis.getImoveis().get(position).getSubTipoOferta().equals("Normal")){
                viewHolder.destaque.setHeight(15);
                viewHolder.destaque.getLayoutParams().height = 15;
                viewHolder.destaque.setBackgroundColor(mcontext.getResources().getColor(R.color.colorPrimary));
            }else {
                viewHolder.destaque.setHeight(60);
                viewHolder.destaque.getLayoutParams().height = 60;
                viewHolder.destaque.setBackgroundColor(mcontext.getResources().getColor(R.color.purple));
            }
            viewHolder.destaque.setText(list_imoveis.getImoveis().get(position).getSubTipoOferta());
            viewHolder.destaque.setVisibility(View.VISIBLE);

            Picasso.with(viewHolder.itemView.getContext())
                    .load(list_imoveis.getImoveis().get(position).getUrlImagem())
                    .fit()
                    .error(R.drawable.ic_crop_original_grey_24dp)
                    .into(viewHolder.ImovelImg);
        }catch (Exception e){

            Log.e("Erro ao popular lista",e.toString());

        }



        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mactivity, DetailImovelActivity.class);
                intent.putExtra("idImovel", list_imoveis.getImoveis().get(position).getCodImovel());
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mactivity, viewHolder.ImovelImg ,"imgImovel");
                mcontext.startActivity(intent);
            }
        });
    }

    // initializes some private fields to be used by RecyclerView.
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView valor;
        public TextView endereco;
        public TextView informacoes;
        public TextView destaque;
        public TextView subtipo;
        public ImageView ImovelImg;


        public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            valor = (TextView) itemLayoutView.findViewById(R.id.valor);
            endereco = (TextView) itemLayoutView.findViewById(R.id.endereco);
            informacoes = (TextView) itemLayoutView.findViewById(R.id.informacoes);
            destaque = (TextView) itemLayoutView.findViewById(R.id.destaque);
            subtipo = (TextView) itemLayoutView.findViewById(R.id.subtipo);
            ImovelImg = (ImageView) itemLayoutView.findViewById(R.id.imageimovel);

        }
    }

    //Returns the total number of items in the data set hold by the adapter.
    @Override
    public int getItemCount() {
        return list_imoveis.getImoveis().size();
    }

}