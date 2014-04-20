/**
 * 
 */
package com.gs.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * @author vbancroft
 *
 */
public class Comands {

	/**
	 * usage: java EncryptedProperties test.properties password
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		File f = new File(args[0]);
		EncryptedProperties ep = new EncryptedProperties( args[1] );
		try {
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				ep.load(in);
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String key = null;
			do {
				System.out.print("Enter key: ");
				key = br.readLine();
				System.out.print("Enter value: ");
				String value = br.readLine();
				if (key.length() > 0 && value.length() > 0) {
					ep.setProperty(key, value);
				}
			} while (key != null && key.length() > 0);

			FileOutputStream out = new FileOutputStream(f);
			ep.store(out, "Encrypted Properties File");
			out.close();

			System.out.println("Dump");
			Iterator i = ep.keySet().iterator();
			while (i.hasNext()) {
				String k = (String) i.next();
				String value = (String) ep.get(k);
				System.out.println("   " + k + "=" + value);
			}
		}
		catch (Exception e) {
			System.out.println("Couldn't access encrypted properties file: " + f.getAbsolutePath());
			e.printStackTrace();
		}
	}

}
