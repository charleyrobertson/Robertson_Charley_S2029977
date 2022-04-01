package org.me.gcu.robertson_charley_s2029977.models;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.me.gcu.robertson_charley_s2029977.R;


import java.util.List;

public class ListAdapter extends ArrayAdapter<TrafficItem>  implements OnClickListener {

    private Context c;
    private List<TrafficItem> list;
    public TrafficItem item;

    public ListAdapter(Context contextIn, List<TrafficItem> listIn) {
        super(contextIn, R.layout.card_view, listIn);
        this.c = contextIn;
        this.list = listIn;
    }

    @NonNull
    @Override
    public View getView(int pos, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getApplicationContext().getSystemService(c.LAYOUT_INFLATER_SERVICE);
        View card = inflater.inflate(R.layout.card_view, parent, false);
        TextView title = card.findViewById(R.id.cardview_title);
        TextView desc = card.findViewById(R.id.short_description1);
        TextView cLink = card.findViewById(R.id.link);

        item = list.get(pos);

        cLink.setOnClickListener(view -> {
            onClick(view);
        });


        title.setText(list.get(pos).getTitle());
        desc.setText(list.get(pos).getDescription());

        return card;
    }

    @Override
    public void onClick(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(this.getContext()).create();
        alertDialog.setTitle("More Information");
        alertDialog.setMessage("Link: " + item.getLink() + "\n"
                + "Publish Date: " + item.getPubDate());
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

}