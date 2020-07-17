import mockit.Expectations;
import mockit.Mocked;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClassUnderTestTest {
    @Mocked
    DummyApiClient dummyApiClient;

    @Mocked
    Singleton singletonMock;

    ClassUnderTest unit;

    @BeforeEach
    public void beforeEach(){
        unit = new ClassUnderTest(dummyApiClient);
    }

    @Test
    public void testMethodUnderTestPositive(){
        new Expectations(){{
            singletonMock.getBool(); result = true;
            Singleton.getSingleton(); result = singletonMock;
            dummyApiClient.doPositive();
        }};

        unit.methodUnderTest();
    }


    @Test
    public void testMethodUnderTestNegative(){
        new Expectations(){{
            singletonMock.getBool(); result = false;
            Singleton.getSingleton(); result = singletonMock;
            dummyApiClient.doNegative();
        }};

        unit.methodUnderTest();
    }
}
