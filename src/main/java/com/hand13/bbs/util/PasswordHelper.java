package com.hand13.bbs.util;

import com.hand13.bbs.entity.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by hd110 on 2017/10/25.
 * edited by hand13
 */
public class PasswordHelper {
    private String algorithmName;
    private int iterations;
    public PasswordHelper() {
        algorithmName = "md5";
        iterations = 2;
    }
    public void encrypt(User user) {
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        user.setSalt(salt);
        SimpleHash hash = new SimpleHash(algorithmName,user.getPassword(),user.getUserName()+salt,iterations);
        user.setPassword(hash.toHex());
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
}
