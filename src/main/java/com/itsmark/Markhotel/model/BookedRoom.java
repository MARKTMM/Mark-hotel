package com.itsmark.Markhotel.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId; // Primary key for BookedRoom entity

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room; // Lazy-loaded link to Room entity
    @Column(name = "guest_FullName")
    private String guestFullName; // Guest's full name
    @Column(name = "guest_Email")
    private String guestEmail; // Guest's email address
    @Column(name = "guest_PhoneNumber")
    private int guestPhoneNumber; // Guest's phone number
    @Column(name = "children")
    private int numberOfChildren; // Number of children in the booking
    @Column(name = "adults")
    private int numberOfAdults; // Number of adults in the booking
    @Column(name = "total_Guests")
    private int totalNumberOfGuests; // Total number of guests
    @Column(name = "checkin")
    private LocalDate checkInDate; // Check-in date
    @Column(name = "checkout")
    private LocalDate checkOutDate; // Check-out date
    @Column(name = "confirmation_Code")
    private String bookingConfirmationCode; // Booking confirmation code
   
   /**
    * Calculates the total number of guests by adding the number of children and adults.
    */
   public void calculateTotalNumberOfGuests() {
      this.totalNumberOfGuests = this.numberOfChildren + this.numberOfAdults;
   }

   public void setNumberOfChildren(int numberOfChildren) {
    // Set the number of children for the booking
    this.numberOfChildren = numberOfChildren;
    // Recalculate the total number of children after updating the number of adults
    calculateTotalNumberOfGuests();
}
   public void setNumberOfAdults(int numberOfAdults) {
    // Set the number of adults for the booking
    this.numberOfAdults = numberOfAdults;
    // Recalculate the total number of guests after updating the number of adults
    calculateTotalNumberOfGuests();
}
   public void setBookingConfirmationCode(String bookingConfirmationCode) {
       // Set the booking confirmation code for the booking
       this.bookingConfirmationCode = bookingConfirmationCode;
   }

}
