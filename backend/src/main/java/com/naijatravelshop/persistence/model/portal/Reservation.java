package com.naijatravelshop.persistence.model.portal;

import com.naijatravelshop.persistence.model.enums.ProcessStatus;
import com.naijatravelshop.persistence.model.enums.ReservationType;
import com.naijatravelshop.persistence.model.enums.SupplierGroupType;
import com.naijatravelshop.persistence.model.flight.FlightBookingDetail;
import com.naijatravelshop.persistence.model.generic.AuditModel;
import com.naijatravelshop.persistence.model.hotel.HotelBookingDetail;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 07/05/2019
 */
@Entity
@Getter
@Setter
@Data
@Table(name = "reservation")
public class Reservation extends AuditModel implements Serializable {
    @Column(nullable = false)
    private String bookingNumber;
    private Timestamp datePaid;
    private Long amountPaidInKobo;
    private Long supplierPrice;
    private Long margin;
    private Long sellingPrice;
    private ReservationType reservationType;
    @Column(nullable = false)
    private ProcessStatus reservationStatus;
    private Long transactionFeeInKobo;
    private Long actualAmountInKobo;
    private Long cancellationCostInKobo = 0L;
    private Long refundAmountInKobo = 0L;
    private String ticketNumber;
    private Timestamp dateProcessed;
    private Timestamp dateTicketed;
    private Boolean processing = false;
    private SupplierGroupType supplierGroupType;
    @ManyToOne
    private ReservationOwner reservationOwner;
    @ManyToOne
    private PortalUser processedBy;
    @ManyToOne
    private PortalUser paymentConfirmedBy;
    @ManyToOne
    private PortalUser ticketedBy;
    @OneToOne
    private HotelBookingDetail hotelBookingDetail;
    @OneToOne
    private FlightBookingDetail flightBookingDetail;
}
