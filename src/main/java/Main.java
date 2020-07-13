public class Main {
    public static void main(String[] args){
        ClassUnderTest classUnderTest = new ClassUnderTest(new DummyApiClient());
        classUnderTest.methodUnderTest();
    }
}
