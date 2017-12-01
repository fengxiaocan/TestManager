package com.evil.testmanager;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.evil.testmanager.ProviderType.*;

@Retention(RetentionPolicy.SOURCE)
@StringDef({AES, AESWRAP, AES_CBC_NoPadding, AES_CBC_PKCS5Padding,
                   AES_CBC_PKCS7Padding, AES_CTR_NoPadding, AES_ECB_NoPadding,
                   AES_ECB_PKCS5Padding, AES_ECB_PKCS7Padding,
                   AES_GCM_NOPADDING, AES_GCM_NoPadding, ARC4, AndroidCAStore,
                   AndroidKeyStore, BKS, BLOWFISH, BouncyCastle, Collection,
                   DES, DESEDE, DESEDEWRAP, DESEDE_CBC_NoPadding,
                   DESEDE_CBC_PKCS5Padding, DH, DSA, Default, EC, ECDH, ECDSA,
                   GCM, HMACMD5, HMACSHA1, HMACSHA224, HMACSHA256, HMACSHA384,
                   HMACSHA512, HmacMD5, HmacSHA1, HmacSHA224, HmacSHA256,
                   HmacSHA384, HmacSHA512, MD5, MD5WITHRSA, MD5WithRSA,
                   MD5withRSA, NONEWITHDSA, NONEwithECDSA, NONEwithRSA, OAEP,
                   PBEWITHHMACSHA, PBEWITHHMACSHA1,
                   PBEWITHMD5AND128BITAES_CBC_OPENSSL,
                   PBEWITHMD5AND192BITAES_CBC_OPENSSL,
                   PBEWITHMD5AND256BITAES_CBC_OPENSSL, PBEWITHMD5ANDDES,
                   PBEWITHMD5ANDRC2, PBEWITHSHA1ANDDES, PBEWITHSHA1ANDRC2,
                   PBEWITHSHA256AND128BITAES_CBC_BC,
                   PBEWITHSHA256AND192BITAES_CBC_BC,
                   PBEWITHSHA256AND256BITAES_CBC_BC,
                   PBEWITHSHAAND128BITAES_CBC_BC, PBEWITHSHAAND128BITRC2_CBC,
                   PBEWITHSHAAND128BITRC4, PBEWITHSHAAND192BITAES_CBC_BC,
                   PBEWITHSHAAND256BITAES_CBC_BC,
                   PBEWITHSHAAND2_KEYTRIPLEDES_CBC,
                   PBEWITHSHAAND3_KEYTRIPLEDES_CBC, PBEWITHSHAAND40BITRC2_CBC,
                   PBEWITHSHAAND40BITRC4, PBEWITHSHAANDTWOFISH_CBC,
                   PBKDF2WithHmacSHA1, PBKDF2WithHmacSHA1And8BIT, PKCS12,
                   PKCS12PBE, PKIX, RSA, RSA_ECB_NoPadding, RSA_ECB_OAEPPadding,
                   RSA_ECB_OAEPWithSHA_1AndMGF1Padding,
                   RSA_ECB_OAEPWithSHA_224AndMGF1Padding,
                   RSA_ECB_OAEPWithSHA_256AndMGF1Padding,
                   RSA_ECB_OAEPWithSHA_384AndMGF1Padding,
                   RSA_ECB_OAEPWithSHA_512AndMGF1Padding, RSA_ECB_PKCS1Padding,
                   SHA1PRNG, SHA1WITHRSA, SHA1WithRSA, SHA1withDSA, SHA1withRSA,
                   SHA1withRSA_PSS, SHA224WITHDSA, SHA224WITHECDSA,
                   SHA224WITHRSA, SHA224WithRSA, SHA224withECDSA, SHA224withRSA,
                   SHA224withRSA_PSS, SHA256WITHDSA, SHA256WITHECDSA,
                   SHA256WITHRSA, SHA256WithRSA, SHA256withECDSA, SHA256withRSA,
                   SHA256withRSA_PSS, SHA384WITHECDSA, SHA384WITHRSA,
                   SHA384WithRSA, SHA384withECDSA, SHA384withRSA,
                   SHA384withRSA_PSS, SHA512WITHECDSA, SHA512WITHRSA,
                   SHA512WithRSA, SHA512withECDSA, SHA512withRSA,
                   SHA512withRSA_PSS, SHA_1, SHA_224, SHA_256, SHA_384, SHA_512,
                   SSL, SSLv3, TLS, TLSv1, TLSv1_1, TLSv1_2, X509, X_509})
/**
 *  @author: Noah QQ:1066537317
 *  @version: 1.0
 *  @desc: 加密算法
 */
