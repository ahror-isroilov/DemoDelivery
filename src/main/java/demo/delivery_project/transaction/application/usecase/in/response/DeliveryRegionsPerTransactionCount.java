package demo.delivery_project.transaction.application.usecase.in.response;

import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryRegionsPerTransactionCount {
    private Integer transactionNumber;
    private List<RegionResponse> regions;
}
