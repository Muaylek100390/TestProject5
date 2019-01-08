package fahsai.ruts.ac.th.testproject5;

import android.renderscript.Sampler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class First extends AppCompatActivity {

    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference LED,LED1,LED2,LED3;
    public static final String TAG = "LEDs Control";
    public Button Switch, Switch1, Switch2, Switch3;
    public Integer Value1, Value0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        firebaseDatabase = FirebaseDatabase.getInstance();
        LED = firebaseDatabase.getReference("Switch/LED");
        LED1 = firebaseDatabase.getReference("Switch/LED1");
        LED2 = firebaseDatabase.getReference("Switch/LED2");
        LED3 = firebaseDatabase.getReference("Switch/LED3");

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
                    Value0=0;
                } else {
                    Switch1.setText("LED2_OFF");
                    Value0=1;
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
                LED1.setValue(Value0);
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
                    Value0=0;
                } else {
                    Switch2.setText("LED3_OFF");
                    Value0=1;
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
                LED2.setValue(Value0);
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
                    Value0=0;
                } else {
                    Switch3.setText("LED4_OFF");
                    Value0=1;
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
                LED3.setValue(Value0);
            }
        });
    }

}
