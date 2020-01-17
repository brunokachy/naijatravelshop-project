package com.naijatravelshop.persistence.model.visa;

import com.naijatravelshop.persistence.model.generic.AuditModel;
import com.naijatravelshop.persistence.model.portal.Country;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 05/06/2019
 */
@Entity
@Table(name = "visa_request")
@Getter
@Setter
public class VisaRequest extends AuditModel implements Serializable {

    private String middleName;

    private String passportNumber;

    private String passportIssueDate;

    private String passportExpiryDate;

    private String visitedPreviously;

    private Boolean rejectedPreviously;

    private String timesAppliedPreviously;

    private String rejectionReason;

    private Boolean reasonRejectionChanged;

    private Boolean visitedTopCountryBefore;

    private String topCountryVisited;

    private Boolean deportedBefore;

    private Boolean arrestedBefore;

    private Boolean overStayedTopCountryBefore;

    private String topCountryOverstayed;

    private String travelPurpose;

    private String otherPurposes;

    private Boolean involvedInTerrorism;

    private String employmentStatus;

    private String employerName;

    private String positionInCompany;

    private String salaryRange;

    private Timestamp employmentResumptionDate;

    private String natureOfBusiness;

    private String nameOfBusiness;

    private String monthlyTurnover;

    private Integer noOfStaff;

    private Boolean isBusinessRegistered;

    private Boolean applicationCapacity;

    private Boolean hasCashFlow;

    private Boolean isAccountBalanceLow;

    private Boolean duplicateAccountFunction;

    private Boolean provideFundSource;

    private String placeToStay;

    private String requestById;

    private String specialCircumstance;

    private String additionalInfo;

    private String planToReturn;

    private Boolean infoAttestation;

    private Boolean visaAttestation;

    private Boolean requireInsurance;

    private Boolean willInviteeHostYou;

    private Boolean needInvitationLetter;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Timestamp travelDate;

    private Timestamp returnDate;

    @ManyToOne
    private Country residentCountry;

    @ManyToOne
    private VisaCountry destinationCountry;

    @ManyToOne
    private Country nationality;

    private boolean processed;
}
