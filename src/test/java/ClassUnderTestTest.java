import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Singleton.class)
public class ClassUnderTestTest {

    DummyApiClient dummyApiClient;
    Singleton singletonMock;


    ClassUnderTest unit;

    @Before
    public void beforeEach(){
        dummyApiClient = PowerMock.createMock(DummyApiClient.class);
        singletonMock = PowerMock.createMock(Singleton.class);
        mockStatic(Singleton.class);
        expect(Singleton.getSingleton()).andReturn(singletonMock);

        unit = new ClassUnderTest(dummyApiClient);
    }

    @Test
    public void testMethodUnderTestPositive(){
        expect(singletonMock.getBool()).andReturn(true);
        dummyApiClient.doPositive();
        PowerMock.expectLastCall();
        PowerMock.replayAll();

        unit.methodUnderTest();
    }

    @Test
    public void testMethodUnderTestNegative(){
        expect(singletonMock.getBool()).andReturn(false);
        dummyApiClient.doNegative();
        PowerMock.expectLastCall();
        PowerMock.replayAll();

        unit.methodUnderTest();
    }
}
