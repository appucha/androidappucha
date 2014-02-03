package file.handle.care;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FliehandlingActivity extends Activity {
    /** Called when the activity is first created. */
	EditText edit;
	Button Save,read;
	FileInputStream fIp;
	FileOutputStream fOp;
	File f = new File(Environment.getExternalStorageDirectory()+"/Sh.txt");
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        edit= (EditText)findViewById(R.id.editText1);
		Save= (Button)findViewById(R.id.button1);
		read= (Button)findViewById(R.id.button2);
		Save.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),"file writed",4000).show();
				String value=edit.getText().toString();
				try{
					fOp= new FileOutputStream(f);
					byte b[]= value.getBytes();
					fOp.write(b);
					
				}catch(FileNotFoundException e){
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		     read.setOnClickListener(new OnClickListener(){
		    	 public void onClick(View v) {
		    		 int val;
		    		 try{
		    		 fIp= new FileInputStream(f);
		    		 String input="";
		    		 while((val=fIp.read())!=-1)
		    		 {
		    			 input=input+(char)val;
		    		 }
		    		 edit.setText(null);
		    		 edit.setText(input);
		    		 System.out.println("accessed");
		    		 Toast.makeText(getApplicationContext(),input,4000).show();
		    		 }catch(FileNotFoundException e){
		    			 e.printStackTrace();
		    		 }catch(IOException e){
		    			 e.printStackTrace();
		    		 
		    		 
		    		 }
		    		 }
		    	 });
  
	}
}
			


