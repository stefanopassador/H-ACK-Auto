package it.spassador.bluetime.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import it.spassador.bluetime.R;
import it.spassador.bluetime.TDA.TodoTask;

/**
 * Created by stefanopassador on 11/04/15.
 */
public class TodoTaskAdapter extends BaseAdapter {
    ArrayList<TodoTask> arrayList;
    Context context;

    public TodoTaskAdapter(Context context, ArrayList<TodoTask> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.row_list_view, null);
        RelativeLayout mRelativeLayout = (RelativeLayout) convertView.findViewById(R.id.relative_layout_row);
        TextView title = (TextView) convertView.findViewById(R.id.textView);
        title.setText(arrayList.get(position).getTitle());
        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "onClickListener()", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return arrayList.get(i).getId();
    }
}

