package com.flightgearserver.Utils;

public class Location {
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }

    public static double distance(Location l1, Location l2) {
        double long1 = Math.toRadians(l1.getLongitude());
        double long2 = Math.toRadians(l2.getLongitude());
        double lat1 = Math.toRadians(l1.getLatitude());
        double lat2 = Math.toRadians(l2.getLatitude());

        // Haversine formula
        double dlon = long2 - long1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in miles. Use 6371
        // for kilometers
        double r = 6371;

        // calculate the result
        return (c * r);
    }
}
