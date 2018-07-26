package p02_services;

public class OnlineStoreOrder {

    private NotificationService notifications;

    public OnlineStoreOrder(NotificationService notifications) {
        this.notifications = notifications;
    }


    public void process() {
        if (this.notifications.isActive()){
            notifications.sendNotification();
        }
    }
}
