package libs.jackson;

public class DealViews {
    public static final Class<RequestDeal> REQUEST_DEAL = RequestDeal.class;
    public static final Class<UpdateDeal> UPDATE_DEAL = UpdateDeal.class;
    public static final Class UPDATE_ACCOUNT = UpdateDeal.Account.class;

    public static class RequestDeal {

    }

    public static class UpdateDeal {
        public static class Account {

        }

    }
}
