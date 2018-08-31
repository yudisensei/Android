package com.example.logonrmlocal.persistencia;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public final String fileName = "texto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**Ler  e salvar arquivo**/
    public void writeFile(String fileName, String conteudo){
       try {
           FileOutputStream fo = openFileOutput(fileName, Context.MODE_PRIVATE);
            fo.write(conteudo.getBytes());
            fo.close();
       }catch(FileNotFoundException e){

       }catch(IOException e){

       }
       }
       public String readFile(String fileName){
        try{
            int data;
            StringBuilder output = new StringBuilder();
            FileInputStream fi = openFileInput(fileName);
            data = fi.read();

            while (data != -1){
                output.append((char)data);
                data = fi.read();
            }
            fi.close();
            return output.toString();

        }catch(FileNotFoundException e){
            return "";
        }catch(IOException e) {
            return "";
        }
       }
        public void gravar(View view){
            EditText et = findViewById(R.id.txtAreaArq);
            writeFile(fileName, et.getText().toString());
    }
        public void recuperar(View view){
            EditText et = findViewById(R.id.txtAreaArq);
            et.setText(readFile(fileName));
        }

}
