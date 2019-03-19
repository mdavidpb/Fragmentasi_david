package id.sch.smktelkom_mlg.www.fragmentasi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button pesanToast, keluar, tampilList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesanToast = findViewById(R.id.toastBtn);
        keluar = findViewById(R.id.exitBtn);
        tampilList = findViewById(R.id.listDialogBtn);
        pesanToast.setOnClickListener(this);
        keluar.setOnClickListener(this);
        tampilList.setOnClickListener(this);
    }

    //jangan diketik langsung di implement methode
    @Override
    public void onClick(View clicked) {
        switch (clicked.getId()) {
            case R.id.listDialogBtn:
                munculListDialog();
                break;
            case R.id.toastBtn:
                Toast.makeText(this, "Kamu memilih toast",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.exitBtn:
                exit();
                break;
        }
    }

    //methode ini hasil dari create metod padaExit
    private void exit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Apakah Anda Benar ingin " +
                "keluar?").setCancelable(false)
                .setPositiveButton("Ya", new
                        DialogInterface.OnClickListener() {
                            //methode ini hasil dari create metod pada OnClickListener
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                MainActivity.this.finish();
                            }
                        })
                .setNegativeButton("Tidak", new
                        DialogInterface.OnClickListener() {
                            //methode ini hasil dari create metod pada  OnClickListener
                            @Override
                            public void onClick(DialogInterface dialog, int arg1) {
                                dialog.cancel();

                            }
                        }).show();
    }

    //methode ini hasil dari create metod pada munculListDialog
    private void munculListDialog() {
        final CharSequence[] items = {"Programming", "Teknisi",
                "Designer", "Animator", "Developer Web"
        };
        AlertDialog.Builder kk = new AlertDialog.Builder(this);
        kk.setTitle("Pilih Profesi");
        kk.setItems(items, new DialogInterface.OnClickListener() {
            //methode ini hasil dari create metod pada OnClickListener
            @Override
            public void onClick(DialogInterface dialog, int item) {
                Toast.makeText(getApplicationContext(), items[item],
                        Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}