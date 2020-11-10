package model.persistence;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class GamerDAO {

	// op 1 si es dato por dato
	// op 2 si volcamos todo el objeto
	public boolean save(GamerDTO o, int op) { // file Not foun IO Expecion

		boolean isOK = false;

		if (op == 1) { // sacar dato a dato
			DataOutputStream out;
			try {
				out = new DataOutputStream(new FileOutputStream("./Data/Data.dat"));

				out.writeUTF(o.getNickName());
				out.writeInt(o.getIdGamer());

				// Complaeetar con los atributos que hace falta

				out.close();
				isOK = true;

			} catch (IOException e) {

				isOK = false;
				System.err.println(e.getMessage());
			}
		} else if (op == 2) {

			ObjectOutputStream salida;
			try {
				salida = new ObjectOutputStream(new FileOutputStream("./Data/Data.obj"));
				salida.writeObject(o);
				salida.close();
				isOK = true;
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				e.printStackTrace();
			}

		}

		return isOK;
	}

	public GamerDTO load(String file, int op) { // file Not foun IO Expecion

		GamerDTO o = null;

		if (op == 1) {
			DataInputStream inp;
			try {
				inp = new DataInputStream(new FileInputStream("./Data/" + file + ".dat"));

				o = new GamerDTO();
				o.setNickName(inp.readUTF());
				o.setIdGamer(inp.readInt());

				// TODO COMPLETAR LOS DATDOS QUE TIENIE

				inp.close();

			} catch (IOException e) {

				System.err.println(e.getMessage());
			}
		} else if (op == 2) {

			ObjectInputStream input;
			try {

				input = new ObjectInputStream(new FileInputStream("./Data/" + file + ".obj"));
				try {
					o = (GamerDTO) input.readObject();
				} catch (ClassNotFoundException e) {
					System.err.println("Class not found" + e.getMessage());
					e.printStackTrace();
				}

				input.close();

			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				e.printStackTrace();
			}

		}

		return o;
	}

	
	
	
	///// Array list 
	
	

	///// Array list 
	
	/**
	public boolean save(ArrayList<GamerDTO> o) { // file Not foun IO Expecion

		boolean isOK = false;

		ObjectOutputStream salida;
		try {
			salida = new ObjectOutputStream(new FileOutputStream("./Data/DataAll.obj"));
			
			for (GamerDTO e : o) {
				salida.writeObject(e);
			}
			
			salida.close();
			isOK = true;
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		return isOK;
	}

	public ArrayList<GamerDTO> loadAll(String file) { // file Not foun IO Expecion

		ArrayList<GamerDTO> o = null;

		ObjectInputStream input;
		try {

			input = new ObjectInputStream(new FileInputStream("./Data/" + file + ".obj"));
			try {
				o =new ArrayList<GamerDTO>(); 
				
				
				Object obj = null;
				while ((obj = input.readObject()) != null) {
				    if (obj instanceof GamerDTO) {
				    GamerDTO ab = ( GamerDTO) obj;
				    o .add(ab);
				    }
				    
				   
				    input.close();
				}
			} catch (ClassNotFoundException e) {
				System.err.println("Class not found" + e.getMessage());
				e.printStackTrace();
			}

			input.close();

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		return o;
	}



	***/

	public boolean save(ArrayList<GamerDTO> o) { // file Not foun IO Expecion

		boolean isOK = false;

		ObjectOutputStream salida;
		try {
			salida = new ObjectOutputStream(new FileOutputStream("./Data/DataAll.obj"));
			salida.writeObject(o);
			salida.close();
			isOK = true;
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		return isOK;
	}

	public ArrayList<GamerDTO> loadAll() { // file Not foun IO Expecion

		ArrayList<GamerDTO> o = null;

		ObjectInputStream input;
		try {

			input = new ObjectInputStream(new FileInputStream("./Data/DataAll.obj"));
			try {
				o =new ArrayList<GamerDTO>();
						o = (ArrayList<GamerDTO>) input.readObject(); 
			} catch (ClassNotFoundException e) {
				System.err.println("Class not found" + e.getMessage());
				e.printStackTrace();
			}

			input.close();

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		return o;
	}
}
