package com.kelompok16.tugasppbkelompok16;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanIntentResult;
import com.journeyapps.barcodescanner.ScanOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;

public class DashboardActivity extends AppCompatActivity {

    private ImageView icBarcode, icAbsen, icLogout, icJadwal, imgProfile;
    private TextView txtNamaDash, txtNIMDash;
    private DBHelper myDB;
    private String emailLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initWidget();

        getDataIntent();

        icBarcode.setOnClickListener(v -> {
            ScanOptions options = new ScanOptions();
            options.setPrompt("For flash use volume up key");
            options.setOrientationLocked(true);
            options.setCameraId(0);
            options.setBeepEnabled(false);
            options.setCaptureActivity(ScanActivity.class);
            barcodeLauncher.launch(options);
        });

        icAbsen.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, AbsenActivity.class);
            intent.putExtra("nimLogin", txtNIMDash.getText());
            startActivity(intent);
        });

        icJadwal.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, JadwalActivity.class);
            startActivity(intent);
        });

        icLogout.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        imgProfile.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
            intent.putExtra("email", emailLogin);
            startActivity(intent);
        });


    }

    void initWidget() {
        icBarcode = (ImageView) findViewById(R.id.ic_barcode);
        icAbsen = (ImageView) findViewById(R.id.ic_show_absence);
        icLogout = (ImageView) findViewById(R.id.ic_logout);
        icJadwal = (ImageView) findViewById(R.id.ic_jadwal);
        imgProfile = (ImageView) findViewById(R.id.imgProfile);
        txtNamaDash = (TextView) findViewById(R.id.txtNamaDashboard);
        txtNIMDash = (TextView) findViewById(R.id.txtNIMDashboard);
        myDB = new DBHelper(DashboardActivity.this);
    }

    void getDataIntent(){
        Intent loginIntent = getIntent();
        emailLogin = loginIntent.getStringExtra("email");

        if(emailLogin.equals("refandasuryasaputra@gmail.com")){
            txtNamaDash.setText("Refanda Surya Saputra");
            txtNIMDash.setText("21120120120022");
        }else if(emailLogin.equals("imamnuralim@gmail.com")){
            txtNamaDash.setText("Imam Nuralim");
            txtNIMDash.setText("21120120120016");
        }else if(emailLogin.equals("muhammadghulamabdul@gmail.com")){
            txtNamaDash.setText("Muhammad Ghulam Abdul Nasr");
            txtNIMDash.setText("21120120120029");
        }else if(emailLogin.equals("muhammadrafianwar@gmail.com")){
            txtNamaDash.setText("Muhammad Rafi Anwar");
            txtNIMDash.setText("21120120140174");
        }else if(emailLogin.equals("fatihrizkyhakim@gmail.com")){
            txtNamaDash.setText("Fatih Rizky Hakim");
            txtNIMDash.setText("21120120140170");
        }else if(emailLogin.equals("hafizhanjarsaputra@gmail.com")){
            txtNamaDash.setText("Hafizh Anjar Saputra");
            txtNIMDash.setText("21120120140143");
        }else{
            txtNIMDash.setText("Nama Lengkap");
            txtNIMDash.setText("NIM");
        }
    }

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(), result -> {
        if (result != null) {
            try{
                addDataAbsen(result);
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "Nothing", Toast.LENGTH_SHORT).show();
        }
    });


    void addDataAbsen(ScanIntentResult resultContract) {
        String uid = UUID.randomUUID().toString();

        String result = resultContract.getContents();
        StringTokenizer tokens = new StringTokenizer(result, "#");
        String nim = tokens.nextToken();
        String nama = tokens.nextToken();

        String tanggal = new SimpleDateFormat("d-M-yyyy", Locale.getDefault()).format(new Date());
        String jam = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        String status = "";
        boolean isLate = false;

        try {
            Date time1 = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).parse(jam);

            Date time2 = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).parse("08:00:00");

            if (time1 != null)
                isLate = time1.after(time2);

            if(!isLate)
                status = "Tepat";
            else
                status = "Terlambat";

        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean cekSimpan = myDB.insertDataAbsensi(uid, nim, nama, tanggal, jam, status);

        if(cekSimpan){
            Toast.makeText(DashboardActivity.this, "Absen berhasil", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(DashboardActivity.this, "Anda sudah absen!!!", Toast.LENGTH_SHORT).show();
        }
    }
}