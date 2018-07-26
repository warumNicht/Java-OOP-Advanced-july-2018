package p02_services;

public class Main {
    public static void main(String[] args) {
        NotificationService comp=new CompositeNotificationService(true,new SmsNotificationService(true),
                new EmailNotificationService(true));

        OnlineStoreOrder order=new OnlineStoreOrder(comp);
        order.process();
    }
}
