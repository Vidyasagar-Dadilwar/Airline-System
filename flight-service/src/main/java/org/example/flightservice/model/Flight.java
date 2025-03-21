    package org.example.flightservice.model;

    import jakarta.persistence.Entity;
    import jakarta.persistence.Table;
    import jakarta.persistence.Id;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import lombok.Getter;
    import lombok.Setter;
    import lombok.AllArgsConstructor;
    import lombok.NoArgsConstructor;
    import lombok.ToString;

    @Entity
    @Table(name = "flights")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public class Flight {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Double price;
        private Integer capacity;
        private String origin;
        private String destination;
        private String flightNumber;
        private Integer availableSeats;
    }
