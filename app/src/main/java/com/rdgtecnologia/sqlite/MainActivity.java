package com.rdgtecnologia.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.security.Key;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try { // tenta

            //Criar do banco de dados

            SQLiteDatabase bd = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Criando a tabela

            bd.execSQL("CREATE TABLE IF NOT EXISTS pessoa (id iNTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))" );

            //Apagar tabela
            //bd.execSQL ("DROP TABLE pessoa");

            //Apagar registro

            bd.execSQL("DELETE FROM pessoa id=1");

            //Inserir dados

            bd.execSQL("INSERT INTO pessoa (nome, idade) VALUES (Pablito, 39)");
            bd.execSQL("INSERT INTO pessoa (nome, idade) VALUES (Adolf, 64)");
            bd.execSQL("INSERT INTO pessoa (nome, idade) VALUES (Stalin, 70)");
            bd.execSQL("INSERT INTO pessoa (nome, idade) VALUES (Lenin, 65)");
            bd.execSQL("INSERT INTO pessoa (nome, idade) VALUES (Josef, 88)");
            bd.execSQL("INSERT INTO pessoa (nome, idade) VALUES (Putin, 50)");

            //Atualizar dados
            bd.execSQL("UPDATE pessoa SET idade = 70 WHERE id = 4");

            //between 20 qnd 35
            //order by idade desc limit 3
            //Recuperar as pessoas
            Cursor cursor = bd.rawQuery("SELECT id, nome, idade FROM pessoa", null);

            //indices da tabela

            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
                    while (cursor != null); {
                        String id =  cursor.getString(indiceId);
                        String nome = cursor.getString(indiceNome);
                        String idade = cursor.getString(indiceIdade);

                Log.i("RESULTADO - id", id+"/nome/"+nome+"/idade/"+idade );

                cursor.moveToNext();
            }

          }catch (Exception e){
            e.printStackTrace();
        }
    }
}