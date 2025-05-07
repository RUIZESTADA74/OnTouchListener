package JR.TokioSchool.OnTouchListener;

import static android.graphics.Color.green;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.coroutines.Delay;
import kotlinx.coroutines.GlobalScope;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ly_fondo = findViewById(R.id.ly_fondo);
        Spinner sp_notas = findViewById(R.id.sp_notas);
        TextView tv_mensaje = findViewById(R.id.tv_mensaje);
        TextView tv_calificar = findViewById(R.id.tv_calificar);


        sp_notas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ly_fondo.setOnTouchListener((View, MotionEvent) -> {
                    float x = MotionEvent.getX();
                    float y = MotionEvent.getY();
                    int zonainiciox = 290;
                    int zonafinx = 734;
                    int zonainicioy = 590;
                    int zonafiny = 660;
                    switch (MotionEvent.getAction()) {
                        case android.view.MotionEvent.ACTION_DOWN:
                            if (x >= zonainiciox && x <= zonafinx && y >= zonainicioy && y <= zonafiny) {
                            ly_fondo.setBackgroundColor(Color.GREEN);
                            tv_calificar.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24);
                            String nota = sp_notas.getSelectedItem().toString();
                            int notaint = Integer.parseInt(nota);
                            String mensajesalida = getResources().getQuantityString(R.plurals.mensaje,notaint,nota,notaint);
                            tv_mensaje.setText(mensajesalida);
                            }else{
                            ly_fondo.setBackgroundColor(Color.RED);
                            }
                            break;
                        case android.view.MotionEvent.ACTION_UP:
                            ly_fondo.setBackgroundColor(Color.WHITE);
                            tv_calificar.setTextSize(TypedValue.COMPLEX_UNIT_DIP,34);

                            break;
                    }
                    return true;
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}

