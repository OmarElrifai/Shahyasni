package com.shahyasni.persistence;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.shahyasni.persistence.Enums.AccomodationType;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.ErrorCodes;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;
import sun.misc.BASE64Decoder;

import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static org.jose4j.keys.RsaKeyUtil.RSA;

public class test {
    public static void main(String[] arg) throws JoseException, MalformedClaimException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, IOException, JOSEException, ParseException {
//        String fac = AccomodationType.privateProperty.name();
//        String facValue = AccomodationType.privateProperty.getAcc();
//        Map<String,String> facMap = new HashMap<String,String>();
//        facMap.put(fac,facValue);
//        for(AccomodationType c:AccomodationType.values()){
//            System.out.println(c);
//
//        }
//        for (Map.Entry<String,String> facMapItem : facMap.entrySet()){
//            System.out.println(facMapItem.getKey());
//            System.out.println(facMapItem.getValue());
//
//        }

        SecureRandom random = new SecureRandom();
        String key = "opopsoioieoewposkosdkopdskpopokepokdopkwopqdokpwpok";
        byte[] sharedSecret = key.getBytes();
        random.nextBytes(key.getBytes(StandardCharsets.UTF_8));

        SecureRandom random1 = new SecureRandom();
        String key1 = "opopsoioieoewposkosdkopdskpopokepokdopkwopqdokpwpok";
        byte[] sharedSecret1 = key1.getBytes();
        random.nextBytes(key.getBytes(StandardCharsets.UTF_8));

// Create HMAC signer
        JWSSigner signer = new MACSigner(sharedSecret);

// Prepare JWS object with "Hello, world!" payload
        JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS256), new Payload("Hello, world!"));

// Apply the HMAC
        jwsObject.sign(signer);

// To serialize to compact form, produces something like
// eyJhbGciOiJIUzI1NiJ9.SGVsbG8sIHdvcmxkIQ.onO9Ihudz3WkiauDO2Uhyuz0Y18UASXlSc1eS0NkWyA
        String s = jwsObject.serialize();

// To parse the JWS and verify it, e.g. on client-side
        jwsObject = JWSObject.parse(s);

        JWSVerifier verifier = new MACVerifier(sharedSecret1);

       System.out.println(jwsObject.verify(verifier));

        System.out.println("Hello, world! "+ jwsObject.getPayload().toString());

    }
}
