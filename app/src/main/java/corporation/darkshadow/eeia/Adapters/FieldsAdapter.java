package corporation.darkshadow.eeia.Adapters;

/**
 * Created by darkshadow on 16/12/17.
 */

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import corporation.darkshadow.eeia.Fragments.HomeFragment;
import corporation.darkshadow.eeia.R;
import corporation.darkshadow.eeia.pojo.Fields;

public class FieldsAdapter extends RecyclerView.Adapter<FieldsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Fields> fieldList;

    public FieldsAdapter(FragmentActivity mContext, List<Fields> fieldList) {
        this.mContext = mContext;
        this.fieldList = fieldList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail;
        public Button buttoncourse;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            buttoncourse = (Button) view.findViewById(R.id.buttoncourse);
        }
    }


    @Override
    public FieldsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.field_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FieldsAdapter.MyViewHolder holder, int position) {

        Fields fields = fieldList.get(position);
        holder.title.setText(fields.getCoursename());
        holder.count.setText(String.valueOf(fields.getNumOfcourse())+" Courses");

        // loading album cover using Glide library
        Glide.with(mContext).load(fields.getThumbnail()).into(holder.thumbnail);

        holder.buttoncourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Wait! It will take some time",Toast.LENGTH_LONG).show();
            }
        });

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Wait! It will take some time",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return fieldList.size();
    }
}
