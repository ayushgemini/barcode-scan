package comblog.wixsite.ayushgemini.barcodescan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import info.androidhive.barcode.BarcodeReader;

public class MainActivity extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener {

    BarcodeReader barcodeReader;
    public static String Tag = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcode_scanner);
    }
        @Override
        public void onScanned(Barcode barcode) {
            // single barcode scanned
            Log.d(Tag+"########onScanned","="+barcode.displayValue);
            // playing barcode reader beep sound
            barcodeReader.playBeep();
            Intent intent=new Intent(MainActivity.this,ResultActivity.class);
            intent.putExtra("result",barcode.displayValue);
            startActivity(intent);
           // Toast.makeText(getApplicationContext(),barcode.displayValue,Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onScannedMultiple(List<Barcode> list) {
            // multiple barcodes scanned
            Log.d(Tag+"########ScannedMultiple","="+list);
        }

        @Override
        public void onBitmapScanned(SparseArray<Barcode> sparseArray) {
            // barcode scanned from bitmap image
            Log.d(Tag+"########onBitmapScanned","="+sparseArray);
        }

        @Override
        public void onScanError(String s) {
            // scan error
            Log.d(Tag+"########onScanError","="+s);
        }

        @Override
        public void onCameraPermissionDenied() {
            // camera permission denied
        }
}
