package example10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static example10.networking.GetCartItemsHttpEndpoint.Callback;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.Optional;

import example10.networking.GetCartItemsHttpEndpoint;

public class FetchCartItemsUseCaseTest {

    private static final int LIMIT = 10;

    @Mock
    GetCartItemsHttpEndpoint mGetCartItemsHttpEndpointMock;

    FetchCartItemsUseCase SUT;

    @Before
    public void setup() throws Exception {
        SUT = new FetchCartItemsUseCase();
    }

    // * correct limit passed to endpoint
    @Test
    public void fetchCartItems_correctLimit_passedToEndpoint() throws Exception {
        // Arrange
        ArgumentCaptor<Integer> acInt = ArgumentCaptor.forClass(Integer.class);
        // Act
        SUT.fetchCartItemsAndNotify(LIMIT);
        // Assert
        verify(mGetCartItemsHttpEndpointMock).getCartItem(acInt.capture(), any(Callback.class));
        assertEquals(Optional.ofNullable(acInt.getValue()), LIMIT);
    }
    // * success → all observers notified with correct data
    // * unsubscribed observers not notified
    // * general error → observers notified of failure
    // * network error → observers notified of failure

}