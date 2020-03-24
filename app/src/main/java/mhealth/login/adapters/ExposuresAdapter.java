package mhealth.login.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import mhealth.login.R;
import mhealth.login.dependencies.Constants;
import mhealth.login.dependencies.Tools;
import mhealth.login.dependencies.ViewAnimation;
import mhealth.login.models.CheckIn;
import mhealth.login.models.Exposure;

public class ExposuresAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Exposure> items = new ArrayList<>();

    private Context context;
    private ExposuresAdapter.OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(ExposuresAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ExposuresAdapter(Context context, List<Exposure> items) {
        this.items = items;
        this.context = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public TextView type;
        public TextView location;
        public TextView date;
        public TextView previous_exposure;
        public TextView pep_initiated;
        public TextView patient_hiv;
        public TextView patient_hbv;
        public TextView device_used;
        public TextView device_purpose;
        public TextView description;
        public ImageButton bt_expand;
        public View lyt_expand;
        public View lyt_parent;

        public OriginalViewHolder(View v) {
            super(v);
            type = (TextView) v.findViewById(R.id.type);
            location = (TextView) v.findViewById(R.id.location);
            date = (TextView) v.findViewById(R.id.date);
            previous_exposure = (TextView) v.findViewById(R.id.previous_exposure);
            pep_initiated = (TextView) v.findViewById(R.id.pep_initiated);
            patient_hiv = (TextView) v.findViewById(R.id.patient_hiv);
            patient_hbv = (TextView) v.findViewById(R.id.patient_hbv);
            device_used = (TextView) v.findViewById(R.id.device_used);
            device_purpose = (TextView) v.findViewById(R.id.device_purpose);
            description = (TextView) v.findViewById(R.id.description);
            bt_expand = (ImageButton) v.findViewById(R.id.bt_expand);
            lyt_expand = (View) v.findViewById(R.id.lyt_expand);
            lyt_parent = (View) v.findViewById(R.id.lyt_parent);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exposure, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Exposure obj = items.get(position);
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            String pepInitiated = obj.getPep_initiated() == 0 ? "NO" : "YES";
            view.type.setText(obj.getType());
            view.location.setText(obj.getLocation());
            view.date.setText(obj.getDate());
            view.previous_exposure.setText("Previous Exposures: "+obj.getPrevious_exposures());
            view.pep_initiated.setText("Pep Initiated: "+pepInitiated);
            view.patient_hbv.setText("Patient HBV: "+obj.getPatient_hbv_status());
            view.patient_hiv.setText("Patient HIV: "+obj.getPatient_hiv_status());
            view.device_used.setText("Device Used: "+obj.getDevice_name());
            view.device_purpose.setText("Device Purpose: "+obj.getDevice_purpose());
            view.description.setText(obj.getDescription());
//            view.lyt_parent.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (mOnItemClickListener != null) {
//                        mOnItemClickListener.onItemClick(view, items.get(position), position);
//                    }
//                }
//            });

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

