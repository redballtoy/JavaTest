package StreamAPI.legasy;

import java.time.LocalDate;

public class RequestDataRow {
    private Long bankId;
    private LocalDate lastRequestDate;
    private String contractNumber;
    private Long contractId;
    private Long managerId;

    public RequestDataRow() {

    }

    public RequestDataRow(Long bankId, LocalDate lastRequestDate, String contractNumber, Long contractId, Long managerId) {
        this.bankId = bankId;
        this.lastRequestDate = lastRequestDate;
        this.contractNumber = contractNumber;
        this.contractId = contractId;
        this.managerId = managerId;
    }

    public Long getBankId() {
        return bankId;
    }

    public LocalDate getLastRequestDate() {
        return lastRequestDate;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public Long getContractId() {
        return contractId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public void setLastRequestDate(LocalDate lastRequestDate) {
        this.lastRequestDate = lastRequestDate;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}

