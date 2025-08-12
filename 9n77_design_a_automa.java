import java.util.ArrayList;
import java.util.List;

public class APIAutomatedNotifier {

    private String serviceName;
    private String apiKey;
    private List<String> subscriberEmails;

    public APIAutomatedNotifier(String serviceName, String apiKey) {
        this.serviceName = serviceName;
        this.apiKey = apiKey;
        this.subscriberEmails = new ArrayList<>();
    }

    public void addSubscriber(String email) {
        this.subscriberEmails.add(email);
    }

    public void removeSubscriber(String email) {
        this.subscriberEmails.remove(email);
    }

    public void notifySubscribers(String message) {
        for (String email : this.subscriberEmails) {
            sendNotificationEmail(email, message);
        }
    }

    private void sendNotificationEmail(String email, String message) {
        // Implement email sending logic using a mail sender library
        System.out.println("Sending notification to " + email + ": " + message);
    }

    public void checkAPIStatus() {
        // Implement API status checking logic using HTTP requests
        String apiStatus = getAPIStatusFromServer(this.apiKey);
        if (!apiStatus.equals("OK")) {
            notifySubscribers("API " + this.serviceName + " is experiencing issues: " + apiStatus);
        }
    }

    private String getAPIStatusFromServer(String apiKey) {
        // Implement API call to check status using HTTP requests
        return "OK"; // Replace with actual API response
    }

    public static void main(String[] args) {
        APIAutomatedNotifier notifier = new APIAutomatedNotifier("My API", "MY_API_KEY");
        notifier.addSubscriber("user1@example.com");
        notifier.addSubscriber("user2@example.com");

        notifier.checkAPIStatus();
    }
}