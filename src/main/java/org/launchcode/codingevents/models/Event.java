package org.launchcode.codingevents.models;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {

        private int id;
        private static int nextId = 1;

        @NotBlank(message = "Name is required.")
        @Size(min = 3, max = 50, message = "Name must be between 3 an 50 characters.")
        private String name;

        @NotBlank
        @Size(max = 500, message = "Description too long!")
        private String description;

        @NotBlank
        @Email(message = "Invalid email. Try again.")
        private String contactEmail;

        @NotNull
        @NotBlank(message = "Venue is required!")
        private String venue;

        @NotBlank
        @AssertTrue(message = "Must Register for event.")
        private boolean mustRegister;

        @Positive(message = "Attendees must be 1 or more")
        private int noOfAttendees;

        @NotBlank(message = "Please mention ticket price.")
        @PositiveOrZero(message = "Ticket price zero or higher")
        private Float ticketPrice;

        public Event(String name, String description, String contactEmail, String venue,
                     boolean mustRegister, int noOfAttendees, Float ticketPrice) {
            this();
            this.name = name;
            this.description = description;
            this.contactEmail = contactEmail;
            this.venue = venue;
            this.mustRegister = mustRegister;
            this.noOfAttendees = noOfAttendees;
            this.ticketPrice = ticketPrice;

        }
    public Event() {
        this.id = nextId;
        nextId++;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Event)) return false;
            Event event = (Event) o;
            return getId() == event.getId();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId());
        }
    }

