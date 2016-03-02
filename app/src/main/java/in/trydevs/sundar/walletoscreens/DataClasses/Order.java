package in.trydevs.sundar.walletoscreens.DataClasses;

/**
 * Created by jmprathab on 27/02/16.
 */
public class Order {
    MenuItem item;
    int quantity = 1;
    OrderTime time = OrderTime.BREAKFAST;

    //Other Possible Fields
    //int orderId;
    //Date date;

    public Order(MenuItem item, int quantity, OrderTime time) {
        this.item = item;
        this.quantity = quantity;
        this.time = time;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderTime getTime() {
        return time;
    }

    public int getOrderAmount() {
        return Integer.parseInt(this.item.getPrice()) * this.quantity;
    }

    public String getTimeForTextView() {
        String text = "Today's";
        if (time == OrderTime.BREAKFAST) {
            text += " Breakfast - 10:00am to 12:00am";
        } else if (time == OrderTime.LUNCH) {
            text += " Lunch - 1:00pm to 2:00pm";
        } else {
            text += " Dinner - 9:00pm to 10:00pm";
        }
        return text;
    }

    public enum OrderTime {
        BREAKFAST, LUNCH, DINNER;
    }
}
