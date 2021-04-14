package javapractice;

public class EagerInitializer {
    private static final EagerInitializer instance = new EagerInitializer();
    //private constructor to avoid client applications to use constructor
    private EagerInitializer(){}
    public static EagerInitializer getInstance(){
        return instance;
    }
}
