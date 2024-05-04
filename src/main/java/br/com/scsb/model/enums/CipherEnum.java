package br.com.scsb.model.enums;

public enum CipherEnum {

    //AES CIPHER
    AES_CBC_PKCS5PADDING("AES/CBC/PKCS5Padding"),
    AES_ECB_PKCS5PADDING("AES/ECB/PKCS5Padding"),
    AES_CFB_PKCS5PADDING("AES/CFB/PKCS5Padding"),
    AES_OFB_PKCS5PADDING("AES/OFB/PKCS5Padding"),
    AES_CTR_PKCS5PADDING("AES/CTR/PKCS5Padding");

    private final String cipher;

    public String getCipher() {
        return this.cipher;
    }

    CipherEnum(final String cipher) {
        this.cipher = cipher;
    }
}
