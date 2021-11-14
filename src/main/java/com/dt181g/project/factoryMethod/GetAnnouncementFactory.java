package com.dt181g.project.factoryMethod;

/**
 * Announcement Factory responsible for creating an Announcement depending on provided String.
 * @author Knud Ronau Larsen
 */
public class GetAnnouncementFactory {

    /**
     * Method to create and return an Announcement if provided String corresponds with name of an Announcement.
     * @param announcementType String with name of wanted type of Announcement
     * @return Announcement if matching name is provided, otherwise null
     */
    public Announcement getAnnouncement(String announcementType) {
        if(announcementType == null) {
            return null;
        }
        if (announcementType.equalsIgnoreCase("CLOSING")) {
            return new Closing();
        } else if (announcementType.equalsIgnoreCase("SALE")) {
            return new Sale();
        } else if (announcementType.equalsIgnoreCase("WARNING")) {
            return new Warning();
        }

        return null;
    }
}
