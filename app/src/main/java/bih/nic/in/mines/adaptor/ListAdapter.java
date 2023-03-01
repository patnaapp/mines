package bih.nic.in.mines.adaptor;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bih.nic.in.mines.R;
import bih.nic.in.mines.entity.DeclarationEntity;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

    private ArrayList<DeclarationEntity> mData;
    private LayoutInflater mInflater;
    ProgressDialog dialog;
    Context context;


    public ListAdapter(Context context, ArrayList<DeclarationEntity> data ) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }


    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adaptor_list, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final DeclarationEntity info = mData.get(position);


       /* holder.tv_unit_name.setText(info.getUnit_Name().equalsIgnoreCase("anytype{}") ? "NA" : info.getUnit_Name());
        holder.tv_unit_code.setText(info.getUnit_Code().equalsIgnoreCase("anytype{}") ? "NA" : info.getUnit_Code());
        holder.tv_address.setText(info.getAddress().equalsIgnoreCase("anytype{}") ? "NA" : info.getAddress());*/
        holder.chk_declaration.setText(info.getDeclaration());


    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder  {
        final CheckBox chk_declaration;
        public View itemView;

        ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            chk_declaration = itemView.findViewById(R.id.chk_declaration);

        }
    }

   /* InspectedFirstPageModel getItem(int id) {
        return mData.get(id);
    }*/
}
