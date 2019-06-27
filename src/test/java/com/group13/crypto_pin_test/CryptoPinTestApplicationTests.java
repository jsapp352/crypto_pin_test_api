package com.group13.crypto_pin_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CryptoPinTestApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void crypto()
	{
		String message = "Some test message";

		Encryptor cryptonic = new Encryptor();

		String encryptedMessage = cryptonic.Encrypt(message);

		System.out.println(encryptedMessage);

		String decryptedMessage = cryptonic.Decrypt(encryptedMessage);

		System.out.println(decryptedMessage);

		if (!message.equals(decryptedMessage)) throw new AssertionError();
	}

	@Test
	public void encrypt()
	{
		Encryptor cryptonic = new Encryptor();

		String pin = "36";

		System.out.println("Encrypted Pin: " + cryptonic.Encrypt(pin));
	}

}
