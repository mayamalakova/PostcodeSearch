package com.maya.postcode.json;

/**
 * Details about a postcode e.g:
 * "postcode": "CV5 6LB",
 "quality": 1,
 "eastings": 431933,
 "northings": 278452,
 "country": "England",
 "nhs_ha": "West Midlands",
 "longitude": -1.53205720956661,
 "latitude": 52.4031550166749,
 "parliamentary_constituency": "Coventry North West",
 "european_electoral_region": "West Midlands",
 "primary_care_trust": "Coventry Teaching",
 "region": "West Midlands",
 "lsoa": "Coventry 030C",
 "msoa": "Coventry 030",
 "incode": "6LB",
 "outcode": "CV5",
 "admin_district": "Coventry",
 "parish": "Coventry, unparished area",
 "admin_county": null,
 "admin_ward": "Whoberley",
 "ccg": "NHS Coventry and Rugby",
 "nuts": "Coventry",
 "codes": {
 "admin_district": "E08000026",
 "admin_county": "E99999999",
 "admin_ward": "E05001233",
 "parish": "E43000246",
 "ccg": "E38000038",
 "nuts": "UKG33"
 }
 */
public class PostcodeDetails {
    private String postcode;
    private String country;
    private String region;
    private String admin_district;

    public PostcodeDetails() {
    }

    @Override
    public String toString() {
        return String.format("Postcode: %s, Country: %s, Region: %s", postcode, country, region);
    }
}
