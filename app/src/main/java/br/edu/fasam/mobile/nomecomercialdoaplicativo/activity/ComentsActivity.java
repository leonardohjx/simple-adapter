package br.edu.fasam.mobile.nomecomercialdoaplicativo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.edu.fasam.mobile.nomecomercialdoaplicativo.R;

public class ComentsActivity extends AppCompatActivity {

    EditText txtComentsId;
    EditText txtComentsName;
    EditText txtComentsEmail;
    EditText txtComentsBody;
    ListView listViewComents;

    List<HashMap<String, String>> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coments);
    }


    @SuppressLint("WrongViewCast")
    public void adicionarComents(View view) {
        //Entrada
        txtComentsId = findViewById(R.id.txtComentsId);
        txtComentsName = findViewById(R.id.txtComentsName);
        txtComentsEmail = findViewById(R.id.txtComentsEmail);
        txtComentsBody = findViewById(R.id.txtComentsBody);

        //Processamento
        String comentsId, name, email, body;
        comentsId = txtComentsId.getText().toString();
        name = txtComentsName.getText().toString();
        email = txtComentsEmail.getText().toString();
        body = txtComentsBody.getText().toString();

        //explicação de como usar o SimpleAdapter no Post Activity
        HashMap<String, String> map = new HashMap<>();
        map.put("comentsId", comentsId);
        map.put("name", name);
        map.put("email", email);
        map.put("body", body);

        lista.add(map);

        //Saída
        String[] from = {"comentsId", "name", "email", "body"};
        int[] to = {R.id.txtItemComentsId, R.id.txtItemComentsName, R.id.txtItemComentsEmail, R.id.txtItemComentsBody};

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, lista, R.layout.item_coments, from, to);

        listViewComents = findViewById((R.id.listViewComents));
        listViewComents.setAdapter((simpleAdapter));


    }
}