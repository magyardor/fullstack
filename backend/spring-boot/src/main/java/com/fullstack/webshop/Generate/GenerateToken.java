package com.fullstack.webshop.Generate;

/**
 *
 * @author dorcs
 */
import javax.crypto.spec.SecretKeySpec;  
import javax.xml.bind.DatatypeConverter;  
import java.security.Key;  
import java.util.Date;  
import java.util.Random;  
import io.jsonwebtoken.*;

public class GenerateToken {
    public String [] createJWT(String idtoken, String issuer, String subject, long ttlMillis){
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        
        Random random = new Random();
        String secretKey = idtoken + Integer.toString(random.nextInt(1000));
        
        byte [] apiKeySecretByte = DatatypeConverter.parseBase64Binary(secretKey);
        
        Key signingKey = null;
        try{
            signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        }catch(Exception e)
        {
            System.out.println("Exception while generating key " + e.getMessage());
        }
        
         JwtBuilder builder = Jwts.builder().setId(idtoken)  
                                    .setIssuedAt(now)  
                                    .setSubject(subject)  
                                    .setIssuer(issuer)  
                                    .signWith(signatureAlgorithm, signingKey);
        
        if(ttlMillis >=0)
        {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
        }
        
        String [] tokenInfo = {builder.compact(), secretKey};
        return tokenInfo;
    }
}
