package com.itsmark.Markhotel.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {
   // @Id annotation specifies the primary key of an entity.
   @Id
   // @GeneratedValue provides the specification of generation strategies for the values of primary keys.
   // GenerationType.IDENTITY indicates that the persistence provider must assign primary keys for the entity using a database identity column.
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id; // Unique identifier for the room
   
   /** Type of the room (e.g., single, double, suite)
    * @Column annotation specifies the mapped column for a persistent property or field.
    * If no @Column is specified, the default values apply.
    */
   @Column
   private String roomType;
   
   // Price of the room per night
   private BigDecimal roomPrice;
   
   // Availability status of the room (true if available)
   private boolean roomAvailability = true;

   // Image of the room
   @Lob
   private Blob roomImage;
   
   /** @OneToMany annotation defines a many-to-one relationship with another entity.
    * 'fetch = FetchType.LAZY' specifies that the related entities should be loaded lazily when they are accessed for the first time.
    * 'cascade = CascadeType.ALL' specifies that all CascadeType operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH) are to be applied to the related entity.
    */
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   private List<BookedRoom> bookings;

   // This constructor initializes the Room object with a list of bookings.
   public Room( List<BookedRoom> bookings) {
      // Initialize bookings as a new ArrayList to ensure it's not null
      this.bookings = new ArrayList<>();
   }

   public void addBooking(BookedRoom booking) {
      // Check if the bookings list is null and initialize it if necessary
      if (bookings == null) {
         bookings = new ArrayList<>();
      }
      // Add the booking to the bookings list
      bookings.add(booking);
      // Set the room of the booking to this room
      booking.setRoom(this);
      // Update the room's availability status to false
      this.roomAvailability = false;
      // Generate a random numeric string of length 10 to be used as the booking confirmation code
      String bookingCode = RandomStringUtils.randomNumeric(10);
      // Set the generated booking confirmation code to the current booking
      booking.setBookingConfirmationCode(bookingCode);
   }
}
