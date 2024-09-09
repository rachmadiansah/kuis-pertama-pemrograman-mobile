import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rachmadiansah.tanjung.kuis.Mahasiswa;

import java.util.List;

public class MahasiswaAdapter extends BaseAdapter {

    private Context context;
    private List<Mahasiswa> mahasiswaList;

    public MahasiswaAdapter(Context context, List<Mahasiswa> mahasiswaList) {
        this.context = context;
        this.mahasiswaList = mahasiswaList;
    }

    @Override
    public int getCount() {
        return mahasiswaList.size();
    }

    @Override
    public Object getItem(int position) {
        return mahasiswaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_mahasiswa, parent, false);
        }

        TextView tvNama = convertView.findViewById(R.id.tv_nama);
        TextView tvNim = convertView.findViewById(R.id.tv_nim);
        TextView tvProgramStudi = convertView.findViewById(R.id.tv_program_studi);

        Mahasiswa mahasiswa = mahasiswaList.get(position);
        tvNama.setText(mahasiswa.namaLengkap);
        tvNim.setText(mahasiswa.nim);
        tvProgramStudi.setText(mahasiswa.programStudi);

        return convertView;
    }

    public void updateData(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        notifyDataSetChanged();
    }
}
