/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityLogger {

    private Queue queue;
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public ActivityLogger() {
        this.queue = new Queue(9); 
    }


    public void logLogin(String username) {
        String activity = String.format("[%s] 🔓 %s logged in",
                timeFormat.format(new Date()), username);
        queue.enqueue(activity);
    }

    public void logAddDog(String username, String dogName) {
        String activity = String.format("[%s]  %s added dog: %s",
                timeFormat.format(new Date()), username, dogName);
        queue.enqueue(activity);
    }

    public void logDeleteDog(String username, String dogName) {
        String activity = String.format("[%s] ️ %s deleted dog: %s",
                timeFormat.format(new Date()), username, dogName);
        queue.enqueue(activity);
    }

    public void logUpdateDog(String username, String dogName) {
        String activity = String.format("[%s]️ %s updated dog: %s",
                timeFormat.format(new Date()), username, dogName);
        queue.enqueue(activity);
    }

    public void logSubmitApplication(String username, String applicantName) {
        String activity = String.format("[%s] %s submitted app for: %s",
                timeFormat.format(new Date()), username, applicantName);
        queue.enqueue(activity);
    }

    public void logApproveApplication(String username, int appId) {
        String activity = String.format("[%s] %s approved app #%d",
                timeFormat.format(new Date()), username, appId);
        queue.enqueue(activity);
    }

    public void logRejectApplication(String username, int appId) {
        String activity = String.format("[%s] %s rejected app #%d",
                timeFormat.format(new Date()), username, appId);
        queue.enqueue(activity);
    }

    public void logBanUser(String admin, String bannedUser) {
        String activity = String.format("[%s] %s banned user: %s",
                timeFormat.format(new Date()), admin, bannedUser);
        queue.enqueue(activity);
    }

    public void logUnbanUser(String admin, String unbannedUser) {
        String activity = String.format("[%s] %s unbanned user: %s",
                timeFormat.format(new Date()), admin, unbannedUser);
        queue.enqueue(activity);
    }

    // Generic log method
    public void log(String action, String username, String details) {
        String activity = String.format("[%s] %s %s: %s",
                timeFormat.format(new Date()), action, username, details);
        queue.enqueue(activity);
    }

    // Get all activities as array
    public String[] getRecentActivities() {
        return queue.getAllActivities();
    }

    // Get activities as single string
    public String getActivitiesAsString() {
        String[] activities = queue.getAllActivities();
        if (activities.length == 0) {
            return "No recent activities.";
        }

        StringBuilder sb = new StringBuilder();
        for (String activity : activities) {
            sb.append(activity).append("\n");
        }
        return sb.toString();
    }

    public void clearActivities() {
        queue.clear();
    }

    public int getActivityCount() {
        return queue.getSize();
    }
}
