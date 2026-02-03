public class InsuranceClaim {

    private String claimId;
    private double amount;
    private String claimStatus;

    public InsuranceClaim(String id, double claimAmount) {
        this.claimId = id;
        this.amount = claimAmount;
        this.claimStatus = "Pending";
    }

    public boolean processClaim(String statusUpdate) {
        // Validate input
        if (statusUpdate == null || statusUpdate.trim().isEmpty()) {
            return false;
        }

        // Only allow update when Pending
        if ("Pending".equals(claimStatus)) {
            claimStatus = statusUpdate.trim();
            return true;
        }
        return false;
    }

    public double calculatePayout() {
        if ("Approved".equals(claimStatus)) {
            return amount * 0.85;
        }
        return 0.0;
    }

    public void updateClaimAmount(double newAmount) {
        // Business rule: cannot update after approved
        if (!"Approved".equals(claimStatus)) {
            this.amount = newAmount;
        }
    }

    // Getters (needed for unit test)
    public String getClaimId() {
        return claimId;
    }

    public double getAmount() {
        return amount;
    }

    public String getClaimStatus() {
        return claimStatus;
    }
}
