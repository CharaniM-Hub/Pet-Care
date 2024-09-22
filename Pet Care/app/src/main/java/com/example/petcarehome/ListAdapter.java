package com.example.petcarehome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Caregiver> {
    public ListAdapter(@NonNull Context context, ArrayList<Caregiver> caregiverArrayList) {
        super(context, R.layout.listitem,caregiverArrayList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Caregiver caregiver = getItem(position);
        if (convertView ==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem,parent,false);
        }

        TextView Rno = convertView.findViewById(R.id.regno);
        TextView Uname = convertView.findViewById(R.id.Uname);
        TextView Fname = convertView.findViewById(R.id.Fname);
        TextView Email = convertView.findViewById(R.id.email);
        TextView Pno = convertView.findViewById(R.id.Pno);
        TextView Password = convertView.findViewById(R.id.password);
        TextView Experience = convertView.findViewById(R.id.Skills);
        TextView Price = convertView.findViewById(R.id.price);


        Rno.setText(caregiver.RegNo);
        Uname.setText(caregiver.UName);
        Fname.setText(caregiver.FName);
        Email.setText(caregiver.Email);
        Pno.setText(caregiver.Pno);
        Password.setText(caregiver.Password);
        Experience.setText(caregiver.Experience);
        Price.setText(caregiver.Price);

        return super.getView(position, convertView, parent);
    }
}
