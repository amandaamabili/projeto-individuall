package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.InBoundOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InboundOrderRequestDTO {

    private Long orderId;
    @NotNull(message = "The date is not null.")
    private Date dateTime;
    private SectorDTO sector;

    private List< @Valid BatchStockDTO> batchStockList;

    public InboundOrderRequestDTO(long orderId, Date dateTime, SectorDTO sector) {
        this.orderId = orderId;
        this.dateTime = dateTime;
        this.sector = sector;
    }

    public long getSectorID(){
        return sector.getSectorId();
    }


}
