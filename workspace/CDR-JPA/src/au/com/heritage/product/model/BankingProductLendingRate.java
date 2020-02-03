package au.com.heritage.product.model;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import javax.persistence.*;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class BankingProductLendingRate {

	@Id @GeneratedValue(generator="system-uuid") @Hidden
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
    private String lendingRateId;

    /**
     * The type of rate (fixed, variable, etc). See the next
     * section for an overview of valid values and their meaning
     */
    private LendingRateType lendingRateType;

    /**
     * The rate to be applied
     */
    private BigDecimal rate;

    /**
     * A comparison rate equivalent for this rate
     */
    private BigDecimal comparisonRate;

    /**
     * The period after which the rate is applied to the balance to
     * calculate the amount due for the period. Calculation of the
     * amount is often daily (as balances may change) but
     * accumulated until the total amount is 'applied' to the
     * account (see applicationFrequency). Formatted according to
     * [ISO 8601
     * Durations](https:*en.wikipedia.org/wiki/ISO_8601#Durations)
     */
    private String calculationFrequency;

    /**
     * The period after which the calculated amount(s) (see
     * calculationFrequency) are 'applied' (i.e. debited or
     * credited) to the account. Formatted according to [ISO 8601
     * Durations](https:*en.wikipedia.org/wiki/ISO_8601#Durations)
     */
    private String applicationFrequency;

    /**
     * When loan payments are due to be paid within each period.
     * The investment benefit of earlier payments affect the rate
     * that can be offered
     */
    private InterestPaymentDue interestPaymentDue;

    /**
     * Rate tiers applicable for this rate
     */
    @OneToMany(mappedBy = "lendingRate")
    @Valid
    private List<BankingProductRateTier> tiers = null;

    /**
     * Generic field containing additional information relevant to
     * the lendingRateType specified. Whether mandatory or not is
     * dependent on the value of lendingRateType
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information on the rate.
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this rate
     */
    @Column(length = 64)
    private String additionalInfoUri;

    /**
     * Array of product IDs for products included in the bundle
     */
    @ManyToMany(mappedBy = "bundles")
    private Collection<BankingProductDetail> productDetail;

    public String getLendingRateId() {
        return lendingRateId;
    }

    public void setLendingRateId(String lendingRateId) {
        this.lendingRateId = lendingRateId;
    }

    public LendingRateType getLendingRateType() {
        return lendingRateType;
    }

    public void setLendingRateType(LendingRateType lendingRateType) {
        this.lendingRateType = lendingRateType;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getComparisonRate() {
        return comparisonRate;
    }

    public void setComparisonRate(BigDecimal comparisonRate) {
        this.comparisonRate = comparisonRate;
    }

    public String getCalculationFrequency() {
        return calculationFrequency;
    }

    public void setCalculationFrequency(String calculationFrequency) {
        this.calculationFrequency = calculationFrequency;
    }

    public String getApplicationFrequency() {
        return applicationFrequency;
    }

    public void setApplicationFrequency(String applicationFrequency) {
        this.applicationFrequency = applicationFrequency;
    }

    public InterestPaymentDue getInterestPaymentDue() {
        return interestPaymentDue;
    }

    public void setInterestPaymentDue(InterestPaymentDue interestPaymentDue) {
        this.interestPaymentDue = interestPaymentDue;
    }

    public List<BankingProductRateTier> getTiers() {
        return tiers;
    }

    public void setTiers(List<BankingProductRateTier> tiers) {
        this.tiers = tiers;
    }

    public String getAdditionalValue() {
        return additionalValue;
    }

    public void setAdditionalValue(String additionalValue) {
        this.additionalValue = additionalValue;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(String additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    public Collection<BankingProductDetail> getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(Collection<BankingProductDetail> productDetail) {
        this.productDetail = productDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingProductLendingRate that = (BankingProductLendingRate) o;
        return Objects.equals(lendingRateId, that.lendingRateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lendingRateId);
    }

    @Override
    public String toString() {
        return "BankingProductLendingRate{" +
            "lendingRateId='" + lendingRateId + '\'' +
            ", lendingRateType=" + lendingRateType +
            ", rate=" + rate +
            ", comparisonRate=" + comparisonRate +
            ", calculationFrequency='" + calculationFrequency + '\'' +
            ", applicationFrequency='" + applicationFrequency + '\'' +
            ", interestPaymentDue=" + interestPaymentDue +
            ", tiers=" + tiers +
            ", additionalValue='" + additionalValue + '\'' +
            ", additionalInfo='" + additionalInfo + '\'' +
            ", additionalInfoUri=" + additionalInfoUri +
            ", productDetail=" + productDetail +
            '}';
    }

    public enum InterestPaymentDue {
        IN_ARREARS,
        IN_ADVANCE
    }

    public enum LendingRateType {
        FIXED,
        VARIABLE,
        INTRODUCTORY,
        DISCOUNT,
        PENALTY,
        FLOATING,
        MARKET_LINKED,
        CASH_ADVANCE,
        PURCHASE,
        BUNDLE_DISCOUNT_FIXED,
        BUNDLE_DISCOUNT_VARIABLE
    }
}