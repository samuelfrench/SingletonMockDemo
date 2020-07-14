import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.*;

public class ClassUnderTestTest {

    DummyApiClient dummyApiClient = mock(DummyApiClient.class);
    Singleton singletonMock = mock(Singleton.class);

    ClassUnderTest unit = new ClassUnderTest(dummyApiClient);

    @Test
    public void testMethodUnderTestPositive(){
        when(singletonMock.getBool()).thenReturn(true);

        try (MockedStatic<Singleton> staticSingleton = mockStatic(Singleton.class)) {
            staticSingleton.when(Singleton::getSingleton).thenReturn(singletonMock);

            unit.methodUnderTest();

            staticSingleton.verify(Singleton::getSingleton);
            verify(dummyApiClient).doPositive();
        }
    }

    @Test
    public void testMethodUnderTestNegative(){
        when(singletonMock.getBool()).thenReturn(false);

        try (MockedStatic<Singleton> staticSingleton = mockStatic(Singleton.class)) {
            staticSingleton.when(Singleton::getSingleton).thenReturn(singletonMock);

            unit.methodUnderTest();

            staticSingleton.verify(Singleton::getSingleton);
            verify(dummyApiClient).doNegative();
        }
    }
}
