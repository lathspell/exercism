import java.math.BigInteger;
import java.util.Random;

public class DiffieHellman {

    public BigInteger privateKey(BigInteger prime) {
        Random rnd = new Random();
        BigInteger bi;
        do {
            bi = new BigInteger(prime.bitCount(), rnd);
        } while (bi.equals(BigInteger.ZERO) || bi.compareTo(prime) == 1);
        return bi;
    }

    public BigInteger publicKey(BigInteger p, BigInteger g, BigInteger privKey) {
        return g.modPow(privKey, p);
    }

    public BigInteger secret(BigInteger prime, BigInteger publicKey, BigInteger privateKey) {
        return publicKey.modPow(privateKey, prime);
    }
}
