public class SingleTonPattern {
    //lazy one

    private static SingleTonPattern singleTon;

    private SingleTonPattern(){
        System.out.println("Private constructor of singleton Class");
    }

    public static SingleTonPattern getSingleTon() {
        synchronized (SingleTonPattern.class) {
            if(singleTon==null){
                singleTon=new SingleTonPattern();
            }
        }
        return singleTon;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Calling finalize method"
                + " of the Object class"+this.hashCode());
        super.finalize();
    }
}