public @interface ProviderType {
    String AES_ECB_PKCS7Padding                  = "AES/ECB/PKCS7Padding";
    String AES_CBC_PKCS7Padding                  = "AES/CBC/PKCS7Padding";
    String RSA_ECB_OAEPPadding                   = "RSA/ECB/OAEPPadding";
    String RSA_ECB_OAEPWithSHA_1AndMGF1Padding   = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";
    String RSA_ECB_OAEPWithSHA_224AndMGF1Padding = "RSA/ECB/OAEPWithSHA-224AndMGF1Padding";
    String RSA_ECB_OAEPWithSHA_256AndMGF1Padding = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    String RSA_ECB_OAEPWithSHA_384AndMGF1Padding = "RSA/ECB/OAEPWithSHA-384AndMGF1Padding";
    String RSA_ECB_OAEPWithSHA_512AndMGF1Padding = "RSA/ECB/OAEPWithSHA-512AndMGF1Padding";
    String MD5withRSA                            = "MD5withRSA";
    String SHA1withRSA                           = "SHA1withRSA";
    String SHA224withRSA                         = "SHA224withRSA";
    String SHA256withRSA                         = "SHA256withRSA";
    String SHA384withRSA                         = "SHA384withRSA";
    String SHA512withRSA                         = "SHA512withRSA";
    String SHA1withRSA_PSS                       = "SHA1withRSA/PSS";
    String SHA224withRSA_PSS                     = "SHA224withRSA/PSS";
    String SHA256withRSA_PSS                     = "SHA256withRSA/PSS";
    String SHA384withRSA_PSS                     = "SHA384withRSA/PSS";
    String SHA512withRSA_PSS                     = "SHA512withRSA/PSS";

    String SSL                     = "SSL";
    String SSLv3                   = "SSLv3";
    String TLS                     = "TLS";
    String TLSv1                   = "TLSv1";
    String TLSv1_1                 = "TLSv1.1";
    String TLSv1_2                 = "TLSv1.2";
    String Default                 = "Default";
    String MD5WithRSA              = "MD5WithRSA";
    String SHA1WithRSA             = "SHA1WithRSA";
    String SHA224WithRSA           = "SHA224WithRSA";
    String SHA256WithRSA           = "SHA256WithRSA";
    String SHA384WithRSA           = "SHA384WithRSA";
    String SHA512WithRSA           = "SHA512WithRSA";
    String NONEwithRSA             = "NONEwithRSA";
    String SHA224withECDSA         = "SHA224withECDSA";
    String SHA256withECDSA         = "SHA256withECDSA";
    String SHA384withECDSA         = "SHA384withECDSA";
    String SHA512withECDSA         = "SHA512withECDSA";
    String RSA_ECB_NoPadding       = "RSA/ECB/NoPadding";
    String RSA_ECB_PKCS1Padding    = "RSA/ECB/PKCS1Padding";
    String AES_ECB_NoPadding       = "AES/ECB/NoPadding";
    String AES_ECB_PKCS5Padding    = "AES/ECB/PKCS5Padding";
    String AES_CBC_NoPadding       = "AES/CBC/NoPadding";
    String AES_CBC_PKCS5Padding    = "AES/CBC/PKCS5Padding";
    String AES_CTR_NoPadding       = "AES/CTR/NoPadding";
    String DESEDE_CBC_NoPadding    = "DESEDE/CBC/NoPadding";
    String DESEDE_CBC_PKCS5Padding = "DESEDE/CBC/PKCS5Padding";
    String AES_GCM_NoPadding       = "AES/GCM/NoPadding";
    String HmacMD5                 = "HmacMD5";
    String X509                    = "X509";

