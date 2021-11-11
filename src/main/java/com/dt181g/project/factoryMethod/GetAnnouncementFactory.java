package com.dt181g.project.factoryMethod;

public class GetAnnouncementFactory {
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
