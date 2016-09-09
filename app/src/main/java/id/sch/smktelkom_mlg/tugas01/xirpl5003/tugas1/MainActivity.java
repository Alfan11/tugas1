package id.sch.smktelkom_mlg.tugas01.xirpl5003.tugas1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etTahun;
    Button bOk;
    TextView tvHasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editText);
        etTahun = (EditText) findViewById(R.id.editText2);
        bOk = (Button) findViewById(R.id.button);
        tvHasil = (TextView) findViewById(R.id.textView4);


        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                doProcess();
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
            tvHasil.setText("data valid");


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