package org.pursuit.unit_03_assessment.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.unit_03_assessment.DisplayActivity;
import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.model.Zodiac;

public class ZodiacViewHolder extends RecyclerView.ViewHolder {
    public static final String NAME = "NAME.KEY";
    public static final String NUMBER = "NUMBER.KEY";
    public static final String IMAGE = "IMAGE.KEY";
    private CardView cardView;
    TextView title;
    View view;


    public ZodiacViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.recycler_text);
        cardView = itemView.findViewById(R.id.card_view);

    }


    public void onBind(final Zodiac zodiac) {
        title.setText(zodiac.getName());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DisplayActivity.class);
                intent.putExtra(NAME, zodiac.getName());
                intent.putExtra(NUMBER, zodiac.getNumber());
                intent.putExtra(IMAGE, zodiac.getImage());
                v.getContext().startActivity(intent);
            }
        });
    }
}
