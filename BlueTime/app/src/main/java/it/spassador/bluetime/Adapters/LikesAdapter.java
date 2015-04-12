package it.spassador.bluetime.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import it.spassador.bluetime.Activities.ModifyTodoTask;
import it.spassador.bluetime.CommonUtilities;
import it.spassador.bluetime.R;
import it.spassador.bluetime.TDA.Todo;

/**
 * Created by stefanopassador on 12/04/15.
 */
public class LikesAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> array;

    public LikesAdapter(Context context, ArrayList<String> array) {
        this.context = context;
        this.array = array;
    }
    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.row_likes, null);
        RelativeLayout mRelativeLayout = (RelativeLayout) view.findViewById(R.id.relative_layout_row_likes);
        TextView title = (TextView) view.findViewById(R.id.textViewLikes);
        title.setText(array.get(i));
        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }
}
