package example10.networking;

import java.util.List;

public interface GetCartItemsHttpEndpoint {
    enum FailReason {
        GENERAL_ERROR,
        NETWORK_ERROR
    }

    interface Callback {
        void onGetCartItemsSucceeded(List<CartItemSchema> cartItems);

        void onGetCartItemFailed(FailReason failReason);
    }

    public void getCartItem(int limit, Callback callback);
}
