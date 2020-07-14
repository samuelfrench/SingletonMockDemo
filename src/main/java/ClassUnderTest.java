public class ClassUnderTest {

    private DummyApiClient dummyApiClient;

    public ClassUnderTest(DummyApiClient dummyApiClient){
        this.dummyApiClient = dummyApiClient;
    }

    public void methodUnderTest(){
        if(Singleton.getSingleton().getBool()){
            dummyApiClient.doPositive();
        } else {
            dummyApiClient.doNegative();
        }
    }
}