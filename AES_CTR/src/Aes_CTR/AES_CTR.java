package Aes_CTR;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES_CTR {
	public static String encrypt_aes_ctr(String pt , byte[] key,byte[] iv) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		SecretKeySpec KEY = new SecretKeySpec(key , "AES");
		IvParameterSpec ivspec = new IvParameterSpec(iv);
		Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE,KEY,ivspec);
		String ct = new String(cipher.doFinal(pt.getBytes()));
		return ct;
		
	}
	public static String decrypt_aes_ctr(String ct , byte[] key , byte[] iv) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		SecretKeySpec KEY = new SecretKeySpec(key , "AES");
		IvParameterSpec ivspec = new IvParameterSpec(iv);
		Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE,KEY,ivspec);
		String pt = new String(cipher.doFinal(ct.getBytes()));	
		return pt;
	}

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		byte[] key = new byte[] {0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07,0x8,0x09,0x0A,0x0B,0x0C,0x0D,0x0E,0x0F};
		byte[] iv = new byte[] {0x00,0x01,0x02,0x03,0x00,0x02,0x01,0x00,0x00,0x00,0x01,0x02,0x00,0x00,0x00,0x00};
		String pt = "Hi this is Shankar" ;
		String ct = encrypt_aes_ctr(pt,key,iv);
		System.out.println("Cipher text : "+ct);
		String pt1 = decrypt_aes_ctr(ct,key,iv);
		System.out.println("Original plain text : "+pt1);
	}

}
