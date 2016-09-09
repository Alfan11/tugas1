package id.sch.smktelkom_mlg.tugas01.xirpl5003.tugas1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etTahun;
    Spinner spinner;
    Button bOk;
    TextView tvHasil;
    RadioButton rbL, rbP;
    CheckBox cbT, cbM, cbL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editText);
        etTahun = (EditText) findViewById(R.id.editText2);
        spinner = (Spinner) findViewById(R.id.spin);
        bOk = (Button) findViewById(R.id.button);
        rbL = (RadioButton) findViewById(R.id.radioButtonL);
        rbP = (RadioButton) findViewById(R.id.radioButtonP);
        cbT = (CheckBox) findViewById(R.id.checkBoxT);
        cbM = (CheckBox) findViewById(R.id.checkBoxM);
        cbL = (CheckBox) findViewById(R.id.checkBoxL);

        tvHasil = (TextView) findViewById(R.id.textView4);


        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nama = etNama.getText().toString();
                String tahun = etTahun.getText().toString();

                String asal = spinner.getSelectedItem().toString();

                String hsl1 = null;
                if (rbL.isChecked()) {
                    hsl1 = rbL.getText().toString();
                } else if (rbP.isChecked()) {
                    hsl1 = rbL.getText().toString();
                }

                String hsl2 = "Hal Kesukaan Anda :\n";
                int startlen = hsl2.length();
                if (cbT.isChecked()) hsl2 += cbT.getText() + "\n";
                if (cbM.isChecked()) hsl2 += cbM.getText() + "\n";
                if (cbL.isChecked()) hsl2 += cbL.getText() + "\n";

                if (hsl2.length() == startlen) hsl2 += "Belum Pernah Memilih";

                tvHasil.setText("Nama Depan :\n" + nama + "\n\nTahun : \n" + tahun + "\n\nJenis Kelamim : \n" + hsl1 + "\n\n Asal Kota : \n" + asal + "\n\n" + hsl2);
            }
        });

        etTahun.setText("");
        etNama.setText("");

    }

    private void doProcess()
    {
        if(isValid())
        {
            String nama =  etNama.getText().toString();
            int tahun = Integer.parseInt(etTahun.getText().toString());



        }
    }

    private boolean isValid()
    {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();

        if(nama.isEmpty())
        {
            etNama.setError("Nama belum diisi");
            valid = false;
        }
        else if(nama.length()<3)
        {
            etNama.setError("Harus lebih dari 3 huruf");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }

        if(tahun.isEmpty())
        {
            etTahun.setError("Isi tahun lahir anda");
            valid = false;
        }
        else if(tahun.length()!=4)
        {
            etTahun.setError("Tahun lahir salah");
            valid = false;
        }
        else
        {
            etTahun.setError(null);
        }
        return valid;
    }
}