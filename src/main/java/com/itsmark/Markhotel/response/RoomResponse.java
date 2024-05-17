package com.itsmark.Markhotel.response;

import java.sql.Blob;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class RoomResponse {
    private long id;
    private String roomType;
    private String roomDescription;
    private double roomPrice;
    private boolean roomAvailability;
    private String roomImage;
    private List<BookingResponse> bookings;

public RoomResponse(long id, String roomType, double roomPrice) {
    this.id = id;
    this.roomType = roomType;
    this.roomPrice = roomPrice;
}

public RoomResponse(long id, String roomType, String roomDescription, double roomPrice, boolean roomAvailability, byte[] imageBytes, List<BookingResponse> bookings) {
    this.id = id;
    this.roomType = roomType;
    this.roomDescription = roomDescription;
    this.roomPrice = roomPrice;
    this.roomAvailability = roomAvailability;
    this.roomImage = imageBytes != null ? Base64.encodeBase64String(imageBytes) : null;
    this.bookings = bookings;
}

}
