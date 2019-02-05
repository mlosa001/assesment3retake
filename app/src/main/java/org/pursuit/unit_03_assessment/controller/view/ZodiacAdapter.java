package org.pursuit.unit_03_assessment.controller.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.model.Zodiac;
import org.pursuit.unit_03_assessment.view.ZodiacViewHolder;

import java.util.List;

public class ZodiacAdapter extends RecyclerView.Adapter<ZodiacViewHolder> {


    List<Zodiac> zodiacList;

    public ZodiacAdapter(List<Zodiac> zodiacList) {
        this.zodiacList = zodiacList;
    }

    @NonNull
    @Override

    //creates view holders on recycler view. calld by RV
    public ZodiacViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zodiac_item_view, viewGroup, false);
        return new ZodiacViewHolder(childView);
    }

    //binds data
    @Override
    public void onBindViewHolder(@NonNull ZodiacViewHolder zodiacViewHolder, int i) {
        Zodiac planet = zodiacList.get(i);
        zodiacViewHolder.onBind(planet);
    }


    //teslls RV how many times it has to recycle its views, how large data set
    @Override
    public int getItemCount() {
        return zodiacList.size();
    }

}




