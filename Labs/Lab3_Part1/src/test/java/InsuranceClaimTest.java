import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsuranceClaimTest {

    @Test
    void constructor_shouldInitializePendingStatus() {
        InsuranceClaim claim = new InsuranceClaim("C001", 1000.0);

        assertEquals("C001", claim.getClaimId());
        assertEquals(1000.0, claim.getAmount());
        assertEquals("Pending", claim.getClaimStatus());
    }

    @Test
    void processClaim_shouldUpdateStatus_whenPending() {
        InsuranceClaim claim = new InsuranceClaim("C002", 2000.0);

        boolean result = claim.processClaim("Approved");

        assertTrue(result);
        assertEquals("Approved", claim.getClaimStatus());
    }
}
