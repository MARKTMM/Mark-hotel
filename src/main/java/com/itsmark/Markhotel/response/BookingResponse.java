package com.itsmark.Markhotel.response;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingResponse {
    private long id;
    private LocalDate checkInDate;
    private LocalTime checkOutDate;
    private String guestName;
    private String guestEmail;
    private String guestPhone;
    private int numberOfAdults;
    private int numberOfChildren;
    private int totalNumberOfGuests;
    private String bookingConfirmationCode;

public BookingResponse(long id, LocalDate checkInDate, LocalTime checkOutDate, String bookingConfirmationCode) {
    this.id = id;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.bookingConfirmationCode = bookingConfirmationCode;
}
}