    String MD5                                = "MD5";
    String HMACMD5                            = "HMACMD5";
    String SHA_1                              = "SHA-1";
    String HMACSHA1                           = "HMACSHA1";
    String PBEWITHHMACSHA                     = "PBEWITHHMACSHA";
    String PBEWITHHMACSHA1                    = "PBEWITHHMACSHA1";
    String PBKDF2WithHmacSHA1                 = "PBKDF2WithHmacSHA1";
    String PBKDF2WithHmacSHA1And8BIT          = "PBKDF2WithHmacSHA1And8BIT";
    String SHA_224                            = "SHA-224";
    String HMACSHA224                         = "HMACSHA224";
    String SHA_256                            = "SHA-256";
    String HMACSHA256                         = "HMACSHA256";
    String SHA_384                            = "SHA-384";
    String HMACSHA384                         = "HMACSHA384";
    String SHA_512                            = "SHA-512";
    String HMACSHA512                         = "HMACSHA512";
    String PKCS12PBE                          = "PKCS12PBE";
    String GCM                                = "GCM";
    String AESWRAP                            = "AESWRAP";
    String AES_GCM_NOPADDING                  = "AES/GCM/NOPADDING";
    String PBEWITHMD5AND128BITAES_CBC_OPENSSL = "PBEWITHMD5AND128BITAES-CBC-OPENSSL";
    String PBEWITHMD5AND192BITAES_CBC_OPENSSL = "PBEWITHMD5AND192BITAES-CBC-OPENSSL";
    String PBEWITHMD5AND256BITAES_CBC_OPENSSL = "PBEWITHMD5AND256BITAES-CBC-OPENSSL";
    String PBEWITHSHAAND128BITAES_CBC_BC      = "PBEWITHSHAAND128BITAES-CBC-BC";
    String PBEWITHSHAAND192BITAES_CBC_BC      = "PBEWITHSHAAND192BITAES-CBC-BC";
    String PBEWITHSHAAND256BITAES_CBC_BC      = "PBEWITHSHAAND256BITAES-CBC-BC";
    String PBEWITHSHA256AND128BITAES_CBC_BC   = "PBEWITHSHA256AND128BITAES-CBC-BC";
    String PBEWITHSHA256AND192BITAES_CBC_BC   = "PBEWITHSHA256AND192BITAES-CBC-BC";
    String PBEWITHSHA256AND256BITAES_CBC_BC   = "PBEWITHSHA256AND256BITAES-CBC-BC";
    String ARC4                               = "ARC4";
    String PBEWITHSHAAND128BITRC4             = "PBEWITHSHAAND128BITRC4";
    String PBEWITHSHAAND40BITRC4              = "PBEWITHSHAAND40BITRC4";
    String BLOWFISH                           = "BLOWFISH";
    String DES                                = "DES";
    String PBEWITHMD5ANDDES                   = "PBEWITHMD5ANDDES";
    String PBEWITHSHA1ANDDES                  = "PBEWITHSHA1ANDDES";
    String DESEDEWRAP                         = "DESEDEWRAP";
    String DESEDE                             = "DESEDE";
    String PBEWITHSHAAND3_KEYTRIPLEDES_CBC    = "PBEWITHSHAAND3-KEYTRIPLEDES-CBC";
    String PBEWITHSHAAND2_KEYTRIPLEDES_CBC    = "PBEWITHSHAAND2-KEYTRIPLEDES-CBC";
    String PBEWITHMD5ANDRC2                   = "PBEWITHMD5ANDRC2";
    String PBEWITHSHA1ANDRC2                  = "PBEWITHSHA1ANDRC2";
    String PBEWITHSHAAND128BITRC2_CBC         = "PBEWITHSHAAND128BITRC2-CBC";
    String PBEWITHSHAAND40BITRC2_CBC          = "PBEWITHSHAAND40BITRC2-CBC";
    String PBEWITHSHAANDTWOFISH_CBC           = "PBEWITHSHAANDTWOFISH-CBC";
    String X_509                              = "X.509";
    String DSA                                = "DSA";
    String SHA1withDSA                        = "SHA1withDSA";
    String NONEWITHDSA                        = "NONEWITHDSA";
    String SHA224WITHDSA                      = "SHA224WITHDSA";
    String SHA256WITHDSA                      = "SHA256WITHDSA";
    String DH                                 = "DH";
    String ECDH                               = "ECDH";
    String ECDSA                              = "ECDSA";
    String NONEwithECDSA                      = "NONEwithECDSA";
    String SHA224WITHECDSA                    = "SHA224WITHECDSA";
    String SHA256WITHECDSA                    = "SHA256WITHECDSA";
    String SHA384WITHECDSA                    = "SHA384WITHECDSA";
    String SHA512WITHECDSA                    = "SHA512WITHECDSA";
    String OAEP                               = "OAEP";
    String MD5WITHRSA                         = "MD5WITHRSA";
    String SHA1WITHRSA                        = "SHA1WITHRSA";
    String SHA224WITHRSA                      = "SHA224WITHRSA";
    String SHA256WITHRSA                      = "SHA256WITHRSA";
    String SHA384WITHRSA                      = "SHA384WITHRSA";
    String SHA512WITHRSA                      = "SHA512WITHRSA";
    String BKS                                = "BKS";
    String BouncyCastle                       = "BouncyCastle";
    String PKCS12                             = "PKCS12";
    String Collection                         = "Collection";

    String SHA1PRNG = "SHA1PRNG";

    String PKIX           = "PKIX";
    String AndroidCAStore = "AndroidCAStore";

    String AndroidKeyStore = "AndroidKeyStore";
    String EC              = "EC";
    String RSA             = "RSA";
    String AES             = "AES";
    String HmacSHA1        = "HmacSHA1";
    String HmacSHA224      = "HmacSHA224";
    String HmacSHA256      = "HmacSHA256";
    String HmacSHA384      = "HmacSHA384";
    String HmacSHA512      = "HmacSHA512";
}
