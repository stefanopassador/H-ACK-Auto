package it.spassador.bluetime.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import it.spassador.bluetime.Activities.ModifyTodoTask;
import it.spassador.bluetime.CommonUtilities;
import it.spassador.bluetime.R;
import it.spassador.bluetime.TDA.Todo;
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
        final int pos = position;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.row_list_view, null);
        RelativeLayout mRelativeLayout = (RelativeLayout) convertView.findViewById(R.id.relative_layout_row);
        TextView title = (TextView) convertView.findViewById(R.id.textView);
        title.setText(arrayList.get(position).getTitle());
        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ModifyTodoTask.class);
                intent.putExtra(CommonUtilities.TODO_TASK, arrayList.get(pos) instanceof Todo ? "todo" : "task");
                intent.putExtra(CommonUtilities.TODO_TASK_ID, arrayList.get(pos).getId());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
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

