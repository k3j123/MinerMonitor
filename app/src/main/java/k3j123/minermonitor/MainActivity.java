package k3j123.minermonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import k3j123.minermonitor.Model.BalanceModel;
import k3j123.minermonitor.Retrofit.RetrofitClient;
import k3j123.minermonitor.Retrofit.RetrofitInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView label;
    private EditText editText;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.addressEditText);
        submit = findViewById(R.id.submitButton);
        label = findViewById(R.id.addressLabel);
        setListener();
    }

    private void setListener(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBalance();
            }
        });
    }

    private void getBalance(){
        RetrofitInterface retrofitInterface = RetrofitClient.getClient().create(RetrofitInterface.class);
        retrofit2.Call<BalanceModel> getBalance = retrofitInterface.getBalance(editText.getText().toString());
        getBalance.enqueue(new Callback<BalanceModel>() {
            @Override
            public void onResponse(Call<BalanceModel> call, Response<BalanceModel> response) {
                Log.e("response", response.toString());
                String data = response.body().getBalance();
                label.setText(data);
//                Log.e("balance", data);
            }

            @Override
            public void onFailure(Call<BalanceModel> call, Throwable t) {

            }
        });
    }
}
