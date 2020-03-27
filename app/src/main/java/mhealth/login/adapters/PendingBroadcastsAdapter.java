package mhealth.login.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mhealth.login.R;
import mhealth.login.dependencies.Tools;
import mhealth.login.dependencies.ViewAnimation;
import mhealth.login.models.BroadCast;

public class PendingBroadcastsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<BroadCast> items = new ArrayList<>();

    private Context context;
    private PendingBroadcastsAdapter.OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(PendingBroadcastsAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public PendingBroadcastsAdapter(Context context, List<BroadCast> items) {
        this.items = items;
        this.context = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public TextView audience;
        public TextView cadre;
        public TextView created_date;
        public TextView created_by;
        public TextView message;
        public ImageButton bt_expand;
        public Button btn_approve;
        public View lyt_expand;
        public View lyt_parent;

        public OriginalViewHolder(View v) {
            super(v);
            audience = (TextView) v.findViewById(R.id.audience);
            cadre = (TextView) v.findViewById(R.id.cadre);
            created_date = (TextView) v.findViewById(R.id.created_date);
            created_by = (TextView) v.findViewById(R.id.created_by);
            message = (TextView) v.findViewById(R.id.message);
            bt_expand = (ImageButton) v.findViewById(R.id.bt_expand);
            btn_approve = (Button) v.findViewById(R.id.btn_approve);
            lyt_expand = (View) v.findViewById(R.id.lyt_expand);
            lyt_parent = (View) v.findViewById(R.id.lyt_parent);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pending_broadcast, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        BroadCast obj = items.get(position);
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            view.audience.setText("Recipients: "+obj.getAudience());
            view.cadre.setText(obj.getCadre());
            view.created_date.setText("On "+obj.getCreated_at());
            view.created_by.setText("Created by: "+obj.getCreated_by());
            view.message.setText(obj.getMessage());

            view.btn_approve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(position);
                    }
                }
            });

            view.bt_expand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean show = toggleLayoutExpand(!obj.expanded, v, view.lyt_expand);
                    items.get(position).expanded = show;
                }
            });


            // void recycling view
            if(obj.expanded){
                view.lyt_expand.setVisibility(View.VISIBLE);
            } else {
                view.lyt_expand.setVisibility(View.GONE);
            }
            Tools.toggleArrow(obj.expanded, view.bt_expand, false);
        }
    }

    private boolean toggleLayoutExpand(boolean show, View view, View lyt_expand) {
        Tools.toggleArrow(show, view);
        if (show) {
            ViewAnimation.expand(lyt_expand);
        } else {
            ViewAnimation.collapse(lyt_expand);
        }
        return show;
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


}

