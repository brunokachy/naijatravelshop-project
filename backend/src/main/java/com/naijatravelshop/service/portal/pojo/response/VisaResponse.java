package com.naijatravelshop.service.portal.pojo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Bruno on
 * 24/06/2019
 */
@Getter
@ToString
@Builder
public class VisaResponse {

    private Long id;

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

    private Date employmentResumptionDate;

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

    private Date travelDate;

    private Date returnDate;

    private String residentCountry;

    private String destinationCountry;

    private String nationality;

    private boolean processed;
}
