package consts;

public enum Gender {

    MALE('m'),FEMALE('f');

    private char code;

    Gender(char code){
        this.code = code;
    }

    public char getCode() {
        return code;
    }
}
