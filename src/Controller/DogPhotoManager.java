/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Shahil
 */
public class DogPhotoManager {

    private Map<Integer, String> dogPhotoPaths = new HashMap<>();
    private Map<Integer, ImageIcon> cachedPhotos = new HashMap<>();

    // Add/Update photo for a dog
    public void addPhoto(int dogId, String photoPath) {
        dogPhotoPaths.put(dogId, photoPath);
        cachedPhotos.remove(dogId); // Clear cache
    }

    // Get photo path for a dog
    public String getPhotoPath(int dogId) {
        return dogPhotoPaths.get(dogId);
    }

    // Check if dog has photo
    public boolean hasPhoto(int dogId) {
        return dogPhotoPaths.containsKey(dogId);
    }

    // Remove photo
    public void removePhoto(int dogId) {
        dogPhotoPaths.remove(dogId);
        cachedPhotos.remove(dogId);
    }

    // Get ImageIcon for display (with caching)
    public ImageIcon getPhotoIcon(int dogId, int width, int height) {
        if (!hasPhoto(dogId)) {
            return getDefaultPhoto(width, height);
        }

        // Check cache first
        if (cachedPhotos.containsKey(dogId)) {
            return cachedPhotos.get(dogId);
        }

        try {
            String path = getPhotoPath(dogId);
            ImageIcon originalIcon = new ImageIcon(path);
            Image scaled = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaled);

            cachedPhotos.put(dogId, scaledIcon);
            return scaledIcon;
        } catch (Exception e) {
            return getDefaultPhoto(width, height);
        }
    }

    private ImageIcon getDefaultPhoto(int width, int height) {
        // Create a default "no photo" icon
        return new ImageIcon(new ImageIcon("default_dog.png")
                .getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    // Load initial photos (optional)
    public void loadInitialPhotos() {
        addPhoto(1, "photos/buddy.jpg");
        addPhoto(2, "photos/bella.jpg");
        addPhoto(3, "photos/charlie.jpg");
    }
}
