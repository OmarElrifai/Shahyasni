package com.shahyasni.services;

//import org.apache.shiro.authc.credential.DefaultPasswordService;
//import org.apache.shiro.authc.credential.PasswordService;
//import org.apache.shiro.codec.Hex;
//import org.apache.shiro.crypto.SecureRandomNumberGenerator;
//import org.apache.shiro.crypto.hash.Sha512Hash;
//import org.apache.shiro.util.ByteSource;


import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.util.ByteSource;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.lang.JoseException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestScoped
public class SecurityUtility {

    private PasswordService passwordService =  new DefaultPasswordService();

    private void generateToken(String subject) throws JoseException {
        RsaJsonWebKey rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
        JwtClaims claims = new JwtClaims();
        claims.setIssuer("http://localhost:8080/Persistence-1.0-SNAPSHOT/ShahYasni/ISO");  // who creates the token and signs it
        claims.setAudience("http://localhost:8080/Persistence-1.0-SNAPSHOT/ShahYasni/ISO/User"); // to whom the token is intended to be sent
        claims.setExpirationTimeMinutesInTheFuture(10); // time when the token will expire (10 minutes from now)
        claims.setGeneratedJwtId(); // a unique identifier for the token
        claims.setIssuedAtToNow();  // when the token was issued/created (now)
        claims.setNotBeforeMinutesInThePast(0); // time before which the token is not yet valid (2 minutes ago)
        claims.setSubject(subject); // the subject/principal is whom the token is about
//        List<String> groups = Arrays.asList("group-one");
//        claims.setStringListClaim("groups", groups);
        JsonWebSignature jws = new JsonWebSignature();

        // The payload of the JWS is JSON content of the JWT Claims
        jws.setPayload(claims.toJson());

        // The JWT is signed using the private key
        jws.setKey(rsaJsonWebKey.getPrivateKey());

        // Set the Key ID (kid) header because it's just the polite thing to do.
        // We only have one key in this example but a using a Key ID helps
        // facilitate a smooth key rollover process
        jws.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());

        // Set the signature algorithm on the JWT/JWS that will integrity protect the claims
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

        // Sign the JWS and produce the compact serialization or the complete JWT/JWS
        // representation, which is a string consisting of three dot ('.') separated
        // base64url-encoded parts in the form Header.Payload.Signature
        // If you wanted to encrypt it, you can simply set this jwt as the payload
        // of a JsonWebEncryption object and set the cty (Content Type) header to "jwt".
        String jwt = jws.getCompactSerialization();


        // Now you can do something with the JWT. Like send it to some other party
        // over the clouds and through the interwebs.
        System.out.println("JWT: " + jwt);
    }

    public boolean validatePassword(String plainTextPassword,String storedSalt, String storedPassword){
        ByteSource salt = ByteSource.Util.bytes(Hex.decode(storedSalt));
        String newHashedPassword = new Sha512Hash(plainTextPassword,salt,200000).toHex();
        return newHashedPassword.equals(storedPassword);
    }
    public Map<String,String> hashPassword(String password){
        Map<String,String> map = new HashMap<>();
        ByteSource salt = generateSalt();
        String hashedPassword = new Sha512Hash(password,salt,200000).toHex();
        map.put("password",hashedPassword);
        map.put("salt",salt.toHex());
        return map;
    }
    public ByteSource generateSalt(){
        return new SecureRandomNumberGenerator().nextBytes();
    }

}
