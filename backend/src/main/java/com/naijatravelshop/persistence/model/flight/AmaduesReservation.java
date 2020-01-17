package com.naijatravelshop.persistence.model.flight;

import com.naijatravelshop.persistence.model.generic.AuditModel;
import com.naijatravelshop.persistence.model.payment.BankAccount;
import com.naijatravelshop.persistence.model.portal.PortalUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 06/05/2019
 */

@Entity
@Table(name = "amadues_reservation")
public class AmaduesReservation extends AuditModel implements Serializable {

    @Column(nullable = false)
    private String bookingNumber;
    private String ticketNumber;
    private String issurerCode;
    private long ticketCostInKobo;
    private long ticketNucInKobo;
    private Double ticketNucInDollar;
    private Double dollarExchangeRate;
    @Column(nullable = false)
    private boolean existOnSystem = false;
    private String airlineName;
    private String airlineCode;
    private Timestamp dateSentFromAmadues;
    private String issuerName;
    private Long amountPaidInKobo;
    @Column(nullable = false)
    private Boolean processed = false;
    private Timestamp dateProcessed;
    private Long ticketLeastSellingPriceInKobo;
    private Boolean dateChange = false;
    private Boolean sotoTicket = false;
    private String departureAirportCode;
    private Timestamp ticketPaymentDate;
    private Boolean excelBacklog = false;
    @ManyToOne
    private PortalUser processedBy;
    @ManyToOne
    private PortalUser issuedBy;
    @ManyToOne
    private Markup markup;
    @ManyToOne
    private Commission commission;
    @ManyToOne
    private AirFile airFile;
    @ManyToOne
    private BankAccount bankAccount;

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getIssurerCode() {
        return issurerCode;
    }

    public void setIssurerCode(String issurerCode) {
        this.issurerCode = issurerCode;
    }

    public long getTicketCostInKobo() {
        return ticketCostInKobo;
    }

    public void setTicketCostInKobo(long ticketCostInKobo) {
        this.ticketCostInKobo = ticketCostInKobo;
    }

    public long getTicketNucInKobo() {
        return ticketNucInKobo;
    }

    public void setTicketNucInKobo(long ticketNucInKobo) {
        this.ticketNucInKobo = ticketNucInKobo;
    }

    public Double getTicketNucInDollar() {
        return ticketNucInDollar;
    }

    public void setTicketNucInDollar(Double ticketNucInDollar) {
        this.ticketNucInDollar = ticketNucInDollar;
    }

    public Double getDollarExchangeRate() {
        return dollarExchangeRate;
    }

    public void setDollarExchangeRate(Double dollarExchangeRate) {
        this.dollarExchangeRate = dollarExchangeRate;
    }

    public boolean isExistOnSystem() {
        return existOnSystem;
    }

    public void setExistOnSystem(boolean existOnSystem) {
        this.existOnSystem = existOnSystem;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public Timestamp getDateSentFromAmadues() {
        return dateSentFromAmadues;
    }

    public void setDateSentFromAmadues(Timestamp dateSentFromAmadues) {
        this.dateSentFromAmadues = dateSentFromAmadues;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public Long getAmountPaidInKobo() {
        return amountPaidInKobo;
    }

    public void setAmountPaidInKobo(Long amountPaidInKobo) {
        this.amountPaidInKobo = amountPaidInKobo;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public Timestamp getDateProcessed() {
        return dateProcessed;
    }

    public void setDateProcessed(Timestamp dateProcessed) {
        this.dateProcessed = dateProcessed;
    }

    public Long getTicketLeastSellingPriceInKobo() {
        return ticketLeastSellingPriceInKobo;
    }

    public void setTicketLeastSellingPriceInKobo(Long ticketLeastSellingPriceInKobo) {
        this.ticketLeastSellingPriceInKobo = ticketLeastSellingPriceInKobo;
    }

    public Boolean getDateChange() {
        return dateChange;
    }

    public void setDateChange(Boolean dateChange) {
        this.dateChange = dateChange;
    }

    public Boolean getSotoTicket() {
        return sotoTicket;
    }

    public void setSotoTicket(Boolean sotoTicket) {
        this.sotoTicket = sotoTicket;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public Timestamp getTicketPaymentDate() {
        return ticketPaymentDate;
    }

    public void setTicketPaymentDate(Timestamp ticketPaymentDate) {
        this.ticketPaymentDate = ticketPaymentDate;
    }

    public Boolean getExcelBacklog() {
        return excelBacklog;
    }

    public void setExcelBacklog(Boolean excelBacklog) {
        this.excelBacklog = excelBacklog;
    }

    public PortalUser getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(PortalUser processedBy) {
        this.processedBy = processedBy;
    }

    public PortalUser getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(PortalUser issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Markup getMarkup() {
        return markup;
    }

    public void setMarkup(Markup markup) {
        this.markup = markup;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    public AirFile getAirFile() {
        return airFile;
    }

    public void setAirFile(AirFile airFile) {
        this.airFile = airFile;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
