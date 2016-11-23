package br.com.marvelapi.commons;

import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;

import br.com.marvelapi.repository.MarvelRestRepository;

public class MD5Utils {

	private static final String MD5 = "MD5";
	private static final Logger log = LoggerFactory.getLogger(MarvelRestRepository.class);

	public static String getHash(Object... args) {
		if (args == null || args.length == 0) {
			throw new InvalidParameterException("Informe ao menos um argumento.");
		}
		String chave = Joiner.on("").join(args);

		MessageDigest m;
		try {
			m = MessageDigest.getInstance(MD5);
			m.update(chave.toString().getBytes(), 0, chave.length());
			return stringHexa(m.digest());
		} catch (NoSuchAlgorithmException e) {
			log.error("Ocorreu um erro ao tentar encriptar uma chave de segurança", e.getMessage());
			throw new RuntimeException(e.getMessage());
		}

	}

	private static String stringHexa(byte[] bytes) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
			int parteBaixa = bytes[i] & 0xf;
			if (parteAlta == 0) {
				s.append('0');
			}
			s.append(Integer.toHexString(parteAlta | parteBaixa));
		}
		return s.toString();
	}
}
