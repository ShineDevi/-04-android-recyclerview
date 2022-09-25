package jti.polinema.ac.id.a04androidrecyclerview;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import java.util.ArrayList;

public class AnggotaAdapter extends RecyclerView.Adapter<AnggotaAdapter.HolderData> {
    private final ArrayList<AnggotaKls> dataList;
    public AnggotaAdapter(ArrayList<AnggotaKls> dataList) {
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_anggota, viewGroup, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnggotaAdapter.HolderData holder, int i) {
        holder.txtNama.setText(dataList.get(i).getNama());
        holder.txtAbsen.setText(dataList.get(i).getAbsen());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class HolderData extends RecyclerView.ViewHolder {
        private TextView txtNama, txtAbsen;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.agt_nama);
            txtAbsen = (TextView) itemView.findViewById(R.id.agt_absen);
        }
    }
}


