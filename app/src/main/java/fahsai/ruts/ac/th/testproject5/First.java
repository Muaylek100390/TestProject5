package fahsai.ruts.ac.th.testproject5;

import android.renderscript.Sampler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Map;

public class First extends AppCompatActivity {

    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference LED,LED1,LED2,LED3,Refer,Refer1,Refer2;
    public static final String TAG = "LEDs Control";
    public Button Switch, Switch1, Switch2, Switch3;
    public Integer Value1, Value0, Value01, Value02, Value03;
    public String Data;
    public TextView txtname,textview,textview1,textview2,textview3,txtTemp,txtHumid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        firebaseDatabase = FirebaseDatabase.getInstance();
        LED = firebaseDatabase.getReference("LED");
        LED1 = firebaseDatabase.getReference("LED1");
        LED2 = firebaseDatabase.getReference("LED2");
        LED3 = firebaseDatabase.getReference("LED3");

        Refer = firebaseDatabase.getReference();
        Refer1 = firebaseDatabase.getReference();
        Refer2 = firebaseDatabase.getReference();

        txtname = (TextView)  findViewById(R.id.txtViewname);

        textview = (TextView) findViewById(R.id.txtView2);
        textview1 = (TextView) findViewById(R.id.txtView1);
        textview2 = (TextView) findViewById(R.id.txtView3);
        textview3 = (TextView) findViewById(R.id.txtView4);
        txtHumid = (TextView) findViewById(R.id.txtHumid);
        txtTemp = (TextView) findViewById(R.id.txtTemp);



        Refer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                Data = String.valueOf(map.get("Name"));
                txtname.setText(Data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Refer1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                Data = String.valueOf(map.get("LED"));
                textview.setText(Data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Refer1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                Data = String.valueOf(map.get("LED1"));
                textview2.setText(Data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Refer1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                Data = String.valueOf(map.get("LED2"));
                textview1.setText(Data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Refer1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                Data = String.valueOf(map.get("LED3"));
                textview3.setText(Data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Refer2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                Data = String.valueOf(map.get("humid"));
                txtHumid.setText(Data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Refer2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                Data = String.valueOf(map.get("temp"));
                txtTemp.setText(Data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        Switch = (Button) findViewById(R.id.button3);
        LED.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Value1 = dataSnapshot.getValue(Integer.class);
                //Log.d(TAG,"Value is"+ Value1);
                if (Value1==1) {
                    Switch.setText("LED1_ON");
                    Value0=0;
                } else {
                    Switch.setText("LED1_OFF");
                    Value0=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.w(TAG,"Failed",databaseError.toException());
            }
        });

        Switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LED.setValue(Value0);
            }
        });

        Switch1 = (Button) findViewById(R.id.button2);
        LED1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Value1 = dataSnapshot.getValue(Integer.class);
                //Log.d(TAG,"Value is"+ Value1);
                if (Value1==1) {
                    Switch1.setText("LED2_ON");
                    Value01=0;
                } else {
                    Switch1.setText("LED2_OFF");
                    Value01=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.w(TAG,"Failed",databaseError.toException());
            }
        });

        Switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LED1.setValue(Value01);
            }
        });

        Switch2 = (Button) findViewById(R.id.button5);
        LED2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Value1 = dataSnapshot.getValue(Integer.class);
                //Log.d(TAG,"Value is"+ Value1);
                if (Value1==1) {
                    Switch2.setText("LED3_ON");
                    Value02=0;
                } else {
                    Switch2.setText("LED3_OFF");
                    Value02=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.w(TAG,"Failed",databaseError.toException());
            }
        });

        Switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LED2.setValue(Value02);
            }
        });

        Switch3 = (Button) findViewById(R.id.button4);
        LED3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Value1 = dataSnapshot.getValue(Integer.class);
                //Log.d(TAG,"Value is"+ Value1);
                if (Value1==1) {
                    Switch3.setText("LED4_ON");
                    Value03=0;
                } else {
                    Switch3.setText("LED4_OFF");
                    Value03=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.w(TAG,"Failed",databaseError.toException());
            }
        });

        Switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LED3.setValue(Value03);
            }
        });
    }

}
